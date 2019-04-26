package com.johnxb.bbs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BbsFollow {
    private Integer id;

    private Integer userId;

    private Integer followUserId;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(Integer followUserId) {
        this.followUserId = followUserId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}