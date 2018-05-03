package com.bishetyl.dao;

import com.bishetyl.dto.ResumeListResult;
import com.bishetyl.dto.ResumeSearchParam;
import com.bishetyl.entity.JobIntention;
import com.bishetyl.entity.Resume;
import com.bishetyl.util.JdbcUtil;
import com.bishetyl.util.PageParams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/22.
 */
public class JobIntentionDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    public JobIntentionDao(){

    }
    //增加
    public void  addJobIntention(JobIntention jobIntention,int resumeId){
        JdbcUtil jdbcUtil = new JdbcUtil();
//        JobIntention jobIntentionRet = new JobIntention();
        int rowID=0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "INSERT into jobintention(salary,workPlace,function,position,industry,industryLabel,introduction,workType,resumeId)\n" +
                    "VALUES(?,?,?,?,?,?,?,?,?)";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, jobIntention.getSalary());
            this.pst.setString(2, jobIntention.getWorkPlace());
            this.pst.setString(3, jobIntention.getFunction());
            this.pst.setString(4, jobIntention.getPosition());
            this.pst.setString(5, jobIntention.getIndustry());
            this.pst.setString(6, jobIntention.getIndustryLabel());
            this.pst.setString(7, jobIntention.getIntroduction());
            this.pst.setString(8, jobIntention.getWorkType());
            this.pst.setInt(9, resumeId);
            int count = this.pst.executeUpdate();
//            if(count>0){
//                //取得插入行的id  新建简历的id
//                String idSql = "SELECT LAST_INSERT_ID()";
//                this.pst = this.con.prepareStatement(idSql);
//                this.rs = this.pst.executeQuery();
//                while (this.rs.next()){
//                    rowID = this.rs.getInt("LAST_INSERT_ID()");
//                }
//            }
            //取得插入行数据
//            jobIntentionRet = this.searchJobIntentionByid(rowID);
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
    }
    //删除
    public Boolean deleteJobIntention(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM jobintention where id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,id);
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
    //删除resumeId下所有jobintention
    public Boolean deleteJobIntentionByResumeId(int resumeId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "DELETE FROM jobintention where resumeId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,resumeId);
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
    public Boolean updateJobIntention(JobIntention jobIntention){
        JdbcUtil jdbcUtil = new JdbcUtil();
        int count = 0;
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "UPDATE jobintention set salary=?,workPlace=?,function=?,position=?,industry=?,industryLabel=?,introduction=?,workType=? \n" +
                    "WHERE id=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, jobIntention.getSalary());
            this.pst.setString(2,jobIntention.getWorkPlace());
            this.pst.setString(3,jobIntention.getFunction());
            this.pst.setString(4,jobIntention.getPosition());
            this.pst.setString(5,jobIntention.getIndustryLabel());
            this.pst.setString(6,jobIntention.getIndustryLabel());
            this.pst.setString(7,jobIntention.getIntroduction());
            this.pst.setString(8, jobIntention.getWorkType());
            this.pst.setInt(9, jobIntention.getId());
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
    //查找ByID
    public JobIntention searchJobIntentionByid(int id){
        JdbcUtil jdbcUtil = new JdbcUtil();
        JobIntention jobIntention = new JobIntention();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM jobIntention where resumeId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,id);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                jobIntention.setId(this.rs.getInt("id"));
                jobIntention.setSalary(this.rs.getString("salary"));
                jobIntention.setWorkPlace(this.rs.getString("workPlace"));
                jobIntention.setFunction(this.rs.getString("function"));
                jobIntention.setPosition(this.rs.getString("position"));
                jobIntention.setIndustry(this.rs.getString("industry"));
                jobIntention.setIndustryLabel(this.rs.getString("industryLabel"));
                jobIntention.setIntroduction(this.rs.getString("introduction"));
                jobIntention.setWorkType(this.rs.getString("workType"));
                jobIntention.setResumeId(this.rs.getInt("resumeId"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return jobIntention;
    }

    //查找ByResumeID
    public List<JobIntention> searchJobIntentionByResumeId(int resumeId){
        JdbcUtil jdbcUtil = new JdbcUtil();
        List<JobIntention> jobIntentionList = new ArrayList<JobIntention>();
        try {
            this.con = jdbcUtil.getConnection();
            this.sql = "select * FROM jobIntention where resumeId=?";
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1,resumeId);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()){
                JobIntention jobIntention = new JobIntention();
                jobIntention.setId(this.rs.getInt("id"));
                jobIntention.setSalary(this.rs.getString("salary"));
                jobIntention.setWorkPlace(this.rs.getString("workPlace"));
                jobIntention.setFunction(this.rs.getString("function"));
                jobIntention.setPosition(this.rs.getString("position"));
                jobIntention.setIndustry(this.rs.getString("industry"));
                jobIntention.setIndustryLabel(this.rs.getString("industryLabel"));
                jobIntention.setIntroduction(this.rs.getString("introduction"));
                jobIntention.setWorkType(this.rs.getString("workType"));
                jobIntention.setResumeId(this.rs.getInt("resumeId"));
                jobIntentionList.add(jobIntention);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return jobIntentionList;
    }



    //查找ByResumeID
    public ResumeListResult searchResume(ResumeSearchParam resumeSearchParam){
        JdbcUtil jdbcUtil = new JdbcUtil();
        ResumeListResult resumeListResult = new ResumeListResult();
        List<Resume> resumeList = new ArrayList<Resume>();
        List<Object> paramsList = new ArrayList<Object>();
        try {
            this.con = jdbcUtil.getConnection();
            StringBuilder sql = new StringBuilder("select * FROM resume,educationalexperience," +
                    "workexperience,jobintention where 1=1");
            StringBuilder  countSql = new StringBuilder("select count(*) FROM resume,educationalexperience," +
                    "workexperience,jobintention where 1=1");
            //关键字
            String keyWord = resumeSearchParam.getKeyWord();
            if (keyWord != null && !keyWord.trim().isEmpty()){
                sql.append(" and (workexperience.position like ?  or resume.address like ?)");
                countSql.append(" and (workexperience.position like ?  or resume.address like ?)");
                paramsList.add("%" + keyWord + "%");
                paramsList.add("%" + keyWord + "%");
            }
            //地址
            String address = resumeSearchParam.getAddress();
            if (address != null && !address.trim().isEmpty()){
                sql.append(" and resume.address like ? ");
                countSql.append(" and resume.address like ? ");
                paramsList.add("%" + address + "%");
            }
            //薪资范围
            String salaryRang = resumeSearchParam.getSalaryRang();
            if (salaryRang != null && !salaryRang.trim().isEmpty() && !salaryRang.equals("所有")){
                sql.append(" and jobintention.salary = ? ");
                countSql.append(" and jobintention.salary = ? ");
                paramsList.add(salaryRang);
            }

            //工作年限
            String workTime = resumeSearchParam.getWorkTime();

            if (workTime != null && !workTime.trim().isEmpty() && !workTime.equals("所有")){
                int min =  Integer.parseInt(workTime.split("-")[0]);
                int max = Integer.parseInt(workTime.split("-")[1].split("年")[0]);

                sql.append(" and (UNIX_TIMESTAMP(workexperience.endDate)-UNIX_TIMESTAMP(workexperience.startDate))/(60*60*24*365) > ?  and (UNIX_TIMESTAMP(workexperience.endDate)-UNIX_TIMESTAMP(workexperience.startDate))/(60*60*24*365) < ?");
                countSql.append(" and (UNIX_TIMESTAMP(workexperience.endDate)-UNIX_TIMESTAMP(workexperience.startDate))/(60*60*24*365) > ?  and (UNIX_TIMESTAMP(workexperience.endDate)-UNIX_TIMESTAMP(workexperience.startDate))/(60*60*24*365) < ?");
                paramsList.add(min);
                paramsList.add(max);
            }

            //学历
            String education = resumeSearchParam.getEducation();
            if (education != null && !education.trim().isEmpty() && !education.equals("所有")){
                sql.append(" and educationalexperience.education = ? ");
                countSql.append(" and educationalexperience.education = ? ");
                paramsList.add(education);
            }

            //工作类型
            String workType = resumeSearchParam.getWorkType();
            if (workType != null && !workType.trim().isEmpty() && !workType.equals("所有")){
                sql.append(" and jobintention.workType = ? ");
                countSql.append(" and jobintention.workType = ? ");
                paramsList.add(workType);
            }

            //分页查询  每次指定查询多少条数据
            int pageNumber = resumeSearchParam.getPageNumber();
            int pageSize = resumeSearchParam.getPageSize();
            int startIndex = (pageNumber-1)*pageSize;
            countSql.append(" and educationalexperience.resumeId = resume.id " +
                    " and workexperience.resumeId = resume.id  and jobintention.resumeId = resume.id ");
//            countSql.append(" and educationalexperience.resumeId = resume.id ");

            sql.append(" and educationalexperience.resumeId = resume.id " +
                    " and workexperience.resumeId = resume.id  and jobintention.resumeId = resume.id ");
            sql.append(" limit " + startIndex + "," + pageSize + "");

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
                resumeList.add(resume);
            }

            //获取记录总数
            this.pst = this.con.prepareStatement(countSql.toString());
            for (int j=0;j<paramsList.size();j++){
                Object param = paramsList.get(j);
                if (param instanceof Integer){
                    this.pst.setInt(j+1, Integer.parseInt(paramsList.get(j).toString()));
                }else if (param instanceof String){
                    this.pst.setString(j+1, paramsList.get(j).toString());
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
            pageParams.setPageNumber(resumeSearchParam.getPageNumber());//当前页码
            pageParams.setPageSize(resumeSearchParam.getPageSize());//每页显示条数


            resumeListResult.setPageParams(pageParams);
            resumeListResult.setResumeList(resumeList);

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            jdbcUtil.releaseConnection(this.con);
        }
        return resumeListResult;
    }
}

