package model.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.dao.DaoFriend;
import model.dao.DaoPost;
import model.dao.DaoUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private int id;
    
    private String firstname;
    
    private String lastname;

    private String email;

    private String password;
    
    private String address;
    @JsonDeserialize(using = EditObjectMapper.class)
    private Date birthday;
    @JsonDeserialize(using = EditObjectMapper.class)
    private Date registerDate;
    
    private Boolean relationship;
    
    private Integer phoneNumber;
    
    private Boolean gender;
    
    private Boolean interestedIn;
    
    private List<Friend> FriendList;
    
    private List<Post> posts;
    
    private List<Schooling> schoolings;
    
    private List<Work> works;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public boolean login(String email,String password){
        List<User> users=new DaoUser().getAll();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getEmail().equals(email)){
                if(users.get(i).getPassword().equals(password)){
                    this.email=users.get(i).getEmail();
                    this.password=users.get(i).getPassword();
                    this.id=users.get(i).getId();
                    this.firstname=users.get(i).getFirstname();
                    this.lastname=users.get(i).getLastname();
                    this.address=users.get(i).getAddress();
                    this.birthday=users.get(i).getBirthday();
                    this.registerDate=users.get(i).getRegisterDate();
                    this.relationship=users.get(i).getRelationship();
                    this.phoneNumber=users.get(i).getPhoneNumber();
                    this.gender=users.get(i).getGender();
                    this.interestedIn=users.get(i).getInterestedIn();
                    return true;
                }
            }
        }
        return false;
    }
    public List<Post> getPostOfYourFriends(){
        List<Friend> friends=new DaoFriend().getAll();
        List<Post> posts=new DaoPost().getAll();
        List<User> friendofyours=new ArrayList<>();
        List<Post> postofyourfriend =new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if((friends.get(i).getReceiver().getId()==this.id || friends.get(i).getReceiver().getId()==this.id) && friends.get(i).getAccepted()){
                friendofyours.add(friends.get(i).getReceiver().getId()==this.id?friends.get(i).getAsker():friends.get(i).getReceiver());
            }
        }
        for (int i = 0; i < posts.size(); i++) {
            for (int j = 0; j < friendofyours.size(); j++) {
                if(posts.get(i).getUser().getId()==friendofyours.get(j).getId()){
                    postofyourfriend.add(posts.get(i));
                }
            }
        }
        return postofyourfriend;
    }
    
}
