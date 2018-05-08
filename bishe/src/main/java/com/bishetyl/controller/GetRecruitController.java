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

    //获得职位 By  公司id
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

    //收藏职位
    @RequestMapping("/recruit/collectionrecruit")
    @ResponseBody
    public Result collectionRecruit(@RequestParam(value = "recruitId") int recruitId,@RequestParam(value = "jobSeekerId") int jobSeekerId){
        RecruitService recruitService = new RecruitService();
        String info = recruitService.collectionRecruit(recruitId,jobSeekerId);
        result = new Result();
        result.setData(info);
        return  result;
    }
    //得到我的收藏
    @RequestMapping("/recruit/getMyCollectionRecruits")
    @ResponseBody
    public Result getMyCollectionRecruits(@RequestBody JobSeeker jobSeeker){
        result = new Result();
        List<Recruit> recruitList = new ArrayList<Recruit>();
        RecruitService recruitService = new RecruitService();
        recruitList = recruitService.getMyCollectionRecruits(jobSeeker);
        result.setData(recruitList);
        return  result;
    }

    //发布招聘职位
    @RequestMapping("/recruit/buildRecruit")
    @ResponseBody
    public Result buildRecruit(@RequestBody Recruit recruit){
        result = new Result();
        RecruitService recruitService = new RecruitService();
        Boolean isScuess = recruitService.buildRecruit(recruit);
        if (isScuess){
            result.setStatus(true);
            result.setData("发布成功");
        }else{
            result.setStatus(false);
            result.setData("发布失败");
        }
        return  result;
    }

    //删除招聘职位
    @RequestMapping("/recruit/deleteRecruitById")
    @ResponseBody
    public Result deleteRecruitById(@RequestBody Recruit recruit){
        result = new Result();
        RecruitService recruitService = new RecruitService();
        Boolean isScuess = recruitService.deleteRecruitById(recruit);
        if (isScuess){
            result.setStatus(true);
            result.setData("删除成功");
        }else{
            result.setStatus(false);
            result.setData("删除失败");
        }
        return  result;
    }

    //根据地区随机获得招聘
    @RequestMapping("/recruit/getRecruitByAddressRandom")
    @ResponseBody
    public Result getRecruitByAddressRandom(@RequestBody Recruit recruit){
        result = new Result();
        RecruitService recruitService = new RecruitService();
        List<Recruit> recruitList = recruitService.getRecruitByAddressRandom(recruit);
        result.setData(recruitList);
        return  result;
    }
}
