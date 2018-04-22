package com.bishetyl.service;

import com.bishetyl.dao.*;
import com.bishetyl.entity.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/21.
 */
public class ResumeService {

    //新建简历
    public Resume getResumeById(Resume resume){
        ResumeDao resumeDao = new ResumeDao();
        Resume resumeRet = resumeDao.searchResume(resume.getId());

        //求职意向
        JobIntention jobIntention = new JobIntention();
        JobIntentionDao jobIntentionDao = new JobIntentionDao();
        jobIntention = jobIntentionDao.searchJobIntentionByid(resume.getId());
        resumeRet.setJobIntention(jobIntention);
        //工作经验
        List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();
        WorkExperienceDao  workExperienceDao = new WorkExperienceDao();
        workExperienceList = workExperienceDao.searchWorkExperienceByResumeId(resume.getId());
        resumeRet.setWorkExperiencesList(workExperienceList);
        //项目经验
        List<ProjectExperience> projectExperiencesList = new ArrayList<ProjectExperience>();
        ProjectExperiencesDao projectExperiencesDao = new ProjectExperiencesDao();
        projectExperiencesList = projectExperiencesDao.searchProjectExperiencesByResumeId(resume.getId());
        resumeRet.setProjectExperiencesList(projectExperiencesList);
        //教育经历
        EducationExperience educationExperience = new EducationExperience();
        EducationExperienceDao educationExperienceDao = new EducationExperienceDao();
        educationExperience = educationExperienceDao.searchEducationExperienceByResumeId(resume.getId());
        resumeRet.setEducationExperience(educationExperience);
        //学校荣誉
        List<SchoolHonor> schoolHonorList = new ArrayList<SchoolHonor>();
        SchoolHonorDao schoolHonorDao = new SchoolHonorDao();
        schoolHonorList = schoolHonorDao.searchSchoolHonorByResumeId(resume.getId());
        resumeRet.setSchoolHonorList(schoolHonorList);
        //学校职务
        List<SchoolDuties> schoolDutiesList = new ArrayList<SchoolDuties>();
        SchoolDutiesDao schoolDutiesDao = new SchoolDutiesDao();
        schoolDutiesList = schoolDutiesDao.searchSchoolDutiesByResumeId(resume.getId());
        resumeRet.setSchoolDutiesList(schoolDutiesList);

        return resumeRet;
    }

    //新建简历
    public Resume addResume(Resume resume){
        ResumeDao resumeDao = new ResumeDao();
        Resume resumeRet = resumeDao.addResume(resume);
        return resumeRet;
    }

    //修改年收入
    public Resume changeAnnualIncome(Resume resume){
        ResumeDao resumeDao = new ResumeDao();

        Resume resumeRet = resumeDao.addResumeIncome(resume);
        return resumeRet;
    }

    //新建求职意向
    public JobIntention addJobIntention(JobIntention jobIntention){
        JobIntentionDao jobIntentionDao = new JobIntentionDao();
        JobIntention jobIntentionRet = new JobIntention();
        jobIntentionRet = jobIntentionDao.addJobIntention(jobIntention);
        return jobIntentionRet;
    }
}
