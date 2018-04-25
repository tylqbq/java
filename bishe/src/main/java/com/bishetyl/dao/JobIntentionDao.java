package com.bishetyl.dao;

import com.bishetyl.entity.JobIntention;
import com.bishetyl.entity.Resume;
import com.bishetyl.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/22.
 */
public class JobIntentionDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public JobIntentionDao(){

    }
    //增加
    public void  addJobIntention(JobIntention jobIntention,int resumeId){
        JdbcUtil jdbcUtil = new JdbcUtil();
//        JobIntention jobIntentionRet = new JobIntention();
        int rowID=0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "INSERT into jobintention(salary,workPlace,function,position,industry,industryLabel,introduction,workType,resumeId)\n" +
                    "VALUES(?,?,?,?,?,?,?,?,?)";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, jobIntention.getSalary());
            this.pst.setString(2, jobIntention.getWorkPlace());
            this.pst.setString(3, jobIntention.getFunction());
            this.pst.setString(4, jobIntention.getPosition());
            this.pst.setString(5, jobIntention.getIndustry());
            this.pst.setString(6, jobIntention.getIndustryLabel());
            this.pst.setString(7, jobIntention.getIntroduction());
            this.pst.setString(8, jobIntention.getWorkType());
            this.pst.setInt(9, resumeId);
            int count = this.pst.executeUpdate();
//            if(count>0){
//                //取得插入行的id  新建简历的id
//                String idSql = "SELECT LAST_INSERT_ID()";
//                this.pst = this.con.prepareStatement(idSql);
//                this.rs = this.pst.executeQuery();
//                while (this.rs.next()){
//                    rowID = this.rs.getInt("LAST_INSERT_ID()");
//                }
//            }
            //取得插入行数据
//            jobIntentionRet = this.searchJobIntentionByid(rowID);
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
    }
    //删除
    public Boolean deleteJobIntention(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM jobintention where id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,id);
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if(count > 0) {
            return true;
        }else{
            return false;
        }
    }
    //删除resumeId下所有jobintention
    public Boolean deleteJobIntentionByResumeId(int resumeId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM jobintention where resumeId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,resumeId);
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if(count > 0) {
            return true;
        }else{
            return false;
        }
    }

    //修改
    public Boolean updateJobIntention(JobIntention jobIntention){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE jobintention set salary=?,workPlace=?,function=?,position=?,industry=?,industryLabel=?,introduction=?,workType=? \n" +
                    "WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, jobIntention.getSalary());
            this.pst.setString(2,jobIntention.getWorkPlace());
            this.pst.setString(3,jobIntention.getFunction());
            this.pst.setString(4,jobIntention.getPosition());
            this.pst.setString(5,jobIntention.getIndustryLabel());
            this.pst.setString(6,jobIntention.getIndustryLabel());
            this.pst.setString(7,jobIntention.getIntroduction());
            this.pst.setString(8, jobIntention.getWorkType());
            this.pst.setInt(9, jobIntention.getId());
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if(count > 0) {
            return true;
        }else{
            return false;
        }
    }
    //查找ByID
    public JobIntention searchJobIntentionByid(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        JobIntention jobIntention = new JobIntention();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM jobIntention where resumeId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,id);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                jobIntention.setId(this.rs.getInt("id"));
                jobIntention.setSalary(this.rs.getString("salary"));
                jobIntention.setWorkPlace(this.rs.getString("workPlace"));
                jobIntention.setFunction(this.rs.getString("function"));
                jobIntention.setPosition(this.rs.getString("position"));
                jobIntention.setIndustry(this.rs.getString("industry"));
                jobIntention.setIndustryLabel(this.rs.getString("industryLabel"));
                jobIntention.setIntroduction(this.rs.getString("introduction"));
                jobIntention.setWorkType(this.rs.getString("workType"));
                jobIntention.setResumeId(this.rs.getInt("resumeId"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return jobIntention;
    }

    //查找ByResumeID
    public List<JobIntention> searchJobIntentionByResumeId(int resumeId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        List<JobIntention> jobIntentionList = new ArrayList<JobIntention>();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM jobIntention where resumeId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,resumeId);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                JobIntention jobIntention = new JobIntention();
                jobIntention.setId(this.rs.getInt("id"));
                jobIntention.setSalary(this.rs.getString("salary"));
                jobIntention.setWorkPlace(this.rs.getString("workPlace"));
                jobIntention.setFunction(this.rs.getString("function"));
                jobIntention.setPosition(this.rs.getString("position"));
                jobIntention.setIndustry(this.rs.getString("industry"));
                jobIntention.setIndustryLabel(this.rs.getString("industryLabel"));
                jobIntention.setIntroduction(this.rs.getString("introduction"));
                jobIntention.setWorkType(this.rs.getString("workType"));
                jobIntention.setResumeId(this.rs.getInt("resumeId"));
                jobIntentionList.add(jobIntention);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return jobIntentionList;
    }
}

