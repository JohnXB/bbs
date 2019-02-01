package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.dao.mapper.BbsArticleMapper;
import com.johnxb.bbs.dto.Common.GetArticleDto;
import com.johnxb.bbs.entity.BbsArticle;
import com.johnxb.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    private final BbsArticleMapper bbsArticleMapper;

    @Autowired
    public ArticleServiceImpl(BbsArticleMapper bbsArticleMapper) {
        this.bbsArticleMapper = bbsArticleMapper;
    }

    @Override
    public List<BbsArticle> getArticleByTag(Integer tagId, GetArticleDto getArticleDto) {
        // 设置查找文章数
        getArticleDto.setPage((getArticleDto.getPage() - 1) * getArticleDto.getPageSize());
        List<BbsArticle> list = this.bbsArticleMapper.getArticleByTag(tagId, getArticleDto);
        return list;
    }

    @Override
    public BbsArticle getArticleInfoById(Integer ariticleId) {
        return this.bbsArticleMapper.getArticleInfoById(ariticleId);
    }
}
