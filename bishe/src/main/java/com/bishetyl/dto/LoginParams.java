package com.bishetyl.dto;

/**
 * Created by ÌÀÓñÁú on 2018/3/28.µÇÂ¼²ÎÊı
 */
public class LoginParams {
    private String phoneNumber;
    private String password;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
