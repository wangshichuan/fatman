package Action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.OrderDao;
import Model.Order;
/**
 * 查看当前所下的订单
 *
 */
public class LookOrderAction {
	private Integer userid;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	OrderDao orderDao = new OrderDao();

	public String execute() {
		if(userid==null)
			return "fail";
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Order> order = new ArrayList<Order>();
		//查看当前订单信息
		order = orderDao.selOrderByUserid(userid);
		if (order != null) {
			request.setAttribute("order", order.get(0));  //从用户所有订单信息中取当前所下的订单信息
			return "success";
		}
		return "fail";
	}
}
