package BackAction;

import Dao.UserDao;
import Model.Admin;

public class UpdateAdminSuccessAction {
	private Integer adminid;
	private String adminname;
	private String password;
	private String repassword;
	private String grade;
	UserDao userDao = new UserDao();
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getAdminid() {
		return adminid;
	}
	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}
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
		Admin admin = new Admin();
		admin.setId(adminid);
		admin.setAdminname(adminname);
		admin.setPassword(password);
		admin.setGrade(grade);
		userDao.updateAdmin(admin);
		return "success";
	}
}
