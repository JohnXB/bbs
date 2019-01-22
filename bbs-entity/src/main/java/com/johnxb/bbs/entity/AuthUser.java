package com.johnxb.bbs.entity;

import java.util.Date;
import java.util.List;

public class AuthUser {
    private Integer id;

    private String nickname;

    private String mail;

    private String password;

    private String avatar;

    private Date registerAt;

    private boolean gender;

    private String phone;

    private String currentToken;

    private String username;

    private List<String> roles;

    public AuthUser(Integer id, String nickname, String mail, String password, String avatar, Date registerAt, boolean gender, String phone, String currentToken, String username) {
        this.id = id;
        this.nickname = nickname;
        this.mail = mail;
        this.password = password;
        this.avatar = avatar;
        this.registerAt = registerAt;
        this.gender = gender;
        this.phone = phone;
        this.currentToken = currentToken;
        this.username = username;
    }

    public AuthUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Date getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(Date registerAt) {
        this.registerAt = registerAt;
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
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken == null ? null : currentToken.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}