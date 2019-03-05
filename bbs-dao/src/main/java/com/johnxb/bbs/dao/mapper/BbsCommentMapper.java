package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.dto.comment.CommentInputDto;
import com.johnxb.bbs.entity.BbsComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BbsCommentMapper {
    List<BbsComment> selectAll();

    /**
     * 通过文章id查询一级评论
     */
    List<BbsComment> findCommentsByArticleId(@Param("articleId") Integer articleId, @Param("start") Integer start, @Param("count") Integer count);

    Integer createComment(@Param("userId") Integer userId, @Param("comment") CommentInputDto commentInputDto);

    Integer getArticleUser(@Param("commentId") Integer commentId);

    Integer deleteByUser(@Param("userId")Integer userId,@Param("commentId")Integer commentId);

    Integer deleteByAuthor(@Param("commentId")Integer commentId);
}