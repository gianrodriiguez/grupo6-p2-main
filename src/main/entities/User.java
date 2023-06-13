package src.main.entities;

import src.main.tads.linkedlist.ListaEnlazada;

public class User {
    private long id;
    private String name;
    private int favourites;
    private boolean isVerified;
    ListaEnlazada<Tweet> tweets;

    public User(long id, String name, int favourites, boolean isVerified) {
        this.id = id;
        this.name = name;
        this.favourites = favourites;
        this.isVerified = isVerified;
        this.tweets = new ListaEnlazada<>();
    }

    public User() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setTweets(ListaEnlazada<Tweet> tweets) {
        this.tweets = tweets;
    }
}
