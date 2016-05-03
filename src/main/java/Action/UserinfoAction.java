package Action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Dao.OrderDao;
import Model.Order;
import SearchMethod.SearchMethod;
/**
 * 订单保存
 */
public class UserinfoAction {
	private Integer userid;
	private String username;
	private String address;
	private String phone;
	private String paymethod;
	
	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String totalprice;
	
	private List<Integer> listmenuid = new ArrayList<Integer>();
	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	SearchMethod search = new SearchMethod();
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String execute(){
		OrderDao orderDao = new OrderDao();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		listmenuid = (List<Integer>)request.getSession().getAttribute("menuid");
		if(listmenuid==null)
			return "fail";
		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置显示格式
		String nowTime="";
		nowTime= df.format(dt);
		
		
		if(listmenuid!=null){
			Order order = new Order();
			order.setUserid(userid);
			order.setOrderaddress(address);
			order.setOrderusername(username);
			order.setOrderphone(phone);
			order.setMenuid(listmenuid);
			order.setTimes(nowTime);
			order.setPaymethod(paymethod);
			order.setTotalprice(Double.parseDouble(totalprice));
			orderDao.save(order);   //保存订单信息
			session.removeAttribute("listMenu");  //将加入购物车的商品移除
			session.removeAttribute("menuid");
			return "success";
		}
		
		return "fail";
	}
}
