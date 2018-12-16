package model.pojo;


import java.util.Date;

public class Schooling {

    private String name;

    private String address;

    private String type;

    private Date beginDate;

    private Date endDate;

    private Boolean graduate;

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

    private String getType() {
        return this.type;
    }

    private void setType(String type) {
        this.type = type;
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

    private Boolean getGraduate() {
        return this.graduate;
    }

    private void setGraduate(Boolean graduate) {
        this.graduate = graduate;
    }


    //                          Operations

    public Schooling CreateASchooling() {
        //TODO
        return null;
    }

    public boolean DeleteASchooling() {
        //TODO
        return false;
    }


}