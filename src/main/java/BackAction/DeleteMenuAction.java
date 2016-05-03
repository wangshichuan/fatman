package BackAction;

import Dao.MenuDao;
import IndexData.MenuIndex;

public class DeleteMenuAction {
	private Integer menuid;
	MenuDao menuDao = new MenuDao();
	MenuIndex menuIndex = new MenuIndex();
	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	public String execute(){
		menuDao.deleteMenuById(menuid);
		menuIndex.deleteMenuById(menuid);
		return "success";
	}
}
