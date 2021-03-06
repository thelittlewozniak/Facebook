package model.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.dao.DaoLikeComment;
import model.dao.DaoLikePost;

import java.util.Date;

public class Like {

  private int id;

  @JsonDeserialize(using = EditObjectMapper.class)
  private Date dateLiked;

  private User user;

  private Post post;

  private Comment comment;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDateLiked() {
    return this.dateLiked;
  }

  public void setDateLiked(Date dateLiked) {
    this.dateLiked = dateLiked;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }

  //                          Operations

  public boolean createALikePost() {
    return new DaoLikePost().create(this);
  }

  public boolean createALikeOnComment() {
    return new DaoLikeComment().create(this);
  }

  public boolean deleteALikeOnComment() {
    return new DaoLikeComment().delete(this);
  }

  public boolean deleteALikePost() {
    return new DaoLikePost().delete(this);
  }
}
