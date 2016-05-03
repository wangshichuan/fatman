package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Model.MenuModel;
import SearchMethod.SearchMethod;
/**
 * 加入购物车
 */
public class JoinOrdercarAction {
	private Integer menuid;
	SearchMethod search = new SearchMethod();
	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		MenuModel menu = search.searchMenuById(menuid);
		if(menu==null)
			return "fail";
		if(session.getAttribute("user")==null){  //未登录点击之时，会先跳转到登陆页面，登陆过后再跳转到购物车
			session.setAttribute("menu", menu);
			return "login";
		}
		request.setAttribute("menu", menu);
		return "success";
	}
}
