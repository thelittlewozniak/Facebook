package model.pojo;

import java.util.Date;

public class Post {

  private int id;

  private String data;

  private String type;

  private Date postDate;

  private User user;

  public int getId() {
    return this.id;
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

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
