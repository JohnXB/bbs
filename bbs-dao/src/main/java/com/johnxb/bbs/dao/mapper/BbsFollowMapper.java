package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.dto.follow.FollowDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsFollowMapper {
    //根据type获取关注或者粉丝列表
    List<FollowDto> getFollowListByUser(@Param("userId") Integer userId, @Param("type") Integer type);

    Integer getFollowCountByUser(@Param("userId") Integer userId, @Param("type") Integer type);

    Integer deleteFollow(@Param("userId") Integer userId, @Param("followUserId") Integer followUserId);

    Integer followByUser(@Param("userId") Integer userId, @Param("followUserId") Integer followUserId);
}