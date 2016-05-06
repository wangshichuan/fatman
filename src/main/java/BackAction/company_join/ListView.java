package BackAction.company_join;

import Model.CompanyJoin;
import Model.Honor;
import org.apache.struts2.ServletActionContext;
import service.CompanyJoinService;
import service.impl.CompanyJoinServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wangshichuan on 2016/5/6.
 */
public class ListView {

    int page = 1;
    int size = 20;
    CompanyJoinService joinService = new CompanyJoinServiceImpl();

    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            List<CompanyJoin> joinList = joinService.getList(page, size, null);
            request.setAttribute("joinList", joinList);
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
