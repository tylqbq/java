package com.bishetyl.dao;

import com.bishetyl.dto.ChangePassWordParams;
import com.bishetyl.dto.RegisterParams;
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
    private int rsCount = 0;
    public JobSeekerDao(){

    }
    /**
     *通过 电话或者email查找是否存在
    **/
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
    /**
     *注册插入一个用户
     **/
    public Boolean insertJobSeeker(RegisterParams params){
        JdbcUtil jdbcUtil = new JdbcUtil();
        try{
            this.con = jdbcUtil.getConnection();
            this.sql = "INSERT into jobseeker(phoneNumber,password) VALUES(?,?)";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1,params.getPhoneNumber());
            this.pst.setString(2,params.getPassword());
            System.out.println(params.getPhoneNumber());
            System.out.println(params.getPassword());
            this.rsCount = this.pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if( this.rsCount == 1){
            return Boolean.valueOf(true);
        }else{
            return Boolean.valueOf(false);
        }
    }
    /**
     *selected 用户 byId
     **/
    public JobSeeker getUserInfo(int id ){
        JdbcUtil jdbcUtil = new JdbcUtil();
        JobSeeker jobSeekerRet = new JobSeeker();
        try{
            this.con = jdbcUtil.getConnection();
            this.sql = "SELECT * FROM jobseeker WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id);
            this.rs = this.pst.executeQuery();
            if (this.rs.next()){
                jobSeekerRet.setId(this.rs.getInt("id"));
                jobSeekerRet.setPassword(this.rs.getString("password"));
                jobSeekerRet.setName(this.rs.getString("name"));
                jobSeekerRet.setSex(this.rs.getString("sex"));
                jobSeekerRet.setPhoneNumber(this.rs.getString("phoneNumber"));
                jobSeekerRet.setEmail(this.rs.getString("email"));
                jobSeekerRet.setBrithDate(this.rs.getString("brithDate"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return jobSeekerRet;
    }

    public Boolean updateUserName(JobSeeker jobSeeker){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try{
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE jobseeker SET name=? WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, jobSeeker.getName());
            this.pst.setInt(2, jobSeeker.getId());
            count = this.pst.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count > 0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean updatePassword(ChangePassWordParams changePassWordParams){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try{
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE jobseeker SET password=? WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, changePassWordParams.getNewPassword());
            this.pst.setInt(2, changePassWordParams.getJobSeekerId());
            count = this.pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count > 0){
            return true;
        }else {
            return false;
        }
    }
    //判断密码是否正确
    public String getPassword(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        String password = "";
        try{
            this.con = jdbcUtil.getConnection();
            this.sql = "SELECT  * FROM jobseeker WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                password = this.rs.getString("password");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return password;
    }

    //修改电话
    public Boolean updatePhoneNumber(JobSeeker jobSeeker){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try{
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE jobseeker SET phoneNumber=? WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, jobSeeker.getPhoneNumber());
            this.pst.setInt(2, jobSeeker.getId());
            count = this.pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count > 0){
            return true;
        }else {
            return false;
        }
    }

    //修改邮箱
    public Boolean updateEmail(JobSeeker jobSeeker){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try{
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE jobseeker SET email=? WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, jobSeeker.getEmail());
            this.pst.setInt(2, jobSeeker.getId());
            count = this.pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count > 0){
            return true;
        }else {
            return false;
        }
    }
}
