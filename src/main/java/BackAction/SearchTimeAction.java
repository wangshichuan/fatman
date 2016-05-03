package BackAction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.OrderDao;
import Model.Money;

public class SearchTimeAction {
	private String keyword;
	Money money = new Money();
	OrderDao orderDao = new OrderDao();
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String execute(){
		money = orderDao.getMoneyDay(keyword);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("money", money);
		request.setAttribute("nowTime", keyword);
		if(keyword.split("/").length==3)
			return "day";
		if(keyword.split("/").length==2)
			return "month";
		return "year";
	}
}
