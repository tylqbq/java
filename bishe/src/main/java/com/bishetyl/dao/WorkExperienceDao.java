package com.bishetyl.dao;

import com.bishetyl.entity.Resume;
import com.bishetyl.entity.WorkExperience;
import com.bishetyl.util.JdbcUtil;
import sun.security.acl.WorldGroupImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/22.
 */
public class WorkExperienceDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public WorkExperienceDao(){

    }
    //增加
    public Boolean  addWorkExperience(WorkExperience workExperience){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "INSERT into workexperience (startDate,endDate,companyName,companyType,function,industry,position,department,workDetails,starffNumber,resumeId)\n" +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, workExperience.getStartDate());
            this.pst.setString(2, workExperience.getEndDate());
            this.pst.setString(3, workExperience.getCompanyName());
            this.pst.setString(4, workExperience.getCompanyType());
            this.pst.setString(5, workExperience.getFunction());
            this.pst.setString(6, workExperience.getIndustry());
            this.pst.setString(7, workExperience.getPosition());
            this.pst.setString(8, workExperience.getDepartment());
            this.pst.setString(9, workExperience.getWorkDetails());
            this.pst.setString(10, workExperience.getStarffNumber());
            this.pst.setInt(11, workExperience.getResumeId());
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
    //删除
    public Boolean deleteWorkExperience(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM workexperience where id=?";
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

    //修改
    public Boolean updateWorkExperience(WorkExperience workExperience){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE workexperience  set startDate=?,endDate=?,companyName=?,companyType=?,function=?,industry=?,position=?,\n" +
                    "department?,workDetails=?,starffNumber=? WHERE  id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, workExperience.getStartDate());
            this.pst.setString(2,workExperience.getEndDate());
            this.pst.setString(3,workExperience.getCompanyName());
            this.pst.setString(4,workExperience.getCompanyType());
            this.pst.setString(5,workExperience.getFunction());
            this.pst.setString(6,workExperience.getIndustry());
            this.pst.setString(7,workExperience.getPosition());
            this.pst.setString(8, workExperience.getDepartment());
            this.pst.setString(9,workExperience.getWorkDetails());
            this.pst.setString(10, workExperience.getStarffNumber());
            this.pst.setInt(11, workExperience.getId());
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
    //查找ById
    public WorkExperience searchWorkExperience(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        WorkExperience workExperience = new WorkExperience();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM workexperience where id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,id);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                workExperience.setId(this.rs.getInt("id"));
                workExperience.setStartDate(this.rs.getString("startDate"));
                workExperience.setEndDate(this.rs.getString("endDate"));
                workExperience.setCompanyName(this.rs.getString("companyName"));
                workExperience.setCompanyType(this.rs.getString("companyType"));
                workExperience.setFunction(this.rs.getString("function"));
                workExperience.setIndustry(this.rs.getString("industry"));
                workExperience.setPosition(this.rs.getString("position"));
                workExperience.setDepartment(this.rs.getString("department"));
                workExperience.setWorkDetails(this.rs.getString("workDetails"));
                workExperience.setStarffNumber(this.rs.getString("starffNumber"));
                workExperience.setResumeId(this.rs.getInt("resumeId"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return workExperience;
    }

    //查找ByResumeId
    public List<WorkExperience> searchWorkExperienceByResumeId(int resumeId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM workexperience where resumeId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,resumeId);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                WorkExperience workExperience = new WorkExperience();
                workExperience.setId(this.rs.getInt("id"));
                workExperience.setStartDate(this.rs.getString("startDate"));
                workExperience.setEndDate(this.rs.getString("endDate"));
                workExperience.setCompanyName(this.rs.getString("companyName"));
                workExperience.setCompanyType(this.rs.getString("resumeId"));
                workExperience.setFunction(this.rs.getString("function"));
                workExperience.setIndustry(this.rs.getString("industry"));
                workExperience.setPosition(this.rs.getString("position"));
                workExperience.setDepartment(this.rs.getString("department"));
                workExperience.setWorkDetails(this.rs.getString("workDetails"));
                workExperience.setStarffNumber(this.rs.getString("starffNumber"));
                workExperience.setResumeId(this.rs.getInt("resumeId"));
                workExperienceList.add(workExperience);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return workExperienceList;
    }
}
