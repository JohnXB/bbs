package com.johnxb.bbs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BbsLike {
    private Integer id;

    private Integer belongId;

    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createdAt;

    private Boolean type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBelongId() {
        return belongId;
    }

    public void setBelongId(Integer belongId) {
        this.belongId = belongId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
}