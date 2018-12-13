package model.pojo;

import java.util.Date;
import java.util.List;

public class User {
    
    private String firstname;
    
    private String lastname;
    
    private String address;
    
    private Date birthday;
    
    private Date registerDate;
    
    private Boolean relationship;
    
    private Integer phoneNumber;
    
    private Boolean gender;
    
    private Boolean interestedIn;
    
    private List<Friend> FriendList;
    
    private List<Post> posts;
    
    private List<Schooling> schoolings;
    
    private List<Work> works;
    
    
    private String getFirstname() {
        return this.firstname;
    }
    
    private void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    private String getLastname() {
        return this.lastname;
    }
    
    private void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    private String getAddress() {
        return this.address;
    }
    
    private void setAddress(String address) {
        this.address = address;
    }
    
    private Date getBirthday() {
        return this.birthday;
    }
    
    private void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    private Date getRegisterDate() {
        return this.registerDate;
    }
    
    private void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    
    private Boolean getRelationship() {
        return this.relationship;
    }
    
    private void setRelationship(Boolean relationship) {
        this.relationship = relationship;
    }
    
    private Integer getPhoneNumber() {
        return this.phoneNumber;
    }
    
    private void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    private Boolean getGender() {
        return this.gender;
    }
    
    private void setGender(Boolean gender) {
        this.gender = gender;
    }
    
    private Boolean getInterestedIn() {
        return this.interestedIn;
    }
    
    private void setInterestedIn(Boolean interestedIn) {
        this.interestedIn = interestedIn;
    }
    
    private List<Friend> getFriendList() {
        return this.FriendList;
    }
    
    private void setFriendList(List<Friend> FriendList) {
        this.FriendList = FriendList;
    }

    private List<Post> getPosts() {
        return this.posts;
    }
    
    private void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
    private List<Schooling> getSchoolings() {
        return this.schoolings;
    }
    
    private void setSchoolings(List<Schooling> schoolings) {
        this.schoolings = schoolings;
    }
    
    private List<Work> getWorks() {
        return this.works;
    }
    
    private void setWorks(List<Work> works) {
        this.works = works;
    }
    

    //                          Operations                                  
    
    public boolean makeAPost() {
        //TODO
        return false;
    }
    
    public boolean makeAComment() {
        //TODO
        return false;
    }
    
    public boolean acceptAFriend() {
        //TODO
        return false;
    }
    
    public boolean addAFriend() {
        //TODO
        return false;
    }
    
    public boolean makeALike() {
        //TODO
        return false;
    }
    
    public boolean addAWork() {
        //TODO
        return false;
    }
    
    public boolean addASchool() {
        //TODO
        return false;
    }
    
    
}
