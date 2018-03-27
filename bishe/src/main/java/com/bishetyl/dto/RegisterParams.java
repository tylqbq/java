package com.bishetyl.dto;

/**
 * Created by 汤玉龙 on 2018/3/26. 注册参数类
 */
public class RegisterParams {
    private String phoneNumber;
    private String password;
    private String repeatPassword;
    private String captcha;
    private String verificationCode;

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    private Integer vertificationCode;//验证码

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

    public Integer getVertificationCode() {
        return vertificationCode;
    }

    public void setVertificationCode(Integer vertificationCode) {
        this.vertificationCode = vertificationCode;
    }
}
