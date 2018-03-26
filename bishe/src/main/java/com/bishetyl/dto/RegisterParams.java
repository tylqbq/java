package com.bishetyl.dto;

/**
 * Created by 汤玉龙 on 2018/3/26. 注册参数类
 */
public class RegisterParams {
    private String phoneNumber;
    private String password;
    private Integer vertificationCode;//验证码

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCode() {
        return 1111;
    }

    public void setCode(Integer vertificationCode) {
        this.vertificationCode = vertificationCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
