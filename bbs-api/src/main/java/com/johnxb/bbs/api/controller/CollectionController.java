package com.johnxb.bbs.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.johnxb.bbs.service.CollectionService;
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
@Api("收藏相关api")
public class CollectionController extends BaseController {

    private final CollectionService collectionService;

    @Autowired
    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }
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
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(collectionService.selectByUserAndType(currentUser().getId(), type));
        return new JSONResult(pageInfo);
    }

    @ApiOperation(value = "收藏文章", notes = "根据文章id收藏文章")
    @RequestMapping(value = "/colletion/{articleId}", method = RequestMethod.POST)
    public JSONResult addCollection(@PathVariable Integer articleId) throws BusinessException {
        boolean result = collectionService.addCollection(currentUser().getId(), articleId);
        if (!result) {
            throw new BusinessException("收藏文章失败!");
        }
        return new JSONResult("收藏成功");
    }

    @ApiOperation(value = "删除收藏", notes = "根据文章id删除收藏的文章")
    @RequestMapping(value = "/colletion/{articleId}", method = RequestMethod.DELETE)
    public JSONResult delCollection(@PathVariable Integer articleId) throws BusinessException{
        //todo 删除收藏
        boolean result = collectionService.addCollection(currentUser().getId(), articleId);
        if (!result) {
            throw new BusinessException("删除收藏失败!");
        }
        return new JSONResult("删除收藏成功");
    }
}
