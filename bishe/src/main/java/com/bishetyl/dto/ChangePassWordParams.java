package com.bishetyl.dto;

/**
 * Created by 汤玉龙 on 2018/4/25.
 */
public class ChangePassWordParams {
    private String oldPassword;
    private String newPassword;
    private int jobSeekerId;
    private int companyUserId;
    private int manageUserId;

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

    public int getCompanyUserId() {
        return companyUserId;
    }

    public void setCompanyUserId(int companyUserId) {
        this.companyUserId = companyUserId;
    }

    public int getManageUserId() {
        return manageUserId;
    }

    public void setManageUserId(int manageUserId) {
        this.manageUserId = manageUserId;
    }
}
