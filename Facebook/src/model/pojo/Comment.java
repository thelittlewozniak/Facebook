package model.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.dao.DaoComment;
import model.dao.DaoLikeComment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {

    private int id;

    private String data;

    private String type;
    @JsonDeserialize(using = EditObjectMapper.class)
    private Date postDate;

    private List<Like> likes;

    private Post post;

    private User user;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<Like> getLikes() {
        return this.likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //                          Operations

    public boolean createAComment() {
        return new DaoComment().create(this);
    }

    public boolean deleteAComment() {
        return new DaoComment().delete(this);
    }

    public void getAComment() {
        this.likes = new ArrayList<>();
        List<Like> l = new DaoLikeComment().getAll();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getComment().getId() == this.id) {
                this.likes.add(l.get(i));
            }
        }
    }

}