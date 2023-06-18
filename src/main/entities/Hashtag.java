package main.entities;

public class Hashtag {
    private long id = 0;
    private String text;
    private static long counter = 0;
    private static synchronized long generateId() {
        return ++counter;
    }

    public Hashtag(String text) {
        this.id = generateId();
        this.text = text;
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
