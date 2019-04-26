package com.johnxb.bbs.api.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Api("点赞Api")
public class LikeController extends BaseController {
    //todo 点赞（对应表点赞数加1
    //todo 取消点赞
    //todo 点赞人列表
}
