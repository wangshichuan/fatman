package Model;
/**
 * 菜品索引实体类
 */
public class MenuModel {
	private Integer id;
	private Integer menuid;    //菜品id 
	private String menuname;   //菜品名
	private double price;      //菜品单价
	private String describes;   //描述
	private Double chengben;
	private String picUrl;     //图片地址
	private String typename;   //菜品类别名
	private String address;    //送餐地址
	
	
	public Double getChengben() {
		return chengben;
	}
	public void setChengben(Double chengben) {
		this.chengben = chengben;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Integer getMenuid() {
		return menuid;
	}
	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	
}
