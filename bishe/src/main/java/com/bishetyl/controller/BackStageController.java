package com.bishetyl.controller;

import com.bishetyl.dto.*;
import com.bishetyl.entity.*;
import com.bishetyl.service.BackStageService;
import com.bishetyl.service.RecruitService;
import com.bishetyl.util.Log;
import com.bishetyl.util.Result;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 汤玉龙 on 2018/5/8. 后台管理
 */

@Controller
@ResponseBody
public class BackStageController {

    Result result = null;

    @RequestMapping("/stage/login")
    @ResponseBody
    @Log(title="登录")
    public Result getRecruit(@RequestBody ManageUser manageUser){
        result = new Result();
        BackStageService backStageService = new BackStageService();
        ManageUser manageUserRet = backStageService.login(manageUser);
        if (manageUserRet == null){
            result.setStatus(false);
            result.setData("账户或密码错误");
        }else{
            result.setStatus(true);
            result.setData(manageUserRet);
        }
        return result;
    }

    /**
     *公司查找------------------------------------------------------------------
     * */
    @RequestMapping("/stage/getCompanyListByParam")
     @ResponseBody
     @Log(title="公司查找")
     public Result getCompanyListByParam(@RequestBody CompanySearchParam companySearchParam){
        result = new Result();
        BackStageService backStageService = new BackStageService();
        CompanyListRet companyListRet = backStageService.getCompanyListByParam(companySearchParam);
        result.setData(companyListRet);
        return result;
    }

    @RequestMapping("/stage/adoptCompany")
    @ResponseBody
    @Log(title="公司审核通过")
    public Result adoptCompany(@RequestBody Company company){
        result = new Result();
        BackStageService backStageService = new BackStageService();
        Boolean isScuess = backStageService.adoptCompany(company);
        if (isScuess){
            result.setStatus(true);
            result.setData("操作成功");
        }else{
            result.setStatus(false);
            result.setData("操作失败");
        }
        return result;
    }

    @RequestMapping("/stage/sendBackCompany")
    @ResponseBody
    @Log(title="公司审核退回")
    public Result sendBackCompany(@RequestBody Company company){
        result = new Result();
        BackStageService backStageService = new BackStageService();
        Boolean isScuess = backStageService.sendBackCompany(company);
        if (isScuess){
            result.setStatus(true);
            result.setData("操作成功");
        }else{
            result.setStatus(false);
            result.setData("操作失败");
        }
        return result;
    }

    /**
     *帖子查找------------------------------------------------------------------
     * */

    @RequestMapping("/stage/publishArticle")
    @ResponseBody
    @Log(title="文章发布")
    public Result publishArticle(@RequestBody Article article){
        result = new Result();
        BackStageService backStageService = new BackStageService();
        Boolean isScuess = backStageService.publishArticle(article);
        if (isScuess){
            result.setStatus(true);
            result.setData("发布成功");
        }else{
            result.setStatus(false);
            result.setData("发布失败");
        }
        return result;
    }


    @RequestMapping("/stage/getArticleByParams")
    @ResponseBody
    @Log(title="文章查找")
    public Result getArticleByParams(@RequestBody ArticleSearchParams articleSearchParams){
        result = new Result();
        BackStageService backStageService = new BackStageService();
        ArticleListRet articleListRet = backStageService.getArticleByParams(articleSearchParams);
        result.setData(articleListRet);
        return result;
    }

    @RequestMapping("/stage/adoptArticle")
    @ResponseBody
    @Log(title="文章审核通过")
    public Result adoptArticle(@RequestBody Article article){
        result = new Result();
        BackStageService backStageService = new BackStageService();
        Boolean isScuess = backStageService.adoptArticle(article);
        if (isScuess){
            result.setStatus(true);
            result.setData("操作成功");
        }else{
            result.setStatus(false);
            result.setData("操作失败");
        }
        return result;
    }



    @RequestMapping("/stage/sendBackArticle")
    @ResponseBody
    @Log(title="文章审核退回")
    public Result sendBackArticle(@RequestBody Article article){
        result = new Result();
        BackStageService backStageService = new BackStageService();
        Boolean isScuess = backStageService.sendBackArticle(article);
        if (isScuess){
            result.setStatus(true);
            result.setData("操作成功");
        }else{
            result.setStatus(false);
            result.setData("操作失败");
        }
        return result;
    }



    /**
     * 公告发布
     * **/
    @RequestMapping("/stage/publishNotice")
    @ResponseBody
    @Log(title="文章发布")
    public Result publishNotice(@RequestBody Notice notice){
        result = new Result();
        BackStageService backStageService = new BackStageService();
        Boolean isScuess = backStageService.publishNotice(notice);
        if (isScuess){
            result.setStatus(true);
            result.setData("发布成功");
        }else{
            result.setStatus(false);
            result.setData("发布失败");
        }
        return result;
    }


    /**
     * 安全中心
     * */

    @RequestMapping("/stage/updateAccount")
    @ResponseBody
    @Log(title="修改用户名")
    public Result updateAccount(@RequestBody ManageUser manageUser){
        result = new Result();
        BackStageService backStageService = new BackStageService();
        Boolean isScuess = backStageService.updateAccount(manageUser);
        if (isScuess){
            result.setStatus(true);
            result.setData("修改成功");
        }else{
            result.setStatus(false);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/stage/updatePassword")
    @ResponseBody
    @Log(title="修改密码")
    public Result updatePassword(@RequestBody ChangePassWordParams changePassWordParams){
        result = new Result();
        BackStageService backStageService = new BackStageService();
        String isScuess = backStageService.updatePassword(changePassWordParams);
        result.setData(isScuess);
        return result;
    }

    @RequestMapping("/stage/industryComparison")
    @ResponseBody
    @Log(title="行业对比")
    public Result  industryComparison( @RequestBody IndustryComparisonParams industryComparisonParams) {
        result = new Result();
        BackStageService backStageService = new BackStageService();
        List<Industry> industrieList = backStageService.industryComparison(industryComparisonParams);
        result.setData(industrieList);
        return result;
    }




}
