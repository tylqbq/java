package com.bishetyl.service;

import com.bishetyl.dao.JobSeekerDao;
import com.bishetyl.dto.LoginParams;
import com.bishetyl.dto.RegisterParams;
import com.bishetyl.entity.JobSeeker;
import com.bishetyl.entity.User;
import com.bishetyl.util.Result;

import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;

/**
 * Created by 汤玉龙 on 2018/3/21.
 */
public class JobSeekerSevice {
    public JobSeekerSevice(){

    }
    /**
     *登录验证
     * */
    public Result login(LoginParams loginParams) throws Exception{
        Result result = new Result();
        JobSeeker jobSeekerResult = new JobSeeker();
        String phoneOrEmail = "";
        String phone = loginParams.getPhoneNumber();
        String email = loginParams.getEmail();
        String password = loginParams.getPassword();
        if(phone == null && email == null){
            result.setStatus(Boolean.valueOf(false));
            result.setMessage("手机号或邮箱不能为空！");
            return result;
        }
        if(password == null){
            result.setStatus(Boolean.valueOf(false));
            result.setMessage("密码不能为空！");
            return result;
        }
        if(phone != null){  //电话或者邮箱
            phoneOrEmail = phone;
        }else {
            phoneOrEmail = email;
        }
        JobSeekerDao jobSeekerDao = new JobSeekerDao();
        jobSeekerResult = jobSeekerDao.findJobSeekerByPhoneNumberOrEmail(phoneOrEmail);
        try{
            if (jobSeekerResult == null){
                throw  new Exception("该账号不存在！");
            }else if(!password.equals(jobSeekerResult.getPassword())){
                throw  new Exception("密码错误！");
            }else{
                result.setStatus(Boolean.valueOf(true));
                result.setMessage("登录成功！");
                jobSeekerResult.setPassword("");
                result.setData(jobSeekerResult);
                return result;
            }
        }catch (Exception e){
            result.setStatus(Boolean.valueOf(false));
            result.setMessage(e.getMessage());
            return result;
        }
    }
    /**
     *注册
     * */
    public Result register(RegisterParams params) throws Exception{
        Result result = new Result();
        JobSeeker jobSeeker = null;
        JobSeekerDao jobSeekerDao = new JobSeekerDao();
        jobSeeker = jobSeekerDao.findJobSeekerByPhoneNumberOrEmail(params.getPhoneNumber());
        if(jobSeeker != null){
            result.setStatus(Boolean.valueOf(false));
            result.setMessage("该账号已注册，请直接登录");
            return result;
        }else{
            Boolean rs = jobSeekerDao.insertJobSeeker(params);
            if(rs){
                result.setStatus(Boolean.valueOf(true));
                result.setMessage("注册成功");
                result.setData(new String("/login"));
            }else{
                result.setStatus(Boolean.valueOf(false));
                result.setMessage("注册失败");
            }
            return result;
        }
    }
 }
