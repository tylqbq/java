package com.bishetyl.dto;

import com.bishetyl.entity.Resume;
import com.bishetyl.util.PageParams;

import java.util.List;

/**
 * Created by 汤玉龙 on 2018/5/3.  简历搜索返回数据
 */
public class ResumeListResult {
    private PageParams pageParams;
    private List<Resume> resumeList;

    public PageParams getPageParams() {
        return pageParams;
    }

    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    public List<Resume> getResumeList() {
        return resumeList;
    }

    public void setResumeList(List<Resume> resumeList) {
        this.resumeList = resumeList;
    }
}
