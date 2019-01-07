package model.pojo;

import java.util.Date;

public class Like {

  private int id;

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

  public Like createAPost() {
    // TODO
    return null;
  }

  public boolean deleteAPost() {
    // TODO
    return false;
  }
}
