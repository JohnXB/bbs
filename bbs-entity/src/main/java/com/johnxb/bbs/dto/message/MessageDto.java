package com.johnxb.bbs.dto.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MessageDto {
    private Integer id;

    private Integer userId;

    private Byte messageType;

    private String content;

    private Integer messageId;

    private Boolean alreadyRead;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createdAt;

    private String title;
    private String baUsername;//文章
    private String cTitle;//评论
    private String bacUsername;//评论
    private String blUsername; //点赞
    private String bfUsername;//关注
    private Integer examine;
    private String result;

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

    public Byte getMessageType() {
        return messageType;
    }

    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getAlreadyRead() {
        return alreadyRead;
    }

    public void setAlreadyRead(Boolean alreadyRead) {
        this.alreadyRead = alreadyRead;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBaUsername() {
        return baUsername;
    }

    public void setBaUsername(String baUsername) {
        this.baUsername = baUsername;
    }

    public String getcTitle() {
        return cTitle;
    }

    public void setcTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    public String getBacUsername() {
        return bacUsername;
    }

    public void setBacUsername(String bacUsername) {
        this.bacUsername = bacUsername;
    }

    public String getBlUsername() {
        return blUsername;
    }

    public void setBlUsername(String blUsername) {
        this.blUsername = blUsername;
    }

    public String getBfUsername() {
        return bfUsername;
    }

    public void setBfUsername(String bfUsername) {
        this.bfUsername = bfUsername;
    }

    public Integer getExamine() {
        return examine;
    }

    public void setExamine(Integer examine) {
        this.examine = examine;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}