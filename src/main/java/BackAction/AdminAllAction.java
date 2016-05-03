package BackAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.UserDao;
import Model.Admin;

public class AdminAllAction {
	UserDao userDao = new UserDao();
	public String execute(){
		List<Admin> adminlist = new ArrayList<Admin>();
		adminlist = userDao.selAdminAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("adminlist", adminlist);
		return "success";
	}
}
