package com.johnxb.bbs.dto.common;

import com.johnxb.bbs.dto.RequestDto;

import javax.validation.constraints.NotNull;

public class ArticleInputDto extends RequestDto {
    @NotNull
    private String title;
    @NotNull
    private Integer tagId;
    @NotNull
    private Byte type;
    @NotNull
    private String content;

    @NotNull
    private Integer status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
