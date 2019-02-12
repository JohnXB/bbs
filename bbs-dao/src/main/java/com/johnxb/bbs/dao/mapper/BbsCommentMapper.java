package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.BbsComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsCommentMapper {
    List<BbsComment> selectAll();

    /**
     * 通过文章id查询一级评论
     */
    List<BbsComment> findCommentsByArticleId(@Param("articleId") Integer articleId, @Param("start") Integer start, @Param("count") Integer count);
}