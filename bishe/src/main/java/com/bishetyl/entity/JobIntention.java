package com.bishetyl.entity;

import java.util.List;

/**
 * Created by 汤玉龙 on 2018/3/21. 求职意向
 */
public class JobIntention {
    private  int id;
    private  float salary;
    private  String workPlace;
    private  String function; //职能
    private  String position;//职位
    private  String industry;//行业
    private  List<String> industryLabel;//行业标签 多个 在数据库中存为字符串 以,分隔(英文逗号)
    private  String introduction;//自我介绍
    private  int resumeId;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
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

    public List<String> getIndustryLabel() {
        return industryLabel;
    }

    public void setIndustryLabel(List<String> industryLabel) {
        this.industryLabel = industryLabel;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }
}
