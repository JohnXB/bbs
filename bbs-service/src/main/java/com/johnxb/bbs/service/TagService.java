package com.johnxb.bbs.service;

import com.johnxb.bbs.entity.BbsTag;
import io.swagger.models.auth.In;

import java.util.List;

public interface TagService {
    List<BbsTag> getTagList();

    BbsTag getTagById(Integer tagId);
}
