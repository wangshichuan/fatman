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

    int page = 1;
    int size = 20;
    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
//            int page = request.getAttribute("page") == null ? 0 : (int) request.getAttribute("page");
//            int size = request.getAttribute("size") == null ? 20 : (int) request.getAttribute("size");
            List<Article> articleList = companyArticleService.getListByPage(page, size, null);
            request.setAttribute("articleList", articleList);
//            request.setAttribute("test", articleList);
            request.setAttribute("page",page);
            return "success";
        } catch (Exception e) {
            return "fail";
        }

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
