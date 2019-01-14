package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.BbsMessage;
import java.util.List;

public interface BbsMessageMapper {
    List<BbsMessage> selectAll();
}