package Action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Model.MenuModel;
import SearchMethod.SearchMethod;


/**
 * 在购物车中删除菜品
 *
 */
public class DeleteMenuAction {
	private Integer menuid;
	private String typename;
	SearchMethod search = new SearchMethod();
	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<MenuModel> listmenu = new ArrayList<MenuModel>();
		listmenu = (List<MenuModel>)session.getAttribute("listMenu");
		List<Integer> listmenuid = (List<Integer>)session.getAttribute("menuid");
		if(listmenu.isEmpty()||listmenuid.isEmpty())
			return "fail";
		int index = -100;
		for(int i=0;i<listmenu.size();i++){
			if(listmenu.get(i).getMenuid() == menuid){
				index = i;
			}
		}
		if(index!=-100){
			listmenu.remove(index);
		}
		int idindex = -100;
		for(int i=0;i<listmenuid.size();i++){
			if(listmenuid.get(i)==menuid){
				idindex = i;
			}
		}
		if(idindex!=-100){
			listmenuid.remove(idindex);
		}
		session.setAttribute("typename", typename);
		session.setAttribute("listMenu", listmenu);
		session.setAttribute("menuid", listmenuid);
		return "success";
	}
}
