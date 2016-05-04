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
            ps.setInt(1, start);
            ps.setInt(2, limit);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Article article = new Article();
                    article.setArticleId(rs.getInt("id"));
                    article.setTitle(rs.getString("title"));
                    article.setContent(rs.getString("content"));
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
}
