package com.bishetyl.dto;

/**
 * Created by 汤玉龙 on 2018/4/25.
 */
public class ChangePassWordParams {
    private String oldPassword;
    private String newPassword;
    private int jobSeekerId;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public int getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(int jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }
}
