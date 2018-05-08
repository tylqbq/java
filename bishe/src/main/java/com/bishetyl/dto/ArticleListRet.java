package com.bishetyl.dto;

import com.bishetyl.entity.Article;
import com.bishetyl.util.PageParams;

import java.util.List;

/**
 * Created by 汤玉龙 on 2018/5/8.
 */
public class ArticleListRet {
    private PageParams pageParams;
    private List<Article> articleList;

    public PageParams getPageParams() {
        return pageParams;
    }

    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
