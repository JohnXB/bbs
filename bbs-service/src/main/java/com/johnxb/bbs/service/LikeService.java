package com.johnxb.bbs.service;

import com.johnxb.bbs.dto.like.UserInfoDto;

import java.util.List;

public interface LikeService {
    Integer addLike(Integer userId, Integer belongId, Integer type);

    Integer delLike(Integer userId, Integer belongId, Integer type);

    List<UserInfoDto> likeList(Integer articleId);

    Integer addLikeCount(Integer belongId, Integer belongType);

    Integer reduceLikeCount(Integer belongId, Integer belongType);
}
