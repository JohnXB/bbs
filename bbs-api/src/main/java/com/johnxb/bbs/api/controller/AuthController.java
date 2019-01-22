package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.utils.BeanMapper;
import com.johnxb.bbs.utils.JSONResult;
import com.johnxb.bbs.dto.Auth.LogInDto;
import com.johnxb.bbs.dto.Auth.LogInOutputDto;
import com.johnxb.bbs.dto.Auth.RegisterDto;
import com.johnxb.bbs.entity.AuthUser;
import com.johnxb.bbs.service.AuthUserService;
import com.johnxb.bbs.utils.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(description = "用户api")
@RequestMapping(value = "/auth")
@CrossOrigin
public class AuthController extends BaseController {
    private final AuthUserService authUserService;

    @Autowired
    public AuthController(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONResult<LogInOutputDto> login(@Valid @RequestBody LogInDto logInDto) throws BusinessException {
        JSONResult<LogInOutputDto> jsonResult = new JSONResult<>();
        AuthUser user = authUserService.signIn(BeanMapper.map(logInDto, AuthUser.class));
        if (user == null) {
            throw new BusinessException("用户名或密码错误");
        }
        jsonResult.setData(BeanMapper.map(user, LogInOutputDto.class));
        return jsonResult;
    }

    @ApiOperation(value = "注册", notes = "用户注册", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JSONResult register(@RequestBody RegisterDto registerDto) throws BusinessException{
        JSONResult jsonResult = new JSONResult();
        AuthUser authUser = BeanMapper.map(registerDto,AuthUser.class);
        String message = authUserService.register(authUser);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    @PreAuthorize("hasRole('USER')")
    @ApiOperation(value = "用户信息获取", notes = "用户信息获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public JSONResult<LogInOutputDto> getUserInfo() throws Exception {
        JSONResult<LogInOutputDto> jsonResult = new JSONResult<>();
        AuthUser user = currentUser();
        if (user == null) {
            throw new BusinessException("登录信息已过期，请重新登陆");
        }
        jsonResult.setData(BeanMapper.map(user, LogInOutputDto.class));
        return jsonResult;
    }

    @PreAuthorize("hasRole('USER')")
    @ApiOperation(value = "用户访问api", notes = "用户访问api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hi() {
        return "hello";
    }
}
