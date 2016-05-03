package BackAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.OrderDao;
import Dao.UserDao;
import Model.Order;
import Model.Menu;
import Model.User;

public class OrderDetailAction {
	private Integer userid;
	private Integer orderid;
	UserDao userDao = new UserDao();
	OrderDao orderDao = new OrderDao();
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String execute(){
		//查看订单详情
		User user = new User();
		user = userDao.searchByUserid(userid);
		Order order = new Order();
		order = orderDao.selOrderByOrderid(orderid);
		List<Menu> menulist = new ArrayList<Menu>();
		menulist = orderDao.selMenuListByOrderid(orderid);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("user", user);
		request.setAttribute("order", order);
		request.setAttribute("menulist", menulist);
		return "success";
	}
}
