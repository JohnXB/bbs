package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.dao.mapper.BbsMessageMapper;
import com.johnxb.bbs.entity.BbsMessage;
import com.johnxb.bbs.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    private final BbsMessageMapper bbsMessageMapper;

    @Autowired
    public MessageServiceImpl(BbsMessageMapper bbsMessageMapper) {
        this.bbsMessageMapper = bbsMessageMapper;
    }

    @Override
    public List<BbsMessage> getMessagesByUser(Integer userId) {
        return bbsMessageMapper.selectByUserId(userId);
    }
}
