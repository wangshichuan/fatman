package BackAction;

import Dao.UserDao;
import IndexData.UserIndex;

public class DelUserAction {
	private Integer userid;
	UserDao userDao = new UserDao();
	UserIndex userIndex = new UserIndex();
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String execute(){
		userDao.delUserById(userid);
		userIndex.deleteById(userid);
		return "success";
	}
}
