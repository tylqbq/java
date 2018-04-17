package com.bishetyl.dto;

import com.bishetyl.entity.Recruit;
import com.bishetyl.util.PageParams;

import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/17.
 */
public class RecruitResult {
    private  List<Recruit> recruitList;
    private PageParams pageParams;

    public List<Recruit> getRecruitList() {
        return recruitList;
    }

    public void setRecruitList(List<Recruit> recruitList) {
        this.recruitList = recruitList;
    }

    public PageParams getPageParams() {
        return pageParams;
    }

    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }
}
