package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单数据库实体类
 */
public class Order {
	private Integer id;//订单id
	private Integer userid;//用户id
	private Double totalprice;//订单总价
	private String times;//下订单时间
	private String orderusername;//收货人
	private String orderaddress;//收货地址
	private String orderphone;//收货联系方式
	private String ordernumber;//订单编号
	private String status;//订单状态
	private String paymethod;//付款方式
	private Integer flag;
	
	List<Integer> menuid = new ArrayList<Integer>();//菜品id
	
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public List<Integer> getMenuid() {
		return menuid;
	}
	public void setMenuid(List<Integer> menuid) {
		this.menuid = menuid;
	}
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderusername() {
		return orderusername;
	}
	public void setOrderusername(String orderusername) {
		this.orderusername = orderusername;
	}
	public String getOrderaddress() {
		return orderaddress;
	}
	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}
	public String getOrderphone() {
		return orderphone;
	}
	public void setOrderphone(String orderphone) {
		this.orderphone = orderphone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	
}
