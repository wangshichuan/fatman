package BackAction;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Model.Admin;
import Model.MenuModel;
import Model.User;

/**
 * 退出登陆
 */

public class ExitLoginAction {
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin==null)
			return "fail";
		session.removeAttribute("admin");
		return "success";
	}
}
