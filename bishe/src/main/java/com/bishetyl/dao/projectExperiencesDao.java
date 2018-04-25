package com.bishetyl.dao;

import com.bishetyl.entity.ProjectExperience;
import com.bishetyl.entity.WorkExperience;
import com.bishetyl.util.JdbcUtil;
import jdk.nashorn.internal.ir.PropertyKey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/22.
 */
public class ProjectExperiencesDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public ProjectExperiencesDao(){

    }

    //增加
    public Boolean  addProjectExperience(ProjectExperience projectExperience,int resumeId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "insert into projectexperience(companyName,startDate,endDate,projectName,projectDetails,dutyDetails,resumeId)\n" +
                    "VALUES(?,?,?,?,?,?,?)";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, projectExperience.getCompanyName());
            this.pst.setString(2, projectExperience.getStartDate());
            this.pst.setString(3, projectExperience.getEndDate());
            this.pst.setString(4, projectExperience.getProjectName());
            this.pst.setString(5, projectExperience.getProjectDetails());
            this.pst.setString(6, projectExperience.getDutyDetails());
            this.pst.setInt(7, resumeId);
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
    public Boolean deleteProjectExperience(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM projectexperience where id=?";
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

    //删除所有ByResumeId
    public Boolean deleteProjectExperienceByResumeId(int resumeId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM projectexperience where resumeId=?";
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
    public Boolean updateProjectExperience(ProjectExperience projectExperiencese){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE projectexperience set companyName=?,startDate=?,endDate=?,projectName=?,projectDetails=?,dutyDetails=? \n" +
                    "WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, projectExperiencese.getCompanyName());
            this.pst.setString(2,projectExperiencese.getStartDate());
            this.pst.setString(3,projectExperiencese.getEndDate());
            this.pst.setString(4,projectExperiencese.getProjectName());
            this.pst.setString(5, projectExperiencese.getProjectDetails());
            this.pst.setString(6, projectExperiencese.getDutyDetails());
            this.pst.setInt(7,projectExperiencese.getId());
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
    public ProjectExperience searchProjectExperience(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        ProjectExperience projectExperience = new ProjectExperience();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM projectexperience where id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,id);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                projectExperience.setId(this.rs.getInt("id"));
                projectExperience.setCompanyName(this.rs.getString("companyName"));
                projectExperience.setStartDate(this.rs.getString("startDate"));
                projectExperience.setEndDate(this.rs.getString("endDate"));
                projectExperience.setProjectName(this.rs.getString("projectName"));
                projectExperience.setProjectDetails(this.rs.getString("projectDetails"));
                projectExperience.setDutyDetails(this.rs.getString("dutyDetails"));
                projectExperience.setResumeId(this.rs.getInt("resumeId"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return projectExperience;
    }

    //查找ByResumeId
    public List<ProjectExperience> searchProjectExperiencesByResumeId(int resumeId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        List<ProjectExperience> projectExperienceList = new ArrayList<ProjectExperience>();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM projectexperience where resumeId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,resumeId);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                ProjectExperience projectExperience = new ProjectExperience();
                projectExperience.setId(this.rs.getInt("id"));
                projectExperience.setStartDate(this.rs.getString("startDate"));
                projectExperience.setEndDate(this.rs.getString("endDate"));
                projectExperience.setCompanyName(this.rs.getString("companyName"));
                projectExperience.setProjectName(this.rs.getString("projectName"));
                projectExperience.setProjectDetails(this.rs.getString("projectDetails"));
                projectExperience.setDutyDetails(this.rs.getString("dutyDetails"));
                projectExperience.setResumeId(this.rs.getInt("resumeId"));
                projectExperienceList.add(projectExperience);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return projectExperienceList;
    }

}
