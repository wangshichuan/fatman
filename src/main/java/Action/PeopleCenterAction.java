package Action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Dao.OrderDao;
import Dao.UserDao;
import IndexData.OrderIndex;
import Model.User;
import Model.Order;
import SearchMethod.SearchMethod;
/**
 * 个人中心Action
 */
public class PeopleCenterAction {
	
	OrderDao order = new OrderDao();
	UserDao userDao = new UserDao();
	OrderDao orderDao = new OrderDao();
	OrderIndex orderIndex = new OrderIndex();
	public String execute(){
		User user = new User();
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("user")==null){
			return "fail";
		}
		//获取当前用户id
		Integer id = ((User)session.getAttribute("user")).getId();
		List<Order> orderList = new ArrayList<Order>();
		//根据当前用户id查找所下订单列表信息
		orderList = order.selOrderByUserid(id);
		user = userDao.searchByUserid(id);
		
		//获取当前系统时间，便于判断订单状态
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String nowTime = df.format(dt);
		
		
		Integer nowMin = Integer.parseInt(nowTime.split(":")[1]);
		Integer nowHour = Integer.parseInt(nowTime.split(" ")[1].split(":")[0]);
		for(int i=0;i<orderList.size();i++){
			String[] times = orderList.get(i).getTimes().split(" ");
			Integer min = Integer.parseInt(times[1].split(":")[1]);
			Integer hour = Integer.parseInt(times[1].split(":")[0]);
			if(nowTime.split(" ")[0].equals(times[0])){  //在同一天内查看该订单状态
				if((nowHour==hour&&(nowMin-min<=5))||((nowMin-min<=-55)&&nowHour-hour==1)&&(nowMin-min>-60)){  //5分钟内可以取消订单
					orderList.get(i).setFlag(1);
				}
			} 
			if(nowTime.split(" ")[0].equals(times[0])){    //在同一天查看该订单状态
				if(!((nowHour==hour&&(nowMin-min<30))||((nowMin-min<-30)&&nowHour-hour==1&&nowMin-min>=0))||(nowHour-hour>1)){   //超过30分钟标记为已过期
					if(orderList.get(i).getStatus().equals("已下单")){
					orderList.get(i).setStatus("已过期");
					orderDao.updateOrderByStatus("已过期", orderList.get(i).getId());
					orderIndex.buildIndex();
				}}
			}
			if(!nowTime.split(" ")[0].equals(times[0])){  //不在同一天查看该订单状态
					if(orderList.get(i).getStatus().equals("已下单")){
					orderList.get(i).setStatus("已过期");
					orderDao.updateOrderByStatus("已过期", orderList.get(i).getId());
					orderIndex.buildIndex();
				}
			}
			
		}
		if(user.getId()!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("orderlist", orderList);
			request.setAttribute("userinfo", user);
		}
		return "success";
	}
}
