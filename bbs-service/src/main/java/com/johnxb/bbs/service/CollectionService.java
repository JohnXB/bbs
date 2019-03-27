package com.johnxb.bbs.service;


import com.johnxb.bbs.entity.BbsCollection;

import java.util.List;

public interface CollectionService {
    List<BbsCollection> selectByUserAndType(Integer userId, Integer type);

    boolean addCollection(Integer userId, Integer articleId);

    boolean deleteCollection(Integer userId, Integer articleId);
}
