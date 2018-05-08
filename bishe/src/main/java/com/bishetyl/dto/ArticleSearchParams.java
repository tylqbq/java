package com.bishetyl.dto;

import com.bishetyl.entity.Article;
import com.bishetyl.util.PageParams;

/**
 * Created by 汤玉龙 on 2018/5/8.
 */
public class ArticleSearchParams {
    private PageParams pageParams;
    private Article article;

    public PageParams getPageParams() {
        return pageParams;
    }

    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
