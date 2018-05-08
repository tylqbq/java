package com.bishetyl.util;

import com.bishetyl.entity.Industry;
import com.bishetyl.entity.Recruit;

import java.util.List;

/**
 * Created by 汤玉龙 on 2018/5/8.
 */
public class SalaryUtil {

    public Double getAverage(String salary){
        String salaryNumber = salary.split("/")[0];
        String minSalary = salaryNumber.split("-")[0];
        String maxSalary = salaryNumber.split("-")[1];

        Double minSalaryNumber = Double.parseDouble(minSalary);
        Double maxSalaryNumber = Double.parseDouble(maxSalary.substring(0, maxSalary.length() - 1));

        String unit = salaryNumber.substring(salaryNumber.length()-1,salaryNumber.length());
        if (unit.equals("千")){
            minSalaryNumber = minSalaryNumber*1000;
            maxSalaryNumber = maxSalaryNumber*1000;
        }else if (unit.equals("万")){
            minSalaryNumber = minSalaryNumber*10000;
            maxSalaryNumber = maxSalaryNumber*10000;
        }

        Double averageSalary = (minSalaryNumber+maxSalaryNumber)/2;
        return  averageSalary;
    }

    public int getRecruitNumber(String recruitNumber){
        int peopleNumber =0;
        String number =  recruitNumber.substring(1, recruitNumber.length()-1);
        if (!number.equals("若干")){
            peopleNumber = Integer.parseInt(number);
        }
        return  peopleNumber;
    }

    public Industry analysis(List<Recruit> recruitList,String industryName){
        int recruitNumber=0;//招聘人数
        Double totalSalary = 0.0; //薪资总量
        Double averageSalary = 0.0;//平均薪资
        Double minSalary = this.getAverage(recruitList.get(0).getSalaryRange());//最低薪资
        Double maxSalary = this.getAverage(recruitList.get(0).getSalaryRange());//最高薪资

        for (int i=0;i<recruitList.size();i++){
            //计算招聘人数
            int peopleNumber = this.getRecruitNumber(recruitList.get(i).getRecruitsNumber());
            recruitNumber = recruitNumber+peopleNumber;
            //计算薪资相关
            Double curAverageSalary = this.getAverage(recruitList.get(i).getSalaryRange());
            totalSalary = totalSalary+curAverageSalary;
            if (minSalary > curAverageSalary){
                minSalary = curAverageSalary;
            }
            if (maxSalary < curAverageSalary){
                maxSalary = curAverageSalary;
            }
        }
        averageSalary = totalSalary/recruitList.size();

        Industry industry = new Industry();

        industry.setIndustryName(industryName);
        industry.setAverageSalary(averageSalary);
        industry.setMinSalary(minSalary);
        industry.setMaxSalary(maxSalary);
        industry.setRecruitNumber(recruitNumber);

        return industry;
    }
}
