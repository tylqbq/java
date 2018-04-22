package com.bishetyl.dao;

import com.bishetyl.entity.Resume;
import com.bishetyl.util.JdbcUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.beans.binding.BooleanExpression;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 汤玉龙 on 2018/4/21.
 */
public class ResumeDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public ResumeDao(){

    }
    //新增简历
    public Resume  addResume(Resume resume){
        JdbcUtil jdbcUtil = new JdbcUtil();
        Resume resumeRet = new Resume();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "INSERT into resume(name,sex,birthDate,phoneNumber,email,address,annualIncome,isPublic) \n" +
                    "VALUES (?,?,?,?,?,?,?,?)";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, resume.getName());
            this.pst.setString(2, resume.getSex());
            this.pst.setString(3, resume.getBirthDate());
            this.pst.setString(4, resume.getPhoneNumber());
            this.pst.setString(5, resume.getEmail());
            this.pst.setString(6, resume.getAddress());
            this.pst.setString(7, resume.getAnnualIncome());
            this.pst.setInt(8, resume.getIsPublic());
            int co = this.pst.executeUpdate();

            //取得插入行的id  新建简历的id
            String idSql = "SELECT LAST_INSERT_ID()";
            this.pst = this.con.prepareStatement(idSql);
            this.rs = this.pst.executeQuery();
            int rowID=0;
            while (this.rs.next()){
                rowID = this.rs.getInt("LAST_INSERT_ID()");
            }
            //取得插入行的数据
            resumeRet = this.searchResume(rowID);

//            String searchSql = "SELECT * from resume where id=?";
//            this.pst = this.con.prepareStatement(searchSql);
//            this.pst.setInt(1, rowID);
//            this.rs = this.pst.executeQuery();
//            while (this.rs.next()){
//                resumeRet.setId(this.rs.getInt("id"));
//                resumeRet.setName(this.rs.getString("name"));
//                resumeRet.setSex(this.rs.getString("sex"));
//                resumeRet.setBirthDate(this.rs.getString("birthDate"));
//                resumeRet.setPhoneNumber(this.rs.getString("phoneNumber"));
//                resumeRet.setEmail(this.rs.getString("email"));
//                resumeRet.setAddress(this.rs.getString("address"));
//                resumeRet.setAnnualIncome(this.rs.getString("annualIncome"));
//                resumeRet.setIsPublic(this.rs.getInt("isPublic"));
//                resumeRet.setBrowsingTimes(this.rs.getInt("browsingTimes"));
//            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
       return resumeRet;
    }
    //新增简历中的年收入
    public Resume  addResumeIncome(Resume resume){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        Resume resumeRet = new Resume();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE resume SET annualIncome=?,id = (SELECT @update_id := id)" +
                    " WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, resume.getAnnualIncome());
            this.pst.setInt(2, resume.getId());
            count = this.pst.executeUpdate();

            //取得插入行的id  新建简历的id
            String idSql = "SELECT @update_id";
            this.pst = this.con.prepareStatement(idSql);
            this.rs = this.pst.executeQuery();
            int rowID=0;
            while (this.rs.next()){
                rowID = this.rs.getInt("@update_id");
            }
            //取得插入行的数据
            resumeRet = this.searchResume(rowID);


        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return resumeRet;
    }
    //删除
    public Boolean deleteResume(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM resume where id=?";
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
    public Boolean updateResume(Resume resume){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE resume set name=?,sex=?,birthDate=?,phoneNumber=?,\n" +
                    "email=?,address=?,annualIncome=?,isPublic=? WHERE id =?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, resume.getName());
            this.pst.setString(2,resume.getSex());
            this.pst.setString(3,resume.getBirthDate());
            this.pst.setString(4,resume.getPhoneNumber());
            this.pst.setString(5,resume.getEmail());
            this.pst.setString(6,resume.getAddress());
            this.pst.setString(7,resume.getAnnualIncome());
            this.pst.setInt(8, resume.getIsPublic());
            this.pst.setInt(9, resume.getId());
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
    //查找
    public Resume searchResume(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        Resume resume = new Resume();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM resume where id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,id);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                resume.setId(this.rs.getInt("id"));
                resume.setName(this.rs.getString("name"));
                resume.setSex(this.rs.getString("sex"));
                resume.setBirthDate(this.rs.getString("birthDate"));
                resume.setPhoneNumber(this.rs.getString("phoneNumber"));
                resume.setEmail(this.rs.getString("email"));
                resume.setAddress(this.rs.getString("address"));
                resume.setAnnualIncome(this.rs.getString("annualIncome"));
                resume.setIsPublic(this.rs.getInt("isPublic"));
                resume.setBrowsingTimes(this.rs.getInt("browsingTimes"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return resume;
    }
}
