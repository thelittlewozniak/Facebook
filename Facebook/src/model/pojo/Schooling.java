package model.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.dao.DaoSchooling;

import java.util.Date;

public class Schooling {

  private int id;

  private String name;

  private String address;

  private String type;

  @JsonDeserialize(using = EditObjectMapper.class)
  private Date beginDate;

  @JsonDeserialize(using = EditObjectMapper.class)
  private Date endDate;

  private Boolean graduate;

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

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
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

  public Boolean getGraduate() {
    return this.graduate;
  }

  public void setGraduate(Boolean graduate) {
    this.graduate = graduate;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  //                          Operations

  public boolean createASchooling() {
    return new DaoSchooling().create(this);
  }

  public boolean deleteASchooling() {
    return new DaoSchooling().delete(this);
  }

  public boolean updateASchooling() {
    return new DaoSchooling().update(this);
  }
}
