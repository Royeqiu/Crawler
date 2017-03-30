package model;

/**
 * Created by roye on 2017/3/29.
 */
    public abstract class WebPageContent {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected String title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    protected String content;
}
