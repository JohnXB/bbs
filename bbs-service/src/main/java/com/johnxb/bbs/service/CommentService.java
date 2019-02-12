package com.johnxb.bbs.service;

import com.johnxb.bbs.entity.BbsComment;

import java.util.List;

public interface CommentService {
    /**
     * 找出文章一级评论
     */
    List<BbsComment> findCommentsByArticleId(Integer articleId, Integer page, Integer pageSize);
}
