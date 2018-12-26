package model.pojo;

import java.util.Date;
import java.util.List;

public class User {

    private String firstname;

    private String lastname;

    private String email;

    private String password;

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


    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Boolean getRelationship() {
        return this.relationship;
    }

    public void setRelationship(Boolean relationship) {
        this.relationship = relationship;
    }

    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getGender() {
        return this.gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getInterestedIn() {
        return this.interestedIn;
    }

    public void setInterestedIn(Boolean interestedIn) {
        this.interestedIn = interestedIn;
    }

    public List<Friend> getFriendList() {
        return this.FriendList;
    }

    public void setFriendList(List<Friend> FriendList) {
        this.FriendList = FriendList;
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Schooling> getSchoolings() {
        return this.schoolings;
    }

    public void setSchoolings(List<Schooling> schoolings) {
        this.schoolings = schoolings;
    }

    public List<Work> getWorks() {
        return this.works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
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