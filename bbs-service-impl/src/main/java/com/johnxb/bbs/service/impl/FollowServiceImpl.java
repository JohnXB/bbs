package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.dao.mapper.BbsFollowMapper;
import com.johnxb.bbs.dto.follow.FollowDto;
import com.johnxb.bbs.event.MessageAddEvent;
import com.johnxb.bbs.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {
    private final BbsFollowMapper bbsFollowMapper;
    private final ApplicationContext applicationContext;

    @Autowired
    public FollowServiceImpl(BbsFollowMapper bbsFollowMapper, ApplicationContext applicationContext) {
        this.bbsFollowMapper = bbsFollowMapper;
        this.applicationContext = applicationContext;
    }

    @Override
    public List<FollowDto> getListByUserAndType(Integer userId, Integer type) {
        // type为1表示关注列表，2表示粉丝列表
        return bbsFollowMapper.getFollowListByUser(userId, type);
    }

    @Override
    public Integer getCountByUser(Integer userId, Integer type) {
        return bbsFollowMapper.getFollowCountByUser(userId, type);
    }

    @Override
    public boolean deleteFollow(Integer userId, Integer followUserId) {
        return bbsFollowMapper.deleteFollow(userId, followUserId) > 0;
    }

    @Override
    public boolean followByUser(Integer userId, Integer followUserId) {
        boolean result = bbsFollowMapper.followByUser(userId, followUserId) > 0;
        if (result) {
            applicationContext.publishEvent(new MessageAddEvent(this,userId,followUserId,2,"新关注"));
        }
        return result;
    }
}
