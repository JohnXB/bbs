package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.BbsCollection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsCollectionMapper {
    List<BbsCollection> selectByUserAndType(@Param("userId") Integer userId, @Param("type") Integer type);

    Integer addCollection(@Param("userId") Integer userId, @Param("articleId") Integer articleId);

    Integer deleteCollection(@Param("userId") Integer userId, @Param("articleId") Integer articleId);
}