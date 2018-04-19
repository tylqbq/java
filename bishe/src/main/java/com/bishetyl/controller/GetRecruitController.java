package com.bishetyl.controller;

import com.bishetyl.dto.RecruitResult;
import com.bishetyl.dto.RecruitSearchByCoIDParams;
import com.bishetyl.dto.RecruitSearchParams;
import com.bishetyl.entity.JobSeeker;
import com.bishetyl.entity.Recruit;
import com.bishetyl.service.RecruitService;
import com.bishetyl.util.PageParams;
import com.bishetyl.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/3/22.
 */
@Controller
//@RequestMapping("/")
@ResponseBody
public class GetRecruitController {
    Result result = null;
    @RequestMapping("/recruit/getrecruit")
    @ResponseBody
    public Result getRecruit(@RequestBody RecruitSearchParams searchParams){
        result = new Result();
        RecruitService recruitService =  new RecruitService();
        RecruitResult recruitResult = new RecruitResult();
        recruitResult = recruitService.getRecruit(searchParams);
        result.setData(recruitResult);
        return result;
    }

     @RequestMapping("/recruit/getrecruitbyid")
     @ResponseBody
     public Result getRecruitById(@RequestParam(value = "recruitId") int recruitId){
        RecruitService  recruitService = new RecruitService();
        Recruit recruit = new Recruit();
        recruit = recruitService.getRecruitById(recruitId);
        result = new Result();
        result.setData(recruit);
        return  result;
    }

    @RequestMapping("/recruit/getrecruitbycompanyid")
    @ResponseBody
    public Result getRecruitByCompanyId(@RequestBody RecruitSearchByCoIDParams params){
        RecruitService  recruitService = new RecruitService();
        RecruitResult recruitResult = new RecruitResult();
        recruitResult = recruitService.getRecruitByCompanyId(params);
        result = new Result();
        result.setData(recruitResult);
        return  result;
    }
}
