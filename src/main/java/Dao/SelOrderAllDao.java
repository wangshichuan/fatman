package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.OrderModel;
import IndexData.DataFromDB;

public class SelOrderAllDao {
	DataFromDB db = new DataFromDB();
	public List<OrderModel> selOrderAll(){
		List<OrderModel> listOrder = new ArrayList<OrderModel>();
		String sql = "select * from order";
		Connection conn = db.getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				OrderModel order = new OrderModel();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listOrder;
	}
}
