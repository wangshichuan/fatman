package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户索引实体类
 */
public class UserModel {
	private Integer id;
	private Integer userid; // 用户id
	private String username; // 用户名
	private String usernickname;// 昵称
	private String phone;// 手机
	private String qq;// QQ
	private String email;// 邮箱
	private String password;// 密码
	private String address;// 地址
	private List<Integer> menuid = new ArrayList<Integer>();// 菜品id集合
	private List<String> menuname = new ArrayList<String>();// 菜品名集合
	private List<String> typename = new ArrayList<String>();// 菜品类别集合
	private List<Double> price = new ArrayList<Double>();// 菜品单价集合
	private List<String> describe = new ArrayList<String>();// 菜品描述集合
	private List<String> picUrl = new ArrayList<String>();// 菜品图片地址集合

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Integer> getMenuid() {
		return menuid;
	}

	public void setMenuid(List<Integer> menuid) {
		this.menuid = menuid;
	}

	public List<String> getMenuname() {
		return menuname;
	}

	public void setMenuname(List<String> menuname) {
		this.menuname = menuname;
	}

	public List<String> getTypename() {
		return typename;
	}

	public void setTypename(List<String> typename) {
		this.typename = typename;
	}

	public List<Double> getPrice() {
		return price;
	}

	public void setPrice(List<Double> price) {
		this.price = price;
	}

	public List<String> getDescribe() {
		return describe;
	}

	public void setDescribe(List<String> describe) {
		this.describe = describe;
	}

	public List<String> getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(List<String> picUrl) {
		this.picUrl = picUrl;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernickname() {
		return usernickname;
	}

	public void setUsernickname(String usernickname) {
		this.usernickname = usernickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

}
