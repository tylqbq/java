package com.bishetyl.dao;

import com.bishetyl.entity.EducationExperience;
import com.bishetyl.entity.WorkExperience;
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
public class EducationExperienceDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public EducationExperienceDao(){

    }
    //增加
    public Boolean  addEducationExperience(EducationExperience educationExperience,int resumeId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "INSERT into educationalexperience(startDate,endDate,education,school,profession,details,resumeId)\n" +
                    "VALUES (?,?,?,?,?,?,?)";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, educationExperience.getStartDate());
            this.pst.setString(2, educationExperience.getEndDate());
            this.pst.setString(3, educationExperience.getEducation());
            this.pst.setString(4, educationExperience.getSchool());
            this.pst.setString(5, educationExperience.getProfession());
            this.pst.setString(6, educationExperience.getDetails());
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
    public Boolean deleteEducationExperience(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM educationalexperience where id=?";
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
    //删除By ResumeID
    public Boolean deleteEducationExperienceByResumeId(int ResumeID){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM educationalexperience where ResumeID=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,ResumeID);
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
    public Boolean updateEducationExperience(EducationExperience educationExperience){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE educationalexperience SET startDate=?,endDate=?,education=?,school=?,profession=?,details=?\n" +
                    "where id = ?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, educationExperience.getStartDate());
            this.pst.setString(2,educationExperience.getEndDate());
            this.pst.setString(3,educationExperience.getEducation());
            this.pst.setString(4,educationExperience.getSchool());
            this.pst.setString(5,educationExperience.getProfession());
            this.pst.setString(6,educationExperience.getDetails());
            this.pst.setInt(7, educationExperience.getId());
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
    public EducationExperience searchEducationExperience(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        EducationExperience educationExperience = new EducationExperience();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM educationalexperience where id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,id);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                educationExperience.setId(this.rs.getInt("id"));
                educationExperience.setStartDate(this.rs.getString("startDate"));
                educationExperience.setEndDate(this.rs.getString("endDate"));
                educationExperience.setEducation(this.rs.getString("education"));
                educationExperience.setSchool(this.rs.getString("school"));
                educationExperience.setProfession(this.rs.getString("profession"));
                educationExperience.setProfession(this.rs.getString("profession"));
                educationExperience.setResumeId(this.rs.getInt("resumeId"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return educationExperience;
    }

    //查找ByResumeId
    public EducationExperience searchEducationExperienceByResumeId(int resumeId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        EducationExperience educationExperience = new EducationExperience();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM educationalexperience where resumeId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,resumeId);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                educationExperience.setId(this.rs.getInt("id"));
                educationExperience.setStartDate(this.rs.getString("startDate"));
                educationExperience.setEndDate(this.rs.getString("endDate"));
                educationExperience.setEducation(this.rs.getString("education"));
                educationExperience.setSchool(this.rs.getString("school"));
                educationExperience.setProfession(this.rs.getString("profession"));
                educationExperience.setDetails(this.rs.getString("details"));
                educationExperience.setResumeId(this.rs.getInt("resumeId"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return educationExperience;
    }

}
