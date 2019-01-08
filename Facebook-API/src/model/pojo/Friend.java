package model.pojo;

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
}
