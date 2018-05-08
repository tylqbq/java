package com.bishetyl.dao;

import com.bishetyl.entity.Notice;
import com.bishetyl.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/5/8.
 */
public class NoticeDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public NoticeDao(){

    }

    public  Boolean insertIntoNotice(Notice notice){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count=0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "INSERT into notice(title,author,content,publishTime) VALUES (?,?,?,?)";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, notice.getTitle());
            this.pst.setString(2, notice.getAuthor());
            this.pst.setString(3, notice.getContent());
            this.pst.setString(4, notice.getPublishTime());
            count = this.pst.executeUpdate();

        }catch (SQLException e){
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
