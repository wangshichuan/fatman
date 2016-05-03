package Model;
/**
 * 菜品数据库实体类
 *
 */
public class Menu {
	private Integer id;   //菜品id
	private String menuname;     //菜品名
	private Double price;        //菜品单价
	private Double chengben;
	private String describes;     //菜品描述
	private String picUrl;
	private String typename;
	
	public Double getChengben() {
		return chengben;
	}
	public void setChengben(Double chengben) {
		this.chengben = chengben;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	
}
