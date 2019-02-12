package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.dto.article.ArticleByUserDto;
import com.johnxb.bbs.dto.common.ArticleInputDto;
import com.johnxb.bbs.dto.common.GetArticleDto;
import com.johnxb.bbs.entity.BbsArticle;
import com.johnxb.bbs.service.ArticleService;
import com.johnxb.bbs.utils.BeanMapper;
import com.johnxb.bbs.utils.JSONResult;
import com.johnxb.bbs.utils.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Api(description = "文章操作api(需权限)")
@CrossOrigin
//@RequestMapping(value = "/article")
public class ArticleController extends BaseController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @ApiOperation(value = "创建文章", notes = "创建文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/article", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public JSONResult createAticle(@Valid @RequestBody ArticleInputDto articleInputDto) throws BusinessException{
        JSONResult jsonResult = new JSONResult();
        BbsArticle bbsArticle = BeanMapper.map(articleInputDto,BbsArticle.class);
        bbsArticle.setUserId(currentUser().getId());
        boolean result = this.articleService.createArticle(bbsArticle);
        if(!result){
            throw new BusinessException("创建文章失败");
        }
        jsonResult.setMessage("创建成功");
        return jsonResult;
    }

    @ApiOperation(value = "文章获取", notes = "获取当前用户的文章列表")
    @RequestMapping(value = "/user/articles", method = RequestMethod.GET)
    public JSONResult<List<ArticleByUserDto>> getArticlesByTag(GetArticleDto getArticleDto) {
        JSONResult<List<ArticleByUserDto>> jsonResult = new JSONResult();
        // dto空值判断
        getArticleDto.setPage(Optional.ofNullable(getArticleDto.getPage()).orElse(1));
        getArticleDto.setPageSize(Optional.ofNullable(getArticleDto.getPageSize()).orElse(20));
        getArticleDto.setType(Optional.ofNullable(getArticleDto.getType()).orElse(0));

        List<BbsArticle> bbsArticles = this.articleService.getArticleByUser(currentUser().getId(), getArticleDto);
        jsonResult.setData(BeanMapper.mapList(bbsArticles, ArticleByUserDto.class));
        return jsonResult;
    }
}
