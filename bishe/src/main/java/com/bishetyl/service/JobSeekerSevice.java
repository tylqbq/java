package com.bishetyl.service;

import com.bishetyl.dao.JobSeekerDao;
import com.bishetyl.entity.JobSeeker;
import com.bishetyl.entity.User;
import com.bishetyl.util.Result;

/**
 * Created by 汤玉龙 on 2018/3/21.
 */
public class JobSeekerSevice {
    public JobSeekerSevice(){

    }
    /**
     *登录验证
     * */
    public Result login(JobSeeker jobSeeker) throws Exception{
        Result result = new Result();
        JobSeeker jobSeekerResult = new JobSeeker();
        String phoneOrEmail = "";
        String phone = jobSeeker.getPhoneNumber();
        String email = jobSeeker.getEmail();
        String password = jobSeeker.getPassword();
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
        System.out.println(password.equals(jobSeekerResult.getPassword()));
        try{
            if (jobSeekerResult == null){
                throw  new Exception("该账号不存在！");
            }else if(!password.equals(jobSeekerResult.getPassword())){
                throw  new Exception("密码错误！");
            }else{
                result.setStatus(Boolean.valueOf(true));
                result.setMessage("登录成功！");
                result.setData(jobSeekerResult);
                return result;
            }
        }catch (Exception e){
            result.setStatus(Boolean.valueOf(false));
            result.setMessage(e.getMessage());
            return result;
        }
    }

 }
