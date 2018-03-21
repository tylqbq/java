package com.bishetyl.util;

import java.sql.*;
import java.util.List;

/**
 * Created by Abcde on 2017/12/11.
 */
public class JdbcUtil {
    private  static  String  url="jdbc:mysql://localhost:3306/yulongrecruit";
    private  static  String driver = "com.mysql.jdbc.Driver";
    private  static  String JDBC_ACCOUNT="root";
    private  static  String JDBC_PASSWORD="mysql";
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet resultSet;
    public JdbcUtil() {
        // TODO Auto-generated constructor stub

    }
    /**
     * 数据库连接
     */
    public Connection  getConnection(){
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url, JDBC_ACCOUNT, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * 数据库 增删改查
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public boolean update(String sql, List<Object> params)throws SQLException{
        boolean flag = false;
        int result = -1;
        try {
            pstmt = connection.prepareStatement(sql);
            int index = 1;
            if (params != null && !params.isEmpty()) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(index++, params.get(i));
                }
            }
            result = pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        flag = result > 0 ? true : false;
        return flag;
    }
    /**
     * 数据库释放
     */
    public static void releaseConnection(Connection connection){
        try {
            if(connection != null){
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
