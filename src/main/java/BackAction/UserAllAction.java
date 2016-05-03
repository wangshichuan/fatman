package BackAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.UserDao;
import Model.User;

public class UserAllAction {
	UserDao userDao = new UserDao();
	public String execute(){
		List<User> userlist = new ArrayList<User>();
		userlist = userDao.selUserAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("userlist", userlist);
		return "success";
	}
}
