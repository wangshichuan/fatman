package BackAction.company_honor;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.CompanyHonorService;
import service.impl.CompanyHonorServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangshichuan on 2016/5/4.
 */
public class delete  extends ActionSupport {
    CompanyHonorService honorService = new CompanyHonorServiceImpl();

    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
//            int id = request.getAttribute("id") == null ? 0 : (int) request.getAttribute("id");

            honorService.delete(id);
//            request.setAttribute("test", articleList);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }
}
