package com.bishetyl.service;

import com.bishetyl.dao.CollectionRecruitDao;
import com.bishetyl.dao.RecruitDao;
import com.bishetyl.dto.RecruitResult;
import com.bishetyl.dto.RecruitSearchByCoIDParams;
import com.bishetyl.dto.RecruitSearchParams;
import com.bishetyl.entity.CollectionRecruit;
import com.bishetyl.entity.JobSeeker;
import com.bishetyl.entity.Recruit;
import com.bishetyl.util.PageParams;
import com.sun.javafx.font.directwrite.RECT;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.image.RescaleOp;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/17.
 */
@Controller
@ResponseBody
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

    //得到 收藏的职位By id
    public List<Recruit> getMyCollectionRecruits(JobSeeker jobSeeker){
        List<Recruit> recruitList = new ArrayList<Recruit>();

        CollectionRecruitDao  collectionRecruitDao = new CollectionRecruitDao();
        List<CollectionRecruit> collectionRecruitList = new ArrayList<CollectionRecruit>();
        collectionRecruitList = collectionRecruitDao.getMyCollectionRecruits(jobSeeker.getId());

        RecruitDao recruitDao = new RecruitDao();

        for(int i=0;i<collectionRecruitList.size();i++){
            Recruit recruit = new Recruit();
            recruit = recruitDao.getRecruitById(collectionRecruitList.get(i).getRecruitId());
            recruitList.add(recruit);
        }
        return recruitList;
    }

    //发布职位
    public Boolean buildRecruit(Recruit recruit){
        RecruitDao recruitDao = new RecruitDao();
        Boolean isScuess = recruitDao.buildRecruit(recruit);
        return isScuess;
    }

    //删除发布职位
    public Boolean deleteRecruitById(Recruit recruit){
        RecruitDao recruitDao = new RecruitDao();
        Boolean isScuess = recruitDao.deleteRecruitById(recruit);
        return isScuess;
    }
    //根据地区随机获得招聘
    public List<Recruit> getRecruitByAddressRandom(Recruit recruit){
        RecruitDao recruitDao = new RecruitDao();
        List<Recruit> recruitList = recruitDao.getRecruitByAddressRandom(recruit);
        return recruitList;
    }
}
