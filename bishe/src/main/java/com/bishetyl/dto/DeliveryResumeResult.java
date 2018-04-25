package com.bishetyl.dto;

/**
 * Created by 汤玉龙 on 2018/4/25.  简历投返回数据
 */
public class DeliveryResumeResult {
    private int id;
    private int jobSeekerId;
    private int resumeId;
    private String resumeName;
    private int recruitId;
    private String recruitPositionName;
    private String deliveryTime;
    private int companyId;

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

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public int getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(int recruitId) {
        this.recruitId = recruitId;
    }

    public String getRecruitPositionName() {
        return recruitPositionName;
    }

    public void setRecruitPositionName(String recruitPositionName) {
        this.recruitPositionName = recruitPositionName;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
