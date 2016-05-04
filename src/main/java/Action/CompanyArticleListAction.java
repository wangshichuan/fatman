package Action;

import Model.Article;
import org.apache.struts2.ServletActionContext;
import service.CompanyArticleService;
import service.impl.CompanyArticleServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 文章列表
 */
public class CompanyArticleListAction {

    private CompanyArticleService companyArticleService = new CompanyArticleServiceImpl();

    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            int page = request.getAttribute("page") == null ? 0 : (int) request.getAttribute("page");
            int size = request.getAttribute("size") == null ? 0 : (int) request.getAttribute("size");
            List<Article> articleList = companyArticleService.getListByPage(page, size, null);
            request.setAttribute("articleList", articleList);
            request.setAttribute("test", articleList);
            return "success";
        } catch (Exception e) {
            return "fail";
        }

    }
}
