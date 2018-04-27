package com.bishetyl.service;

import com.bishetyl.dao.*;
import com.bishetyl.dto.DeliveryResumeResult;
import com.bishetyl.entity.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/21.
 */
public class ResumeService {

    //获得简历
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
    //获得该求职下所有简历
    public List<Resume> getResumeByJobSeekerId(Resume resume){
        ResumeDao resumeDao = new ResumeDao();
        List<Resume> resumeList = new ArrayList<Resume>();
        resumeList = resumeDao.searchResumeByJobSeekerId(resume.getJobSeekerId());
        for (int i=0;i<resumeList.size();i++){
            //求职意向
            JobIntention jobIntention = new JobIntention();
            JobIntentionDao jobIntentionDao = new JobIntentionDao();
            jobIntention = jobIntentionDao.searchJobIntentionByid(resumeList.get(i).getId());
            resumeList.get(i).setJobIntention(jobIntention);
            //工作经验
            List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();
            WorkExperienceDao  workExperienceDao = new WorkExperienceDao();
            workExperienceList = workExperienceDao.searchWorkExperienceByResumeId(resumeList.get(i).getId());
            resumeList.get(i).setWorkExperiencesList(workExperienceList);
            //项目经验
            List<ProjectExperience> projectExperiencesList = new ArrayList<ProjectExperience>();
            ProjectExperiencesDao projectExperiencesDao = new ProjectExperiencesDao();
            projectExperiencesList = projectExperiencesDao.searchProjectExperiencesByResumeId(resumeList.get(i).getId());
            resumeList.get(i).setProjectExperiencesList(projectExperiencesList);
            //教育经历
            EducationExperience educationExperience = new EducationExperience();
            EducationExperienceDao educationExperienceDao = new EducationExperienceDao();
            educationExperience = educationExperienceDao.searchEducationExperienceByResumeId(resumeList.get(i).getId());
            resumeList.get(i).setEducationExperience(educationExperience);
            //学校荣誉
            List<SchoolHonor> schoolHonorList = new ArrayList<SchoolHonor>();
            SchoolHonorDao schoolHonorDao = new SchoolHonorDao();
            schoolHonorList = schoolHonorDao.searchSchoolHonorByResumeId(resumeList.get(i).getId());
            resumeList.get(i).setSchoolHonorList(schoolHonorList);
            //学校职务
            List<SchoolDuties> schoolDutiesList = new ArrayList<SchoolDuties>();
            SchoolDutiesDao schoolDutiesDao = new SchoolDutiesDao();
            schoolDutiesList = schoolDutiesDao.searchSchoolDutiesByResumeId(resumeList.get(i).getId());
            resumeList.get(i).setSchoolDutiesList(schoolDutiesList);
        }
        return resumeList;
    }
    //通过求职者id获取开启了快速投递的简历 如果没有则返回名下所有的简历以供选择
    public List<Resume> getSpecialResumeByJobSeekerId(Resume resume){
        List<Resume> resumeList = new ArrayList<Resume>();
        ResumeDao resumeDao = new ResumeDao();
        Resume resumeSpecial = resumeDao.getSpecialResume(resume.getJobSeekerId());
        if(resumeSpecial == null){
            resumeList = resumeDao.searchResumeByJobSeekerId(resume.getJobSeekerId());
        }else{
            resumeList.add(resumeSpecial);
        }
        return resumeList;
    }


    //新建简历
    public void addResume(Resume resume){
        ResumeDao resumeDao = new ResumeDao();
        int rowID = resumeDao.addResume(resume);
        //求职意向
        JobIntentionDao jobIntentionDao = new JobIntentionDao();
        jobIntentionDao.addJobIntention(resume.getJobIntention(), rowID);

        //工作经验
        if (resume.getWorkExperiencesList()!=null) {
            List<WorkExperience> workExperienceList = resume.getWorkExperiencesList();
            WorkExperienceDao workExperienceDao = new WorkExperienceDao();
            for (int i = 0; i < workExperienceList.size(); i++) {
                workExperienceDao.addWorkExperience(workExperienceList.get(i), rowID);
            }
        }
        //项目经验
        if (resume.getProjectExperiencesList() != null){
            List<ProjectExperience> projectExperiencesList =resume.getProjectExperiencesList();
            ProjectExperiencesDao projectExperiencesDao = new ProjectExperiencesDao();
            for(int i=0;i<projectExperiencesList.size();i++){
                projectExperiencesDao.addProjectExperience(projectExperiencesList.get(i), rowID);
            }
        }
        //教育经历
        if (resume.getEducationExperience() != null){
            EducationExperience educationExperience  = resume.getEducationExperience();
            EducationExperienceDao educationExperienceDao = new EducationExperienceDao();
            educationExperienceDao.addEducationExperience(educationExperience,rowID);
        }

        //学校荣誉
        if (resume.getSchoolHonorList().size() > 0){
            List<SchoolHonor> schoolHonorList = resume.getSchoolHonorList();
            SchoolHonorDao schoolHonorDao = new SchoolHonorDao();
            for(int i=0;i<schoolHonorList.size();i++){
                schoolHonorDao.addSchoolHonor(schoolHonorList.get(i),rowID);
            }
        }

        //学校职务
        if (resume.getSchoolDutiesList().size()>0){
            List<SchoolDuties> schoolDutiesList = resume.getSchoolDutiesList();
            SchoolDutiesDao schoolDutiesDao = new SchoolDutiesDao();
            for(int i=0;i<schoolDutiesList.size();i++){
                schoolDutiesDao.addSchoolDuties(schoolDutiesList.get(i),rowID);
            }
        }
    }

    //删除简历
    public Boolean deleteResume(Resume resume){
        //删除简历
        ResumeDao resumeDao = new ResumeDao();
        Boolean isSuccess = resumeDao.deleteResume(resume.getId());
        //删除jobIntention
        JobIntentionDao jobIntentionDao = new JobIntentionDao();
        Boolean jobIntentionIsSuccess = jobIntentionDao.deleteJobIntentionByResumeId(resume.getId());
        //工作经验
        WorkExperienceDao workExperienceDao = new WorkExperienceDao();
        Boolean workExperienceIsSuccess = workExperienceDao.deleteWorkExperienceByResumeId(resume.getId());
        //项目经验
        ProjectExperiencesDao projectExperiencesDao = new ProjectExperiencesDao();
        Boolean projectExperiencesIsSuccess = projectExperiencesDao.deleteProjectExperienceByResumeId(resume.getId());
        //教育经历
        EducationExperienceDao educationExperienceDao = new EducationExperienceDao();
        Boolean educationExperienceIsSuccess = educationExperienceDao.deleteEducationExperienceByResumeId(resume.getId());
        //学校荣誉
        SchoolHonorDao schoolHonorDao = new SchoolHonorDao();
        Boolean  schoolHonorIsSuccess = schoolHonorDao.deleteSchoolHonorByResumeId(resume.getId());
        //学习职务
        SchoolDutiesDao schoolDutiesDao = new SchoolDutiesDao();
        Boolean schoolDutiesIsSuccess = schoolDutiesDao.deleteSchoolDutiesByResumeId(resume.getId());
        if (isSuccess && jobIntentionIsSuccess && workExperienceIsSuccess && projectExperiencesIsSuccess
                && educationExperienceIsSuccess && schoolHonorIsSuccess && schoolDutiesIsSuccess){
            return isSuccess;
        }else{
            return Boolean.valueOf(false);
        }

    }

    //修改简历基本信息
    public Boolean updateResume(Resume resume){
        ResumeDao resumeDao = new ResumeDao();
        Boolean isSuccess = resumeDao.updateResume(resume);
        return isSuccess;
    }

    //修改年收入
    public Boolean updateAnnualIncome(Resume resume){
        ResumeDao resumeDao = new ResumeDao();
        Boolean isScuess = resumeDao.updateResumeIncome(resume);
        return isScuess;
    }

    //修改简历公开程度
    public Boolean updatePublic(Resume resume){
        ResumeDao resumeDao = new ResumeDao();
        Boolean isSuccess = resumeDao.updatePublic(resume);
        return isSuccess;
    }

    //修改求职意向
    public Boolean updateJobIntention(JobIntention jobIntention){
        JobIntentionDao jobIntentionDao = new JobIntentionDao();
        Boolean isScuess = jobIntentionDao.updateJobIntention(jobIntention);
        return isScuess;
    }

    //修改工作经验
    public Boolean updateWorkExperience(WorkExperience workExperience){
        WorkExperienceDao workExperienceDao = new WorkExperienceDao();
        Boolean isScuess = workExperienceDao.updateWorkExperience(workExperience);
        return isScuess;
    }

    //修改项目经验
    public Boolean updateProjectExperience(ProjectExperience projectExperience){
        ProjectExperiencesDao projectExperiencesDao = new ProjectExperiencesDao();
        Boolean isScuess = projectExperiencesDao.updateProjectExperience(projectExperience);
        return isScuess;
    }

    //修改教育经历
    public Boolean updateEducationExperience(EducationExperience educationExperience){
        EducationExperienceDao educationExperienceDao = new EducationExperienceDao();
        Boolean isScuess = educationExperienceDao.updateEducationExperience(educationExperience);
        return isScuess;
    }

    //修改学校荣誉
    public Boolean updateSchoolHonor(SchoolHonor schoolHonor){
        SchoolHonorDao schoolHonorDao = new SchoolHonorDao();
        Boolean isScuess = schoolHonorDao.updateSchoolHonor(schoolHonor);
        return isScuess;
    }

    //修改学校职务
    public Boolean updateSchoolDuties(SchoolDuties schoolDuties){
        SchoolDutiesDao schoolDutiesDao  = new SchoolDutiesDao();
        Boolean isScuess = schoolDutiesDao.updateSchoolDuties(schoolDuties);
        return isScuess;
    }

    //修改快速投递
    public Boolean updateDilivery(Resume resume){
        ResumeDao resumeDao = new ResumeDao();
        Boolean isScuess = resumeDao.updateDilivery(resume);
        List<Resume> resumeList = new ArrayList<Resume>();
        resumeList = resumeDao.searchResumeByJobSeekerId(resume.getJobSeekerId());
        for(int i=0;i<resumeList.size();i++){
            if (resumeList.get(i).getId() != resume.getId()){
                resumeList.get(i).setDilivery("false");
                resumeDao.updateDilivery(resumeList.get(i));
            }
        }
        return isScuess;
    }

    //投递简历
    public Boolean diliveryResume(DeliveryResume deliveryResume){
        DeliveruResumeDao deliveruResumeDao = new DeliveruResumeDao();
        Boolean isExist = deliveruResumeDao.isExistDiliveryResume(deliveryResume);
        if(isExist){ //如果已经收藏了
            return false;
        }else{
            deliveruResumeDao.diliveryResume(deliveryResume);
            return true;
        }
    }
    //删除投递简历
    public Boolean deleteDiliveryResume(DeliveryResume deliveryResume){
        DeliveruResumeDao deliveruResumeDao = new DeliveruResumeDao();
        Boolean isScuess = deliveruResumeDao.deleteDiliveryResume(deliveryResume);
        return isScuess;
    }


    //查询投递的简历
    public List<DeliveryResumeResult> getDeliveryResume(JobSeeker jobSeeker){
        //得到投递简历数组
        List<DeliveryResume> deliveryResumeList = new ArrayList<DeliveryResume>();
        DeliveruResumeDao deliveruResumeDao = new DeliveruResumeDao();
        deliveryResumeList = deliveruResumeDao.searchDeliveryResumeByJobSeekerId(jobSeeker.getId());

        List<DeliveryResumeResult> deliveryResumeResultList = new ArrayList<DeliveryResumeResult>();

        ResumeDao resumeDao = new ResumeDao();
        RecruitDao recruitDao = new RecruitDao();

        for(int i=0;i<deliveryResumeList.size();i++){
            int id =  deliveryResumeList.get(i).getId();
            int jobSeekerId = deliveryResumeList.get(i).getJobSeekerId();
            int resumeId = deliveryResumeList.get(i).getResumeId();
            int recruitId = deliveryResumeList.get(i).getRecruitId();
            String deliveryTime = deliveryResumeList.get(i).getDeliveryTime();
            int isBrowse =  deliveryResumeList.get(i).getIsBrowse();

            Resume resume = new Resume();
            resume = resumeDao.searchResume(resumeId);

            Recruit recruit = new Recruit();
            recruit = recruitDao.getRecruitById(recruitId);

            DeliveryResumeResult deliveryResumeResult = new DeliveryResumeResult();

            deliveryResumeResult.setId(id);
            deliveryResumeResult.setJobSeekerId(jobSeekerId);
            deliveryResumeResult.setRecruitId(recruitId);
            deliveryResumeResult.setRecruitPositionName(recruit.getPositionName());
            deliveryResumeResult.setResumeId(resumeId);
            deliveryResumeResult.setResumeName(resume.getName());
            deliveryResumeResult.setDeliveryTime(deliveryTime);
            deliveryResumeResult.setCompanyId(recruit.getCompanyId());
            deliveryResumeResultList.add(deliveryResumeResult);
        }
        return  deliveryResumeResultList;
    }





//    //新建求职意向
//    public JobIntention addJobIntention(JobIntention jobIntention){
//        JobIntentionDao jobIntentionDao = new JobIntentionDao();
//        JobIntention jobIntentionRet = new JobIntention();
//        jobIntentionRet = jobIntentionDao.addJobIntention(jobIntention);
//        return jobIntentionRet;
//    }
}
