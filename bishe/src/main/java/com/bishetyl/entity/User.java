package com.bishetyl.entity;

/**
 * Created by Abcde on 2017/12/12.
 */
public class User {
    private  int     id;
    private  String  userName;
    private  String  userAccount;
    private  String  userPsd;
    private  String  tellNumber;
    private  String  sex;
    private  String  address;
    private  int     age;

    public String getTellNumber() {
        return tellNumber;
    }

    public void setTellNumber(String tellNumber) {
        this.tellNumber = tellNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
