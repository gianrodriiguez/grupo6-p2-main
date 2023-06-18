package main.entities;

import main.tads.linkedlist.ListaEnlazada;

import java.util.Date;

public class Tweet {
    private long id;
    private String tweetText;
    private String tweetSource;
    private boolean isRetweet;
    private ListaEnlazada<Hashtag> hashtags;
    private Date date;
    public Tweet(long id, String tweetText, String tweetSource, boolean isRetweet, Date date) {
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

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public String getTweetSource() {
        return tweetSource;
    }

    public void setTweetSource(String tweetSource) {
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

    public void addHashtag(Hashtag hashtag) {
        hashtags.add(hashtag);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
