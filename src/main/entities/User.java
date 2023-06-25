package main.entities;

import main.tads.linkedlist.ListaEnlazada;

public class User implements Comparable<User> {
    private long id;
    private String name;
    private double favourites;
    private boolean isVerified;
    private ListaEnlazada<Tweet> tweets;
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

    public void incrementNumberOfTweets() {
        numberOfTweets++;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFavourites(double favourites) {
        this.favourites = favourites;
    }

    public void setTweets(ListaEnlazada<Tweet> tweets) {
        this.tweets = tweets;
    }

    public int getNumberOfTweets() {
        return numberOfTweets;
    }

    public void setNumberOfTweets(int numberOfTweets) {
        this.numberOfTweets = numberOfTweets;
    }

    public static long getCounter() {
        return counter;
    }

    public static void setCounter(long counter) {
        User.counter = counter;
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

    public boolean getIsVerified() {
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
        numberOfTweets += 1;
    }

    @Override
    public int compareTo(User otherUser) {
        return Integer.compare(this.numberOfTweets, otherUser.numberOfTweets);
    }
}
