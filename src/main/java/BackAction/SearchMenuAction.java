package BackAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import SearchMethod.SearchMethod;
import Model.MenuModel;
public class SearchMenuAction {
	private String keyword;
	SearchMethod search = new SearchMethod();
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String execute(){
		List<MenuModel> menulist = new ArrayList<MenuModel>();
		menulist = search.searchMenu(keyword);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("menulist", menulist);
		return "success";
	}
}
