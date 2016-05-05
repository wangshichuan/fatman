package BackAction.company_honor;

import Model.Admin;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.CompanyHonorService;
import service.impl.CompanyHonorServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * Created by wangshichuan on 2016/5/4.
 */
public class add extends ActionSupport {

    CompanyHonorService honor = new CompanyHonorServiceImpl();
    private File file;

    // 提交过来的file的名字
    private String fileFileName;

    // 提交过来的file的MIME类型
    private String fileContentType;
    private String title;
    private String content;
    private String note;

    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
//        Admin admin = (Admin) session.getAttribute("admin");
//        if (admin == null) {
//            request.setAttribute("flag", -1);
//            return "fail";
//        }
        String fileName;
        try {
            fileName = saveFile();
        } catch (IOException e) {
//            e.printStackTrace();
            return "fail";
        }
        int page = request.getAttribute("page") == null ? 0 : (int) request.getAttribute("page");
        honor.add(title, content, fileName, "");
        request.setAttribute("flag", 1);
        return "success";
    }

    public String saveFile() throws IOException {
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
        fileFileName = "upload" + File.separator + fileFileName;
        System.out.println("上传文件名:" + fileFileName);
        // 关闭输入流
        is.close();

        // 关闭输出流
        os.close();

        return fileFileName;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
