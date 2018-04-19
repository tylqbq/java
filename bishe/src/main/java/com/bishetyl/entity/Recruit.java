package com.bishetyl.entity;

/**
 * Created by 汤玉龙 on 2018/3/21. 招聘
 */
public class Recruit {
    private int id;
    private String positionName; //职位名称
    private String workPlace;    //工作地点
    private String salaryRange; //薪资范围
    private String recruitsNumber; //招聘人数
    private String positionInfo;  //职位信息
    private String contactWay;  //联系方式
    private String workTime;  //工作年限
    private String education;  //学历
    private String workType;   //工作类型
    private String publishDate; //发布日期
    private int companyId;   //所属公司id
    private String companyName;//所属公司名称

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }
    public String getRecruitsNumber() {
        return recruitsNumber;
    }

    public void setRecruitsNumber(String recruitsNumber) {
        this.recruitsNumber = recruitsNumber;
    }
    public String getPositionInfo() {
        return positionInfo;
    }

    public void setPositionInfo(String positionInfo) {
        this.positionInfo = positionInfo;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
