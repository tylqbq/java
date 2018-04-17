package com.bishetyl.dto;

/**
 * Created by 汤玉龙 on 2018/4/17. 招聘搜索参数
 */
public class RecruitSearchParams {
    public  String keyWord;//关键字
    public  String address;//地点
    public  String industry;//行业
    public  String function;//职能
    public  String publishTime;//发布时间
    public  String salaryRang;//薪资范围
    public  String companyType;//公司类型
    public  String workTime;//工作年限
    public  String education;//学历
    public  String staffNumber;//公司规模（员工人数）
    public  String workType;//工作类型（全职、兼职、实习等）

    private int pageNumber; //页码数
    private int pageSize;  //每页数据条数

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getSalaryRang() {
        return salaryRang;
    }

    public void setSalaryRang(String salaryRang) {
        this.salaryRang = salaryRang;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String starffNumber) {
        this.staffNumber = starffNumber;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }
}
