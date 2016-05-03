package BackAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Dao.UserDao;
import Model.Admin;

public class BackLoginAction {
	private String username;
	private String password;

	UserDao userDao = new UserDao();
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
		Admin admin = new Admin();
		admin = userDao.backLogin(username,password);
		if(admin.getId()!=null){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("admin", admin);
			return "success";
		}
		return "fail";
	}
}
