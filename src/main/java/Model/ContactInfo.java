package Model;

/**
 * Created by wangshichuan on 2016/5/6.
 */
public class ContactInfo {
    private int tel;
    private String name;
    private String msg;

    public ContactInfo(int tel, String name, String msg) {
        this.tel = tel;
        this.name = name;
        this.msg = msg;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
