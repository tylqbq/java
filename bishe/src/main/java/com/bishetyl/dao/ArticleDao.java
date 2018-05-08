package com.bishetyl.dao;

import com.bishetyl.dto.ArticleListRet;
import com.bishetyl.dto.ArticleSearchParams;
import com.bishetyl.entity.Article;
import com.bishetyl.util.JdbcUtil;
import com.bishetyl.util.PageParams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/5/4.
 */
public class ArticleDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public ArticleDao(){

    }

    public Boolean insertIntoArticle(Article article){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="INSERT INTO article(author,publishTime,title,content,type)VALUES(?,?,?,?,?)";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, article.getAuthor());
            this.pst.setString(2, article.getPublishTime());
            this.pst.setString(3, article.getTitle());
            this.pst.setString(4, article.getContent());
            this.pst.setString(5, article.getType());
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count>0){
            return true;
        }else {
            return  false;
        }
    }

    public List<Article> getArticleByType(String type){
        List<Article> articleList = new ArrayList<Article>();
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="SELECT * FROM article WHERE  type=? and status=1 limit 0,5";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, type);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                Article article = new Article();
                article.setId(this.rs.getInt("id"));
                article.setAuthor(this.rs.getString("author"));
                article.setPublishTime(this.rs.getString("publishTime"));
                article.setTitle(this.rs.getString("title"));
                article.setContent(this.rs.getString("content"));
                article.setType(this.rs.getString("type"));
                articleList.add(article);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return articleList;
    }

    public Article getArticleByid(int id){
        Article article = new Article();
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="SELECT * FROM article WHERE  id=?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setInt(1, id);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                article.setId(this.rs.getInt("id"));
                article.setAuthor(this.rs.getString("author"));
                article.setPublishTime(this.rs.getString("publishTime"));
                article.setTitle(this.rs.getString("title"));
                article.setContent(this.rs.getString("content"));
                article.setType(this.rs.getString("type"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return article;
    }

    public ArticleListRet getArticleByParams(ArticleSearchParams articleSearchParams){
        ArticleListRet articleListRet =  new ArticleListRet();
        List<Article> articleList = new ArrayList<Article>();

        Article article = new Article();
        JdbcUtil jdbcUtil = new JdbcUtil();
        List<Object> paramsList = new ArrayList<Object>();
        try {
            this.con = jdbcUtil.getConnection();
            StringBuilder  sql = new StringBuilder("select * from article where 1=1 and status=0");
            StringBuilder  countSql = new StringBuilder("select count(*) from article where 1=1 and status=0");
            //标题
            String title = articleSearchParams.getArticle().getTitle();
            if (title != null && !title.trim().isEmpty()){
                sql.append(" and title like ?");
                countSql.append(" and title like ?");
                paramsList.add("%" + title + "%");
            }

            //作者
            String author = articleSearchParams.getArticle().getAuthor();
            if (author != null && !author.trim().isEmpty()){
                sql.append(" and author like ?");
                countSql.append(" and author like ?");
                paramsList.add("%" + author + "%");
            }
            //类型
            String type = articleSearchParams.getArticle().getType();
            if (type != null && !type.trim().isEmpty()&& !type.equals("所有")){
                sql.append(" and type = ?");
                countSql.append(" and type = ?");
                paramsList.add(type);
            }

            //日期
            String publishTime = articleSearchParams.getArticle().getPublishTime();
            if (publishTime != null && !publishTime.trim().isEmpty()){
                sql.append(" and publishTime = ?");
                countSql.append(" and publishTime = ?");
                paramsList.add(publishTime);
            }

            //分页查询  每次指定查询多少条数据
            int pageNumber = articleSearchParams.getPageParams().getPageNumber();
            int pageSize = articleSearchParams.getPageParams().getPageSize();
            int startIndex = (pageNumber-1)*pageSize;
            sql.append(" limit "+startIndex+","+pageSize+"");

            this.pst = this.con.prepareStatement(sql.toString());

            for (int i=0;i<paramsList.size();i++){
                Object param = paramsList.get(i);
                if (param instanceof Integer){
                    this.pst.setInt(i+1, Integer.parseInt(paramsList.get(i).toString()));
                }else if (param instanceof String){
                    this.pst.setString(i+1, paramsList.get(i).toString());
                }
            }
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                Article articleRet = new Article();
                articleRet.setId(this.rs.getInt("id"));
                articleRet.setAuthor(this.rs.getString("author"));
                articleRet.setPublishTime(this.rs.getString("publishTime"));
                articleRet.setTitle(this.rs.getString("title"));
                articleRet.setContent(this.rs.getString("content"));
                articleRet.setType(this.rs.getString("type"));
                articleList.add(articleRet);
            }
            //获取记录总数
            this.pst = this.con.prepareStatement(countSql.toString());
            for (int i=0;i<paramsList.size();i++){
                Object param = paramsList.get(i);
                if (param instanceof Integer){
                    this.pst.setInt(i+1, Integer.parseInt(paramsList.get(i).toString()));
                }else if (param instanceof String){
                    this.pst.setString(i+1, paramsList.get(i).toString());
                }
            }
            this.rs = this.pst.executeQuery();
            int rowCount = 0;
            if (this.rs.next()){
                rowCount = this.rs.getInt(1);
            }
            //分页参数
            PageParams pageParams = new PageParams();
            pageParams.setTotal(rowCount);//总数
            pageParams.setPageNumber(articleSearchParams.getPageParams().getPageNumber());//当前页码
            pageParams.setPageSize(articleSearchParams.getPageParams().getPageSize());//每页显示条数

            articleListRet.setArticleList(articleList); //设置数据
            articleListRet.setPageParams(pageParams);//设置分页参数

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return articleListRet;
    }

    public Boolean adoptArticle(int articleId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="UPDATE article SET status=1 WHERE id =?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setInt(1, articleId);
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean sendBackArticle(int articleId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="UPDATE article SET status=2 WHERE id =?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setInt(1, articleId);
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count>0){
            return true;
        }else{
            return false;
        }
    }






}
