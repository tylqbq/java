package com.bishetyl.dto;

import com.bishetyl.entity.Company;
import com.bishetyl.util.PageParams;

import java.util.List;

/**
 * Created by 汤玉龙 on 2018/5/8.
 */
public class CompanyListRet {
    private List<Company> companyList;
    private PageParams pageParams;

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public PageParams getPageParams() {
        return pageParams;
    }

    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }
}
