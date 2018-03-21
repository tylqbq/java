package com.bishetyl.entity;

import java.util.List;

/**
 * Created by ������ on 2018/3/21. ����
 */
public class Resume {
    private int id;
    private String name;
    private String sex;
    private String birthDate;
    private String phoneNumber;
    private String email;
    private String address;
    private String  annualIncome;//������
    private int isPublic;  //�Ƿ񹫿�
    private int browsingTimes;//�������
    private EducationExperience educationExperience; //��������
    private JobIntention jobIntention;//��������
    private List<WorkExperience> workExperiences;//��������  ���Զ��

    public EducationExperience getEducationExperience() {
        return educationExperience;
    }

    public void setEducationExperience(EducationExperience educationExperience) {
        this.educationExperience = educationExperience;
    }

    public JobIntention getJobIntention() {
        return jobIntention;
    }

    public void setJobIntention(JobIntention jobIntention) {
        this.jobIntention = jobIntention;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }

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
}
