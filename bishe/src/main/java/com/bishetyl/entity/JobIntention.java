package com.bishetyl.entity;

import java.util.List;

/**
 * Created by 汤玉龙 on 2018/3/21. 简历 求职意向
 */
public class JobIntention {
    private  int id;
    private  String  salary;//薪资
    private  String workPlace;//工作地点
    private  String function; //职能
    private  String position;//职位
    private  String industry;//行业
    private  String industryLabel;//标签
    private  String introduction;//自我 评价
    private  String workType;//工作类型
    private  int resumeId;

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustryLabel() {
        return industryLabel;
    }

    public void setIndustryLabel(String industryLabel) {
        this.industryLabel = industryLabel;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }
}
