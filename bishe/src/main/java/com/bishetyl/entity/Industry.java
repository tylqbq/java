package com.bishetyl.entity;

/**
 * Created by 汤玉龙 on 2018/5/8.
 */
public class Industry {
    private String industryName;
    private Double maxSalary;
    private Double minSalary;
    private Double averageSalary;
    private int recruitNumber;


    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(Double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public int getRecruitNumber() {
        return recruitNumber;
    }

    public void setRecruitNumber(int recruitNumber) {
        this.recruitNumber = recruitNumber;
    }
}
