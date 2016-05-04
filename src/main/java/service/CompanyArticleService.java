package service;

import Model.Article;

import java.util.List;

/**
 * Created by wangshichuan on 2016/5/4.
 */
public interface CompanyArticleService {

    List<Article> getListByPage(int page, int limit, String condition);

    Article getArticleById(int id);
}
