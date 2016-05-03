package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Dao.UserDao;
import IndexData.UserIndex;
import Model.User;

public class UpdateUserAction {
	private String address;
	private String qq;
	private String email;
	private String phone;
	private String password;
	private String repassword;
	UserDao userDao = new UserDao();
	UserIndex userIndex = new UserIndex();
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String execute() {
		if ((!password.equals(repassword))&&(password!=null)) {
			return "fail";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		//1.在session中取出当前用户的所有信息
		User user = (User) session.getAttribute("user");
		//2.将修改后的数据取出，替换掉原有信息
		if (user == null) {
			System.out.println("user is null");
			return "fail";
		}

		session.setAttribute("userid", user.getId());
		if (address != null) {
			user.setAddress(address);
		}
		if (qq != null) {
			user.setQq(qq);
		}
		if (email != null) {
			user.setEmail(email);
		}
		if (phone != null) {
			user.setPhone(phone);
		}
		if (password != null) {
			user.setPassword(password);
		}
		//3.将替换信息后的user更新到数据库，并重建索引
		userDao.save(user);
		userIndex.buildIndex();
		return "success";
	}
}
