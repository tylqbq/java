package com.bishetyl.service;

import com.bishetyl.dao.ArticleDao;
import com.bishetyl.dto.ArticleAllResult;
import com.bishetyl.entity.Article;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * Created by 汤玉龙 on 2018/5/4.
 */
public class ArticleService {

    public Boolean publishArticle(Article article){
        ArticleDao articleDao = new ArticleDao();
        Boolean isScuess = articleDao.insertIntoArticle(article);
        return isScuess;
    }

    public ArticleAllResult getArticleAll(){
        ArticleAllResult articleAllResult = new ArticleAllResult();

        ArticleDao articleDao = new ArticleDao();
        List<Article> todayHot = articleDao.getArticleByType("今日热点");
        List<Article> hotArticle = articleDao.getArticleByType("热门文章");
        List<Article> interviewArticle = articleDao.getArticleByType("面试");
        List<Article> jobHoppingArticle = articleDao.getArticleByType("跳槽");
        List<Article> entranceArticle = articleDao.getArticleByType("就职");

        articleAllResult.setTodayHotList(todayHot);
        articleAllResult.setHotArticle(hotArticle);
        articleAllResult.setInterviewArticle(interviewArticle);
        articleAllResult.setJobHoppingArticle(jobHoppingArticle);
        articleAllResult.setEntranceArticle(entranceArticle);

        return articleAllResult;
    }

    public Article getArticleById(Article article){
        ArticleDao articleDao = new ArticleDao();
        Article articleRet = articleDao.getArticleByid(article.getId());

        return articleRet;
    }

}
