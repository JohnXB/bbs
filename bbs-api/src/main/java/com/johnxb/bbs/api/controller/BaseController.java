package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.entity.AuthUser;
import com.johnxb.bbs.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基础控制器，提供获取当前用户的接口
 */
public class BaseController {
    @Autowired
    AuthUserService authUserService;

    protected AuthUser currentUser() {
        return authUserService.currentUser();
    }
}
