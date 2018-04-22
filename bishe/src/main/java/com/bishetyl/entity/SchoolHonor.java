package com.bishetyl.entity;

/**
 * Created by 汤玉龙 on 2018/4/21. 简历 学习荣誉获奖
 */
public class SchoolHonor {
    private  int id;
    private  String startDate;//获奖日期
    private  String prizeName;//获奖名称
    private  String level;//获奖级别
    private  int resumeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }
}
