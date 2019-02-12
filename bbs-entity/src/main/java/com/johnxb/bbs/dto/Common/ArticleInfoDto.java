package com.johnxb.bbs.dto.Common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.johnxb.bbs.dto.ResponseDto;
import com.johnxb.bbs.entity.BbsComment;

import java.util.Date;
import java.util.List;

public class ArticleInfoDto extends ResponseDto {
    private Integer id;

    private String title;

    private Integer viewCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createdAt;

    private Integer commentNum;

    private Boolean type;

    private String content;

    private Integer likeNum;
    /**
     * 用户名字段
     */
    private String username;



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
        this.title = title;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
