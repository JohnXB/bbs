package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.dao.mapper.BbsCommentMapper;
import com.johnxb.bbs.dto.comment.CommentInputDto;
import com.johnxb.bbs.entity.BbsComment;
import com.johnxb.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final BbsCommentMapper bbsCommentMapper;

    @Autowired
    public CommentServiceImpl(BbsCommentMapper bbsCommentMapper) {
        this.bbsCommentMapper = bbsCommentMapper;
    }

    @Override
    public List<BbsComment> findCommentsByArticleId(Integer articleId, Integer page, Integer pageSize) {
        return this.bbsCommentMapper.findCommentsByArticleId(articleId, (page - 1) * pageSize, pageSize);
    }

    @Override
    public Boolean createComment(Integer userId, CommentInputDto commentInputDto) {
        return this.bbsCommentMapper.createComment(userId, commentInputDto) > 0;
    }

    @Override
    public Boolean deleteComment(Integer userId, Integer commentId) {
        Integer authorId = this.bbsCommentMapper.getArticleUser(commentId);
        if (authorId == userId) {
            // 删除自己文章的评论
            return this.bbsCommentMapper.deleteByAuthor(commentId) > 0;
        }
        // 删除自己的评论
        return this.bbsCommentMapper.deleteByUser(userId, commentId) > 0;
    }
}
