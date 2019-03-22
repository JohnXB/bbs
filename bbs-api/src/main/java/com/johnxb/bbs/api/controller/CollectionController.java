package com.johnxb.bbs.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.johnxb.bbs.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api("收藏相关api")
public class CollectionController extends BaseController {

    @ApiOperation(value = "获取当前用户收藏列表", notes = "分页获取，区分文章和问题")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示条数", dataType = "Integer")
    })
    @RequestMapping(value = "/collections", method = RequestMethod.GET)
    public JSONResult<PageInfo> getCollectionList(@RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "20") Integer pageSize,
                                                  @RequestParam(defaultValue = "1") Integer type) {
        // todo 获取用户收藏列表
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo();
        return new JSONResult(pageInfo);
    }

    public JSONResult addCollection() {
        //todo 收藏文章
        return null;
    }

    public JSONResult delCollection() {
        //todo 删除收藏
        return null;
    }
}
