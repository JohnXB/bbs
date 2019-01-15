package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.api.utils.BeanMapper;
import com.johnxb.bbs.api.utils.JSONResult;
import com.johnxb.bbs.dto.Auth.SignInDto;
import com.johnxb.bbs.dto.Auth.SignInOutDto;
import com.johnxb.bbs.entity.AuthUser;
import com.johnxb.bbs.service.AuthUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(description = "权限测试api")
@RequestMapping(value = "/auth")
public class AuthController extends BaseController {
    private final AuthUserService authUserService;

    @Autowired
    public AuthController(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONResult<SignInOutDto> login(@Valid SignInDto signInDto) {
        System.out.println(signInDto.getPassword());
        AuthUser user = authUserService.signIn(BeanMapper.map(signInDto,AuthUser.class));
        JSONResult<SignInOutDto> jsonResult = new JSONResult<>();
        jsonResult.setData(BeanMapper.map(user,SignInOutDto.class));
        return jsonResult;
    }

    @PreAuthorize("hasRole('USER')")
    @ApiOperation(value = "用户访问api", notes = "用户访问api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hi() {
        return "hello";
    }
}
