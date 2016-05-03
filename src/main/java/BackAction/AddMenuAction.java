package BackAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.MenuDao;
import IndexData.MenuIndex;
import Model.Menu;
@SuppressWarnings("serial")
public class AddMenuAction extends ActionSupport{
	private File file;

	// 提交过来的file的名字
	private String fileFileName;

	// 提交过来的file的MIME类型
	private String fileContentType;
	private Integer menuid;
	private Double price;
	private String menuname;
	private String describe;
	private String typename;
	private Double chengben;
	MenuDao menuDao = new MenuDao();
	MenuIndex menuIndex = new MenuIndex();
	
	
	
	public Double getChengben() {
		return chengben;
	}

	public void setChengben(Double chengben) {
		this.chengben = chengben;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String execute() throws Exception {
		// 基于myFile创建一个文件输入流
		InputStream is = new FileInputStream(file);

		// 设置上传文件目录
		String uploadPath = ServletActionContext.getServletContext()
				.getRealPath("/Back/upload");
		// 设置目标文件
		File toFile = new File(uploadPath, this.getFileFileName());

		// 创建一个输出流
		OutputStream os = new FileOutputStream(toFile);

		// 设置缓存
		byte[] buffer = new byte[1024];

		int length = 0;

		// 读取myFile文件输出到toFile文件中
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		System.out.println(uploadPath);
		System.out.println("上传文件名:" + fileFileName);
		// 关闭输入流
		is.close();

		// 关闭输出流
		os.close();
		File pathfrom = new File(uploadPath);
		File pathto = new File("D:/JAVA/apache-tomcat-6.0.29/apache-tomcat-6.0.29/webapps/FastNet/Before/upload");
		FileUtils.copyDirectory(pathfrom, pathto);
		Menu menu = new Menu();
		menu.setId(menuid);
		menu.setDescribes(describe);
		menu.setMenuname(menuname);
		menu.setPicUrl("upload/" + fileFileName);
		menu.setPrice(price);
		menu.setTypename(typename);
		menu.setChengben(chengben);
		menuDao.addMenu(menu);
		menuIndex.buildIndex();
		return "success";
	}
}
