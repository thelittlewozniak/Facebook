package model.pojo;

import model.dao.DaoFriend;

public class Friend {

  private Boolean accepted;

  private User asker;

  private User receiver;

  public Boolean getAccepted() {
    return this.accepted;
  }

  public void setAccepted(Boolean accepted) {
    this.accepted = accepted;
  }

  public User getAsker() {
    return this.asker;
  }

  public void setAsker(User asker) {
    this.asker = asker;
  }

  public User getReceiver() {
    return this.receiver;
  }

  public void setReceiver(User receiver) {
    this.receiver = receiver;
  }

  //                          Operations

  public boolean createADemand() {
    return new DaoFriend().create(this);
  }

  public boolean deleteAFriend() {
    return new DaoFriend().delete(this);
  }

  public boolean acceptADemand() {
    return new DaoFriend().update(this);
  }
}
