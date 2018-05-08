package com.bishetyl.service;

import com.bishetyl.dao.CompanyDao;
import com.bishetyl.dao.CompanyUserDao;
import com.bishetyl.dao.RecruitDao;
import com.bishetyl.dao.ResumeDao;
import com.bishetyl.dto.ChangePassWordParams;
import com.bishetyl.dto.CompanyGetResume;
import com.bishetyl.dto.CompanyRegisterParam;
import com.bishetyl.entity.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.text.spi.CollatorProvider;
import java.util.ArrayList;
import java.util.List;

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

    //修改公司信息
    public Boolean updateCompanyInfo(Company company){
        CompanyDao companyDao = new CompanyDao();
        Boolean isScuess = companyDao.updateCompanyInfo(company);
        return isScuess;
    }

    //获取
    public  List<CompanyGetResume>  getDeliveryResume(Company company){
        ResumeDao resumeDao = new ResumeDao();
        RecruitDao recruitDao = new RecruitDao();
        CompanyDao companyDao = new CompanyDao();

        List<CompanyGetResume> CompanyGetResumeList = new ArrayList<CompanyGetResume>();

        List<DeliveryResume> deliveryResumeList = new ArrayList<DeliveryResume>();
        deliveryResumeList = companyDao.getDeliveryResume(company);

        for (int i=0;i<deliveryResumeList.size();i++){
            Resume resume = new Resume();
            resume = resumeDao.searchResume(deliveryResumeList.get(i).getResumeId());

            Recruit recruit = new Recruit();
            recruit = recruitDao.getRecruitById(deliveryResumeList.get(i).getRecruitId());

            CompanyGetResume companyGetResume = new CompanyGetResume();
            companyGetResume.setId(deliveryResumeList.get(i).getId());
            companyGetResume.setPositionName(recruit.getPositionName());
            companyGetResume.setResumeName(resume.getName());
            companyGetResume.setRecruitId(recruit.getId());
            companyGetResume.setJobSeekerId(resume.getJobSeekerId());
            companyGetResume.setResumeId(resume.getId());
            companyGetResume.setDeliveryTime(deliveryResumeList.get(i).getDeliveryTime());
            companyGetResume.setCompanyId(deliveryResumeList.get(i).getCompanyId());
            CompanyGetResumeList.add(companyGetResume);
        }
        return CompanyGetResumeList;
    }
    public List<Company> getCompanyRecruitRandom(Company company){
        CompanyDao companyDao = new CompanyDao();
        RecruitDao recruitDao = new RecruitDao();
        List<Company> companyList = new ArrayList<Company>();
        companyList = companyDao.getCompanyRecruitRandom(company.getCompanyAddress());
        for (int i=0;i<companyList.size();i++){
            List<Recruit> recruitList = recruitDao.getCompanyRecruitByIdRandom(companyList.get(i).getId());
            companyList.get(i).setRecruits(recruitList);
        }
        return companyList;
    }


    /**
     *分割线
     * */
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

    //公司用户登录
    public CompanyUser  loginCompany(CompanyUser companyUser){
        CompanyUser companyUserRet = new CompanyUser();
        CompanyUserDao companyUserDao = new CompanyUserDao();
        companyUserRet = companyUserDao.login(companyUser);
        if(companyUserRet == null){
            return null;
        }else if(!companyUserRet.getPassword().equals(companyUser.getPassword())){
            return null;
        }else{
            companyUserRet.setPassword("");
            return companyUserRet;
        }
    }
    //公司用户信息获取
    public CompanyUser getCompanyUserInfo(CompanyUser companyUser){
        CompanyUser companyUserRet = new CompanyUser();
        CompanyUserDao companyUserDao = new CompanyUserDao();
        companyUserRet = companyUserDao.getCompanyUserInfo(companyUser);
        return companyUserRet;
    }

    //公司用户修改昵称
    public Boolean updateMember(CompanyUser companyUser){
        CompanyUser companyUserRet = new CompanyUser();
        CompanyUserDao companyUserDao = new CompanyUserDao();
        Boolean isScuess = companyUserDao.updateMember(companyUser);
        return isScuess;
    }

    //公司用户修改密码
    public String updatePassword(ChangePassWordParams changePassWordParams){
        CompanyUser companyUser = new CompanyUser();
        CompanyUserDao companyUserDao = new CompanyUserDao();
        companyUser = companyUserDao.getCompanyUserById(changePassWordParams.getCompanyUserId());
        if (companyUser.getPassword().equals(changePassWordParams.getOldPassword())){
            Boolean isScuess = companyUserDao.updatePassword(changePassWordParams);
           if (isScuess){
               return "修改成功";
           }else{
               return "数据库错误";
           }
        }else{
            return "原密码错误";
        }
    }

    //公司用户修改手机
    public Boolean updatePhoneNumber(CompanyUser companyUser){

        CompanyUserDao companyUserDao = new CompanyUserDao();
        Boolean isScuess = companyUserDao.updatePhoneNumber(companyUser);
        return isScuess;
    }

    //公司用户修改邮箱
    public Boolean updateEmail(CompanyUser companyUser){
        CompanyUserDao companyUserDao = new CompanyUserDao();
        Boolean isScuess = companyUserDao.updateEmail(companyUser);
        return isScuess;
    }








}
