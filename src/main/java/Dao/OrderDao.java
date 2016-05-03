package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import IndexData.DataFromDB;
import IndexData.OrderIndex;
import Model.Menu;
import Model.Money;
import Model.Order;
/**
 * order 相关的数据库操作
 */
public class OrderDao {
	DataFromDB db = new DataFromDB();
	
	/**
	 * 保存订单
	 * @param order
	 */
	public void save(Order order){
		String result ="";
		do{
		 Random random = new Random(); 
		 result="";

         for(int i=0;i<6;i++){
        	 result+=random.nextInt(10);    
         }
         System.out.println(result);
		}
         while(selOrderByOrderid(Integer.parseInt(result))==null);
		Integer orderid = Integer.parseInt(result);
		String sql = "insert into ordertable(userid,totalprice,times,orderaddress,orderusername,orderphone,id,status,paymethod) values(?,?,?,?,?,?,?,?,?)";
		String menusql = "insert into order_menu(orderid,menuid) values(?,?)";
		Connection conn = db.getConnection();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, order.getUserid());
			st.setDouble(2, order.getTotalprice());
			st.setString(3, order.getTimes());
			st.setString(4, order.getOrderaddress());
			st.setString(5, order.getOrderusername());
			st.setString(6, order.getOrderphone());
			st.setInt(7, orderid);
			st.setString(8, "已下单");
			st.setString(9, order.getPaymethod());
			st.execute();
			st = conn.prepareStatement(menusql);
			for(Integer menuid : order.getMenuid()){
				st.setInt(1, orderid);
				st.setInt(2, menuid);
				st.execute();
			}
			conn.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrderIndex orderindex = new OrderIndex();
		orderindex.buildIndex();
	}
	
	/**
	 * 根据用户id查找订单
	 * @param userid
	 * @return
	 */
	public List<Order> selOrderByUserid(Integer userid){
		List<Order> orderList = new ArrayList<Order>();
		//根据当前用户id查找他所下的订单列表
		String sql = "select * from ordertable where userid = ? order by times desc";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, userid);
			ResultSet rs  = pst.executeQuery();
			while(rs.next()){
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setOrderaddress(rs.getString("orderaddress"));
				order.setOrderphone(rs.getString("orderphone"));
				order.setOrderusername(rs.getString("orderusername"));
				order.setTimes(rs.getString("times"));
				order.setTotalprice(rs.getDouble("totalprice"));
				order.setStatus(rs.getString("status"));
				order.setPaymethod(rs.getString("paymethod"));
				order.setUserid(rs.getInt("userid"));
				orderList.add(order);
			}
			db.close(conn, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderList;
	}
	
	public List<Order> selOrderAll(){
		String sql = "select * from ordertable order by times desc";
		List<Order> orderlist = new ArrayList<Order>();
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				//TODO：
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderlist;
	}
	
	public Order selOrderByOrderid(Integer orderid){
		String sql = "select * from ordertable where id = ?";
		Order order = new Order();
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, orderid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				order.setId(rs.getInt("id"));
				order.setUserid(rs.getInt("userid"));
				order.setOrderaddress(rs.getString("orderaddress"));
				order.setOrdernumber(rs.getString("ordernumber"));
				order.setOrderphone(rs.getString("orderphone"));
				order.setOrderusername(rs.getString("orderusername"));
				order.setStatus(rs.getString("status"));
				order.setStatus(rs.getString("paymethod"));
				order.setTotalprice(rs.getDouble("totalprice"));
				order.setTimes(rs.getString("times"));
			}
			db.close(conn, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return order;
	}
	
	public List<Menu> selMenuListByOrderid(Integer orderid){
		List<Menu> menulist = new ArrayList<Menu>();
		List<Integer> menuidList = new ArrayList<Integer>();
		String sql = "select menuid from order_menu where orderid = ?";
		String menusql = "select * from menu where id = ?";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, orderid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				menuidList.add(rs.getInt("menuid"));
			}
			pst = conn.prepareStatement(menusql);
			for(Integer menuid : menuidList){
				pst.setInt(1,menuid);
				rs = pst.executeQuery();
				while(rs.next()){
					Menu menu = new Menu();
					menu.setId(menuid);
					menu.setMenuname(rs.getString("menuname"));
					menu.setPrice(rs.getDouble("price"));
					menu.setDescribes(rs.getString("describes"));
					menu.setPicUrl(rs.getString("picUrl"));
					menu.setTypename(rs.getString("typename"));
					menulist.add(menu);
				}
			}
			db.close(conn, pst, rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menulist;
	}
	
	public void delOrderById(Integer orderid){
		//在数据库中删除订单
		String sql = "delete from ordertable where id = ?";
		String ordersql = "delete from order_menu where orderid = ?";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(ordersql);
			pst.setInt(1, orderid);
			pst.execute();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, orderid);
			pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateOrderByStatus(String status,Integer orderid){
		String sql = "update ordertable set status = ? where id = ?";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, status);
			pst.setInt(2, orderid);
			pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Money getMoneyDay(String times){
		Money money = new Money();
		Double chengben = 0.0;
		Double shouru = 0.0;
		Double yinli = 0.0;
		String sql = "select * from ordertable where times like ? and status='已完成'";
		String menusql = "select chengben from menu where id in (select menuid from order_menu where orderid=?)";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, times+"%");
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				pst = conn.prepareStatement(menusql);
				pst.setInt(1, rs.getInt("id"));
				ResultSet crs = pst.executeQuery();
				while(crs.next()){
					chengben += crs.getDouble("chengben");
					System.out.println("成本:"+chengben);
				}
				crs.close();
				shouru += rs.getDouble("totalprice");
				System.out.println("收入:"+shouru);
			}
			yinli = shouru-chengben;
			money.setChengben(chengben);
			money.setShouru(shouru);
			money.setYinli(yinli);
			db.close(conn, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return money;
	}
	
	public void cancelOrderById(Integer id){
		String sql ="update ordertable set status = '已取消' where id = ?";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
