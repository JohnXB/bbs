package com.johnxb.bbs.dto.like;

import com.johnxb.bbs.dto.ResponseDto;

public class LikeInfoDto extends ResponseDto {
    private Integer id;
    private String username;
    private String avatar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
