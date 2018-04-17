package com.bishetyl.util;

/**
 * Created by 汤玉龙 on 2018/4/17.
 */
public class PageParams {
    private  int total;
    private  int pageNumber;
    private  int pageSize;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
