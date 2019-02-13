package com.johnxb.bbs.dto.auth;

import com.johnxb.bbs.dto.RequestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ChangePassInputDto extends RequestDto {
    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "新密码不能为空")
    @Size(max = 16, min = 6, message = "密码必须在6~16位之间")
    private String newPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
