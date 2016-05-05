package BackAction.company_article;

import Model.Article;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.CompanyArticleService;
import service.impl.CompanyArticleServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wangshichuan on 2016/5/4.
 */
public class ListView  extends ActionSupport {
    CompanyArticleService articleService = new CompanyArticleServiceImpl();
    int page = 1;
    int size = 20;
    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
//            int page = request.getAttribute("page") == null ? 0 : (int) request.getAttribute("page");
//            int size = request.getAttribute("size") == null ? 20 : (int) request.getAttribute("size");
            List<Article> articleList = articleService.getListByPage(page, size, null);
            request.setAttribute("articleList", articleList);
//            request.setAttribute("test", articleList);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
