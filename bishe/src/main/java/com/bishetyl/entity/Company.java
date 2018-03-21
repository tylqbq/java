package com.bishetyl.entity;

import java.util.List;

/**
 * Created by ������ on 2018/3/21.��˾
 */
public class Company {
    private int id;
    private String companyName;
    private String companyType;//��˾����
    private int staffNumber;//Ա������
    private String companyInfo;//��˾��Ϣ
    private String companyBussiness;//��˾ҵ��
    private List<Recruit> recruits;//��Ƹ�б�

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
