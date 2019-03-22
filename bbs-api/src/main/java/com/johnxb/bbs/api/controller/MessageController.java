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
            @ApiImplicitParam(paramType = "query", name = "messageType", value = "消息类型，1表示新的回复，2表示新的关注，3表示关注的人发布新消息", dataType = "Byte"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页，默认第1页", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页的显示条数，默认为20条", dataType = "Integer")
    })
    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    @PreAuthorize(value = "hasRole('USER')")
    public JSONResult<PageInfo> getMessages(@RequestParam()Byte messageType,
                                            @RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "20") Integer pageSize) {
        JSONResult<PageInfo> jsonResult = new JSONResult();
        PageHelper.startPage(pageNum, pageSize);
        jsonResult.setData(new PageInfo(this.messageService.getMessagesByUser(currentUser().getId(),messageType)));
        return jsonResult;
    }

    public JSONResult readMessages() {
        //todo 消息标为已读
        return null;
    }

    public JSONResult deleteMessages() {
        //todo 消息删除
        return null;
    }
}
