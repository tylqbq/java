package com.bishetyl.controller;

import com.bishetyl.entity.User;
import com.bishetyl.entity.JobSeeker;
import com.bishetyl.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bishetyl.dao.UserDao;
import com.bishetyl.util.Result;

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
    public Result login(@RequestBody JobSeeker jobSeeker){
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
