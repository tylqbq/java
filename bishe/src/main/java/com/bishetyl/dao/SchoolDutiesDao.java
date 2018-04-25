package com.bishetyl.dao;

import com.bishetyl.entity.Resume;
import com.bishetyl.entity.SchoolDuties;
import com.bishetyl.entity.SchoolHonor;
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
public class SchoolDutiesDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;

    public SchoolDutiesDao() {

    }

    //增加
    public Boolean addSchoolDuties(SchoolDuties schoolDuties,int resumeId) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "INSERT into schoolduties(startDate,endDate,name,details,resumeId) VALUES(?,?,?,?,?)";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, schoolDuties.getStartDate());
            this.pst.setString(2, schoolDuties.getEndDate());
            this.pst.setString(3, schoolDuties.getName());
            this.pst.setString(4, schoolDuties.getDetails());
            this.pst.setInt(5, resumeId);
            count = this.pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    //删除
    public Boolean deleteSchoolDuties(int id) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM schoolduties where id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id);
            count = this.pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    //删除ByResumeId
    public Boolean deleteSchoolDutiesByResumeId(int resumeId) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM schoolduties where resumeId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, resumeId);
            count = this.pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    //修改
    public Boolean updateSchoolDuties(SchoolDuties schoolDuties) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE schoolduties set startDate=?,endDate=?,name=?,details=? where id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, schoolDuties.getStartDate());
            this.pst.setString(2, schoolDuties.getEndDate());
            this.pst.setString(3, schoolDuties.getName());
            this.pst.setString(4, schoolDuties.getDetails());
            this.pst.setInt(5, schoolDuties.getId());
            count = this.pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }


    //查找ById
    public SchoolDuties searchSchoolDuties(int id) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        SchoolDuties schoolDuties = new SchoolDuties();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM schoolduties where id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()) {
                schoolDuties.setId(this.rs.getInt("id"));
                schoolDuties.setStartDate(this.rs.getString("startDate"));
                schoolDuties.setEndDate(this.rs.getString("endDate"));
                schoolDuties.setName(this.rs.getString("name"));
                schoolDuties.setDetails(this.rs.getString("details"));
                schoolDuties.setResumeId(this.rs.getInt("resumeId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return schoolDuties;
    }

    //查找ByResumeId
    public List<SchoolDuties> searchSchoolDutiesByResumeId(int resumeId) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        List<SchoolDuties> schoolDutiesList = new ArrayList<SchoolDuties>();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM schoolduties where resumeId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, resumeId);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()) {
                SchoolDuties schoolDuties = new SchoolDuties();
                schoolDuties.setId(this.rs.getInt("id"));
                schoolDuties.setStartDate(this.rs.getString("startDate"));
                schoolDuties.setEndDate(this.rs.getString("endDate"));
                schoolDuties.setName(this.rs.getString("name"));
                schoolDuties.setDetails(this.rs.getString("details"));
                schoolDuties.setResumeId(this.rs.getInt("resumeId"));
                schoolDutiesList.add(schoolDuties);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return schoolDutiesList;
    }
}
