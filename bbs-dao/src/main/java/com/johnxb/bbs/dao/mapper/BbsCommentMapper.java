package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.BbsComment;
import java.util.List;

public interface BbsCommentMapper {
    List<BbsComment> selectAll();
}