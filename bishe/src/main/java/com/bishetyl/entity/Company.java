package com.bishetyl.entity;

import java.util.List;

/**
 * Created by 汤玉龙 on 2018/3/21.公司
 */
public class Company {
    private int id;
    private String companyName;
    private String companyType;//公司性质
    private int staffNumber;//员工数量
    private String companyInfo;//公司信息
    private String companyBussiness;//公司业务
    private List<Recruit> recruits;//招聘列表

    public List<Recruit> getRecruits() {
        return recruits;
    }

    public void setRecruits(List<Recruit> recruits) {
        this.recruits = recruits;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public int getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(int staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getCompanyBussiness() {
        return companyBussiness;
    }

    public void setCompanyBussiness(String companyBussiness) {
        this.companyBussiness = companyBussiness;
    }
}
