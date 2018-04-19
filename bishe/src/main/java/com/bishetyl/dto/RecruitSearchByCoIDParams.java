package com.bishetyl.dto;

import com.bishetyl.util.PageParams;

/**
 * Created by 汤玉龙 on 2018/4/19.
 */
public class RecruitSearchByCoIDParams {
    private int companyId;
    private int total;
    private int pageSize;
    private int pageNumber;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
