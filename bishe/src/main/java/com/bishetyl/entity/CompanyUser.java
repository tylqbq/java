package com.bishetyl.entity;

/**
 * Created by 汤玉龙 on 2018/4/27.
 */
public class CompanyUser {
    private int id;
    private String member;//会员名
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    private int companyId;
    private int examinePass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getExaminePass() {
        return examinePass;
    }

    public void setExaminePass(int examinePass) {
        this.examinePass = examinePass;
    }
}
