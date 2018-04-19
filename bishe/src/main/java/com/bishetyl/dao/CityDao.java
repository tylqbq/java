package com.bishetyl.dao;

import com.bishetyl.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/18.
 */
public class CityDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public CityDao(){

    }
    public List<String> getCityByPyCode(String pyCode){
        List<String> cityList = new ArrayList<String>();
        JdbcUtil jdbcUtil = new JdbcUtil();
        try{
            this.con = jdbcUtil.getConnection();
            this.sql = "select * from city where pyCode = ?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, pyCode);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                String cityName = this.rs.getString("cityName");
                cityList.add(cityName);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return cityList;
    }
}
