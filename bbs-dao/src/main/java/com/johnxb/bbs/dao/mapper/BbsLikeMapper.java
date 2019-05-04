package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.dto.like.LikeInfoDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsLikeMapper {
    Integer addLike(@Param("userId") Integer userId, @Param("belongId") Integer belongId, @Param("type") Integer type);

    Integer delLike(@Param("userId") Integer userId, @Param("belongId") Integer belongId, @Param("type") Integer type);

    List<LikeInfoDto> likeList(@Param("articleId") Integer articleId);

    Integer addLikeCount(@Param("belongId") Integer belongId, @Param("belongType") Integer belongType);

    Integer reduceLikeCount(@Param("belongId") Integer belongId, @Param("belongType") Integer belongType);
}