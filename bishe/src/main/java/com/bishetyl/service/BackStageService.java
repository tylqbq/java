package com.bishetyl.service;

import com.bishetyl.dao.*;
import com.bishetyl.dto.*;
import com.bishetyl.entity.*;
import com.bishetyl.util.SalaryUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/5/8.
 */
public class BackStageService {
    //登录
    public ManageUser login(ManageUser manageUser){
        ManageUserDao manageUserDao = new ManageUserDao();
        ManageUser manageUserRet = manageUserDao.getManageUserBuAccount(manageUser.getAccount());
        if (manageUserRet.getPassWord().equals(manageUser.getPassWord())){
            manageUserRet.setPassWord("");
            return manageUserRet;
        }else{
            return null;
        }
    }

    //公司查找
    public CompanyListRet getCompanyListByParam(CompanySearchParam companySearchParam){
        CompanyDao companyDao = new CompanyDao();
        CompanyListRet companyListRet = companyDao.getCompanyListByParam(companySearchParam);
        return companyListRet;
    }

    //公司审核通过
    public Boolean adoptCompany(Company company){
        CompanyDao companyDao = new CompanyDao();
        Boolean isScuess = companyDao.adoptCompany(company.getId());
        return isScuess;
    }

    //公司审核退回
    public Boolean sendBackCompany(Company company){
        CompanyDao companyDao = new CompanyDao();
        Boolean isScuess = companyDao.sendBackCompany(company.getId());
        return isScuess;
    }


    /**
     * ---------------------------------------------------
     * **/
    //发布文章
    public Boolean publishArticle(Article article){
        ArticleDao articleDao = new ArticleDao();
        Boolean isScuess = articleDao.insertIntoArticle(article);
        return isScuess;
    }


    //得到文章综合查询
    public ArticleListRet getArticleByParams(ArticleSearchParams articleSearchParams){
        ArticleDao articleDao = new ArticleDao();
        ArticleListRet articleListRet = articleDao.getArticleByParams(articleSearchParams);
        return articleListRet;
    }

    //文章审核通过
    public Boolean adoptArticle(Article article){
        ArticleDao articleDao = new ArticleDao();
        Boolean isScuess = articleDao.adoptArticle(article.getId());
        return isScuess;
    }

    //文章审核退回
    public Boolean sendBackArticle(Article article){
        ArticleDao articleDao = new ArticleDao();
        Boolean isScuess = articleDao.sendBackArticle(article.getId());
        return isScuess;
    }


    public Boolean publishNotice(Notice notice){
        NoticeDao noticeDao = new NoticeDao();
        Boolean isScuess = noticeDao.insertIntoNotice(notice);
        return isScuess;
    }

    //安全中心 修改用户名
    public Boolean updateAccount(ManageUser manageUser){
        ManageUserDao manageUserDao = new ManageUserDao();
        Boolean isScuess = manageUserDao.updateAccount(manageUser);
        return isScuess;
    }

    //安全中心 修改密码
    public String updatePassword(ChangePassWordParams changePassWordParams){
        ManageUserDao manageUserDao = new ManageUserDao();
        String oldPassWord = manageUserDao.getManageUserById(changePassWordParams.getManageUserId()).getPassWord();
        if (oldPassWord.equals(changePassWordParams.getOldPassword())){
            Boolean isScuess = manageUserDao.updatePassword(changePassWordParams);
            if (isScuess){
                return "修改成功！";
            }else{
                return "数据库错误！";
            }
        }else{
            return  "原密码错误！";
        }
    }

    //行业对比
    public List<Industry> industryComparison(IndustryComparisonParams industryComparisonParams){
        SalaryUtil salaryUtil = new SalaryUtil();
        List<Industry> industrieList = new ArrayList<Industry>();
        RecruitDao recruitDao = new RecruitDao();
        //行业相关数据
        List<Recruit> recruitList = new ArrayList<Recruit>();
        recruitList = recruitDao.getRecruitByIndustry(industryComparisonParams.getIndustry());
        Industry industry = salaryUtil.analysis(recruitList,industryComparisonParams.getIndustry());
        industrieList.add(industry);
        //对标行业相关数据
        List<Recruit> recruitListComparison = new ArrayList<Recruit>();
        recruitListComparison = recruitDao.getRecruitByIndustry(industryComparisonParams.getIndustryComparison());
        Industry industryComparison = salaryUtil.analysis(recruitListComparison,industryComparisonParams.getIndustryComparison());
        industrieList.add(industryComparison);
        return industrieList;
    }











}
