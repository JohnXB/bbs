package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.dao.mapper.BbsCollectionMapper;
import com.johnxb.bbs.entity.BbsCollection;
import com.johnxb.bbs.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollectionServiceImpl implements CollectionService {
    private final BbsCollectionMapper bbsCollectionMapper;

    @Autowired
    public CollectionServiceImpl(BbsCollectionMapper bbsCollectionMapper) {
        this.bbsCollectionMapper = bbsCollectionMapper;
    }

    @Override
    public List<BbsCollection> selectByUserAndType(Integer userId, Integer type) {
        return bbsCollectionMapper.selectByUserAndType(userId, type);
    }

    @Override
    public boolean addCollection(Integer userId, Integer articleId) {
        return bbsCollectionMapper.addCollection(userId, articleId) > 0;
    }

    @Override
    public boolean deleteCollection(Integer userId, Integer articleId) {
        return bbsCollectionMapper.deleteCollection(userId, articleId) > 0;
    }
}
