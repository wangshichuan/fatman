package BackAction;

import Dao.UserDao;
import Model.Admin;

public class AddAdminAction {
	private String adminname;
	private String password;
	private String repassword;
	private String grade;
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	UserDao userDao = new UserDao();
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String execute(){
		if(!repassword.equals(password)||repassword.isEmpty()){
			return "fail";
		}
		if(userDao.selAdminByName(adminname)){
			return "fail";
		}
		Admin admin = new Admin();
		admin.setAdminname(adminname);
		admin.setPassword(password);
		admin.setGrade(grade);
		userDao.saveAdmin(admin);
		return "success";
	}
}
