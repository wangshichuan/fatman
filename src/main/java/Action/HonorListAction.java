package Action;

import Model.Article;
import Model.Honor;
import org.apache.struts2.ServletActionContext;
import service.CompanyHonorService;
import service.impl.CompanyHonorServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wangshichuan on 2016/5/4.
 */
public class HonorListAction {

    private CompanyHonorService honor = new CompanyHonorServiceImpl();
    int page = 1;
    int size = 20;

    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            List<Honor> honorList = honor.getListByPage(1, 20, null);
            request.setAttribute("honorList", honorList);
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
