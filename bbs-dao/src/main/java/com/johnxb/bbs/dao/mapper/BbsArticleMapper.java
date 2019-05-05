package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.dto.common.GetArticleDto;
import com.johnxb.bbs.entity.BbsArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsArticleMapper {
    // 通过tag查询
    List<BbsArticle> getArticleByTag(@Param("tagId") Integer tagId, @Param("articleQuery") GetArticleDto articleDto);

    /**
     * @param articleId
     * @return 文章详细信息
     */
    BbsArticle getArticleInfoById(@Param("articleId") Integer articleId);

    /**
     * 创建文章
     */
    Integer createArticle(BbsArticle bbsArticle);

    Integer updateArticle(BbsArticle bbsArticle);
    /**
     * @param userId
     * @param type   文章类型
     * @return
     */
    List<BbsArticle> getArticleByUser(@Param("userId") Integer userId, @Param("type") Integer type);

    Integer deleteArticle(@Param("articleId") Integer articleId, @Param("userId") Integer userId);

    Integer commentNumAdd(@Param("articleId") Integer articleId);

    Integer commentNumReduce(@Param("articleId") Integer articleId);

    Integer viewCountAdd(@Param("articleId") Integer articleId);

    List<BbsArticle> searchByQuery(@Param("query") String query);
}