package BackAction;

import Dao.UserDao;

public class DeleteAdminAction {
	private Integer adminid;
	UserDao userDao = new UserDao();
	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}
	public String execute(){
		userDao.delAdminById(adminid);
		return "success";
	}
}
