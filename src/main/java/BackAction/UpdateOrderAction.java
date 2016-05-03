package BackAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.OrderDao;
import Dao.UserDao;
import Model.Menu;
import Model.Order;
import Model.User;

public class UpdateOrderAction {
	private String orderid;
	private String userid;
	UserDao userDao = new UserDao();
	OrderDao orderDao = new OrderDao();
	
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String execute(){
		User user = userDao.searchByUserid(Integer.parseInt(userid));
		Order order = orderDao.selOrderByOrderid(Integer.parseInt(orderid));
		List<Menu> menulist = orderDao.selMenuListByOrderid(Integer.parseInt(orderid));
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("user", user);
		request.setAttribute("order", order);
		request.setAttribute("menulist", menulist);
		return "success";
	}
}
