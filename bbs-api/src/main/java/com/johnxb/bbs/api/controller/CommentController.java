package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.service.ArticleService;
import com.johnxb.bbs.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "评论相关api")
//@RequestMapping(value = "/comment")
@CrossOrigin
public class CommentController extends BaseController{
    private final ArticleService articleService;

    @Autowired
    public CommentController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @ApiOperation(value = "评论", notes = "创建评论", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/aaa", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public JSONResult createAticle() {
        JSONResult jsonResult = new JSONResult();
        // Todo 创建评论
        return jsonResult;
    }
}
