package BackAction.company_article;

import Model.Admin;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.CompanyArticleService;
import service.impl.CompanyArticleServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wangshichuan on 2016/5/4.
 */
public class add  extends ActionSupport {
    CompanyArticleService articleService = new CompanyArticleServiceImpl();
    private String title;
    private String content;


    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
//        String title = (String) request.getAttribute("title");
//        String content = (String) request.getAttribute("content");
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            request.setAttribute("flag", -1);
            return "fail";
        }
        articleService.add(title, content, admin.getAdminname(), "");
        request.setAttribute("flag", 1);
        return "success";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
