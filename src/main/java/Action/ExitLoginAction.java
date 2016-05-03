package Action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Model.MenuModel;
import Model.User;

/**
 * 退出登陆
 */

public class ExitLoginAction {
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		List<MenuModel> listmenu = (List<MenuModel>)session.getAttribute("listMenu");
		List<Integer> listid = (List<Integer>)session.getAttribute("menuid");
		if(user==null)
			return "fail";
		session.removeAttribute("user");
		if(listmenu!=null){
			session.removeAttribute("listMenu");
		}
		if(listid!=null){
			session.removeAttribute("menuid");
		}
		return "success";
	}
}
