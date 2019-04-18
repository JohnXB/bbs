package com.johnxb.bbs.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.johnxb.bbs.service.FollowService;
import com.johnxb.bbs.utils.JSONResult;
import com.johnxb.bbs.utils.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api("关注api")
public class FollowController extends BaseController {
    private final FollowService followService;

    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @ApiOperation(value = "获取关注列表或粉丝列表", notes = "根据用户id和类型获取列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示条数", dataType = "Integer")
    })
    @RequestMapping(value = "/followers", method = RequestMethod.GET)
    public JSONResult getFollowers(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "20") Integer pageSize,
                                   @RequestParam(defaultValue = "1") Integer type) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(followService.getListByUserAndType(currentUser().getId(), type));
        return new JSONResult(pageInfo);
    }

    @ApiOperation(value = "获取关注数和粉丝数", notes = "根据用户id和类型获取列表")
    @RequestMapping(value = "/followers/count", method = RequestMethod.GET)
    public JSONResult getFollowersCount(@RequestParam(defaultValue = "1") Integer type) {
        return new JSONResult(followService.getCountByUser(currentUser().getId(), type));
    }

    @ApiOperation(value = "关注", notes = "根据被关注人id关注")
    @RequestMapping(value = "/follow/{userId}", method = RequestMethod.POST)
    public JSONResult followUser(@PathVariable Integer userId) throws BusinessException{
        boolean result = followService.followByUser(userId,currentUser().getId());
        if (!result) {
            throw new BusinessException("关注失败!");
        }
        return new JSONResult("关注成功");
    }

    @ApiOperation(value = "取消关注", notes = "根据被关注人id取消关注")
    @RequestMapping(value = "/follow/{userId}", method = RequestMethod.DELETE)
    public JSONResult delFollower(@PathVariable Integer userId) throws BusinessException{
        boolean result = followService.deleteFollow(userId,currentUser().getId());
        if (!result) {
            throw new BusinessException("取消关注失败!");
        }
        return new JSONResult("取消关注成功");
    }
}
