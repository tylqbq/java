package com.bishetyl.dto;

import com.bishetyl.entity.Article;

import java.util.List;

/**
 * Created by 汤玉龙 on 2018/5/4.
 */
public class ArticleAllResult {
    private List<Article> todayHotList; //今日热点
    private List<Article> hotArticle;//热门文章
    private List<Article> interviewArticle;//面试
    private List<Article> jobHoppingArticle;//跳槽
    private List<Article> entranceArticle;//求职

    public List<Article> getTodayHotList() {
        return todayHotList;
    }

    public void setTodayHotList(List<Article> todayHotList) {
        this.todayHotList = todayHotList;
    }

    public List<Article> getHotArticle() {
        return hotArticle;
    }

    public void setHotArticle(List<Article> hotArticle) {
        this.hotArticle = hotArticle;
    }

    public List<Article> getInterviewArticle() {
        return interviewArticle;
    }

    public void setInterviewArticle(List<Article> interviewArticle) {
        this.interviewArticle = interviewArticle;
    }

    public List<Article> getJobHoppingArticle() {
        return jobHoppingArticle;
    }

    public void setJobHoppingArticle(List<Article> jobHoppingArticle) {
        this.jobHoppingArticle = jobHoppingArticle;
    }

    public List<Article> getEntranceArticle() {
        return entranceArticle;
    }

    public void setEntranceArticle(List<Article> entranceArticle) {
        this.entranceArticle = entranceArticle;
    }
}
