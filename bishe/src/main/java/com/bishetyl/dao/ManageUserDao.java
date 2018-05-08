package com.bishetyl.dao;

import com.bishetyl.dto.ChangePassWordParams;
import com.bishetyl.dto.CompanyListRet;
import com.bishetyl.dto.CompanySearchParam;
import com.bishetyl.dto.IndustryComparisonParams;
import com.bishetyl.entity.Company;
import com.bishetyl.entity.JobSeeker;
import com.bishetyl.entity.ManageUser;
import com.bishetyl.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/5/8.
 */
public class ManageUserDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    private int rsCount = 0;
    public ManageUserDao(){

    }

    /**
     *通过 account 查找账户
     **/
    public ManageUser getManageUserBuAccount(String account){
        ManageUser manageUser = new ManageUser();
        JdbcUtil jdbcUtil = new JdbcUtil();
        try{
            this.con = jdbcUtil.getConnection();
            this.sql = "select * from manageuser where account=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1,account);
            this.rs = this.pst.executeQuery();
            if (this.rs.next()){
                manageUser.setId(this.rs.getInt("id"));
                manageUser.setName(this.rs.getString("name"));
                manageUser.setAccount(this.rs.getString("account"));
                manageUser.setPassWord(this.rs.getString("password"));
                manageUser.setPhoneNumber(this.rs.getString("phoneNumber"));
                manageUser.setEmail(this.rs.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return manageUser;
    }

    public ManageUser getManageUserById(int id){
        ManageUser manageUser = new ManageUser();
        JdbcUtil jdbcUtil = new JdbcUtil();
        try{
            this.con = jdbcUtil.getConnection();
            this.sql = "select * from manageuser where id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id);
            this.rs = this.pst.executeQuery();
            if (this.rs.next()){
                manageUser.setId(this.rs.getInt("id"));
                manageUser.setName(this.rs.getString("name"));
                manageUser.setAccount(this.rs.getString("account"));
                manageUser.setPassWord(this.rs.getString("password"));
                manageUser.setPhoneNumber(this.rs.getString("phoneNumber"));
                manageUser.setEmail(this.rs.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return manageUser;
    }

    //修改用户名
    public Boolean updateAccount(ManageUser manageUser){
        int count=0;
        JdbcUtil jdbcUtil = new JdbcUtil();
        try{
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE  manageuser set name=? WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1,manageUser.getName());
            this.pst.setInt(2, manageUser.getId());
            count = this.pst.executeUpdate();
        }catch (Exception e){
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

    //修改密码
    public Boolean updatePassword(ChangePassWordParams changePassWordParams){
        int count=0;
        JdbcUtil jdbcUtil = new JdbcUtil();
        try{
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE  manageuser set password=? WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, changePassWordParams.getNewPassword());
            this.pst.setInt(2, changePassWordParams.getManageUserId());
            count = this.pst.executeUpdate();
        }catch (Exception e){
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
