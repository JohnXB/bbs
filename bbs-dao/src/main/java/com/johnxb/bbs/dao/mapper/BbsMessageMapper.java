package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.dto.message.MessageDto;
import com.johnxb.bbs.entity.BbsMessage;
import com.johnxb.bbs.event.MessageAddEvent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsMessageMapper {
    List<MessageDto> selectByUserId(@Param("userId") Integer userId);

    Integer readMessages(@Param("messageIds") Integer[] messageIds, @Param("userId") Integer userId);

    Integer delMessages(@Param("messageIds") Integer[] messageIds, @Param("userId") Integer userId);

    //新消息
    Integer newArticleMessage(MessageAddEvent messageAddEvent);

    Integer newLikeMessage( MessageAddEvent messageAddEvent);

    Integer newCommentMessage(MessageAddEvent messageAddEvent);

    Integer newFollowMessage(MessageAddEvent messageAddEvent);

    Integer newExamineMessage(MessageAddEvent messageAddEvent);
}