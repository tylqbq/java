package com.bishetyl.dao;

import com.bishetyl.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/4/19.
 */
public class CollectionRecruitDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;


    public Boolean insertCollectionRecruit(int recruitId , int jobSeekerId,String collectionTime){
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            this.con = jdbcUtil.getConnection();
            String sql = "INSERT INTO collectionrecruit (jobSeekerId,recruitId,collectionTime) VALUES (?,?,?) ";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setInt(1, recruitId);
            this.pst.setInt(2, jobSeekerId);
            this.pst.setString(3,collectionTime);
            int count = this.pst.executeUpdate();
            if(count >0 ){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return false;
    }

    public Boolean deleteCollectionRecruit(int recruitId , int jobSeekerId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql = "delete from collectionrecruit where jobSeekerId = ? AND  recruitId = ?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setInt(1, recruitId);
            this.pst.setInt(2, jobSeekerId);
            count = this.pst.executeUpdate();
//            while (this.rs.next()){
//                count = this.rs.getInt(1);
//            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if(count > 0 ){
            return true;
        }else{
            return false;
        }

    }

    public Boolean isExist(int recruitId , int jobSeekerId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql = "SELECT COUNT(*) FROM collectionrecruit WHERE jobSeekerId = ? AND  recruitId = ?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setInt(1, recruitId);
            this.pst.setInt(2, jobSeekerId);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                count = this.rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count > 0 ){
            return true;
        }else{
            return false;
        }

    }

}
