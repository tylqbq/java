package com.bishetyl.controller;

import com.bishetyl.entity.JobIntention;
import com.bishetyl.entity.Resume;
import com.bishetyl.service.ResumeService;
import com.bishetyl.util.Log;
import com.bishetyl.util.Result;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.text.StyledEditorKit;

/**
 * Created by 汤玉龙 on 2018/4/21.
 */
@Controller
@ResponseBody
public class ResumeController {
    Result result = null;

    @RequestMapping("/resume/getAllById")
    @ResponseBody
    @Log(title = "获取简历")
    public Result getResumeAllById(@RequestBody Resume resume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Resume resumeRet = resumeService.getResumeById(resume);
        result.setData(resumeRet);
        return result;
    }


    @RequestMapping("/resume/addresume")
    @ResponseBody
    @Log(title = "新增简历")
    public Result addResume(@RequestBody Resume resume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Resume resumeRet = resumeService.addResume(resume);
        result.setData(resumeRet);
        return result;
    }

    @RequestMapping("/resume/addannualIncome")
    @ResponseBody
    @Log(title = "年收入")
    public Result addAnnualIncome(@RequestBody Resume resume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Resume resumeRet=resumeService.changeAnnualIncome(resume);
        result.setData(resumeRet);
        return result;
    }

    @RequestMapping("/resume/addJobIntention")
    @ResponseBody
    @Log(title = "工作意向")
    public Result addJobIntention(@RequestBody JobIntention jobIntention){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        JobIntention jobIntentionRet=resumeService.addJobIntention(jobIntention);
        result.setData(jobIntentionRet);
        return result;
    }

}
