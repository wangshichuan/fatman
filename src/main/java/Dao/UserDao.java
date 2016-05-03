package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import IndexData.DataFromDB;
import Model.Admin;
import Model.User;
/**
 * user 相关的数据库操作
 */
public class UserDao {
	DataFromDB db = new DataFromDB();
	
	/**
	 * 更新用户
	 * @param user
	 */
	public void save(User user){
		String sql = "update user set address=?,qq=?,phone=?,email=?,password=? where id=?";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user.getAddress());
			pst.setString(2, user.getQq());
			pst.setString(3, user.getPhone());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPassword());
			pst.setInt(6, user.getId());
			pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public User searchByUserid(Integer userid){
		User user = new User();
		String sql = "select * from user where id = ?";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, userid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				user.setId(rs.getInt("id"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setQq(rs.getString("qq"));
				user.setUsername(rs.getString("username"));
			}
			db.close(conn, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 查询所有管理员
	 * @return
	 */
	public List<Admin> selAdminAll(){
		String sql = "select * from admin";
		List<Admin> adminlist = new ArrayList<Admin>();
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setAdminname(rs.getString("adminname"));
				admin.setPassword(rs.getString("password"));
				admin.setGrade(rs.getString("grade"));
				adminlist.add(admin);
			}
			db.close(conn, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminlist;
	}
	//保存管理员信息
	public void saveAdmin(Admin admin){
		String sql = "insert into admin(adminname,password,grade) values(?,?,?)";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getAdminname());
			pst.setString(2, admin.getPassword());
			pst.setString(3, admin.getGrade());
			pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<User> selUserAll(){
		String sql = "select * from user";
		List<User> userlist = new ArrayList<User>();
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setQq(rs.getString("qq"));
				userlist.add(user);
			}
			db.close(conn, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
	}
	
	public boolean selAdminByName(String adminname){
		String sql = "select * from admin where adminname=?";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, adminname);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				return true;
			}
			db.close(conn, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Admin selAdminById(Integer adminid){
		String sql = "select * from admin where id = ?";
		Admin admin = new Admin();
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, adminid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				admin.setId(rs.getInt("id"));
				admin.setAdminname(rs.getString("adminname"));
				admin.setPassword(rs.getString("password"));
				admin.setGrade(rs.getString("grade"));
			}
			db.close(conn, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return admin;
	}
	
	public void updateAdmin(Admin admin){
		String sql = "update admin set adminname=? , password=? , grade=? where id = ?";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getAdminname());
			pst.setString(2, admin.getPassword());
			pst.setString(3, admin.getGrade());
			pst.setInt(4, admin.getId());
			pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delAdminById(Integer adminid){
		String sql = "delete from admin where id = ?";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, adminid);
			pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void delUserById(Integer userid){
		String ordersql = "delete from ordertable where userid = ?";
		String menusql = "delete from order_menu where orderid = (select orderid from ordertable where userid = ?)";
		String sql = "delete from user where id = ?";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(menusql);
			pst.setInt(1, userid);
			pst.execute();
			pst = conn.prepareStatement(ordersql);
			pst.setInt(1, userid);
			pst.execute();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userid);
			pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Admin backLogin(String username,String password){
		String sql = "select * from admin where adminname=? and password=?";
		Admin admin = new Admin();
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				admin.setId(rs.getInt("id"));
				admin.setAdminname(rs.getString("adminname"));
				admin.setPassword(rs.getString("password"));
				admin.setGrade(rs.getString("grade"));
			}
			db.close(conn, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}
}
