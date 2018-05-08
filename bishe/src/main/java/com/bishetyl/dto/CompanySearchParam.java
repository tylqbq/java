package com.bishetyl.dto;

import com.bishetyl.entity.Company;
import com.bishetyl.util.PageParams;

/**
 * Created by 汤玉龙 on 2018/5/8.
 */
public class CompanySearchParam {
    private PageParams pageParams;
    private Company company;

    public PageParams getPageParams() {
        return pageParams;
    }

    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
