package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import IndexData.DataFromDB;
import Model.Menu;

public class MenuDao {
	DataFromDB db = new DataFromDB();
	/**
	 * 查询所有菜品
	 * @return
	 */
	public List<Menu> selMenuAll(){
		String sql = "select * from menu";
		List<Menu> listmenu = new ArrayList<Menu>();
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setId(rs.getInt("id"));
				menu.setMenuname(rs.getString("menuname"));
				menu.setChengben(rs.getDouble("chengben"));
				menu.setPrice(rs.getDouble("price"));
				menu.setDescribes(rs.getString("describes"));
				menu.setPicUrl(rs.getString("picUrl"));
				menu.setTypename(rs.getString("typename"));
				listmenu.add(menu);
			}
			db.close(conn, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listmenu;
	}
	
	public Menu selMenuById(Integer menuid){
		String sql = "select * from menu where id = ?";
		Menu menu = new Menu();
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, menuid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				menu.setId(menuid);
				menu.setDescribes(rs.getString("describes"));
				menu.setMenuname(rs.getString("menuname"));

				menu.setChengben(rs.getDouble("chengben"));
				menu.setPicUrl(rs.getString("picUrl"));
				menu.setPrice(rs.getDouble("price"));
				menu.setTypename(rs.getString("typename"));
			}
			db.close(conn, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}
	
	public void updateMenu(Menu menu){
		String sql = "update menu set menuname=? , describes=? , price=? , typename=? , picUrl=? , chengben=? where id = ?";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, menu.getMenuname());
			pst.setString(2, menu.getDescribes());
			pst.setDouble(3, menu.getPrice());
			pst.setString(4, menu.getTypename());
			pst.setString(5, menu.getPicUrl());
			pst.setDouble(6, menu.getChengben());
			pst.setInt(7, menu.getId());
			pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据菜品id在数据库中删除
	 * @param menuid
	 */
	public void deleteMenuById(Integer menuid){
		String sql = "delete from menu where id = ?";
		String menusql = "delete from order_menu where menuid = ?";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, menuid);
			pst.execute();
			pst = conn.prepareStatement(menusql);
			pst.setInt(1, menuid);
			pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addMenu(Menu menu){
		String sql = "insert into menu(menuname,price,describes,typename,picUrl,chengben) values(?,?,?,?,?,?)";
		Connection conn = db.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, menu.getMenuname());
			pst.setDouble(2, menu.getPrice());
			pst.setString(3, menu.getDescribes());
			pst.setString(4, menu.getTypename());
			pst.setString(5, menu.getPicUrl());
			pst.setDouble(6, menu.getChengben());
			pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
