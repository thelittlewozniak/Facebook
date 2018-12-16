package model.pojo;


public class Friend {

    private Boolean accepted;

    private User asker;

    private User receiver;


    private Boolean getAccepted() {
        return this.accepted;
    }

    private void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    private User getAsker() {
        return this.asker;
    }

    private void setAsker(User asker) {
        this.asker = asker;
    }

    private User getReceiver() {
        return this.receiver;
    }

    private void setReceiver(User receiver) {
        this.receiver = receiver;
    }


    //                          Operations

    public Friend createADemand() {
        //TODO
        return null;
    }

    public boolean deleteADemand() {
        //TODO
        return false;
    }

    public boolean acceptADemand() {
        //TODO
        return false;
    }


}