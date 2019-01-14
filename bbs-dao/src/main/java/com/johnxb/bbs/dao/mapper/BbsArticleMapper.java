package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.BbsArticle;
import java.util.List;

public interface BbsArticleMapper {
    List<BbsArticle> selectAll();
}