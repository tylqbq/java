package com.bishetyl.dao;

import com.bishetyl.entity.EducationExperience;
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
public class SchoolHonorDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;

    public SchoolHonorDao() {

    }

    //增加
    public Boolean addSchoolHonor(SchoolHonor schoolHonor,int resumeId) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "INSERT into schoolhonor(startDate,prizeName,level,resumeId) VALUES(?,?,?,?)";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, schoolHonor.getStartDate());
            this.pst.setString(2, schoolHonor.getPrizeName());
            this.pst.setString(3, schoolHonor.getLevel());
            this.pst.setInt(4, resumeId);
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
    public Boolean deleteSchoolHonor(int id) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM schoolhonor where id=?";
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

    //删除By ResumeId
    public Boolean deleteSchoolHonorByResumeId(int resumeId) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM schoolhonor where resumeId=?";
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
    public Boolean updateSchoolHonor(SchoolHonor schoolHonor) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE schoolhonor set startDate=?,prizeName=?,level=? WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, schoolHonor.getStartDate());
            this.pst.setString(2, schoolHonor.getPrizeName());
            this.pst.setString(3, schoolHonor.getLevel());
            this.pst.setInt(4, schoolHonor.getId());
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
    public SchoolHonor searchSchoolHonor(int id) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        SchoolHonor schoolHonor = new SchoolHonor();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM schoolhonor where id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()) {
                schoolHonor.setId(this.rs.getInt("id"));
                schoolHonor.setStartDate(this.rs.getString("startDate"));
                schoolHonor.setPrizeName(this.rs.getString("prizeName"));
                schoolHonor.setLevel(this.rs.getString("level"));
                schoolHonor.setResumeId(this.rs.getInt("resumeId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return schoolHonor;
    }

    //查找ByResumeId
    public List<SchoolHonor> searchSchoolHonorByResumeId(int resumeId) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        List<SchoolHonor> schoolHonorList = new ArrayList<SchoolHonor>();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM schoolhonor where resumeId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, resumeId);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()) {
                SchoolHonor schoolHonor = new SchoolHonor();
                schoolHonor.setId(this.rs.getInt("id"));
                schoolHonor.setStartDate(this.rs.getString("startDate"));
                schoolHonor.setPrizeName(this.rs.getString("prizeName"));
                schoolHonor.setLevel(this.rs.getString("level"));
                schoolHonor.setResumeId(this.rs.getInt("resumeId"));
                schoolHonorList.add(schoolHonor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return schoolHonorList;
    }
}
