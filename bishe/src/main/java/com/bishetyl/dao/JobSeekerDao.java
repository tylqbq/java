package com.bishetyl.dao;

import com.bishetyl.entity.JobSeeker;
import com.bishetyl.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by 汤玉龙 on 2018/3/21.
 */
public class JobSeekerDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public JobSeekerDao(){

    }

    public JobSeeker findJobSeekerByPhoneNumberOrEmail(String phoneOrEmail){
        JobSeeker jobSeeker = null;
        JdbcUtil jdbcUtil = new JdbcUtil();
        try{
            this.con = jdbcUtil.getConnection();
            this.sql = "select * from JobSeeker where phoneNumber=? or email=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1,phoneOrEmail);
            this.pst.setString(2,phoneOrEmail);
            this.rs = this.pst.executeQuery();
            if (this.rs.next()){
                jobSeeker = new JobSeeker();
                jobSeeker.setId(this.rs.getInt("id"));
                jobSeeker.setPassword(this.rs.getString("password"));
                jobSeeker.setName(this.rs.getString("name"));
                jobSeeker.setSex(this.rs.getString("sex"));
                jobSeeker.setPhoneNumber(this.rs.getString("phoneNumber"));
                jobSeeker.setEmail(this.rs.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return jobSeeker;
    }

}
