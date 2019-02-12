package com.johnxb.bbs.dto.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.johnxb.bbs.dto.ResponseDto;

import java.util.Date;

public class ArticleByUserDto extends ResponseDto {
    private Integer id;

    private String title;

    private Integer viewCount;
    // 0未审核，1审核，2审核不通过
    private Byte isExamine;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createdAt;

    private Integer commentNum;

    private String examineResult;

    private String content;

    private Integer likeNum;
    /**
     * 标签名
     */
    private String tagName;

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

    public Byte getIsExamine() {
        return isExamine;
    }

    public void setIsExamine(Byte isExamine) {
        this.isExamine = isExamine;
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

    public String getExamineResult() {
        return examineResult;
    }

    public void setExamineResult(String examineResult) {
        this.examineResult = examineResult;
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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
