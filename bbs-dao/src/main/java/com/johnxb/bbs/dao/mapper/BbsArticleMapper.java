package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.dto.Common.GetArticleDto;
import com.johnxb.bbs.entity.BbsArticle;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface BbsArticleMapper {
    // 通过tag查询
    List<BbsArticle> getArticleByTag(@Param("tagId") Integer tagId,@Param("articleQuery") GetArticleDto articleDto);

    /**
     * @param articleId
     * @return 文章详细信息
     */
    BbsArticle getArticleInfoById(@Param("articleId")Integer articleId);

    /**
     * 创建文章
     */
    Integer createArticle(BbsArticle bbsArticle);

    /**
     * @param start 偏移量，分页
     * @param count
     * @return
     */
    List<BbsArticle> getArticleByUser(@Param("userId")Integer userId, @Param("start")Integer start,@Param("count")Integer count);
}