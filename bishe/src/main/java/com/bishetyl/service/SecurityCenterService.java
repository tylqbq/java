package com.bishetyl.service;

import com.bishetyl.dao.JobSeekerDao;
import com.bishetyl.dto.ChangePassWordParams;
import com.bishetyl.entity.JobSeeker;

/**
 * Created by 汤玉龙 on 2018/4/25.
 */
public class SecurityCenterService {

    //修改用户名
    public Boolean updateUserjName(JobSeeker jobSeeker){
        JobSeekerDao jobSeekerDao = new JobSeekerDao();
        Boolean isSucess = jobSeekerDao.updateUserName(jobSeeker);
        return isSucess;
    }

    //修改密码
    public String updatePassword(ChangePassWordParams changePassWordParams){
        JobSeekerDao jobSeekerDao = new JobSeekerDao();
        String oldPassword = jobSeekerDao.getPassword(changePassWordParams.getJobSeekerId());
        if (oldPassword.equals(changePassWordParams.getOldPassword())){
            jobSeekerDao.updatePassword(changePassWordParams);
            return "修改成功";
        }else{
            return "密码不正确";
        }
    }
    //修改电话
    public Boolean updatePhoneNumber(JobSeeker jobSeeker){
        JobSeekerDao jobSeekerDao = new JobSeekerDao();
        Boolean isSucess = jobSeekerDao.updatePhoneNumber(jobSeeker);
        return isSucess;
    }

    //修改邮箱
    public Boolean updateEmail(JobSeeker jobSeeker){
        JobSeekerDao jobSeekerDao = new JobSeekerDao();
        Boolean isSucess = jobSeekerDao.updateEmail(jobSeeker);
        return isSucess;
    }

}
