package com.bishetyl.dao;

import com.bishetyl.entity.DeliveryResume;
import com.bishetyl.entity.Resume;
import com.bishetyl.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public Integer  addResume(Resume resume){
        JdbcUtil jdbcUtil = new JdbcUtil();
        Resume resumeRet = new Resume();
        int rowID=0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "INSERT into resume(name,sex,birthDate,phoneNumber,email,address,annualIncome,jobSeekerId) \n" +
                    "VALUES (?,?,?,?,?,?,?,?)";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, resume.getName());
            this.pst.setString(2, resume.getSex());
            this.pst.setString(3, resume.getBirthDate());
            this.pst.setString(4, resume.getPhoneNumber());
            this.pst.setString(5, resume.getEmail());
            this.pst.setString(6, resume.getAddress());
            this.pst.setString(7, resume.getAnnualIncome());
            this.pst.setInt(8, resume.getJobSeekerId());
            int co = this.pst.executeUpdate();
            if(co>0){
                //取得插入行的id  新建简历的id
                String idSql = "SELECT LAST_INSERT_ID()";
                this.pst = this.con.prepareStatement(idSql);
                this.rs = this.pst.executeQuery();
                while (this.rs.next()){
                    rowID = this.rs.getInt("LAST_INSERT_ID()");
                }
            }
            //取得插入行的数据
//            resumeRet = this.searchResume(rowID);
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
       return rowID;
    }
    //新增简历中的年收入
    public Boolean  updateResumeIncome(Resume resume){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        Resume resumeRet = new Resume();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE resume SET annualIncome=? WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, resume.getAnnualIncome());
            this.pst.setInt(2, resume.getId());
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count > 0){
            return true;
        }else{
            return false;
        }
    }
    //删除
    public Boolean deleteResume(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM resume where id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id);
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
                    "email=?,address=? WHERE id =?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, resume.getName());
            this.pst.setString(2,resume.getSex());
            this.pst.setString(3,resume.getBirthDate());
            this.pst.setString(4,resume.getPhoneNumber());
            this.pst.setString(5,resume.getEmail());
            this.pst.setString(6, resume.getAddress());
            this.pst.setInt(7, resume.getId());
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

    //修改简历公开程度
    public Boolean updatePublic(Resume resume){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE resume set isPublic = ? WHERE id =?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, resume.getIsPublic());
            this.pst.setInt(2, resume.getId());
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

    //修改快速投递
    public Boolean updateDilivery(Resume resume) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE resume set dilivery=? where id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, resume.getDilivery());
            this.pst.setInt(2, resume.getId());
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

    //查找该求职名下所有简历
    public List<Resume> searchResumeByJobSeekerId(int jobSeekerId){
        List<Resume> resumeList =  new ArrayList<Resume>();
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM resume where jobSeekerId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,jobSeekerId);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                Resume resume = new Resume();
                resume.setId(this.rs.getInt("id"));
                resume.setName(this.rs.getString("name"));
                resume.setSex(this.rs.getString("sex"));
                resume.setBirthDate(this.rs.getString("birthDate"));
                resume.setPhoneNumber(this.rs.getString("phoneNumber"));
                resume.setEmail(this.rs.getString("email"));
                resume.setAddress(this.rs.getString("address"));
                resume.setAnnualIncome(this.rs.getString("annualIncome"));
                resume.setDilivery(this.rs.getString("dilivery"));
                resume.setIsPublic(this.rs.getInt("isPublic"));
                resume.setBrowsingTimes(this.rs.getInt("browsingTimes"));
                resume.setJobSeekerId(this.rs.getInt("jobSeekerId"));
                resumeList.add(resume);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return resumeList;
    }

    public Resume getSpecialResume(int jobSeekerId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        Resume resume = null;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM resume where jobSeekerId=? AND dilivery = 'true'";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,jobSeekerId);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                resume = new Resume();
                resume.setId(this.rs.getInt("id"));
                resume.setName(this.rs.getString("name"));
                resume.setSex(this.rs.getString("sex"));
                resume.setBirthDate(this.rs.getString("birthDate"));
                resume.setPhoneNumber(this.rs.getString("phoneNumber"));
                resume.setEmail(this.rs.getString("email"));
                resume.setAddress(this.rs.getString("address"));
                resume.setAnnualIncome(this.rs.getString("annualIncome"));
                resume.setDilivery(this.rs.getString("dilivery"));
                resume.setIsPublic(this.rs.getInt("isPublic"));
                resume.setBrowsingTimes(this.rs.getInt("browsingTimes"));
                resume.setJobSeekerId(this.rs.getInt("jobSeekerId"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return resume;
    }


}
