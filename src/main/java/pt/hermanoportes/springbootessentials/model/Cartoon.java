package pt.hermanoportes.springbootessentials.model;

public class Cartoon {
    private String title;

    public Cartoon(String title) {
        this.title = title;
    }

    public Cartoon() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
