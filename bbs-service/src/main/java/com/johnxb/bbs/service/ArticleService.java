package com.johnxb.bbs.service;

import com.johnxb.bbs.dto.common.GetArticleDto;
import com.johnxb.bbs.entity.BbsArticle;

import java.util.List;

public interface ArticleService {
    List<BbsArticle> getArticleByTag(Integer tagId, GetArticleDto getArticleDto);

    BbsArticle getArticleInfoById(Integer ariticleId);

    /**
     * @param bbsArticle
     * @return 创建是否成功
     */
    Boolean createArticle(BbsArticle bbsArticle);
    Boolean updateArticle(BbsArticle bbsArticle);
    /**
     * @param userId
     * @param getArticleDto
     * 获取用户文章
     */
    List<BbsArticle> getArticleByUser(Integer userId, GetArticleDto getArticleDto);

    Boolean deleteArticle(Integer articleId,Integer userId);

    Integer commentNumAdd(Integer articleId);

    Integer commentNumReduce(Integer articleId);

    Integer viewCountAdd(Integer articleId);

}
