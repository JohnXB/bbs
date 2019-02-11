package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.service.ArticleService;
import com.johnxb.bbs.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.print.attribute.standard.Media;

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
    public JSONResult createAticle() {
        JSONResult jsonResult = new JSONResult();
        // Todo 创建文章
        return jsonResult;
    }

    @ApiOperation(value = "获取文章", notes = "通过文章id获取文章(问题)", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('null')")
    public JSONResult getAticle() {
        JSONResult jsonResult = new JSONResult();
        // Todo 创建文章
        return jsonResult;
    }
}
