package com.bishetyl.service;

import com.bishetyl.dao.CollectionRecruitDao;
import com.bishetyl.dao.RecruitDao;
import com.bishetyl.dto.RecruitResult;
import com.bishetyl.dto.RecruitSearchByCoIDParams;
import com.bishetyl.dto.RecruitSearchParams;
import com.bishetyl.entity.Recruit;
import com.bishetyl.util.PageParams;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/17.
 */
public class RecruitService {
    public RecruitService(){

    }
    //综合条件搜索招聘
    public RecruitResult getRecruit(RecruitSearchParams searchParams){
        RecruitResult recruitResult = new RecruitResult();
        RecruitDao recruitDao = new RecruitDao();
        recruitResult = recruitDao.getRecruit(searchParams);
        return recruitResult;
    }

    //搜索招聘ById
    public Recruit getRecruitById( int recruitId){
        Recruit recruit = new Recruit();
        RecruitDao recruitDao = new RecruitDao();
        recruit = recruitDao.getRecruitById(recruitId);
        return recruit;
    }

    //搜索招聘ByCompanyId
    public RecruitResult getRecruitByCompanyId(RecruitSearchByCoIDParams params){
        RecruitResult recruitResult = new RecruitResult();
        RecruitDao recruitDao = new RecruitDao();
        recruitResult = recruitDao.getRecruitByCompanyId(params);
        return recruitResult;
    }

    //收藏职位
    public String collectionRecruit(int recruitId, int jobSeekerId){
        CollectionRecruitDao  collectionRecruitDao = new CollectionRecruitDao();
        Boolean isExit = collectionRecruitDao.isExist(recruitId,jobSeekerId);
        if(!isExit){ //如果不存在
            RecruitDao recruitDao = new RecruitDao();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//转换格式
            System.out.println(sdf.format(new Date()));
            Boolean isSuccess = recruitDao.collectionRecruit(recruitId,jobSeekerId,sdf.format(new Date()).toString());
            if (isSuccess){
                return "收藏成功";
            }
        }else{
            Boolean isDelete = collectionRecruitDao.deleteCollectionRecruit(recruitId, jobSeekerId);
            if(isDelete){
                return "取消收藏成功";
            }
        }
        return "错误";
    }



}
