package com.bishetyl.service;

import com.bishetyl.dao.CollectionRecruitDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 汤玉龙 on 2018/4/20.
 */
public class CollectionControllerService {

    //判断是否存在
    public Boolean isExist(int recruitId, int jobSeekerId){
        CollectionRecruitDao collectionRecruitDao = new CollectionRecruitDao();
        Boolean isExist = collectionRecruitDao.isExist(recruitId,jobSeekerId);
        return isExist;
    }

    //删除收藏
    public Boolean deleteRecruitCollection(int recruitId, int jobSeekerId){
        CollectionRecruitDao collectionRecruitDao = new CollectionRecruitDao();
        Boolean isExist = collectionRecruitDao.deleteCollectionRecruit(recruitId,jobSeekerId);
        return isExist;
    }
}
