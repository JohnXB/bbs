package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.dao.mapper.BbsCommentMapper;
import com.johnxb.bbs.dto.comment.CommentInputDto;
import com.johnxb.bbs.entity.BbsComment;
import com.johnxb.bbs.event.MessageAddEvent;
import com.johnxb.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final BbsCommentMapper bbsCommentMapper;
    private final ApplicationContext applicationContext;

    @Autowired
    public CommentServiceImpl(BbsCommentMapper bbsCommentMapper, ApplicationContext applicationContext) {
        this.bbsCommentMapper = bbsCommentMapper;
        this.applicationContext = applicationContext;
    }

    @Override
    public List<BbsComment> findCommentsByArticleId(Integer articleId) {
        return this.bbsCommentMapper.findCommentsByArticleId(articleId);
    }

    @Override
    public Boolean createComment(Integer userId, CommentInputDto commentInputDto) {
        Boolean result = this.bbsCommentMapper.createComment(userId, commentInputDto) > 0;
        if (result) {
            applicationContext.publishEvent(new MessageAddEvent(this, commentInputDto.getToUserId(), commentInputDto.getArticleId(), 1, commentInputDto.getContent()));
        }
        return result;
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
