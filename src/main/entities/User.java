package main.entities;

import main.tads.linkedlist.ListaEnlazada;

public class User {
    private long id;
    private String name;
    private int favourites;
    private boolean isVerified;
    ListaEnlazada<Tweet> tweets;
    private static long counter = 0;
    private static synchronized long generateId() {
        return ++counter; // Increment the counter and assign the new value as the ID
    }
    public User(long id, String name, int favourites, boolean isVerified) {
        this.id = generateId();
        this.name = name;
        this.favourites = favourites;
        this.isVerified = isVerified;
        this.tweets = new ListaEnlazada<>();
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    public User() {}

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFavourites() {
        return favourites;
    }

    public void setFavourites(int favourites) {
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
    }
}
