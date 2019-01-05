package model.pojo;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

public class Work {

    private int id;

    private String name;

    private String address;
    @JsonDeserialize(using = EditObjectMapper.class)
    private Date beginDate;
    @JsonDeserialize(using = EditObjectMapper.class)
    private Date endDate;

    private String jobTitle;

    private User user;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBeginDate() {
        return this.beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //                          Operations

    public Work createAWork() {
        //TODO
        return null;
    }

    public boolean deleteAWork() {
        //TODO
        return false;
    }


}