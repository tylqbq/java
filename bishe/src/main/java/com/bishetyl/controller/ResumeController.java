package com.bishetyl.controller;

import com.bishetyl.dao.RecruitDao;
import com.bishetyl.dao.ResumeDao;
import com.bishetyl.dto.DeliveryResumeResult;
import com.bishetyl.entity.*;
import com.bishetyl.service.ResumeService;
import com.bishetyl.util.Log;
import com.bishetyl.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/21.
 */
@Controller
@ResponseBody
public class ResumeController {
    Result result = null;

    @RequestMapping("/resume/getAllById")
    @ResponseBody
    @Log(title = "获取简历By简历id")
    public Result getResumeAllById(@RequestBody Resume resume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Resume resumeRet = resumeService.getResumeById(resume);
        result.setData(resumeRet);
        return result;
    }
    @RequestMapping("/resume/getAllByJobSeekerId")
    @ResponseBody
    @Log(title = "获取简历By人id")
    public Result getResumeAllByJobSeekerId(@RequestBody Resume resume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        List<Resume> resumeList = new ArrayList<Resume>();
        resumeList = resumeService.getResumeByJobSeekerId(resume);
        result.setData(resumeList);
        return result;
    }
    /**
     * 通过求职者id获取开启了快速投递的简历 如果没有则返回名下所有的简历以供选择
     * **/

    @RequestMapping("/resume/getSpecialResumeByJobSeekerId")
    @ResponseBody
    @Log(title = "获取开启快速投递的简历 By人id")
    public Result getSpecialResumeByJobSeekerId(@RequestBody Resume resume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        List<Resume> resumeList = new ArrayList<Resume>();
        resumeList = resumeService.getSpecialResumeByJobSeekerId(resume);
        if(resumeList.size() == 0){
            result.setStatus(false);
            result.setData("您还未创建简历，马上去创建");
        }else{
            result.setStatus(true);
            result.setData(resumeList);
        }
        return result;
    }


    @RequestMapping("/resume/addresume")
    @ResponseBody
    @Log(title = "新增简历")
    public Result addResume(@RequestBody Resume resume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        resumeService.addResume(resume);
        result.setData("新建简历成功！");
        return result;
    }

    @RequestMapping("/resume/deleteresume")
    @ResponseBody
    @Log(title = "删除简历")
    public Result deleteResume(@RequestBody Resume resume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Boolean isSuccess = resumeService.deleteResume(resume);
        if (isSuccess){
            result.setStatus(true);
            result.setData("删除简历成功！");
        }else{
            result.setStatus(false);
            result.setData("删除简历失败！");
        }
        return result;
    }

    @RequestMapping("/resume/updateResume")
    @ResponseBody
    @Log(title = "修改简历基本信息")
    public Result updateResume(@RequestBody Resume resume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Boolean isSucce = resumeService.updateResume(resume);
        if(isSucce){
            result.setStatus(true);
            result.setData("修改成功!");
        }else{
            result.setStatus(false);
            result.setData("修改失败!");
        }
        return result;
    }

    @RequestMapping("/resume/updatePublic")
    @ResponseBody
    @Log(title = "修改简历公开程度")
    public Result updatePublic(@RequestBody Resume resume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Boolean isSucce = resumeService.updatePublic(resume);
        if(isSucce){
            result.setStatus(true);
            result.setData("修改成功!");
        }else{
            result.setStatus(false);
            result.setData("修改失败!");
        }
        return result;
    }


    @RequestMapping("/resume/updateAnnualIncome")
    @ResponseBody
    @Log(title = "修改年收入")
    public Result updateAnnualIncome(@RequestBody Resume resume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Boolean  isScuess = resumeService.updateAnnualIncome(resume);
        if (isScuess){
            result.setStatus(true);
            result.setData("修改成功");
        }else{
            result.setStatus(false);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/resume/updateJobIntention")
    @ResponseBody
    @Log(title = "修改求职意向")
    public Result updateJobIntention(@RequestBody JobIntention jobIntention){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Boolean  isScuess = resumeService.updateJobIntention(jobIntention);
        if (isScuess){
            result.setStatus(true);
            result.setData("修改成功");
        }else{
            result.setStatus(false);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/resume/updateWorkExperience")
    @ResponseBody
    @Log(title = "修改工作经验")
    public Result updateWorkExperience(@RequestBody WorkExperience workExperience){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Boolean  isScuess = resumeService.updateWorkExperience(workExperience);
        if (isScuess){
            result.setStatus(true);
            result.setData("修改成功");
        }else{
            result.setStatus(false);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/resume/updateProjectExperience")
    @ResponseBody
    @Log(title = "修改项目经验")
    public Result updateWorkExperience(@RequestBody ProjectExperience projectExperience){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Boolean  isScuess = resumeService.updateProjectExperience(projectExperience);
        if (isScuess){
            result.setStatus(true);
            result.setData("修改成功");
        }else{
            result.setStatus(false);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/resume/updateEducationExperience")
    @ResponseBody
    @Log(title = "修改教育经历")
    public Result updateEducationExperience(@RequestBody EducationExperience educationExperience){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Boolean  isScuess = resumeService.updateEducationExperience(educationExperience);
        if (isScuess){
            result.setStatus(true);
            result.setData("修改成功");
        }else{
            result.setStatus(false);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/resume/updateSchoolHonor")
    @ResponseBody
    @Log(title = "修改学校荣誉")
    public Result updateSchoolHonor(@RequestBody SchoolHonor schoolHonor){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Boolean  isScuess = resumeService.updateSchoolHonor(schoolHonor);
        if (isScuess){
            result.setStatus(true);
            result.setData("修改成功");
        }else{
            result.setStatus(false);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/resume/updateSchoolDuties")
    @ResponseBody
    @Log(title = "修改学校职务")
    public Result updateSchoolDuties(@RequestBody SchoolDuties schoolDuties){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Boolean  isScuess = resumeService.updateSchoolDuties(schoolDuties);
        if (isScuess){
            result.setStatus(true);
            result.setData("修改成功");
        }else{
            result.setStatus(false);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/resume/updateDilivery")
    @ResponseBody
    @Log(title = "修改快速投递")
    public Result updateDilivery(@RequestBody Resume resume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Boolean  isScuess = resumeService.updateDilivery(resume);
        if (isScuess){
            result.setStatus(true);
            result.setData("修改成功");
        }else{
            result.setStatus(false);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/resume/diliveryResume")
    @ResponseBody
    @Log(title = "投递简历")
    public Result diliveryResume(@RequestBody DeliveryResume deliveryResume){
        Result result = new Result();
        ResumeService resumeService = new ResumeService();
        Boolean  isScuess = resumeService.diliveryResume(deliveryResume);
        if (isScuess){
            result.setStatus(true);
            result.setData("投递成功");
        }else{
            result.setStatus(false);
            result.setData("已投递");
        }
        return result;
    }

    @RequestMapping("/resume/getDeliveryResume")
    @ResponseBody
    @Log(title = "查询自己投递的简历")
    public Result getDeliveryResume(@RequestBody JobSeeker jobSeeker){
        Result result = new Result();
        List<DeliveryResumeResult> deliveryResumeResults = new ArrayList<DeliveryResumeResult>();
        ResumeService resumeService = new ResumeService();
        deliveryResumeResults = resumeService.getDeliveryResume(jobSeeker);
        result.setData(deliveryResumeResults);
        return result;
    }





}
