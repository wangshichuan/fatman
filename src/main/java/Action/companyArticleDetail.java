package Action;

import Model.Article;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.CompanyArticleService;
import service.impl.CompanyArticleServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * 文章详情
 */
public class CompanyArticleDetail {

    private final Logger logger = LoggerFactory.getLogger(CompanyArticleDetail.class);

    private CompanyArticleService articleService = new CompanyArticleServiceImpl();


    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            int id = request.getAttribute("id") == null ? 0 : (int) request.getAttribute("id");
            Article article = articleService.getArticleById(id);
            request.setAttribute("article", article);
            return "success";
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "fail";
        }

    }
}
