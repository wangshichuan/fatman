package BackAction.company_join;

import service.CompanyJoinService;
import service.impl.CompanyJoinServiceImpl;

/**
 * Created by wangshichuan on 2016/5/6.
 */
public class Delete {

    int id;
    CompanyJoinService joinService = new CompanyJoinServiceImpl();

    public String execute() {
        try {
            joinService.delete(id);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
