package com.bishetyl.dto;

/**
 * Created by 汤玉龙 on 2018/5/8.
 */
public class IndustryComparisonParams {
    private String industry;
    private String industryComparison;
    private String date;
    private String dateType;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustryComparison() {
        return industryComparison;
    }

    public void setIndustryComparison(String industryComparison) {
        this.industryComparison = industryComparison;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }
}
