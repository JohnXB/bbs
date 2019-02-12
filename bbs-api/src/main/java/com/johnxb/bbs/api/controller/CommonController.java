package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.dto.common.*;
import com.johnxb.bbs.entity.BbsArticle;
import com.johnxb.bbs.entity.BbsComment;
import com.johnxb.bbs.entity.BbsTag;
import com.johnxb.bbs.service.ArticleService;
import com.johnxb.bbs.service.CommentService;
import com.johnxb.bbs.service.TagService;
import com.johnxb.bbs.utils.BeanMapper;
import com.johnxb.bbs.utils.JSONResult;
import com.johnxb.bbs.utils.exception.BusinessException;
import com.johnxb.bbs.utils.exception.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@Api(description = "公共服务api")
@RequestMapping(value = "/common")
public class CommonController {
    private final TagService tagService;
    private final ArticleService articleService;
    private final CommentService commentService;

    @Autowired
    public CommonController(TagService tagService, ArticleService articleService, CommentService commentService) {
        this.tagService = tagService;
        this.articleService = articleService;
        this.commentService = commentService;
    }


    @ApiOperation(value = "所有文章", notes = "所有文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String articles() {
        return "ab";
    }

    @ApiOperation(value = "所有标签", notes = "获取所有标签基本信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/tags", method = RequestMethod.GET)
    public JSONResult<List<TagsOutputDto>> tags() {
        JSONResult<List<TagsOutputDto>> jsonResult = new JSONResult();
        List<BbsTag> tags = tagService.getTagList();

        List<TagsOutputDto> tagsOutputDtos = BeanMapper.mapList(tags, TagsOutputDto.class);
        jsonResult.setData(tagsOutputDtos);
        return jsonResult;
    }

    @ApiOperation(value = "标签信息", notes = "根据标签id获取标签详细信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/tag/{tagId}", method = RequestMethod.GET)
    public JSONResult<TagOutputDto> tag(@PathVariable @NotNull(message = "标签id不能为空") Integer tagId) throws BusinessException {
        JSONResult<TagOutputDto> jsonResult = new JSONResult<>();
        // 获取数据+数据转换+异常处理
        TagOutputDto tagOutputDto = BeanMapper.map(Optional.ofNullable(this.tagService.getTagById(tagId)).orElseThrow(() -> new BusinessException("无对应标签")), TagOutputDto.class);
        jsonResult.setData(tagOutputDto);
        return jsonResult;
    }

    @ApiOperation(value = "文章获取", notes = "根据tag获取文章")
    @RequestMapping(value = "/tag/{tagId}/articles", method = RequestMethod.GET)
    public JSONResult<List<GetArticleOutputDto>> getArticlesByTag(@PathVariable Integer tagId, GetArticleDto getArticleDto) {
        JSONResult<List<GetArticleOutputDto>> jsonResult = new JSONResult();
        // dto空值判断
        getArticleDto.setPage(Optional.ofNullable(getArticleDto.getPage()).orElse(1));
        getArticleDto.setPageSize(Optional.ofNullable(getArticleDto.getPageSize()).orElse(20));
        getArticleDto.setType(Optional.ofNullable(getArticleDto.getType()).orElse(0));
        List<BbsArticle> bbsArticles = this.articleService.getArticleByTag(tagId, getArticleDto);
        jsonResult.setData(BeanMapper.mapList(bbsArticles, GetArticleOutputDto.class));
        return jsonResult;
    }

    @ApiOperation(value = "文章详细信息获取", notes = "根据文章id访问文章")
    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
    public JSONResult<ArticleInfoDto> getArticleInfo(@PathVariable Integer articleId) throws NotFoundException {
        JSONResult<ArticleInfoDto> jsonResult = new JSONResult<>();
        BbsArticle bbsArticle = Optional.ofNullable(this.articleService.getArticleInfoById(articleId)).orElseThrow(() -> new NotFoundException("未找到文章！"));
        jsonResult.setData(BeanMapper.map(bbsArticle, ArticleInfoDto.class));
        return jsonResult;
    }

    @ApiOperation(value = "文章评论获取", notes = "根据文章id获取文章一级评论以及一级评论子评论数")
    @RequestMapping(value = "/article/{articleId}/comments", method = RequestMethod.GET)
    public JSONResult<List<CommentDto>> getArticleComment(@PathVariable Integer articleId, CommentInputDto commentInputDto) throws NotFoundException {
        JSONResult<List<CommentDto>> jsonResult = new JSONResult<>();

        // dto空值判断
        commentInputDto.setPage(Optional.ofNullable(commentInputDto.getPage()).orElse(1));
        commentInputDto.setPageSize(Optional.ofNullable(commentInputDto.getPageSize()).orElse(20));

        List<BbsComment> bbsComments = this.commentService.findCommentsByArticleId(articleId, commentInputDto.getPage(), commentInputDto.getPageSize());
        jsonResult.setData(BeanMapper.mapList(bbsComments, CommentDto.class));

        return jsonResult;
    }
}
