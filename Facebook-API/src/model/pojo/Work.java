package model.pojo;


import java.util.Date;

public class Work {

    private String name;

    private String address;

    private Date beginDate;

    private Date endDate;

    private String jobTitle;


    private User user;


    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getAddress() {
        return this.address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    private Date getBeginDate() {
        return this.beginDate;
    }

    private void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    private Date getEndDate() {
        return this.endDate;
    }

    private void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    private String getJobTitle() {
        return this.jobTitle;
    }

    private void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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