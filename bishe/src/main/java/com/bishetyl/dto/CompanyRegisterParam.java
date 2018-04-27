package com.bishetyl.dto;

import com.bishetyl.entity.Company;
import com.bishetyl.entity.CompanyUser;

/**
 * Created by 汤玉龙 on 2018/4/27.
 */
public class CompanyRegisterParam {
    private Company company;
    private CompanyUser companyUser;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CompanyUser getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(CompanyUser companyUser) {
        this.companyUser = companyUser;
    }
}
