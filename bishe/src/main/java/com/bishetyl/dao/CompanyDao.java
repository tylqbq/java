package com.bishetyl.dao;

import com.bishetyl.entity.Company;
import com.bishetyl.entity.CompanyUser;
import com.bishetyl.entity.Recruit;
import com.bishetyl.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/19.
 */
public class CompanyDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public CompanyDao(){

    }



    public int registerCompany(Company company){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        int rowID = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="INSERT INTO company(companyName,companyType,staffNumber,companyInfo" +
                    ",companyBusiness,companyAddress,businessLicense)VALUES(?,?,?,?,?,?,?)";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, company.getCompanyName());
            this.pst.setString(2, company.getCompanyType());
            this.pst.setString(3, company.getStaffNumber());
            this.pst.setString(4, company.getCompanyInfo());
            this.pst.setString(5, company.getCompanyBusiness());
            this.pst.setString(6, company.getCompanyAddress());
            this.pst.setString(7, company.getBusinessLicense());
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

    public Company getCompanyInfoById(int companyId){
        Company company = new Company();
        List<Recruit> recruitList = new ArrayList<Recruit>();
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            this.con = jdbcUtil.getConnection();
            String sql = "select * from company where company.id = ?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setInt(1, companyId);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                company.setId(this.rs.getInt("id"));
                company.setCompanyName(this.rs.getString("companyName"));
                company.setCompanyType(this.rs.getString("companyType"));
                company.setStaffNumber(this.rs.getString("staffNumber"));
                company.setCompanyInfo(this.rs.getString("companyInfo"));
                company.setCompanyBusiness(this.rs.getString("companyBusiness"));
                company.setCompanyAddress(this.rs.getString("companyAddress"));
            }
            String recruitSql = "select * from recruit where companyId = ?";
            this.pst = this.con.prepareStatement(recruitSql);
            this.pst.setInt(1, companyId);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                Recruit recruit = new Recruit();
                recruit.setId(this.rs.getInt("id"));
                recruit.setPositionName(this.rs.getString("positionName"));
                recruit.setWorkPlace(this.rs.getString("workPlace"));
                recruit.setSalaryRange(this.rs.getString("salaryRange"));
                recruit.setRecruitsNumber(this.rs.getString("recruitsNumber"));
                recruit.setPositionInfo(this.rs.getString("positionInfo"));
                recruit.setContactWay(this.rs.getString("contactWay"));
                recruit.setWorkTime(this.rs.getString("workTime"));
                recruit.setEducation(this.rs.getString("education"));
                recruit.setWorkType(this.rs.getString("positionName"));
                recruit.setPublishDate(this.rs.getString("publishDate"));
                recruit.setCompanyId(this.rs.getInt("companyId"));
                recruitList.add(recruit);
            }
            company.setRecruits(recruitList);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return company;
    }
}
