package com.johnxb.bbs.dto.auth;

import com.johnxb.bbs.dto.RequestDto;
import com.johnxb.bbs.utils.RegexpPattern;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterDto extends RequestDto {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(max = 16, min = 6, message = "密码必须在6~16位之间")
    private String password;

    @NotNull(message = "性别不能为空")
    private boolean gender;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = RegexpPattern.MOBILE, message = "请输入正确的手机号")
    private String phone;

    @NotBlank(message = "邮箱不能为空")
    @Pattern(regexp = RegexpPattern.MAIL, message = "请输入正确的邮箱")
    private String mail;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
