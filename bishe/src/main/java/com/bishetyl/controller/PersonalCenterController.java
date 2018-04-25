package com.bishetyl.controller;

import com.bishetyl.entity.Resume;
import com.bishetyl.service.ResumeService;
import com.bishetyl.util.Log;
import com.bishetyl.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 汤玉龙 on 2018/4/24. 个人中心
 */
public class PersonalCenterController {
    Result result = null;

    @RequestMapping("/personal/getCollection")
    @ResponseBody
    @Log(title = "获取我的收藏")
    public Result getResumeAllById(@RequestBody Resume resume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Resume resumeRet = resumeService.getResumeById(resume);
        result.setData(resumeRet);
        return result;
    }

}
