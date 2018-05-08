package com.bishetyl.dao;

import com.bishetyl.dto.CompanyListRet;
import com.bishetyl.dto.CompanySearchParam;
import com.bishetyl.entity.*;
import com.bishetyl.util.JdbcUtil;
import com.bishetyl.util.PageParams;

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

    public Boolean updateCompanyInfo(Company company){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql ="UPDATE company SET companyName=?,companyType=?,staffNumber=?,companyInfo=?,\n" +
                    "companyBusiness=?,companyAddress=? WHERE id=?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, company.getCompanyName());
            this.pst.setString(2, company.getCompanyType());
            this.pst.setString(3, company.getStaffNumber());
            this.pst.setString(4, company.getCompanyInfo());
            this.pst.setString(5, company.getCompanyBusiness());
            this.pst.setString(6, company.getCompanyAddress());
            this.pst.setInt(7, company.getId());
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if (count > 0){
            return true;
        }else{
            return false;
        }
    }

    public List<DeliveryResume> getDeliveryResume(Company company){
        List<DeliveryResume> deliveryResumeList = new ArrayList<DeliveryResume>();
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            this.con = jdbcUtil.getConnection();
            String sql = "select * from deliveryresume where companyId = ? AND isBrowse=0";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setInt(1, company.getId());
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                DeliveryResume deliveryResume = new DeliveryResume();
                deliveryResume.setId(this.rs.getInt("id"));
                deliveryResume.setJobSeekerId(this.rs.getInt("jobSeekerId"));
                deliveryResume.setResumeId(this.rs.getInt("resumeId"));
                deliveryResume.setRecruitId(this.rs.getInt("recruitId"));
                deliveryResume.setCompanyId(this.rs.getInt("companyId"));
                deliveryResume.setDeliveryTime(this.rs.getString("deliveryTime"));
                deliveryResumeList.add(deliveryResume);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return deliveryResumeList;
    }

    public List<Company> getCompanyRecruitRandom(String companyAddress){
        List<Company> companyList = new ArrayList<Company>();
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            this.con = jdbcUtil.getConnection();
            String sql = "SELECT * FROM company WHERE id >= ((SELECT MAX(id) FROM company)-(SELECT MIN(id) FROM company)) * RAND() + (SELECT MIN(id) FROM company) \n" +
                    "and companyAddress like ?  LIMIT 5";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, "%" + companyAddress + "%");
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                Company company = new Company();
                company.setId(this.rs.getInt("id"));
                company.setCompanyName(this.rs.getString("companyName"));
                companyList.add(company);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return companyList;
    }

    public CompanyListRet getCompanyListByParam(CompanySearchParam companySearchParam){
        CompanyListRet companyListRet = new CompanyListRet();
        List<Company> companyList = new ArrayList<Company>();
        ManageUser manageUser = new ManageUser();
        JdbcUtil jdbcUtil = new JdbcUtil();
        List<Object> paramsList = new ArrayList<Object>();
        try{
            this.con = jdbcUtil.getConnection();
            StringBuilder  sql = new StringBuilder("select * from company where 1=1 and examinePass=0 ");
            StringBuilder  countSql = new StringBuilder("select count(*) from company where 1=1 and examinePass=0");
            //公司名称
            String companyName = companySearchParam.getCompany().getCompanyName();
            if (companyName != null && !companyName.trim().isEmpty()){
                sql.append(" and companyName like ?");
                countSql.append(" and companyName like ?");
                paramsList.add("%"+companyName+"%");
            }

            //公司类型
            String companyType = companySearchParam.getCompany().getCompanyType();
            if (companyType != null && !companyType.trim().isEmpty() && !companyType.equals("所有")){
                sql.append(" and companyType = ?");
                countSql.append(" and companyType = ?");
                paramsList.add(companyType);
            }

            //分页查询  每次指定查询多少条数据
            int pageNumber = companySearchParam.getPageParams().getPageNumber();
            int pageSize = companySearchParam.getPageParams().getPageSize();
            int startIndex = (pageNumber-1)*pageSize;
            sql.append(" limit "+startIndex+","+pageSize+"");

            this.pst = this.con.prepareStatement(sql.toString());
            for (int i=0;i<paramsList.size();i++){
                Object param = paramsList.get(i);
                if (param instanceof Integer){
                    this.pst.setInt(i+1, Integer.parseInt(paramsList.get(i).toString()));
                }else if (param instanceof String){
                    this.pst.setString(i+1, paramsList.get(i).toString());
                }
            }
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                Company company = new Company();
                company.setId(this.rs.getInt("id"));
                company.setCompanyName(this.rs.getString("companyName"));
                company.setCompanyType(this.rs.getString("companyType"));
                company.setStaffNumber(this.rs.getString("staffNumber"));
                company.setCompanyInfo(this.rs.getString("companyInfo"));
                company.setCompanyBusiness(this.rs.getString("companyBusiness"));
                company.setCompanyAddress(this.rs.getString("companyAddress"));
                company.setBusinessLicense(this.rs.getString("businessLicense"));
                company.setExaminePass(this.rs.getInt("examinePass"));
                companyList.add(company);
            }

            //获取记录总数
            this.pst = this.con.prepareStatement(countSql.toString());
            for (int i=0;i<paramsList.size();i++){
                Object param = paramsList.get(i);
                if (param instanceof Integer){
                    this.pst.setInt(i+1, Integer.parseInt(paramsList.get(i).toString()));
                }else if (param instanceof String){
                    this.pst.setString(i+1, paramsList.get(i).toString());
                }
            }
            this.rs = this.pst.executeQuery();
            int rowCount = 0;
            if (this.rs.next()){
                rowCount = this.rs.getInt(1);
            }
            //分页参数
            PageParams pageParams = new PageParams();
            pageParams.setTotal(rowCount);//总数
            pageParams.setPageNumber(companySearchParam.getPageParams().getPageNumber());//当前页码
            pageParams.setPageSize(companySearchParam.getPageParams().getPageSize());//每页显示条数

            companyListRet.setCompanyList(companyList); //设置数据
            companyListRet.setPageParams(pageParams);//设置分页参数

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return companyListRet;
    }

    public Boolean adoptCompany(int companyId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql = "UPDATE company set examinePass = 1 WHERE  id=?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setInt(1, companyId);
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if(count>0){
            return true;
        }else{
            return false;
        }
    }
    //退回
    public Boolean sendBackCompany(int companyId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            String sql = "UPDATE company set examinePass = 2 WHERE  id=?";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setInt(1, companyId);
            count = this.pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

}
