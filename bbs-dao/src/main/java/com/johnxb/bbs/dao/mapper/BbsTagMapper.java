package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.BbsTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsTagMapper {
    List<BbsTag> selectAll();

    BbsTag selectById(@Param("tagId") Integer tagId);
}