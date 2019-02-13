package com.johnxb.bbs.dto.comment;

import com.johnxb.bbs.dto.RequestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CommentInputDto extends RequestDto {
    @NotNull(message = "文章id不能为空")
    private Integer articleId;

    private Integer parentId;

    @NotBlank(message = "评论内容不能为空")
    private String content;

    private Integer toUserId;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }
}
