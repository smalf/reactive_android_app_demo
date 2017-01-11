package com.demo.smalf.reactiveandroidappdemo.data.posts;

/**
 * Model for post object.
 * URL : http://jsonplaceholder.typicode.com/posts/1
 *
 * @author Serhiy Malofeev
 */
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{ " +
                "userId = " + userId +
                ", id = " + id +
                ", title = " + title +
                "}";
    }
}
