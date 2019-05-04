package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.dto.like.LikeInputDto;
import com.johnxb.bbs.service.LikeService;
import com.johnxb.bbs.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@Api(value = "点赞Api")
public class LikeController extends BaseController {
    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    // 点赞（对应表点赞数加1
    @ApiOperation(value = "给文章或评论点赞")
    @RequestMapping(value = "/like", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public JSONResult addLike(@RequestBody @Valid LikeInputDto likeInputDto) {
        likeService.addLike(currentUser().getId(), likeInputDto.getLikedId(), likeInputDto.getLikedType());
        return new JSONResult(true);
    }

    // 取消点赞
    @PreAuthorize("hasRole('USER')")
    @ApiOperation(value = "给文章或评论取消点赞")
    @RequestMapping(value = "/like", method = RequestMethod.DELETE)
    public JSONResult delLike(@RequestBody @Valid LikeInputDto likeInputDto) {
        likeService.delLike(currentUser().getId(), likeInputDto.getLikedId(), likeInputDto.getLikedType());
        return new JSONResult(true);
    }

    // 点赞人列表
    @PreAuthorize("hasRole('USER')")
    @ApiOperation(value = "文章点赞列表前10个")
    @ApiImplicitParam(paramType = "query", name = "articleId", value = "文章id", dataType = "Integer")
    @RequestMapping(value = "/like", method = RequestMethod.GET)
    public JSONResult likeList(@RequestParam Integer articleId) {
        return new JSONResult(true);
    }
}
