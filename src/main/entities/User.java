package main.entities;

import main.tads.linkedlist.ListaEnlazada;

public class User {
    private long id;
    private String name;
    private double favourites;
    private boolean isVerified;
    ListaEnlazada<Tweet> tweets;
    private int numberOfTweets = 0;
    private static long counter = 0;
    public User(String name, double favourites, boolean isVerified) {
        this.id = generateId();
        this.name = name;
        this.favourites = favourites;
        this.isVerified = isVerified;
        this.tweets = new ListaEnlazada<>();
    }

    private static synchronized long generateId() {
        return ++counter;
    }
    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFavourites() {
        return favourites;
    }

    public void setFavourites(Double favourites) {
        this.favourites = favourites;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public ListaEnlazada<Tweet> getTweets() {
        return tweets;
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
        numberOfTweets =+ 1;
    }
}
