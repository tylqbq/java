package com.bishetyl.controller;

import com.bishetyl.dto.ChangePassWordParams;
import com.bishetyl.dto.CompanyGetResume;
import com.bishetyl.dto.CompanyRegisterParam;
import com.bishetyl.entity.Company;
import com.bishetyl.entity.CompanyUser;
import com.bishetyl.entity.Resume;
import com.bishetyl.service.CompanyService;
import com.bishetyl.util.Log;
import com.bishetyl.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/19.
 */
@Controller
@ResponseBody
public class CompanyController {
    Result result = null;

    @RequestMapping("/company/getcompanyInfobyid")
    @ResponseBody
    @Log(title = "公司信息")
    public Result getCompanyInfoById(@RequestParam(value="id") int companyId){
        result = new Result();
        Company company = new Company();
        CompanyService companyService = new CompanyService();
        company = companyService.getCompanyInfoById(companyId);
        result.setData(company);
        return result;
    }

    @RequestMapping("/company/updateCompanyInfo")
    @ResponseBody
    @Log(title = "修改公司信息")
    public Result updateCompanyInfo(@RequestBody Company company){
        result = new Result();
        CompanyService companyService = new CompanyService();
        Boolean isScuess = companyService.updateCompanyInfo(company);
        if (isScuess){
            result.setStatus(true);
            result.setData("修改成功");
        }else {
            result.setStatus(true);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/company/uploadIcon")
    @ResponseBody
    @Log(title = "上传营业执照")
    public Result uploadIcon(@RequestParam(value="id") int companyId){
        result = new Result();
        Company company = new Company();
        CompanyService companyService = new CompanyService();
        company = companyService.getCompanyInfoById(companyId);
        result.setData(company);
        return result;
    }

    @RequestMapping("/company/getDeliveryResume")
    @ResponseBody
    @Log(title = "获取投递的简历")
    public Result getDeliveryResume(@RequestBody Company company){
        result = new Result();
        List<CompanyGetResume> CompanyGetResumeList = new ArrayList<CompanyGetResume>();
        CompanyService companyService = new CompanyService();
        CompanyGetResumeList = companyService.getDeliveryResume(company);
        result.setData(CompanyGetResumeList);
        return result;
    }


/**
 * 分割线----------------------------------------------------------------------------------
 */
    @RequestMapping("/company/registerCompany")
    @ResponseBody
    @Log(title = "注册公司用户")
    public Result registerCompany(@RequestBody CompanyRegisterParam companyRegisterParam){
        result = new Result();
        CompanyRegisterParam companyRegisterParamRet = new CompanyRegisterParam();

        CompanyService companyService = new CompanyService();
        companyRegisterParamRet = companyService.registerCompany(companyRegisterParam);

        result.setData(companyRegisterParamRet);
        return result;
    }

    @RequestMapping("/company/loginCompany")
    @ResponseBody
    @Log(title = "公司用户登录")
    public Result loginCompany(@RequestBody CompanyUser companyUser){
        result = new Result();
        CompanyUser companyUserRet = new CompanyUser();
        CompanyService companyService = new CompanyService();
        companyUserRet = companyService.loginCompany(companyUser);
        if(companyUserRet == null){
            result.setStatus(false);
            result.setData("帐号或密码错误");
        }else {
            result.setStatus(true);
            result.setData(companyUserRet);
        }
        return result;
    }

    @RequestMapping("/company/getCompanyUserInfo")
    @ResponseBody
    @Log(title = "公司用户信息获取")
    public Result getCompanyUserInfo(@RequestBody CompanyUser companyUser){
        result = new Result();
        CompanyUser companyUserRet = new CompanyUser();
        CompanyService companyService = new CompanyService();
        companyUserRet = companyService.getCompanyUserInfo(companyUser);
        if(companyUserRet == null){
            result.setStatus(false);
            result.setData("帐号或密码错误");
        }else {
            result.setStatus(true);
            result.setData(companyUserRet);
        }
        return result;
    }

    @RequestMapping("/company/updateMember")
    @ResponseBody
    @Log(title = "公司用户修改昵称")
    public Result updateMember(@RequestBody CompanyUser companyUser){
        result = new Result();
        CompanyUser companyUserRet = new CompanyUser();
        CompanyService companyService = new CompanyService();
        Boolean isScuess = companyService.updateMember(companyUser);
        if(isScuess){
            result.setStatus(true);
            result.setData("修改成功");
        }else {
            result.setStatus(false);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/company/updatePassword")
    @ResponseBody
    @Log(title = "公司用户修改密码")
    public Result updatePassword(@RequestBody ChangePassWordParams changePassWordParams){
        result = new Result();
        CompanyUser companyUserRet = new CompanyUser();
        CompanyService companyService = new CompanyService();

        String info = companyService.updatePassword(changePassWordParams);
        result.setStatus(true);
        result.setData(info);
        return result;
    }

    @RequestMapping("/company/updatePhoneNumber")
    @ResponseBody
    @Log(title = "公司用户修改手机")
    public Result updatePhoneNumber(@RequestBody CompanyUser companyUser){
        result = new Result();
        CompanyUser companyUserRet = new CompanyUser();
        CompanyService companyService = new CompanyService();
        Boolean isScuess = companyService.updatePhoneNumber(companyUser);
        if(isScuess){
            result.setStatus(false);
            result.setData("修改成功");
        }else {
            result.setStatus(true);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/company/updateEmail")
    @ResponseBody
    @Log(title = "公司用户修改邮箱")
    public Result updateEmail(@RequestBody CompanyUser companyUser){
        result = new Result();
        CompanyService companyService = new CompanyService();
        Boolean isScuess = companyService.updateEmail(companyUser);
        if(isScuess){
            result.setStatus(false);
            result.setData("修改成功");
        }else {
            result.setStatus(true);
            result.setData("修改失败");
        }
        return result;
    }





}
