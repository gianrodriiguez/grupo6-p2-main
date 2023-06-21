package main.entities;

import main.tads.linkedlist.ListaEnlazada;

public class Hashtag {
    ListaEnlazada<Tweet> tweets;
    private long id = 0;
    private String text;
    private static long counter = 0;
    private static synchronized long generateId() {
        return ++counter;
    }

    public Hashtag(String text) {
        this.tweets = new ListaEnlazada<>();
        this.id = generateId();
        this.text = text;
    }

    public ListaEnlazada<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(ListaEnlazada<Tweet> tweets) {
        this.tweets = tweets;
    }

    public static long getCounter() {
        return counter;
    }

    public static void setCounter(long counter) {
        Hashtag.counter = counter;
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
