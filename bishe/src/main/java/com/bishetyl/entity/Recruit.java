package com.bishetyl.entity;

/**
 * Created by ������ on 2018/3/21. ��Ƹ
 */
public class Recruit {
    private int id;
    private String positionName;
    private String workPlace;
    private int salaryRange; //н�ʷ�Χ  �����ִ���ͬ��Χ ���txt��¼
    private String minRecruitsNumber; //��Ƹ������Χ ��С
    private String maxRecruitsNumber; //��Ƹ������Χ ���
    private String positionInfo;  //ְλ��Ϣ
    private String contactWay;  //��ϵ��ʽ
    private int education;  //ѧ�� �����ִ���ͬѧ�� ���txt��¼
    private int workType;   //�������� �����ִ���ͬѧ�� ���txt��¼
    private String publishDate; //��������
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
