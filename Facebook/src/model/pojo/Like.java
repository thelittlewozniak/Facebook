package model.pojo;


import java.util.Date;

public class Like {
    
    private Date dateLiked;
    
    private User user;
    
    private Post post;
    
    private Comment comment;


    private Date getDateLiked() {
        return this.dateLiked;
    }
    
    private void setDateLiked(Date dateLiked) {
        this.dateLiked = dateLiked;
    }
    
    private User getUser() {
        return this.user;
    }
    
    private void setUser(User user) {
        this.user = user;
    }
    

    //                          Operations                                  
    
    public Like createAPost() {
        //TODO
        return null;
    }
    
    public boolean deleteAPost() {
        //TODO
        return false;
    }
    
    
}
