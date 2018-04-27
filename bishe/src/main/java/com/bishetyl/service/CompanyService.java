package com.bishetyl.service;

import com.bishetyl.dao.CompanyDao;
import com.bishetyl.dao.CompanyUserDao;
import com.bishetyl.dto.CompanyRegisterParam;
import com.bishetyl.entity.Company;
import com.bishetyl.entity.CompanyUser;

/**
 * Created by 汤玉龙 on 2018/4/19.
 */
public class CompanyService {

    //获取公司信息
    public Company getCompanyInfoById(int companyId){
        Company company = new Company();
        CompanyDao companyDao = new CompanyDao();
        company = companyDao.getCompanyInfoById(companyId);
        return company;
    }
    //注册公司用户
    public CompanyRegisterParam registerCompany(CompanyRegisterParam companyRegisterParam){


        CompanyDao companyDao = new CompanyDao();
        CompanyUserDao companyUserDao = new CompanyUserDao();

        //注册公司信息
        int companyId = companyDao.registerCompany(companyRegisterParam.getCompany());
        companyRegisterParam.getCompanyUser().setCompanyId(companyId);
        //注册公司用户信息
        int companyUserId = companyUserDao.registerCompanyUser(companyRegisterParam.getCompanyUser());

        CompanyRegisterParam companyRegisterParamRet = new CompanyRegisterParam();

        Company company = new Company();
        company = companyDao.getCompanyInfoById(companyId);


        CompanyUser companyUser = new CompanyUser();
        companyUser = companyUserDao.getCompanyUserById(companyUserId);

        companyRegisterParamRet.setCompany(company);
        companyRegisterParamRet.setCompanyUser(companyUser);

        return companyRegisterParamRet;
    }


}
