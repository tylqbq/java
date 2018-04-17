package com.bishetyl.service;

import com.bishetyl.dao.RecruitDao;
import com.bishetyl.dto.RecruitResult;
import com.bishetyl.dto.RecruitSearchParams;
import com.bishetyl.entity.Recruit;

import java.util.ArrayList;
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



}
