package model.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.org.apache.xpath.internal.operations.Bool;
import model.dao.DaoComment;
import model.dao.DaoLikePost;
import model.dao.DaoPost;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    private int id;

    private String data;

    private String type;
    @JsonDeserialize(using = EditObjectMapper.class)
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

    public boolean createAPost() {
        return new DaoPost().create(this);
    }

    public void getAPost(){
        List<Like> ls=new DaoLikePost().getAll();
        this.likes=new ArrayList<>();
        for (int i = 0; i < ls.size(); i++) {
            if(ls.get(i).getPost().getId()==this.id){
                this.likes.add(ls.get(i));
            }
        }
        this.comments=new ArrayList<>();
        List<Comment> cs=new DaoComment().getAll();
        for (int i = 0; i < cs.size(); i++) {
            if(cs.get(i).getPost().getId()==this.id){
                this.comments.add(cs.get(i));
            }
        }
    }
    public boolean deleteAPost() {
        //TODO
        return false;
    }


}