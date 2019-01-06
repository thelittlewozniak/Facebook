package model.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.dao.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public void getUser(){
        List<Friend> friends=new DaoFriend().getAll();
        this.FriendList=new ArrayList<>();
        for (Friend f:friends) {
            if((f.getAsker().getId()==this.id || f.getReceiver().getId()==this.id) && f.getAccepted()){
                this.FriendList.add(f);
            }
        }
        List<Post> posts=new DaoPost().getAll();
        this.posts=new ArrayList<>();
        for (Post p:posts) {
            if(p.getUser().getId()==this.id){
                this.posts.add(p);
            }
        }
        List<Schooling> schoools=new DaoSchooling().getAll();
        this.schoolings=new ArrayList<>();
        for (Schooling s:schoools) {
            if (s.getUser().getId() == this.getId()) {
                this.schoolings.add(s);
            }
        }
        List<Work> ws=new DaoWork().getAll();
        this.works=new ArrayList<>();
        for (Work w:works) {
            if(w.getUser().getId()==this.id){
                this.works.add(w);
            }
        }
    }
    
    public boolean makeAPost(String data, String type) {
        Post p = new Post();
        p.setUser(this);
        p.setData(data);
        p.setType(type);
        p.setPostDate(new Date());
        return p.createAPost();
    }

    public boolean makeAComment(String data, String type, int idpost) {
        Comment c = new Comment();
        c.setPost(new DaoPost().find(idpost));
        c.setData(data);
        c.setType(type);
        c.setUser(this);
        c.setPostDate(new Date());
        return c.createAComment();
    }

    public boolean acceptAFriend() {
        //TODO
        return false;
    }

    public boolean addAFriend() {
        //TODO
        return false;
    }

    public boolean makeALikeOnPost(int id) {
        Like l = new Like();
        l.setPost(new DaoPost().find(id));
        l.setUser(this);
        l.setDateLiked(new Date());
        return l.createALikePost();
    }

    public boolean deleteALikeOnPost(int id) {
        Like l = new DaoLikePost().find(id);
        return l.deleteALikePost();
    }

    public boolean makeALikeOnComment(int id) {
        Like l = new Like();
        l.setComment(new DaoComment().find(id));
        l.setUser(this);
        l.setDateLiked(new Date());
        return l.createALikeOnComment();
    }

    public boolean deleteALikeOnComment(int id) {
        Like l = new DaoLikeComment().find(id);
        return l.deleteALikeOnComment();
    }

    public List<User> searchAUser(String keyword){
        List<User> users=new DaoUser().getAll();
        List<User> result=new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).lastname.contains(keyword))
                result.add(users.get(i));
            else if(users.get(i).firstname.contains(keyword))
                result.add(users.get(i));
        }
        return result;
    }

    public boolean addAWork() {
        //TODO
        return false;
    }

    public boolean addASchool() {
        //TODO
        return false;
    }

    public boolean login(String email, String password) {
        List<User> users = new DaoUser().getAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                if (users.get(i).getPassword().equals(password)) {
                    this.email = users.get(i).getEmail();
                    this.password = users.get(i).getPassword();
                    this.id = users.get(i).getId();
                    this.firstname = users.get(i).getFirstname();
                    this.lastname = users.get(i).getLastname();
                    this.address = users.get(i).getAddress();
                    this.birthday = users.get(i).getBirthday();
                    this.registerDate = users.get(i).getRegisterDate();
                    this.relationship = users.get(i).getRelationship();
                    this.phoneNumber = users.get(i).getPhoneNumber();
                    this.gender = users.get(i).getGender();
                    this.interestedIn = users.get(i).getInterestedIn();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean register(String email, String password, String firstname, String lastname, String address, String birthday, String relationShip, String phoneNumber, String gender, String interestedIn) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        try {
            this.birthday = new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
        } catch (ParseException e) {
            this.birthday = new Date();
        }
        this.registerDate = new Date();
        this.relationship = Boolean.parseBoolean(relationShip);
        this.phoneNumber = Integer.parseInt(phoneNumber);
        this.gender = Boolean.parseBoolean(gender);
        this.interestedIn = Boolean.parseBoolean(interestedIn);
        return new DaoUser().create(this);
    }

    public List<Post> getPostOfYourFriends() {
        List<Friend> friends = new DaoFriend().getAll();
        List<Post> posts = new DaoPost().getAll();
        List<User> friendofyours = new ArrayList<>();
        List<Post> postofyourfriend = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if ((friends.get(i).getReceiver().getId() == this.id || friends.get(i).getReceiver().getId() == this.id) && friends.get(i).getAccepted()) {
                friendofyours.add(friends.get(i).getReceiver().getId() == this.id ? friends.get(i).getAsker() : friends.get(i).getReceiver());
            }
        }
        friendofyours.add(this);
        for (int i = 0; i < posts.size(); i++) {
            for (int j = 0; j < friendofyours.size(); j++) {
                if (posts.get(i).getUser().getId() == friendofyours.get(j).getId()) {
                    postofyourfriend.add(posts.get(i));
                }
            }
        }
        return postofyourfriend;
    }

}
