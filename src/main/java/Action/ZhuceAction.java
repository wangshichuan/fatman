package Action;


import IndexData.UserIndex;
import Model.User;
import SearchMethod.SearchMethod;
/**
 * 注册用户
 */
public class ZhuceAction{
	private String userName;
	private String passWord;
	private String sms;
	private String qq;
	private String email;
	private String address;
	public SearchMethod search = new SearchMethod();
	UserIndex userIndex = new UserIndex();
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String execute(){
		User user = new User();
		user.setUsername(userName);
		user.setPassword(passWord);
		user.setPhone(sms);
		user.setQq(qq);
		user.setEmail(email);
		user.setAddress(address);
		if(search.zhuceValite(user)){
			userIndex.buildIndex();
			return "success";
		}
		return "fail";
	}
}
