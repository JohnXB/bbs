package com.johnxb.bbs.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.johnxb.bbs.service.MessageService;
import com.johnxb.bbs.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api("消息Api")
public class MessageController extends BaseController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @ApiOperation(value = "获取当前用户消息列表（分页", notes = "按时间顺序排序")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页，默认第1页", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页的显示条数，默认为20条", dataType = "Integer")
    })
    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    @PreAuthorize(value = "hasRole('USER')")
    public JSONResult<PageInfo> getMessages(
                                            @RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "20") Integer pageSize) {
        JSONResult<PageInfo> jsonResult = new JSONResult();
        PageHelper.startPage(pageNum, pageSize);
        jsonResult.setData(new PageInfo(this.messageService.getMessagesByUser(currentUser().getId())));
        return jsonResult;
    }

    @ApiOperation(value = "标记消息为已读")
    @RequestMapping(value = "/messages", method = RequestMethod.PUT)
    @PreAuthorize(value = "hasRole('USER')")
    public JSONResult readMessages(@RequestParam("messageIds") Integer[] messageIds) {
        //消息标为已读
        this.messageService.readMessages(messageIds, currentUser().getId());
        return new JSONResult(true);
    }

    @ApiOperation(value = "删除消息")
    @RequestMapping(value = "/messages", method = RequestMethod.DELETE)
    @PreAuthorize(value = "hasRole('USER')")
    public JSONResult deleteMessages(@RequestParam("messageIds") Integer[] messageIds) {
        // 消息删除
        this.messageService.delMessages(messageIds, currentUser().getId());
        return new JSONResult(true);
    }


    // 消息观察者模式：发布文章后关注者收到消息（接口 post /article。新的回复被回复人收到消息。新的关注被关注人收到消息,新点赞,审核
}
