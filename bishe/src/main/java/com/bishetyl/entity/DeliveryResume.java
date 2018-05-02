package com.bishetyl.entity;

/**
 * Created by 汤玉龙 on 2018/4/25. 投递简历
 */
public class DeliveryResume {
    private int id;
    private int jobSeekerId;//求职者id
    private int resumeId;//简历id
    private int recruitId;//招聘id
    private int companyId;//公司id
    private String deliveryTime;//投递时间
    private int isBrowse;//是否被浏览

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(int jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public int getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(int recruitId) {
        this.recruitId = recruitId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getIsBrowse() {
        return isBrowse;
    }

    public void setIsBrowse(int isBrowse) {
        this.isBrowse = isBrowse;
    }
}
