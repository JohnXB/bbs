package com.johnxb.bbs.service;

import com.johnxb.bbs.dto.comment.CommentInputDto;
import com.johnxb.bbs.entity.BbsComment;

import java.util.List;

public interface CommentService {
    /**
     * 找出文章一级评论
     */
    List<BbsComment> findCommentsByArticleId(Integer articleId, String sort);

    Boolean createComment(Integer userId, CommentInputDto commentInputDto);

    Boolean deleteComment(Integer userId, Integer commentId, Integer articleId);
}
