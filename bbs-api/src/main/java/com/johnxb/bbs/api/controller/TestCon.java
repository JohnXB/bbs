package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.service.AuthUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "权限测试api", value = "")
public class TestCon {
    @ApiOperation(value = "用户登录", notes = "用户登录", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public String testApi(){
        return "succes";
    }
}
