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
 * Created by 汤玉龙 on 2018/4/25.
 */
public class DeliveruResumeDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public DeliveruResumeDao(){

    }
    //判断是否已投递
    public Boolean isExistDiliveryResume(DeliveryResume deliveryResume){
        JdbcUtil jdbcUtil = new JdbcUtil();
        Resume resume = null;
        int count=0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "SELECT count(*) from deliveryresume WHERE jobSeekerId=? AND recruitId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,deliveryResume.getJobSeekerId());
            this.pst.setInt(2,deliveryResume.getRecruitId());
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                count = this.rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if(count > 0){
            return true;
        }else {
            return false;
        }
    }

    //投递简历
    public Boolean diliveryResume(DeliveryResume deliveryResume){
        JdbcUtil jdbcUtil = new JdbcUtil();
        Resume resume = null;
        int count=0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "INSERT into deliveryresume(jobSeekerId,resumeId,recruitId,deliveryTime) \n" +
                    "VALUES (?,?,?,?)";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,deliveryResume.getJobSeekerId());
            this.pst.setInt(2,deliveryResume.getResumeId());
            this.pst.setInt(3,deliveryResume.getRecruitId());
            this.pst.setString(4, deliveryResume.getDeliveryTime());
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if(count > 0){
            return true;
        }else {
            return false;
        }
    }

    //查找投递简历By 求职者Id
    public List<DeliveryResume> searchDeliveryResumeByJobSeekerId(int jobSeekerId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        List<DeliveryResume> deliveryResumeList = new ArrayList<DeliveryResume>();
        int count=0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "SELECT * FROM  deliveryresume WHERE  jobSeekerId = ?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, jobSeekerId);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                DeliveryResume deliveryResume = new DeliveryResume();
                deliveryResume.setId(this.rs.getInt("id"));
                deliveryResume.setJobSeekerId(this.rs.getInt("jobSeekerId"));
                deliveryResume.setResumeId(this.rs.getInt("resumeId"));
                deliveryResume.setRecruitId(this.rs.getInt("recruitId"));
                deliveryResume.setDeliveryTime(this.rs.getString("deliveryTime"));
                deliveryResume.setIsBrowse(this.rs.getInt("isBrowse"));
                deliveryResumeList.add(deliveryResume);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return deliveryResumeList;
    }

    //删除投递简历
    public Boolean deleteDiliveryResume(DeliveryResume deliveryResume){
        JdbcUtil jdbcUtil = new JdbcUtil();
        Resume resume = null;
        int count=0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM deliveryresume WHERE id=? ";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,deliveryResume.getId());
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if(count > 0){
            return true;
        }else {
            return false;
        }
    }


}
