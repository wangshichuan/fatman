package BackAction;

import Dao.OrderDao;
import IndexData.OrderIndex;

public class UpdateOrderSuccessAction {
	private String status;
	private Integer orderid;
	OrderDao orderDao = new OrderDao();
	OrderIndex orderIndex = new OrderIndex();
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String execute(){
		orderDao.updateOrderByStatus(status,orderid);
		orderIndex.buildIndex();
		return "success";
	}
}
