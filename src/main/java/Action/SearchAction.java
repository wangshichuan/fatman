package Action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Model.MenuModel;
import SearchMethod.SearchMethod;

public class SearchAction {
	private String keyword;
	private String typename;
	SearchMethod search = new SearchMethod();
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(keyword==null){
			HttpSession session = request.getSession();
			session.setAttribute("typename", typename);
			return "fail";
		}
		List<MenuModel> listmenu = new ArrayList<MenuModel>();
		listmenu=search.searchMenuByName(keyword);
		request.setAttribute("listMenu", listmenu);
		return "success";
	}
}
