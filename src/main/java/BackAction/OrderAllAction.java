package BackAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Model.OrderModel;
import SearchMethod.SearchMethod;
public class OrderAllAction {
	SearchMethod search = new SearchMethod();
	public String execute(){
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		//后台查看所有订单信息
		orderList = search.selOrderAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", orderList);
		return "success";
	}
}
