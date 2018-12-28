package model.pojo;

import java.util.Date;
import java.util.List;

public class Post {

    private int id;

    private String data;

    private String type;

    private Date postDate;

    private List<Comment> comments;

    private List<Like> likes;

    private User user;


    public int getId() {return this.id; }

    public void setId(int id) {this.id=id; }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getPostDate() {
        return this.postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return this.likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public User getUser(){return this.user;}

    public void setUser(User user){this.user=user;}

    //                          Operations

    public Post createAPost() {
        //TODO
        return null;
    }

    public boolean deleteAPost() {
        //TODO
        return false;
    }


}