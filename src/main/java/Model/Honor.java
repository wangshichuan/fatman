package Model;

/**
 * Created by wangshichuan on 2016/5/5.
 */
public class Honor {

    private int id;
    private String title;
    private String content;
    private String for_what;
    private String date;
    private String note;
    private String pic_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFor_what() {
        return for_what;
    }

    public void setFor_what(String for_what) {
        this.for_what = for_what;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
}
