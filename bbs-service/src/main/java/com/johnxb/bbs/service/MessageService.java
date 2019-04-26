package com.johnxb.bbs.service;

import com.johnxb.bbs.dto.message.MessageDto;
import com.johnxb.bbs.entity.BbsMessage;
import com.johnxb.bbs.event.MessageAddEvent;

import java.util.List;

/**
 * author johnxiao
 */
public interface MessageService {
    List<MessageDto> getMessagesByUser(Integer user);

    Integer readMessages(Integer[] messageIds, Integer userId);

    Integer delMessages(Integer[] messageIds, Integer userId);

    Integer newArticleMessage(MessageAddEvent messageAddEvent);
    Integer newLikeMessage(MessageAddEvent messageAddEvent);
    Integer newCommentMessage(MessageAddEvent messageAddEvent);
    Integer newFollowMessage(MessageAddEvent messageAddEvent);
    Integer newExamineMessage(MessageAddEvent messageAddEvent);
}
