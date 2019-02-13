package com.johnxb.bbs.dto.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.johnxb.bbs.dto.ResponseDto;

import java.util.Date;

public class GetArticleOutputDto extends ResponseDto {
    private Integer id;

    private String title;

    private String username;

    private Integer viewCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date updatedAt;

    // 状态 0为未审核 1为审核完成 2为推荐
    private Integer status;

    private Integer commentNum;

    private Byte type;

    private String content;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
