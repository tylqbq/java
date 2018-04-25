package com.bishetyl.entity;

/**
 * Created by 汤玉龙 on 2018/4/24. 收藏简历
 */
public class CollectionRecruit {
    private int id;
    private int JobSeekerId;
    private int recruitId;
    private String collectionTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJobSeekerId() {
        return JobSeekerId;
    }

    public void setJobSeekerId(int jobSeekerId) {
        JobSeekerId = jobSeekerId;
    }

    public int getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(int recruitId) {
        this.recruitId = recruitId;
    }

    public String getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(String collectionTime) {
        this.collectionTime = collectionTime;
    }
}
