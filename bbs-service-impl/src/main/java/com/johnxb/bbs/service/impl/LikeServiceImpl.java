package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.dao.mapper.BbsLikeMapper;
import com.johnxb.bbs.dto.like.UserInfoDto;
import com.johnxb.bbs.event.AddCountEvent;
import com.johnxb.bbs.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LikeServiceImpl implements LikeService {
    private final BbsLikeMapper bbsLikeMapper;
    private final ApplicationContext context;

    @Autowired
    public LikeServiceImpl(BbsLikeMapper bbsLikeMapper, ApplicationContext context) {
        this.bbsLikeMapper = bbsLikeMapper;
        this.context = context;
    }

    @Override
    public Integer addLike(Integer userId, Integer belongId, Integer type) {
        Integer result = this.bbsLikeMapper.addLike(userId, belongId, type);
        context.publishEvent(new AddCountEvent(this, belongId, type, 3));
        return result;
    }

    @Override
    public Integer delLike(Integer userId, Integer belongId, Integer type) {
        Integer result = this.bbsLikeMapper.delLike(userId, belongId, type);
        context.publishEvent(new AddCountEvent(this, belongId, type, 4));
        return result;
    }

    @Override
    public List<UserInfoDto> likeList(Integer articleId) {
        return bbsLikeMapper.likeList(articleId);
    }

    @Override
    public Integer addLikeCount(Integer belongId, Integer belongType) {
        return bbsLikeMapper.addLikeCount(belongId, belongType);
    }

    @Override
    public Integer reduceLikeCount(Integer belongId, Integer belongType) {
        return bbsLikeMapper.reduceLikeCount(belongId, belongType);
    }

}
