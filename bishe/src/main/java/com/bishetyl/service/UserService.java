package com.bishetyl.service;

import com.bishetyl.dao.JobSeekerDao;
import com.bishetyl.dao.UserDao;
import com.bishetyl.entity.JobSeeker;
import com.bishetyl.entity.User;
import com.bishetyl.util.Result;

import java.security.PublicKey;

/**
 * Created by 汤玉龙 on 2017/12/13.
 */
public class UserService {

    public UserService(){

    }
    public Result login(JobSeeker jobSeeker)throws Exception {
        Result result = new Result();
        User userReturn = new User();
        String accountName  = jobSeeker.getPhoneNumber();
        String userPsd = jobSeeker.getPassword();
        if(accountName == null||userPsd.length() <= 0){
            result.setStatus(Boolean.valueOf(false));
            result.setMessage("帐号或密码不能为空！");
            return result;
        }
        UserDao userDao =  new UserDao();
        userReturn = userDao.findUserByPhoneNumber(accountName);
        try{
            if(userReturn == null){
                throw  new Exception("该账号不存在！");
            }else if (!(userReturn.getUserPsd().equals(jobSeeker.getPassword()))){
                throw  new Exception("密码错误！");
            }else{
                result.setStatus(Boolean.valueOf(true));
                result.setData(userReturn);
                return result;
            }
        }catch (Exception ex){
            result.setStatus(Boolean.valueOf(false));
            result.setMessage(ex.getMessage());
            return result;
        }
    }

    public Result changePsd(User user) throws Exception{
        Result result = new Result();
        User userReturn = new User();
        String accountName  = user.getUserAccount();
        String userPsd = user.getUserPsd();
        if(accountName == null||userPsd.length() <= 0){
            result.setStatus(Boolean.valueOf(false));
            result.setMessage("帐号或密码不能为空！");
            return result;
        }
        UserDao userDao =  new UserDao();
        userReturn = userDao.findUserByPhoneNumber(accountName);
        try{
            if(userReturn == null){
                throw  new Exception("该账号不存在！");
            }else if (!(userReturn.getUserPsd().equals(user.getUserPsd()))){
                throw  new Exception("密码错误！");
            }else{
                userDao.modifyUserById(user);
                return result;
            }
        }catch (Exception ex){
            result.setStatus(Boolean.valueOf(false));
            result.setMessage(ex.getMessage());
            return result;
        }
    }

    public JobSeeker getUserInfoById(JobSeeker jobSeeker){
        JobSeeker jobSeekerRet = new JobSeeker();
        JobSeekerDao jobSeekerDao = new JobSeekerDao();
        jobSeekerRet = jobSeekerDao.getUserInfo(jobSeeker.getId());
        return  jobSeekerRet;
    }
}
