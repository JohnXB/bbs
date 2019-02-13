package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.dto.comment.CommentInputDto;
import com.johnxb.bbs.service.ArticleService;
import com.johnxb.bbs.service.CommentService;
import com.johnxb.bbs.utils.JSONResult;
import com.johnxb.bbs.utils.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Api(description = "评论相关api")
//@RequestMapping(value = "/comment")
@CrossOrigin
public class CommentController extends BaseController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation(value = "创建评论", notes = "创建评论", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public JSONResult createAticle(@Valid @RequestBody CommentInputDto commentInputDto) throws BusinessException {
        JSONResult jsonResult = new JSONResult();
        //空值处理
        commentInputDto.setParentId(Optional.ofNullable(commentInputDto.getParentId()).orElse(0));
        Boolean result = this.commentService.createComment(currentUser().getId(), commentInputDto);
        if (!result) {
            throw new BusinessException("评论失败，请重试");
        }
        jsonResult.setMessage("评论成功");
        return jsonResult;
    }
}
