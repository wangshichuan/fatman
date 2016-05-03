package Action;

import Dao.OrderDao;

public class CancelOrderAction {
	private Integer orderid;
	OrderDao orderDao = new OrderDao();
	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String execute(){
		
		orderDao.cancelOrderById(orderid);
		return "success";
	}
}
