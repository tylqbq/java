package com.bishetyl.controller;

import com.bishetyl.entity.Company;
import com.bishetyl.service.CompanyService;
import com.bishetyl.util.Log;
import com.bishetyl.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}