package com.bishetyl.entity;

/**
 * Created by 汤玉龙 on 2018/3/21. 招聘
 */
public class Recruit {
    private int id;
    private String positionName;
    private String workPlace;
    private int salaryRange; //薪资范围  用数字代表不同范围 详见txt记录
    private String minRecruitsNumber; //招聘人数范围 最小
    private String maxRecruitsNumber; //招聘人数范围 最大
    private String positionInfo;  //职位信息
    private String contactWay;  //联系方式
    private int education;  //学历 用数字代表不同学历 详见txt记录
    private int workType;   //工作类型 用数字代表不同学历 详见txt记录
    private String publishDate; //发布日期
    private int companyId;

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

    public int getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(int salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getMinRecruitsNumber() {
        return minRecruitsNumber;
    }

    public void setMinRecruitsNumber(String minRecruitsNumber) {
        this.minRecruitsNumber = minRecruitsNumber;
    }

    public String getMaxRecruitsNumber() {
        return maxRecruitsNumber;
    }

    public void setMaxRecruitsNumber(String maxRecruitsNumber) {
        this.maxRecruitsNumber = maxRecruitsNumber;
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

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public int getWorkType() {
        return workType;
    }

    public void setWorkType(int workType) {
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
}
