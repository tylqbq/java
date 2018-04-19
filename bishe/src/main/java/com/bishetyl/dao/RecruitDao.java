package com.bishetyl.dao;

import com.bishetyl.dto.RecruitResult;
import com.bishetyl.dto.RecruitSearchByCoIDParams;
import com.bishetyl.dto.RecruitSearchParams;
import com.bishetyl.entity.Recruit;
import com.bishetyl.util.JdbcUtil;
import com.bishetyl.util.PageParams;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/17.
 */
public class RecruitDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public RecruitDao(){

    }

    public RecruitResult getRecruit(RecruitSearchParams recruitSearchParams){
        RecruitResult recruitResult = new RecruitResult();
        List <Recruit> recruitList = new ArrayList<Recruit>();
        JdbcUtil jdbcUtil = new JdbcUtil();
        List<Object> paramsList = new ArrayList<Object>();
        try{
            this.con = jdbcUtil.getConnection();
            StringBuilder  sql = new StringBuilder("select * from recruit,company where 1=1 ");
            StringBuilder  countSql = new StringBuilder("select count(*) from recruit,company where 1=1 ");
            //关键字
            String keyWord = recruitSearchParams.getKeyWord();
            if (keyWord != null && !keyWord.trim().isEmpty()){
                sql.append(" and (recruit.positionName like ? or recruit.workPlace like ?)");
                countSql.append(" and (recruit.positionName like ? or recruit.workPlace like ?)");
                paramsList.add("%" + keyWord + "%");
                paramsList.add("%" + keyWord + "%");
            }
            //地址
            String address = recruitSearchParams.getAddress();
            if (address != null && !address.trim().isEmpty()){
                sql.append(" and recruit.workPlace like ? ");
                countSql.append(" and recruit.workPlace like ? ");
                paramsList.add("%" + address + "%");
            }
            //行业
//            String industry = recruitSearchParams.getIndustry();
//            if (industry != null && !industry.trim().isEmpty()){
//                sql.append(" and workPlace like ? ");
//                countSql.append(" and workPlace like ? ");
//                paramsList.add("%" + address + "%");
//            }
            //职能
//            String function = recruitSearchParams.getFunction();
//            if (function != null && !function.trim().isEmpty()){
//                sql.append(" and workPlace like ? ");
//                countSql.append(" and workPlace like ? ");
//                paramsList.add("%" + address + "%");
//            }
            //发布时间
            String publishTime = recruitSearchParams.getPublishTime();
            if (publishTime != null && !publishTime.trim().isEmpty() && !publishTime.equals("所有")){
                sql.append(" and publishDate >=  CURDATE()-? ");
                countSql.append(" and publishDate >=  CURDATE()-? ");
                paramsList.add(publishTime);
            }
            //薪资范围
            String salaryRang = recruitSearchParams.getSalaryRang();
            if (salaryRang != null && !salaryRang.trim().isEmpty() && !salaryRang.equals("所有")){
                sql.append(" and salaryRang = ? ");
                countSql.append(" and salaryRang = ? ");
                paramsList.add(salaryRang);
            }

            //公司类型
            String companyType = recruitSearchParams.getCompanyType();
            if (companyType != null && !companyType.trim().isEmpty() && !companyType.equals("所有")){
                sql.append(" and company.companyType = ? ");
                countSql.append(" and company.companyType = ? ");
                paramsList.add(companyType);
            }
            //工作年限
            String workTime = recruitSearchParams.getWorkTime();
            if (workTime != null && !workTime.trim().isEmpty() && !workTime.equals("所有")){
                sql.append(" and recruit.workTime = ? ");
                countSql.append(" and recruit.workTime = ? ");
                paramsList.add(workTime);
            }
            //学历
            String education = recruitSearchParams.getEducation();
            if (education != null && !education.trim().isEmpty() && !education.equals("所有")){
                sql.append(" and recruit.education = ? ");
                countSql.append(" and recruit.education = ? ");
                paramsList.add(education);
            }
            //公司规模
            String staffNumber = recruitSearchParams.getStaffNumber();
            if (staffNumber != null && !staffNumber.trim().isEmpty() && !staffNumber.equals("所有")){
                sql.append(" and company.staffNumber = ? ");
                countSql.append(" and recruit.education = ? ");
                paramsList.add(staffNumber);
            }

            //工作类型
            String workType = recruitSearchParams.getWorkType();
            if (workType != null && !workType.trim().isEmpty() && !workType.equals("所有")){
                sql.append(" and recruit.workType = ? ");
                countSql.append(" and recruit.workType = ? ");
                paramsList.add(workType);
            }

            //分页查询  每次指定查询多少条数据
            int pageNumber = recruitSearchParams.getPageNumber();
            int pageSize = recruitSearchParams.getPageSize();
            int startIndex = (pageNumber-1)*pageSize;
            countSql.append("and recruit.companyId = company.id ");
            sql.append("and recruit.companyId = company.id ");
            sql.append("limit "+startIndex+","+pageSize+"");

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
            while(this.rs.next()) {
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
                recruit.setCompanyName(this.rs.getString("companyName"));
                recruitList.add(recruit);
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
            pageParams.setPageNumber(recruitSearchParams.getPageNumber());//当前页码
            pageParams.setPageSize(recruitSearchParams.getPageSize());//每页显示条数

            recruitResult.setRecruitList(recruitList); //设置数据
            recruitResult.setPageParams(pageParams);//设置分页参数

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return recruitResult;
    }

    public Recruit getRecruitById(int recruitId){
        Recruit recruit = new Recruit();
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            this.con = jdbcUtil.getConnection();
            String sql = "select * from recruit,company where recruit.id = ? and recruit.companyId = company.id";
            this.pst = this.con.prepareStatement(sql);
            this.pst.setInt(1, recruitId);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                recruit.setId(this.rs.getInt("id"));
                recruit.setPositionName(this.rs.getString("positionName"));
                recruit.setWorkPlace(this.rs.getString("workPlace"));
                recruit.setSalaryRange(this.rs.getString("salaryRange"));
                recruit.setRecruitsNumber(this.rs.getString("recruitsNumber"));
                recruit.setPositionInfo(this.rs.getString("positionInfo"));
                recruit.setContactWay(this.rs.getString("contactWay"));
                recruit.setWorkTime(this.rs.getString("workTime"));
                recruit.setEducation(this.rs.getString("education"));
                recruit.setWorkType(this.rs.getString("workType"));
                recruit.setPublishDate(this.rs.getString("publishDate"));
                recruit.setCompanyId(this.rs.getInt("companyId"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return recruit;
    }

    public RecruitResult getRecruitByCompanyId(RecruitSearchByCoIDParams params){
        List<Recruit> recruitList = new ArrayList<Recruit>();
        JdbcUtil jdbcUtil = new JdbcUtil();
        PageParams pageParamsReturn = new PageParams();
        RecruitResult recruitResult = new RecruitResult();
        int companyId = params.getCompanyId();
        //分页查询  每次指定查询多少条数据
        int pageNumber = params.getPageNumber();
        int pageSize = params.getPageSize();
        int startIndex = (pageNumber-1)*pageSize;

        try {
            this.con = jdbcUtil.getConnection();
            String countSql = "select * from recruit where companyId = ?";
            this.pst = this.con.prepareStatement(countSql.toString());
            this.pst.setInt(1, companyId);
            this.rs = this.pst.executeQuery();
            int rowCount = 0;
            while (this.rs.next()){
                rowCount = this.rs.getInt(1);
            }

            StringBuilder sql = new StringBuilder("select * from recruit where companyId = ?");

            sql.append(" limit "+startIndex+","+pageSize);
            this.pst = this.con.prepareStatement(sql.toString());
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
                recruit.setWorkType(this.rs.getString("workType"));
                recruit.setPublishDate(this.rs.getString("publishDate"));
                recruit.setCompanyId(this.rs.getInt("companyId"));
                recruitList.add(recruit);
            }

            pageParamsReturn.setTotal(rowCount);
            pageParamsReturn.setPageSize(params.getPageSize());
            pageParamsReturn.setPageNumber(params.getPageNumber());
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(this.con);
        }
        recruitResult.setRecruitList(recruitList);
        recruitResult.setPageParams(pageParamsReturn);
        return recruitResult;
    }
}
