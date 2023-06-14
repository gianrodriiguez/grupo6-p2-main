package main.entities;

import main.tads.linkedlist.ListaEnlazada;

public class Tweet {
    private long id;
    private String content;
    private String source;
    private boolean isRetweet;
    private ListaEnlazada<Hashtag> hashtags;
    private String date;
    public Tweet(long id, String content, String source, boolean isRetweet, String date) {
        this.id = id;
        this.content = content;
        this.source = source;
        this.isRetweet = isRetweet;
        this.hashtags = new ListaEnlazada<>();
        this.date = date;
    }

    public Tweet() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isRetweet() {
        return isRetweet;
    }

    public void setRetweet(boolean retweet) {
        isRetweet = retweet;
    }

    public ListaEnlazada<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(ListaEnlazada<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
