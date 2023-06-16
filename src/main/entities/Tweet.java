package main.entities;

import main.tads.linkedlist.ListaEnlazada;

public class Tweet {
    private long id;
    private String tweetText;
    private String tweetSource;
    private boolean isRetweet;
    private ListaEnlazada<Hashtag> hashtags;
    private String date;
    public Tweet(long id, String tweetText, String tweetSource, boolean isRetweet, String date) {
        this.id = id;
        this.tweetText = tweetText;
        this.tweetSource = tweetSource;
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

    public String gettweetText() {
        return tweetText;
    }

    public void settweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public String gettweetSource() {
        return tweetSource;
    }

    public void settweetSource(String tweetSource) {
        this.tweetSource = tweetSource;
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
