package com.bishetyl.entity;

import java.util.List;

/**
 * Created by ������ on 2018/3/21. ��ְ����
 */
public class JobIntention {
    private  int id;
    private  float salary;
    private  String workPlace;
    private  String function; //ְ��
    private  String position;//ְλ
    private  String industry;//��ҵ
    private  List<String> industryLabel;//��ҵ��ǩ ��� �����ݿ��д�Ϊ�ַ��� ��,�ָ�(Ӣ�Ķ���)
    private  String introduction;//���ҽ���
    private  int resumeId;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public List<String> getIndustryLabel() {
        return industryLabel;
    }

    public void setIndustryLabel(List<String> industryLabel) {
        this.industryLabel = industryLabel;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }
}
