package com.bishetyl.controller;

import com.bishetyl.entity.JobSeeker;
import com.bishetyl.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
    public Result getRecruit(String str){
        result = new Result();
        result.setStatus(Boolean.valueOf(false));
        result.setMessage("得到招聘职位");
        return result;
    }
}
