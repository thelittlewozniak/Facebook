package model.pojo;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Post {
    
    private String data;
    
    private String type;
    
    private Date postDate;
    
    private List<Comment> comments;
    
    private List<Like> likes;
    
    private User user;
    

    private String getData() {
        return this.data;
    }

    private void setData(String data) {
        this.data = data;
    }
    
    private String getType() {
        return this.type;
    }
    
    private void setType(String type) {
        this.type = type;
    }
    
    private Date getPostDate() {
        return this.postDate;
    }
    
    private void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
    
    private List<Comment> getComments() {
        return this.comments;
    }
    
    private void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
    private List<Like> getLikes() {
        return this.likes;
    }
    
    private void setLikes(List<Like> likes) {
        this.likes = likes;
    }
    

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
