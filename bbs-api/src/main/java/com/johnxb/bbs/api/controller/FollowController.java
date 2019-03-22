package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.utils.JSONResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Api("关注api")
public class FollowController extends BaseController {
    public JSONResult getFollowers() {
        // todo 获取关注列表和粉丝列表（考虑redis
        return null;
    }
    public JSONResult followUser(){
        // todo 关注用户
        return null;
    }
    public JSONResult delFollower(){
        // todo 取消关注用户
        return null;
    }
}
