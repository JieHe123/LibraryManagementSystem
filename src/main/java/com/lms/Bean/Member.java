package com.lms.Bean;


import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {

  private long id;
  private String name;
  private String pwd;
  private long typeId;
  private double balance;
  private java.sql.Date regdate;
  private String tel;
  private String idNumber;

  //外键
  private Membertype type;

  public Member() {
  }

  public Member(long id, String name, String pwd, long typeId, double balance, Date regdate, String tel, String idNumber, Membertype type) {
    this.id = id;
    this.name = name;
    this.pwd = pwd;
    this.typeId = typeId;
    this.balance = balance;
    this.regdate = regdate;
    this.tel = tel;
    this.idNumber = idNumber;
    this.type = type;
  }

  public Member(long id, String pwd, long typeId, double balance, String tel, String idNumber) {
    this.id = id;
    this.pwd = pwd;
    this.typeId = typeId;
    this.balance = balance;
    this.tel = tel;
    this.idNumber = idNumber;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public long getTypeId() {
    return typeId;
  }

  public void setTypeId(long typeId) {
    this.typeId = typeId;
  }

  public Membertype getType() {
    return type;
  }

  public void setType(Membertype type) {
    this.type = type;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public java.sql.Date getRegdate() {
    return regdate;
  }

  public void setRegdate(java.sql.Date regdate) {
    this.regdate = regdate;
  }


  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }


  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  @Override
  public String toString() {
    return "Member{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", pwd='" + pwd + '\'' +
            ", type=" + type +
            ", balance='" + balance + '\'' +
            ", regdate=" + regdate +
            ", tel='" + tel + '\'' +
            ", idNumber='" + idNumber + '\'' +
            '}';
  }
}
