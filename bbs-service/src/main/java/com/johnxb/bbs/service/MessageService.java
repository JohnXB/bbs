package com.johnxb.bbs.service;

import com.johnxb.bbs.entity.BbsMessage;

import java.util.List;

/**
 * author johnxiao
 */
public interface MessageService {
    List<BbsMessage> getMessagesByUser(Integer user, Byte messageType);
}
