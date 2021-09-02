package com.yelp.reviews.models;

public class Review {
    private String id;
    private String url;
    private String text;
    private int rating;
    private String time_created;
    private User user;

    public Review() {

    }

    public Review(String id, String url, String text, int rating, String time_created, User user) {
        this.id = id;
        this.url = url;
        this.text = text;
        this.rating = rating;
        this.time_created = time_created;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTime_created() {
        return time_created;
    }

    public void setTime_created(String time_created) {
        this.time_created = time_created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
