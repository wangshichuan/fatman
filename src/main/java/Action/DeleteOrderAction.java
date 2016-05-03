package Action;

import Dao.OrderDao;
import IndexData.OrderIndex;

public class DeleteOrderAction {
	private Integer orderid;
	OrderIndex orderIndex = new OrderIndex();
	OrderDao orderDao = new OrderDao();
	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String execute(){
		//删除指定订单
		orderDao.delOrderById(orderid);
		orderIndex.delOrderById(orderid);
		return "success";
	}
}
