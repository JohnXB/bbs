package com.johnxb.bbs.dto.like;

import com.johnxb.bbs.dto.RequestDto;

import javax.validation.constraints.NotNull;

public class LikeInputDto extends RequestDto {
    @NotNull
    private Integer likedId;
    @NotNull
    private Integer likedType;

    public Integer getLikedId() {
        return likedId;
    }

    public void setLikedId(Integer likedId) {
        this.likedId = likedId;
    }

    public Integer getLikedType() {
        return likedType;
    }

    public void setLikedType(Integer likedType) {
        this.likedType = likedType;
    }
}
