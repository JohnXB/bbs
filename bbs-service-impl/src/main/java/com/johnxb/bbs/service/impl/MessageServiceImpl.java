package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.dao.mapper.BbsMessageMapper;
import com.johnxb.bbs.dto.message.MessageDto;
import com.johnxb.bbs.entity.BbsMessage;
import com.johnxb.bbs.event.MessageAddEvent;
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
    public List<MessageDto> getMessagesByUser(Integer userId) {
        return bbsMessageMapper.selectByUserId(userId);
    }

    @Override
    public Integer readMessages(Integer[] messageIds, Integer userId) {
        return bbsMessageMapper.readMessages(messageIds, userId);
    }

    @Override
    public Integer delMessages(Integer[] messageIds, Integer userId) {
        return bbsMessageMapper.delMessages(messageIds, userId);
    }

    //   新消息
    @Override
    public Integer newArticleMessage(MessageAddEvent messageAddEvent) {
        return bbsMessageMapper.newArticleMessage(messageAddEvent);
    }

    @Override
    public Integer newLikeMessage(MessageAddEvent messageAddEvent) {
        return bbsMessageMapper.newLikeMessage(messageAddEvent);
    }

    @Override
    public Integer newCommentMessage(MessageAddEvent messageAddEvent) {
        return bbsMessageMapper.newCommentMessage(messageAddEvent);
    }

    @Override
    public Integer newFollowMessage(MessageAddEvent messageAddEvent) {
        return bbsMessageMapper.newFollowMessage(messageAddEvent);
    }

    @Override
    public Integer newExamineMessage(MessageAddEvent messageAddEvent) {
        return bbsMessageMapper.newExamineMessage(messageAddEvent);
    }
}
