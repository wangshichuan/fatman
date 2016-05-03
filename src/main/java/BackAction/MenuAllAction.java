package BackAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.MenuDao;
import Model.Menu;

public class MenuAllAction {
	MenuDao menuDao = new MenuDao();
	public String execute(){
		List<Menu> menulist = new ArrayList<Menu>();
		menulist = menuDao.selMenuAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("menulist", menulist);
		return "success";
	}
}
