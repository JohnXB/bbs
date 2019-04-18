package com.johnxb.bbs.service;

import com.johnxb.bbs.dto.follow.FollowDto;
import com.johnxb.bbs.entity.BbsFollow;

import java.util.List;

public interface FollowService {
    List<FollowDto> getListByUserAndType(Integer userId, Integer type);

    Integer getCountByUser(Integer userId, Integer type);

    boolean deleteFollow(Integer userId, Integer followUserId);

    boolean followByUser(Integer userId, Integer followUserId);
}
