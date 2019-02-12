package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.dto.auth.LoginDto;
import com.johnxb.bbs.dto.auth.LoginOutputDto;
import com.johnxb.bbs.entity.AuthUser;
import com.johnxb.bbs.service.AuthUserService;
import com.johnxb.bbs.utils.BeanMapper;
import com.johnxb.bbs.utils.JSONResult;
import com.johnxb.bbs.utils.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(description = "管理员api")
@RequestMapping(value = "/admin")
public class AdminController extends BaseController{
    private final AuthUserService authUserService;

    @Autowired
    public AdminController(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    @ApiOperation(value = "管理员登录", notes = "管理员登录", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONResult<LoginOutputDto> adminLogin(@Valid @RequestBody LoginDto loginDto) throws BusinessException {
        JSONResult<LoginOutputDto> jsonResult = new JSONResult<>();
        AuthUser user = authUserService.adminLogin(BeanMapper.map(loginDto, AuthUser.class));
        if (user == null) {
            throw new BusinessException("用户名或密码错误,请重试");
        }
        jsonResult.setData(BeanMapper.map(user, LoginOutputDto.class));
        return jsonResult;
    }
}
