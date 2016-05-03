package BackAction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.UserDao;
import Model.Admin;

public class UpdateAdminAction {
	private Integer adminid;
	UserDao userDao = new UserDao();
	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}
	public String execute(){
		Admin admin = userDao.selAdminById(adminid);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("admin", admin);
		return "success";
	}
}
