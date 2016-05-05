package service.impl;

import Dao.HonorDao;
import Model.Article;
import Model.Honor;
import service.CompanyHonorService;

import java.util.List;

/**
 * Created by wangshichuan on 2016/5/4.
 */
public class CompanyHonorServiceImpl implements CompanyHonorService{


    HonorDao honorDao = new HonorDao();

    @Override
    public List<Honor> getListByPage(int page, int limit, String condition) {
//        List<Article> articleList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Article article = new Article();
//            article.setArticleId(i + 1);
//            article.setTitle("title" + i);
//            article.setDate("2015-04-" + i);
//            articleList.add(article);
//        }
        return honorDao.getListByPage(page, limit, condition);
    }

    @Override
    public Honor getArticleById(int id) {
//        Article article = new Article();
//        article.setTitle("测试title");
//        article.setContent("测试内容");
        return honorDao.getArticleById(id);
    }

    @Override
    public void delete(int id) {
        if (id == 0) {
            return;
        }
        honorDao.delete(id);

    }

    @Override
    public void add(String title, String content, String auth, String note) {

        honorDao.add(title, content, auth, note);
    }
}
