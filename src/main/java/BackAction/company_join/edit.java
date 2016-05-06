package BackAction.company_join;

import service.CompanyJoinService;
import service.impl.CompanyJoinServiceImpl;

/**
 * Created by wangshichuan on 2016/5/6.
 */
public class Edit {
    int id;
    int type;//-1 取消 1已加盟 2等待审核

    CompanyJoinService joinService = new CompanyJoinServiceImpl();

    public String execute() {
        try {
            joinService.updateStatus(id, type);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
