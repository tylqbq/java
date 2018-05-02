package com.bishetyl.dao;

import com.bishetyl.dto.ChangePassWordParams;
import com.bishetyl.entity.CompanyUser;
import com.bishetyl.util.JdbcUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 汤玉龙 on 2018/4/27.
 */
public class CompanyUserDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public CompanyUserDao(){

    }
    //注册公司用户
    public int registerCompanyUser(CompanyUser companyUser){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        int rowID = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="INSERT INTO companyuser(member,userName,password,phoneNumber,email,companyId)" +
                    "VALUES(?,?,?,?,?,?)";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, companyUser.getMember());
            this.pst.setString(2, companyUser.getUserName());
            this.pst.setString(3, companyUser.getPassword());
            this.pst.setString(4, companyUser.getPhoneNumber());
            this.pst.setString(5, companyUser.getEmail());
            this.pst.setInt(6, companyUser.getCompanyId());
            count = this.pst.executeUpdate();
            if (count > 0){
                //取得插入行的id  新建简历的id
                String idSql = "SELECT LAST_INSERT_ID()";
                this.pst = this.con.prepareStatement(idSql);
                this.rs = this.pst.executeQuery();
                while (this.rs.next()){
                    rowID = this.rs.getInt("LAST_INSERT_ID()");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return rowID;
    }
    //获取公司用户
    public CompanyUser getCompanyUserById(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        CompanyUser companyUser = new CompanyUser();
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="SELECT * FROM companyuser WHERE id=?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setInt(1, id);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                companyUser.setId(this.rs.getInt("id"));
                companyUser.setMember(this.rs.getString("member"));
                companyUser.setUserName(this.rs.getString("userName"));
                companyUser.setPassword(this.rs.getString("password"));
                companyUser.setPhoneNumber(this.rs.getString("phoneNumber"));
                companyUser.setEmail(this.rs.getString("email"));
                companyUser.setCompanyId(this.rs.getInt("companyId"));
                companyUser.setExaminePass(this.rs.getInt("examinePass"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return companyUser;
    }

    public CompanyUser login(CompanyUser companyUser){
        JdbcUtil jdbcUtil = new JdbcUtil();
        CompanyUser companyUserRet = null;
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="SELECT * FROM companyuser WHERE userName=?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, companyUser.getUserName());
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                companyUserRet = new CompanyUser();
                companyUserRet.setId(this.rs.getInt("id"));
                companyUserRet.setMember(this.rs.getString("member"));
                companyUserRet.setUserName(this.rs.getString("userName"));
                companyUserRet.setPassword(this.rs.getString("password"));
                companyUserRet.setPhoneNumber(this.rs.getString("phoneNumber"));
                companyUserRet.setEmail(this.rs.getString("email"));
                companyUserRet.setCompanyId(this.rs.getInt("companyId"));
                companyUserRet.setExaminePass(this.rs.getInt("examinePass"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return companyUserRet;
    }

    public CompanyUser getCompanyUserInfo(CompanyUser companyUser){
        JdbcUtil jdbcUtil = new JdbcUtil();
        CompanyUser companyUserRet = null;
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="SELECT * FROM companyuser WHERE id=?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setInt(1, companyUser.getId());
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                companyUserRet = new CompanyUser();
                companyUserRet.setId(this.rs.getInt("id"));
                companyUserRet.setMember(this.rs.getString("member"));
                companyUserRet.setUserName(this.rs.getString("userName"));
                companyUserRet.setPhoneNumber(this.rs.getString("phoneNumber"));
                companyUserRet.setEmail(this.rs.getString("email"));
                companyUserRet.setCompanyId(this.rs.getInt("companyId"));
                companyUserRet.setExaminePass(this.rs.getInt("examinePass"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return companyUserRet;
    }

    //注册公司用户
    public Boolean updateMember(CompanyUser companyUser){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="UPDATE companyuser set member=? WHERE id=?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, companyUser.getMember());
            this.pst.setInt(2, companyUser.getId());
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count>0){
            return true;
        }else {
            return false;
        }
    }

    //修改密码
    public Boolean updatePassword(ChangePassWordParams changePassWordParams){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="UPDATE companyuser set password=? WHERE id=?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, changePassWordParams.getNewPassword());
            this.pst.setInt(2, changePassWordParams.getCompanyUserId());
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count>0){
            return true;
        }else {
            return false;
        }
    }

    //修改手机
    public Boolean updatePhoneNumber(CompanyUser companyUser){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="UPDATE companyuser set phoneNumber=? WHERE id=?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, companyUser.getPhoneNumber());
            this.pst.setInt(2, companyUser.getId());
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count>0){
            return true;
        }else {
            return false;
        }
    }

    //修改邮箱
    public Boolean updateEmail(CompanyUser companyUser){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="UPDATE companyuser set email=? WHERE id=?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, companyUser.getEmail());
            this.pst.setInt(2, companyUser.getId());
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count>0){
            return true;
        }else {
            return false;
        }
    }



}
