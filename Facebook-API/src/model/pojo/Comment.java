package model.pojo;

import java.util.Date;
import java.util.List;

public class Comment {

    private String data;

    private String type;

    private Date postDate;

    private List<Like> likes;

    private Post post;

    private User user;


    private String getData() { return this.data; }

    private void setData(String data) { this.data = data; }

    private String getType() { return this.type; }

    private void setType(String type) { this.type = type; }

    private Date getPostDate() { return this.postDate; }

    private void setPostDate(Date postDate) { this.postDate = postDate; }

    private List<Like> getLikes() { return this.likes; }

    private void setLikes(List<Like> likes) { this.likes = likes; }


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