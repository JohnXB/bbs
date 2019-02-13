package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.dto.auth.ChangePassInputDto;
import com.johnxb.bbs.utils.BeanMapper;
import com.johnxb.bbs.utils.JSONResult;
import com.johnxb.bbs.dto.auth.LoginDto;
import com.johnxb.bbs.dto.auth.LoginOutputDto;
import com.johnxb.bbs.dto.auth.RegisterDto;
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
    public JSONResult<LoginOutputDto> login(@Valid @RequestBody LoginDto loginDto) throws BusinessException {
        JSONResult<LoginOutputDto> jsonResult = new JSONResult<>();
        AuthUser user = authUserService.login(BeanMapper.map(loginDto, AuthUser.class));
        if (user == null) {
            throw new BusinessException("用户名或密码错误,请重试");
        }
        jsonResult.setData(BeanMapper.map(user, LoginOutputDto.class));
        return jsonResult;
    }

    @ApiOperation(value = "注册", notes = "用户注册", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JSONResult register(@RequestBody @Valid RegisterDto registerDto) throws BusinessException {
        JSONResult jsonResult = new JSONResult();
        AuthUser authUser = BeanMapper.map(registerDto, AuthUser.class);
        String message = authUserService.register(authUser);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    @PreAuthorize("hasRole('USER')")
    @ApiOperation(value = "用户信息获取", notes = "用户信息获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public JSONResult<LoginOutputDto> getUserInfo() throws Exception {
        JSONResult<LoginOutputDto> jsonResult = new JSONResult<>();
        AuthUser user = currentUser();
        if (user == null) {
            throw new BusinessException("登录信息已过期，请重新登陆");
        }
        jsonResult.setData(BeanMapper.map(user, LoginOutputDto.class));
        return jsonResult;
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @ApiOperation(value = "修改密码", notes = "用户修改密码", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/user/pass", method = RequestMethod.PUT)
    public JSONResult changePass(@Valid @RequestBody ChangePassInputDto changePassInputDto) throws BusinessException{
        JSONResult jsonResult = new JSONResult();
        Boolean result = this.authUserService.changePass(changePassInputDto,currentUser().getUsername());
        if(!result){
            throw new BusinessException("修改密码失败!");
        }
        jsonResult.setMessage("修改密码成功!");
        return jsonResult;
    }
}
