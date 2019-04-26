package com.johnxb.bbs.listener;

import com.johnxb.bbs.event.MessageAddEvent;
import com.johnxb.bbs.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener implements ApplicationListener<MessageAddEvent> {
    private final MessageService messageService;

    @Autowired
    public MessageListener(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void onApplicationEvent(MessageAddEvent messageAddEvent) {
        int type = messageAddEvent.getType();
        switch (type) {
            case 1:
                messageService.newCommentMessage(messageAddEvent);
                break;
            case 2:
                messageService.newFollowMessage(messageAddEvent);
                break;
            case 3:
                messageService.newArticleMessage(messageAddEvent);
                break;
            case 4:
                messageService.newLikeMessage(messageAddEvent);
                break;
            case 5:
                messageService.newExamineMessage(messageAddEvent);
                break;
            default:
                break;
        }
    }
}
