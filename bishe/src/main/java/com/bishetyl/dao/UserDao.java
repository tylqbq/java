package com.bishetyl.dao;
import com.bishetyl.entity.User;
import com.bishetyl.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Abcde on 2017/12/12.
 */
public class UserDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public UserDao(){

    }
    public User findUserByPhoneNumber(String phoneNumber) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        User user=null;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * from jobSeeker where phoneNumber = ?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, phoneNumber);
            this.rs = this.pst.executeQuery();
            if(this.rs.next()){   //或者while(rs.next())
                user= new User();
                user.setUserName(this.rs.getString("userName"));
                user.setUserPsd(this.rs.getString("userPassword"));
                user.setAge(this.rs.getInt("age"));
                user.setSex(this.rs.getString("sex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return  user;
    }
/**
 *账户注册
 */
    public int  registerAccount(User user){
        int count=0;
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "insert into  jobSeeker(phoneNumber,password)values(?,?)";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, user.getTellNumber());
            this.pst.setString(2, user.getAddress());
            count = this.pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }

        return count;
    }
/**
 *修改密码
 */
    public int  modifyUserById(User user) {
        int count=0;
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE user set user.userPassword = ? WHERE user.id = ?;";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, user.getUserName());
            this.pst.setString(2, user.getTellNumber());
            count = this.pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return count;
    }
}
