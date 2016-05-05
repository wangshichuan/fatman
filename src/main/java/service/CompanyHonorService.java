package service;

import Model.Article;
import Model.Honor;

import java.util.List;

/**
 * Created by wangshichuan on 2016/5/4.
 */
public interface CompanyHonorService {
    List<Honor> getListByPage(int page, int limit, String condition);

    Honor getArticleById(int id);

    void delete(int id);

    void add(String title,String content,String auth,String note);
}
