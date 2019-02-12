package com.johnxb.bbs.dto.auth;

import com.johnxb.bbs.dto.RequestDto;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class LoginDto extends RequestDto {
    /**
     * 用户名
     */

    @NotNull(message="用户名不能为空")
    private String username;
    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "用户名", name = "username", dataType = "String")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ApiModelProperty(value = "密码", name = "password", dataType = "String")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
