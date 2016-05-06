package Action;

import Model.ContactInfo;
import org.apache.struts2.ServletActionContext;
import service.CompanyJoinService;
import service.impl.CompanyJoinServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangshichuan on 2016/5/5.
 */
public class CompanyJoinAddAction {

    String name;
    Integer contact;
    String content;

    CompanyJoinService joinService = new CompanyJoinServiceImpl();

    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        ContactInfo contactInfo = new ContactInfo(contact, name, content);
        try {
            joinService.add(contactInfo);
        } catch (Exception e) {
            request.setAttribute("flag", -1);
        }
        request.setAttribute("flag", 1);
        return "success";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
