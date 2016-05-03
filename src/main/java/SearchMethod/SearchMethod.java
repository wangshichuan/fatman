package SearchMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import IndexData.DataFromDB;
import IndexData.UserIndex;
import Model.MenuModel;
import Model.OrderModel;
import Model.User;
import Model.UserModel;

public class SearchMethod {
	private SolrServer server = new HttpSolrServer(
			"http://localhost:7000/solr/menu");
	private SolrServer userServer = new HttpSolrServer(
			"http://localhost:7000/solr/user");
	private SolrServer orderServer = new HttpSolrServer(
			"http://localhost:7000/solr/order");
	SolrQuery query = new SolrQuery();
	QueryResponse output;

	/**
	 * 登陆验证
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 */
	public User loginValite(String username, String pwd) {
		DataFromDB db = new DataFromDB();
		Connection conn = db.getConnection();
		User user = new User();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (username.equals(rs.getString("username"))
						&& pwd.equals(rs.getString("password"))
						|| username.equals(rs.getString("email"))
						&& pwd.equals(rs.getString("password"))) {
					user.setId(rs.getInt("id"));
					user.setAddress(rs.getString("address"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setPhone(rs.getString("phone"));
					user.setQq(rs.getString("qq"));
					user.setUsername(rs.getString("username"));
					db.close(conn, ps, rs);
					return user;
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return user;
	}

	/**
	 * 注册验证
	 * 
	 * @param user
	 * @return
	 */
	public boolean zhuceValite(User user) {
		String queryString = "username:" + user.getUsername();
		query.setQuery(queryString);
		try {
			output = userServer.query(query);
			SolrDocumentList docList = output.getResults();
			if (!docList.isEmpty()) {
				return false;
			}
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		save(user);
		return true;
	}

	/**
	 * 新增用户到数据库
	 * 
	 * @param user
	 */
	public void save(User user) {
		DataFromDB db = new DataFromDB();
		Connection conn = db.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into user(username,password,phone,email,address,qq) values(?,?,?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getQq());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据类别搜索Menu
	 * 
	 * @param type
	 * @return
	 */
	public List<MenuModel> searchByType(String type) {
		List<MenuModel> listMenu = new ArrayList<MenuModel>();
		System.out.println("typename:"+type);
		if(type==null||type==""){
			type="*";
		}
		String queryString = "typename:" + type;
		query.setQuery(queryString);
		try {
			output = server.query(query);
			SolrDocumentList docList = output.getResults();
			for (SolrDocument doc : docList) {
				String id = (String) doc.getFieldValue("id");
				listMenu.add(searchMenuById(Integer.parseInt(id)));
			}
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMenu;
	}

	/**
	 * 根据菜品id查找menu
	 * 
	 * @param id
	 * @return
	 */
	public MenuModel searchMenuById(Integer id) {
		String queryString = "id:" + id;
		MenuModel menu = new MenuModel();
		query.setQuery(queryString);
		query.setRows(1000);
		try {
			output = server.query(query);
			SolrDocumentList docList = output.getResults();
			for (SolrDocument doc : docList) {
				String menuid = (String) doc.getFieldValue("menuid");
				String menuname = (String) doc.getFieldValue("menuname");
				String price = (String) doc.getFieldValue("price");
				String picUrl = (String) doc.getFieldValue("picUrl");
				String describe = (String) doc.getFieldValue("describes");
				String typename = (String) doc.getFieldValue("typename");
				String chengben = (String)doc.getFieldValue("chengben");
				
				if (menuid != null)
					menu.setMenuid(Integer.parseInt(menuid));
				if (menuname != null)
					menu.setMenuname(menuname);
				if (price != null)
					menu.setPrice(Double.parseDouble(price));
				if (picUrl != null)
					menu.setPicUrl(picUrl);
				if (describe != null)
					menu.setDescribes(describe);
				if (typename != null)
					menu.setTypename(typename);
				if (chengben != null)
					menu.setChengben(Double.parseDouble(chengben));
			}
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}

	/**
	 * 根据用户id在索引中查找User
	 * 
	 * @param userid
	 * @return
	 */
	public UserModel searchByUserid(Integer userid) {
		UserModel user = new UserModel();
		String queryString = "id:" + userid;
		query.setQuery(queryString);
		query.setRows(1000);
		try {
			output = userServer.query(query);
			SolrDocumentList docList = output.getResults();
			if (!docList.isEmpty()) {
				SolrDocument doc = docList.get(0);
				if (doc.getFieldValue("username") != null)
					user.setUsername((String) doc.getFieldValue("username"));
				if (doc.getFieldValue("qq") != null)
					user.setQq((String) doc.getFieldValue("qq"));
				if (doc.getFieldValue("phone") != null)
					user.setPhone((String) doc.getFieldValue("phone"));
				if (doc.getFieldValue("email") != null)
					user.setEmail((String) doc.getFieldValue("email"));
				if (doc.getFieldValue("address") != null)
					user.setAddress((String) doc.getFieldValue("address"));
			}
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 根据关键字在索引中搜索Menu
	 * 
	 * @param keyword
	 * @return
	 */
	public List<MenuModel> searchMenuByName(String keyword) {
		List<MenuModel> listmenu = new ArrayList<MenuModel>();
		String queryString = "menuname:*" + keyword + "*";
		query.setQuery(queryString);
		query.setRows(1000);
		try {
			output = server.query(query);
			SolrDocumentList docList = output.getResults();
			for (SolrDocument doc : docList) {
				MenuModel menu = new MenuModel();
				menu.setChengben(Double.parseDouble((String)doc.getFieldValue("chengben")));
				if (doc.getFieldValue("id") != null)
					menu.setMenuid(Integer.parseInt((String) doc
							.getFieldValue("id")));
				if (doc.getFieldValue("menuname") != null)
					menu.setMenuname((String) doc.getFieldValue("menuname"));
				if (doc.getFieldValue("typename") != null)
					menu.setTypename((String) doc.getFieldValue("typename"));
				if (doc.getFieldValue("describe") != null)
					menu.setDescribes((String) doc.getFieldValue("describes"));
				if (doc.getFieldValue("price") != null)
					menu.setPrice(Double.parseDouble((String) doc
							.getFieldValue("price")));
				if (doc.getFieldValue("picUrl") != null)
					menu.setPicUrl((String) doc.getFieldValue("picUrl"));
				listmenu.add(menu);
			}
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listmenu;
	}

	/**
	 * 查询所有订单信息
	 * 
	 * @return
	 */
	public List<OrderModel> selOrderAll() {
		// 在索引中查找所有订单信息
		List<OrderModel> listOrder = new ArrayList<OrderModel>();
		String querystring = "*:*";
		query.setQuery(querystring);
		query.setRows(1000);
		try {
			output = orderServer.query(query);
			SolrDocumentList doclist = output.getResults();
			for (SolrDocument doc : doclist) {
				OrderModel order = new OrderModel();
				order.setOrderid(Integer.parseInt((String) doc
						.getFieldValue("id")));
				order.setUserid((Integer) doc.getFieldValue("userid"));
				order.setUsername((String) doc.getFieldValue("username"));
				order.setTotalprice((Double) doc.getFieldValue("totalprice"));
				order.setTime((String) doc.getFieldValue("time"));
				order.setStatus((String) doc.getFieldValue("status"));
				order.setPaymethod((String)doc.getFieldValue("paymethod"));
				order.setOrderusername((String) doc
						.getFieldValue("orderusername"));
				order.setOrderphone((String) doc.getFieldValue("orderphone"));
				order.setOrderaddress((String) doc
						.getFieldValue("orderaddress"));
				listOrder.add(order);
			}
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOrder;
	}

	public List<OrderModel> searchOrder(String keyword) {
		List<OrderModel> orderlist = new ArrayList<OrderModel>();
		String queryString = "status:*" + keyword + "* || username:*"
				+ keyword + "* || id:" + keyword + " || time:*"
						+ keyword+"* || paymethod:*"+keyword+"*";
		query.setQuery(queryString);
		query.setRows(1000);
		try {
			output = orderServer.query(query);
			SolrDocumentList doclist = output.getResults();
			for (SolrDocument doc : doclist) {
				OrderModel order = new OrderModel();
				order.setOrderid(Integer.parseInt((String) doc
						.getFieldValue("id")));
				order.setUserid((Integer) doc.getFieldValue("userid"));
				order.setUsername((String) doc.getFieldValue("username"));
				order.setTotalprice((Double) doc.getFieldValue("totalprice"));
				order.setTime((String) doc.getFieldValue("time"));
				order.setStatus((String) doc.getFieldValue("status"));
				order.setPaymethod((String)doc.getFieldValue("paymethod"));
				order.setOrderusername((String) doc
						.getFieldValue("orderusername"));
				order.setOrderphone((String) doc.getFieldValue("orderphone"));
				order.setOrderaddress((String) doc
						.getFieldValue("orderaddress"));
				orderlist.add(order);
			}
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderlist;
	}

	public List<MenuModel> searchMenu(String key){
		List<MenuModel> menulist = new ArrayList<MenuModel>();
		String queryString = "id:"+key+" || menuname:*"+key+"* || price:"+key+" || describes:*"+key+"* || typename:*"+key+"*";
		query.setQuery(queryString);
		query.setRows(1000);
		try {
			output = server.query(query);
			SolrDocumentList docList = output.getResults();
			for (SolrDocument doc : docList) {
				MenuModel menu = new MenuModel();
				menu.setId(Integer.parseInt((String) doc
						.getFieldValue("id")));
				menu.setChengben(Double.parseDouble((String) doc
						.getFieldValue("chengben")));
				if (doc.getFieldValue("id") != null)
					menu.setMenuid(Integer.parseInt((String) doc
							.getFieldValue("menuid")));
				if (doc.getFieldValue("menuname") != null)
					menu.setMenuname((String) doc.getFieldValue("menuname"));
				if (doc.getFieldValue("typename") != null)
					menu.setTypename((String) doc.getFieldValue("typename"));
				if (doc.getFieldValue("describes") != null)
					menu.setDescribes((String) doc.getFieldValue("describes"));
				if (doc.getFieldValue("price") != null)
					menu.setPrice(Double.parseDouble((String) doc
							.getFieldValue("price")));
				if (doc.getFieldValue("picUrl") != null)
					menu.setPicUrl((String) doc.getFieldValue("picUrl"));
				menulist.add(menu);
			}
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menulist;
	}
	
	public List<UserModel> searchUser(String key){
		List<UserModel> userlist = new ArrayList<UserModel>();
		String queryString = "id:"+key+" || username:*"+key+"* || address:*"+key+"* || phone:*"+key+"* || qq:*"+key+"* || email:*"+key+"*.com";
		query.setQuery(queryString);
		query.setRows(1000);
		try {
			output = userServer.query(query);
			SolrDocumentList docList = output.getResults();
			for(SolrDocument doc : docList) {
				UserModel user = new UserModel();
				String id = (String)doc.getFieldValue("id");
				user.setId(Integer.parseInt(id));
				if (doc.getFieldValue("username") != null)
					user.setUsername((String) doc.getFieldValue("username"));
				if (doc.getFieldValue("qq") != null)
					user.setQq((String) doc.getFieldValue("qq"));
				if (doc.getFieldValue("phone") != null)
					user.setPhone((String) doc.getFieldValue("phone"));
				if (doc.getFieldValue("email") != null)
					user.setEmail((String) doc.getFieldValue("email"));
				if (doc.getFieldValue("address") != null)
					user.setAddress((String) doc.getFieldValue("address"));
				userlist.add(user);
			}
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
