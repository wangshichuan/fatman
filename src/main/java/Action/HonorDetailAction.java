package Action;

import Model.Article;
import Model.Honor;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.CompanyHonorService;
import service.impl.CompanyHonorServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wangshichuan on 2016/5/4.
 */
public class HonorDetailAction {
    private final Logger logger = LoggerFactory.getLogger(CompanyArticleDetail.class);

    private CompanyHonorService honor = new CompanyHonorServiceImpl();


    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
//            int id = request.getAttribute("id") == null ? 0 : (int) request.getAttribute("id");
//            Honor honor = this.honor.getArticleById(id);
//            request.setAttribute("honor", honor);
            List<Honor> honorList = honor.getListByPage(1, 20, null);
            request.setAttribute("honorList", honorList);
            return "success";
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "fail";
        }

    }
}
