package Dao;

import IndexData.DataFromDB;
import Model.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshichuan on 2016/5/4.
 */
public class ArticleDao {
    DataFromDB db = new DataFromDB();

    public void add(String title, String content, String auth, String note) {
        Connection con = db.getConnection();
        String sql_add = "INSERT into company_article (title,content,auther,create_date,note) VALUES(?,?,?,?,?) ";
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

    public List<Article> getListByPage(int page, int limit, String condition) {
        Connection con = db.getConnection();
        page = page == 0 ? 1 : page;
        String sql = "SELECT * from company_article limit ?,?";
        int start = (page - 1) * limit;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Article> articleList = new ArrayList<>();
        try {
            //PreparedStatement
            ps = con.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, limit);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Article article = new Article();
                    article.setArticleId(rs.getInt("id"));
                    article.setTitle(rs.getString("title"));
                    article.setContent(rs.getString("content"));
                    article.setAuther(rs.getString("auther"));
                    article.setDate(String.valueOf(rs.getDate("create_date")));
                    articleList.add(article);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close(con, ps, rs);
        }
        return articleList;
    }

    public Article getArticleById(int id) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * from company_article where id=?";
        Article article = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    article = new Article();
                    article.setArticleId(rs.getInt("id"));
                    article.setTitle(rs.getString("title"));
                    article.setContent(rs.getString("content"));
                    article.setDate(String.valueOf(rs.getDate("create_date")));
                    article.setNote(rs.getString("note"));
                    article.setAuther(rs.getString("auther"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close(conn, ps, rs);
        }
        return article;

    }

    public void delete(int id) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "delete  from company_article where id=?";
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
