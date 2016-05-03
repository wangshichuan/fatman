package Action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Model.MenuModel;
import SearchMethod.SearchMethod;

/**
 * 根据类别名，搜索菜品信息
 *
 */
public class MenuTypeAction {
	public String type;
	SearchMethod search = new SearchMethod();
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(session.getAttribute("typename")!=null){
			type = (String)session.getAttribute("typename");
		}
		List<MenuModel> listMenu = new ArrayList<MenuModel>();
		System.out.println("type:"+type);
		listMenu = search.searchByType(type);
		if(listMenu.isEmpty())
			return "fail";
		request.setAttribute("listMenu", listMenu);
		request.setAttribute("typename", type);
		session.removeAttribute("typename");
		return "success";
	}
}
