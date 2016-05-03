package BackAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import SearchMethod.SearchMethod;
import Model.OrderModel;
public class SearchOrderAction {
	private String keyword;
	SearchMethod search = new SearchMethod();
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String execute(){
		List<OrderModel> orderlist = new ArrayList<OrderModel>();
		orderlist = search.searchOrder(keyword);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", orderlist);
		return "success";
	}
}
