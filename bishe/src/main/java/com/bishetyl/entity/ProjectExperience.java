package com.bishetyl.entity;

/**
 * Created by 汤玉龙 on 2018/4/21.
 */
public class ProjectExperience {
    private int id;
    private String companyName;
    private String startDate;
    private String endDate;
    private String projectName;
    private String projectDetails;
    private String dutyDetails;
    private int resumeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
    }

    public String getDutyDetails() {
        return dutyDetails;
    }

    public void setDutyDetails(String dutyDetails) {
        this.dutyDetails = dutyDetails;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }
}
