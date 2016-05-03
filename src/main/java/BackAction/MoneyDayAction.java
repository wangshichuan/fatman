package BackAction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.OrderDao;
import Model.Money;

public class MoneyDayAction {
	Money money = new Money();
	OrderDao orderDao = new OrderDao();
	public String execute(){
		Date dt=new Date();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String nowTime=df.format(dt);
		money = orderDao.getMoneyDay(nowTime);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("money", money);
		request.setAttribute("nowTime", nowTime);
		return "success";
	}
}
