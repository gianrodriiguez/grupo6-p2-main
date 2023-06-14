package main.entities;

public class Hashtag {
    private long id = 0;
    private String text;

    public Hashtag(long id, String text) {
        this.id = id;
        this.text = text;
    }
    public Hashtag() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
