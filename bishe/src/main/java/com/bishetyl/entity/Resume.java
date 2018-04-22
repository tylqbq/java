package com.bishetyl.entity;

import java.util.List;

/**
 * Created by 汤玉龙 on 2018/3/21. 简历
 */
public class Resume {
    private int id;
    private String name; //姓名
    private String sex;  //性别
    private String birthDate;//出生日期
    private String phoneNumber;//电话
    private String email;//邮箱
    private String address;//居住地址
    private String  annualIncome;//目前年收入
    private int isPublic;  //是否公开
    private int browsingTimes;//浏览次数


    private JobIntention jobIntention;//求职意向
    private List<WorkExperience> workExperiencesList;//工作经验
    private List<ProjectExperience> projectExperiencesList;//项目经验
    private EducationExperience educationExperience;//教育经历
    private List<SchoolHonor> schoolHonorList; //学校荣誉
    private List<SchoolDuties> schoolDutiesList;//学校职务


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

    public int getBrowsingTimes() {
        return browsingTimes;
    }

    public void setBrowsingTimes(int browsingTimes) {
        this.browsingTimes = browsingTimes;
    }

    public JobIntention getJobIntention() {
        return jobIntention;
    }

    public void setJobIntention(JobIntention jobIntention) {
        this.jobIntention = jobIntention;
    }

    public List<WorkExperience> getWorkExperiencesList() {
        return workExperiencesList;
    }

    public void setWorkExperiencesList(List<WorkExperience> workExperiencesList) {
        this.workExperiencesList = workExperiencesList;
    }

    public List<ProjectExperience> getProjectExperiencesList() {
        return projectExperiencesList;
    }

    public void setProjectExperiencesList(List<ProjectExperience> projectExperiencesList) {
        this.projectExperiencesList = projectExperiencesList;
    }

    public EducationExperience getEducationExperience() {
        return educationExperience;
    }

    public void setEducationExperience(EducationExperience educationExperience) {
        this.educationExperience = educationExperience;
    }

    public List<SchoolHonor> getSchoolHonorList() {
        return schoolHonorList;
    }

    public void setSchoolHonorList(List<SchoolHonor> schoolHonorList) {
        this.schoolHonorList = schoolHonorList;
    }

    public List<SchoolDuties> getSchoolDutiesList() {
        return schoolDutiesList;
    }

    public void setSchoolDutiesList(List<SchoolDuties> schoolDutiesList) {
        this.schoolDutiesList = schoolDutiesList;
    }
}
