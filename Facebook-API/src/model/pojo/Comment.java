package model.pojo;

import java.util.Date;
import java.util.List;

public class Comment {

    private int id;

    private String data;

    private String type;

    private Date postDate;

    private List<Like> likes;

    private Post post;

    private User user;


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getData() { return this.data; }

    public void setData(String data) { this.data = data; }

    public String getType() { return this.type; }

    public void setType(String type) { this.type = type; }

    public Date getPostDate() { return this.postDate; }

    public void setPostDate(Date postDate) { this.postDate = postDate; }

    public List<Like> getLikes() { return this.likes; }

    public void setLikes(List<Like> likes) { this.likes = likes; }

    public Post getPost() { return post; }

    public void setPost(Post post) { this.post = post; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
    //                          Operations

    public Comment createAComment() {
        //TODO
        return null;
    }

    public boolean deleteAComment() {
        //TODO
        return false;
    }


}