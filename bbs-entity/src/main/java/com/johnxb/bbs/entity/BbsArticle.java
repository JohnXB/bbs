package com.johnxb.bbs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class BbsArticle {
    private Integer id;

    private String title;

    private Integer userId;

    private Integer tagId;

    private Integer viewCount;

    private Boolean isExamine;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date updatedAt;
    // 状态 0为未审核 1为审核完成 2为推荐
    private Integer status;

    private Integer commentNum;

    private Boolean type;

    private String examineResult;

    private String content;

    private Integer likeNum;
    /**
     * 用户名字段
     */
    private String username;

    /**
     * 评论(一级评论)
     */
    private List<BbsComment> comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Boolean getIsExamine() {
        return isExamine;
    }

    public void setIsExamine(Boolean isExamine) {
        this.isExamine = isExamine;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getExamineResult() {
        return examineResult;
    }

    public void setExamineResult(String examineResult) {
        this.examineResult = examineResult == null ? null : examineResult.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public List<BbsComment> getComments() {
        return comments;
    }

    public void setComments(List<BbsComment> comments) {
        this.comments = comments;
    }
}