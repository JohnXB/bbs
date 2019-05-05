package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.dao.mapper.BbsArticleMapper;
import com.johnxb.bbs.dto.common.GetArticleDto;
import com.johnxb.bbs.entity.BbsArticle;
import com.johnxb.bbs.event.MessageAddEvent;
import com.johnxb.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    private final BbsArticleMapper bbsArticleMapper;
    private final ApplicationContext applicationContext;

    @Autowired
    public ArticleServiceImpl(BbsArticleMapper bbsArticleMapper, ApplicationContext applicationContext) {
        this.bbsArticleMapper = bbsArticleMapper;
        this.applicationContext = applicationContext;
    }

    @Override
    public List<BbsArticle> getArticleByTag(Integer tagId, GetArticleDto getArticleDto) {
        List<BbsArticle> list = this.bbsArticleMapper.getArticleByTag(tagId, getArticleDto);
        return list;
    }

    /**
     * 通过文章id获取文章信息
     */
    @Override
    public BbsArticle getArticleInfoById(Integer ariticleId) {
        return this.bbsArticleMapper.getArticleInfoById(ariticleId);
    }

    /**
     * 创建文章
     */
    @Override
    public Boolean createArticle(BbsArticle bbsArticle) {
        Boolean result = this.bbsArticleMapper.createArticle(bbsArticle) > 0;
        if(result && bbsArticle.getStatus() != 3){
            applicationContext.publishEvent(new MessageAddEvent(this,bbsArticle.getUserId(),bbsArticle.getId(),3,"发布新文章"));
        }
        return result;
    }

    @Override
    public Boolean updateArticle(BbsArticle bbsArticle) {
        return this.bbsArticleMapper.updateArticle(bbsArticle) > 0;
    }

    public List<BbsArticle> getArticleByUser(Integer userId, GetArticleDto getArticleDto) {
        List<BbsArticle> list = this.bbsArticleMapper.getArticleByUser(userId, getArticleDto.getType());
        return list;
    }

    @Override
    public Boolean deleteArticle(Integer articleId, Integer userId) {
        return this.bbsArticleMapper.deleteArticle(articleId, userId) > 0;
    }

    @Override
    public Integer commentNumAdd(Integer articleId) {
        return bbsArticleMapper.commentNumAdd(articleId);
    }

    @Override
    public Integer commentNumReduce(Integer articleId) {
        return bbsArticleMapper.commentNumReduce(articleId);
    }

    @Override
    public Integer viewCountAdd(Integer articleId){
        return this.bbsArticleMapper.viewCountAdd(articleId);
    }

    @Override
    public List<BbsArticle> searchByQuery(String query) {
        return bbsArticleMapper.searchByQuery(query);
    }
}
