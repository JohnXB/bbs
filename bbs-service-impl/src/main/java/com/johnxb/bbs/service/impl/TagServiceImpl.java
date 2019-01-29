package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.dao.mapper.BbsTagMapper;
import com.johnxb.bbs.entity.BbsTag;
import com.johnxb.bbs.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {
    private final BbsTagMapper bbsTagMapper;

    @Autowired
    public TagServiceImpl(BbsTagMapper bbsTagMapper) {
        this.bbsTagMapper = bbsTagMapper;
    }

    @Override
    public List<BbsTag> getTagList() {
        return bbsTagMapper.selectAll();
    }

    @Override
    public BbsTag getTagById(Integer tagId) {
        return bbsTagMapper.selectById(tagId);
    }
}
