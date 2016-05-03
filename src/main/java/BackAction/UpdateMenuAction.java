package BackAction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.MenuDao;
import Model.Menu;

public class UpdateMenuAction {
	private Integer menuid;
	MenuDao menuDao = new MenuDao();
	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	public String execute(){
		Menu menu = menuDao.selMenuById(menuid);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("menu", menu);
		return "success";
	}
}
