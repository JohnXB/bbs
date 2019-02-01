package com.johnxb.bbs.service;

import com.johnxb.bbs.dto.Common.GetArticleDto;
import com.johnxb.bbs.entity.BbsArticle;

import java.util.List;

public interface ArticleService {
    List<BbsArticle> getArticleByTag(Integer tagId, GetArticleDto getArticleDto);

    BbsArticle getArticleInfoById(Integer ariticleId);
}
