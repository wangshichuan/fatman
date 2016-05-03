package BackAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import SearchMethod.SearchMethod;
import Model.UserModel;
public class SearchUserAction {
	private String keyword;
	SearchMethod search = new SearchMethod();
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String execute(){
		List<UserModel> userlist = new ArrayList<UserModel>();
		userlist = search.searchUser(keyword);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("userlist", userlist);
		return "success";
	}
}
