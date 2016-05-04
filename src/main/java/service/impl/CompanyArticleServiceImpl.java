package service.impl;

import Dao.ArticleDao;
import Model.Article;
import service.CompanyArticleService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshichuan on 2016/5/4.
 */
public class CompanyArticleServiceImpl implements CompanyArticleService {
    ArticleDao articleDao = new ArticleDao();

    @Override
    public List<Article> getListByPage(int page, int limit, String condition) {
//        List<Article> articleList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Article article = new Article();
//            article.setArticleId(i + 1);
//            article.setTitle("title" + i);
//            article.setDate("2015-04-" + i);
//            articleList.add(article);
//        }
        return articleDao.getListByPage(page,limit,condition);
    }

    @Override
    public Article getArticleById(int id) {
//        Article article = new Article();
//        article.setTitle("测试title");
//        article.setContent("测试内容");
        return articleDao.getArticleById(id);
    }
}
