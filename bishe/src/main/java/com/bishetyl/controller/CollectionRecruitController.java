package com.bishetyl.controller;

import com.bishetyl.service.CollectionControllerService;
import com.bishetyl.util.Result;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 汤玉龙 on 2018/4/19. 收藏简历
 */
@Controller
@ResponseBody
public class CollectionRecruitController {
    Result result = null;

    //收藏职位
    @RequestMapping("/collection/isexist")
    @ResponseBody
    public Result isExist(@RequestParam(value = "recruitId") int recruitId,@RequestParam(value = "jobSeekerId") int jobSeekerId){
        result = new Result();
        CollectionControllerService collectionControllerService = new CollectionControllerService();
        Boolean isExist= collectionControllerService.isExist(recruitId,jobSeekerId);
        if(isExist){
            result.setData(Boolean.valueOf(true));
        }else{
            result.setData(Boolean.valueOf(false));
        }
        return result;
    }

    //删除简历收藏
    @RequestMapping("/collection/deleteCollectionRecruit")
    @ResponseBody
    public Result deleteCollectionRecruit(@RequestParam(value = "recruitId") int recruitId,@RequestParam(value = "jobSeekerId") int jobSeekerId){
        result = new Result();
        CollectionControllerService collectionControllerService = new CollectionControllerService();
        Boolean isExist= collectionControllerService.deleteRecruitCollection(recruitId, jobSeekerId);
        if(isExist){
            result.setStatus(true);
            result.setData("删除成功");
        }else{
            result.setStatus(false);
            result.setData("删除失败");
        }
        return result;
    }
}
