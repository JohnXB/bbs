package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.dto.Common.GetArticleDto;
import com.johnxb.bbs.entity.BbsArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsArticleMapper {
    List<BbsArticle> getArticleByTag(@Param("tagId") Integer tagId,@Param("articleQuery") GetArticleDto articleDto);

    /**
     * @param articleId
     * @return 文章详细信息
     */
    BbsArticle getArticleInfoById(@Param("articleId")Integer articleId);

    Integer createArticle(BbsArticle bbsArticle);
}