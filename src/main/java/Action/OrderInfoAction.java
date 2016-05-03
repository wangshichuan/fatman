package Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class OrderInfoAction {
	private Double totalprice;

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("totalprice", totalprice);
		return "success";
	}
	
}
