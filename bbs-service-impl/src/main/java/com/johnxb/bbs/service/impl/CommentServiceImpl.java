package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.dao.mapper.BbsCommentMapper;
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
    public List<BbsComment> findCommentsByArticleId(Integer articleId,Integer page, Integer pageSize) {
        return this.bbsCommentMapper.findCommentsByArticleId(articleId, (page - 1) * pageSize, pageSize);
    }
}
