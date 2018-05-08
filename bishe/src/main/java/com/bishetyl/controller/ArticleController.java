package com.bishetyl.controller;

import com.bishetyl.dto.ArticleAllResult;
import com.bishetyl.entity.Article;
import com.bishetyl.entity.Resume;
import com.bishetyl.service.ArticleService;
import com.bishetyl.service.ResumeService;
import com.bishetyl.util.Log;
import com.bishetyl.util.Result;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 汤玉龙 on 2018/5/4.
 */
@Controller
@ResponseBody
public class ArticleController {
    Result result = null;

    @RequestMapping("/article/publishArticle")
    @ResponseBody
    @Log(title = "发表文章")
    public Result publishArticle(@RequestBody Article article){
        Result result = new Result();
        ArticleService articleService = new ArticleService();
        Boolean isScuess = articleService.publishArticle(article);
        if(isScuess){
            result.setStatus(true);
            result.setData("发表成功");
        }else{
            result.setStatus(false);
            result.setData("发表失败");
        }
        return result;
    }

    @RequestMapping("/article/getArticleAll")
    @ResponseBody
    @Log(title = "发表文章")
    public Result getArticleAll(){
        Result result = new Result();
        ArticleService articleService = new ArticleService();
        ArticleAllResult articleAllResult  = articleService.getArticleAll();
        result.setData(articleAllResult);
        return result;
    }

    @RequestMapping("/article/getArticleById")
    @ResponseBody
    @Log(title = "发表文章")
    public Result getArticleById(Article article){
        Result result = new Result();
        ArticleService articleService = new ArticleService();
        Article articleRet  = articleService.getArticleById(article);
        result.setData(articleRet);
        return result;
    }



}
