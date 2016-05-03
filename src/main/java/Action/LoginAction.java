package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Model.User;
import SearchMethod.SearchMethod;

/**
 * 登陆验证
 */
public class LoginAction {
	private String username;
	private String password;
	public SearchMethod search = new SearchMethod();
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = new User();
		user=search.loginValite(username,password);
		if(user.getId()!=null){
			session.setAttribute("user", user);
			//被动登陆：点击加入到购物车验证用户是否登陆，未登录进入此判断，判断结束，就跳转到购物车页面
			if(session.getAttribute("menu")!=null){ 
				request.setAttribute("menu", session.getAttribute("menu"));
				session.removeAttribute("menu");
				return "order";//这个结果跳转到购物车页面
			}
			return "success";//这个结果跳转到登陆成功页面，就是首页
		}
		return "fail";  //跳转到错误页面
	}
}
