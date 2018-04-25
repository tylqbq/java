package com.bishetyl.controller;

import com.bishetyl.dto.ChangePassWordParams;
import com.bishetyl.dto.LoginParams;
import com.bishetyl.entity.JobSeeker;
import com.bishetyl.service.JobSeekerSevice;
import com.bishetyl.service.SecurityCenterService;
import com.bishetyl.util.Log;
import com.bishetyl.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by 汤玉龙 on 2018/4/25.安全中心
 */
@Controller
@RequestMapping("/")
@ResponseBody
@Log(title = "安全中心")
public class SecurityCenterController {
    Result result = null;

    @RequestMapping("/user/updateUserName")
    @ResponseBody
    @Log(title = "修改用户名")
    public Result updateUserName(@RequestBody JobSeeker jobSeeker){
        result = new Result();
        SecurityCenterService securityCenterService = new SecurityCenterService();
        Boolean isSucess = securityCenterService.updateUserjName(jobSeeker);
        if(isSucess){
            result.setStatus(true);
            result.setData("修改成功");
        }else{
            result.setStatus(false);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/user/updatePassword")
    @ResponseBody
    @Log(title = "修改密码")
    public Result updatePassword(@RequestBody ChangePassWordParams changePassWordParams){
        result = new Result();
        SecurityCenterService securityCenterService = new SecurityCenterService();
        String data = securityCenterService.updatePassword(changePassWordParams);
        result.setStatus(true);
        result.setData(data);
        return result;
    }

    @RequestMapping("/user/updatePhoneNumber")
    @ResponseBody
    @Log(title = "修改电话")
    public Result updatePhoneNumber(@RequestBody JobSeeker jobSeeker){
        result = new Result();
        SecurityCenterService securityCenterService = new SecurityCenterService();
        Boolean isSucess = securityCenterService.updatePhoneNumber(jobSeeker);
        if (isSucess){
            result.setStatus(true);
            result.setData("修改成功");
        }else{
            result.setStatus(false);
            result.setData("修改失败");
        }
        return result;
    }

    @RequestMapping("/user/updateEmail")
    @ResponseBody
    @Log(title = "修改邮箱")
    public Result updateEmail(@RequestBody JobSeeker jobSeeker){
        result = new Result();
        SecurityCenterService securityCenterService = new SecurityCenterService();
        Boolean isSucess = securityCenterService.updateEmail(jobSeeker);
        if (isSucess){
            result.setStatus(true);
            result.setData("修改成功");
        }else{
            result.setStatus(false);
            result.setData("修改失败");
        }
        return result;
    }

}
