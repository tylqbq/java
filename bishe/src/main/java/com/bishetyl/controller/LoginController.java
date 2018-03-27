package com.bishetyl.controller;

import com.bishetyl.dto.RegisterParams;
import com.bishetyl.entity.User;
import com.bishetyl.entity.JobSeeker;
import com.bishetyl.service.JobSeekerSevice;
import com.bishetyl.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bishetyl.dao.UserDao;
import com.bishetyl.util.Result;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Abcde on 2017/12/11.
 */
@Controller
@RequestMapping("/")
@ResponseBody
public class LoginController {
    Result result = null;

    @RequestMapping("/")
    @ResponseBody
    public  String loginSbmit(){
        return  "";
    }
    @RequestMapping("/user/login")
    @ResponseBody
    public Result login(@RequestBody JobSeeker jobSeeker,HttpSession session){
        result = new Result();
        JobSeekerSevice jobSeekerSevice = new JobSeekerSevice();
        try {
            result = jobSeekerSevice.login(jobSeeker);
            result.setData(null);
            session.setAttribute("user", jobSeeker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("/user/logout")
    @ResponseBody
    public Result logout(HttpSession session){
        session.invalidate();
        result = new Result();
        result.setStatus(Boolean.valueOf(false));
        result.setMessage("退出成功！");
        return result;
    }

    @RequestMapping("/user/register")
    @ResponseBody
    public Result register(@RequestBody RegisterParams params){
        result = new Result();
        JobSeekerSevice jobSeekerSevice = new JobSeekerSevice();
        try {
            result = jobSeekerSevice.register(params);
            result.setData(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("user/changePsd")
    @ResponseBody
    public Result changePsd(@RequestBody  JobSeeker jobSeeker){
        result = new Result();
        UserService userService = new UserService();
        User userReturn = null;
        try {
            result = userService.login(jobSeeker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
