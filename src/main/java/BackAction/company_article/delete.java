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
public class delete  extends ActionSupport {
    CompanyArticleService articleService = new CompanyArticleServiceImpl();

    int id;

    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
//            int id = request.getAttribute("id") == null ? 0 : (int) request.getAttribute("id");

            articleService.delete(id);
//            request.setAttribute("test", articleList);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
