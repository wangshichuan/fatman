package IndexData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.DiscussModel;
import Model.MenuModel;
import Model.OrderModel;
import Model.TypeModel;
import Model.UserModel;
/**
 * jdbc拉取数据
 */

public class DataFromDB {
	
	/**
	 * 获得连接
	 * @return
	 */
	public Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			String url = "jdbc:mysql://localhost:3306/food";
			conn = DriverManager.getConnection(url, "root","123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭连接
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public void close(Connection conn,Statement st, ResultSet rs){
		try {
			if(conn!=null){
				conn.close();
			}
			if(st!=null){
				st.close();
			}
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 为User建索引拉取相关属性
	 * @return
	 */
	public List<UserModel> getUserInfo(){
		List<UserModel> list = new ArrayList<UserModel>(0);
		
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select id, username ,address,password,phone,qq,email from user ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				UserModel user = new UserModel();
				List<Integer> menuid = new ArrayList<Integer>();
				List<String> menuname = new ArrayList<String>();
				List<String> typename = new ArrayList<String>();
				List<Double> price = new ArrayList<Double>();
				List<String> describe = new ArrayList<String>();
				List<String> picUrl = new ArrayList<String>();

				int userid = rs.getInt("id");
				user.setUserid(userid);
				ps = conn.prepareStatement("select * from menu where id in (select menuid from ordertable where userid = ?)");
				ps.setInt(1, userid);
				ResultSet rsUser = ps.executeQuery();
				while(rsUser.next()){
					menuid.add(rsUser.getInt("id"));
					menuname.add(rsUser.getString("menuname"));
					typename.add(rsUser.getString("typename"));
					describe.add(rsUser.getString("describes"));
					picUrl.add(rsUser.getString("picUrl"));
					price.add(rsUser.getDouble("price"));
				}
				rsUser.close();
				user.setMenuid(menuid);
				user.setMenuname(menuname);
				user.setTypename(typename);
				user.setPrice(price);
				user.setDescribe(describe);
				user.setPicUrl(picUrl);
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setQq(rs.getString("qq"));
				user.setAddress(rs.getString("address"));
				list.add(user);
			}
			close(conn,ps,rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	/**
	 * 为Menu建索引拉取相关属性
	 * @return
	 */
	public List<MenuModel> getMenuInfo(){
		List<MenuModel> list = new ArrayList<MenuModel>();
		
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from menu ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				MenuModel menu = new MenuModel();
				menu.setMenuid(rs.getInt("id"));
				menu.setMenuname(rs.getString("menuname"));
				menu.setChengben(rs.getDouble("chengben"));
				menu.setPrice(rs.getDouble("price"));
				menu.setDescribes(rs.getString("describes"));
				menu.setPicUrl(rs.getString("picUrl"));
				menu.setTypename(rs.getString("typename"));
				list.add(menu);
			}
			close(conn,ps,rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 为order建索引拉取相关属性
	 * @return
	 */
	public List<OrderModel> getOrderInfo(){
		List<OrderModel> list = new ArrayList<OrderModel>();
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from ordertable order by times desc");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				OrderModel order = new OrderModel();
				order.setOrderid(rs.getInt("id"));
				order.setUserid(rs.getInt("userid"));
				ps = conn.prepareStatement("select username from user where id = (select userid from ordertable where id = ?)");
				ps.setInt(1, order.getOrderid());
				ResultSet userRs = ps.executeQuery();
				while(userRs.next()){
					order.setUsername(userRs.getString("username"));
				}
				userRs.close();
				order.setTotalprice(rs.getDouble("totalprice"));
				order.setTime(rs.getString("times"));
				order.setOrderaddress(rs.getString("orderaddress"));
				order.setOrderusername(rs.getString("orderusername"));
				order.setOrderphone(rs.getString("orderphone"));
				order.setStatus(rs.getString("status"));
				order.setPaymethod(rs.getString("paymethod"));
				list.add(order);
			}
			close(conn,ps,rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 为type建索引拉取相关属性
	 * @return
	 */
	public List<TypeModel> getTypeInfo(){
		List<TypeModel> list = new ArrayList<TypeModel>();
		
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select id,typename, menuid from type ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				TypeModel type = new TypeModel();
				type.setTypeid(rs.getInt("id"));
				type.setMenuid(rs.getInt("menuid"));
				type.setTypename(rs.getString("typename"));
				list.add(type);
			}
			close(conn,ps,rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
