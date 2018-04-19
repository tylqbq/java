package com.bishetyl.service;

import com.bishetyl.dao.CompanyDao;
import com.bishetyl.entity.Company;

/**
 * Created by 汤玉龙 on 2018/4/19.
 */
public class CompanyService {


    public Company getCompanyInfoById(int companyId){
        Company company = new Company();
        CompanyDao companyDao = new CompanyDao();
        company = companyDao.getCompanyInfoById(companyId);
        return company;
    }
}
