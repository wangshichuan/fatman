package Dao;

import IndexData.DataFromDB;
import Model.CompanyJoin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by wangshichuan on 2016/5/6.
 */
public class CompanyJoinDao {
    DataFromDB db = new DataFromDB();

    public void add(CompanyJoin join) {
        if (join == null) {
            return;
        }
        String sql_add = "INSERT into company_join (contact,join_user_name,note) VALUES(?,?,?) ";
        Connection conn = db.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql_add);
            pst.setString(1, join.getContact());
            pst.setString(2, join.getName());
            pst.setString(3, join.getNote());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
        }

    }

    public void delete(int id) {

    }

    public void updateStatus(int id, int type) {
        String sql = "update company_join set `status`=?  where id = ?";
        Connection conn = db.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, type);
            pst.setInt(2, id);
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
