package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.BbsMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsMessageMapper {
    List<BbsMessage> selectByUserId(@Param("userId") Integer userId);
}