package Dao;

import IndexData.DataFromDB;
import Model.Article;
import Model.Honor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshichuan on 2016/5/4.
 */
public class HonorDao {
    DataFromDB db = new DataFromDB();

    public void add(String title, String content, String auth, String note) {
        Connection con = db.getConnection();
        String sql_add = "INSERT into company_honor (title,content,pic_url,create_date,note) VALUES(?,?,?,?,?) ";
        Connection conn = db.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql_add);
            pst.setString(1, title);
            pst.setString(2, content);
            pst.setString(3, auth);
            pst.setDate(4, new Date(System.currentTimeMillis()));
            pst.setString(5, note);
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Honor> getListByPage(int page, int limit, String condition) {
        Connection con = db.getConnection();
        page = page == 0 ? 1 : page;
        String sql = "SELECT * from company_honor limit ?,?";
        int start = (page - 1) * limit;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Honor> honorList = new ArrayList<>();
        try {
            //PreparedStatement
            ps = con.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, limit);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Honor honor =new Honor();
                    honor.setId(rs.getInt("id"));
                    honor.setTitle(rs.getString("title"));
                    honor.setContent(rs.getString("content"));
                    honor.setDate(String.valueOf(rs.getDate("create_date")));
                    honor.setNote(rs.getString("note"));
                    honor.setFor_what(rs.getString("for_what"));
                    honor.setPic_url(rs.getString("pic_url"));
                    honorList.add(honor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close(con, ps, rs);
        }
        return honorList;
    }

    public Honor getArticleById(int id) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * from company_honor where id=?";
        Honor honor = null;
        try {
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    honor = new Honor();
                    honor.setId(rs.getInt("id"));
                    honor.setTitle(rs.getString("title"));
                    honor.setContent(rs.getString("content"));
                    honor.setDate(String.valueOf(rs.getDate("create_date")));
                    honor.setNote(rs.getString("note"));
                    honor.setFor_what(rs.getString("for_what"));
                    honor.setPic_url(rs.getString("pic_url"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close(conn, ps, rs);
        }
        return honor;

    }

    public void delete(int id) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "delete  from company_honor where id=?";
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException e) {
//            e.printStackTrace();
        }

    }
}
