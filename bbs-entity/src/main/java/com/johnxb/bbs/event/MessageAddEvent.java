package com.johnxb.bbs.event;


import org.springframework.context.ApplicationEvent;

public class MessageAddEvent extends ApplicationEvent {
    private Integer userId;
    private Integer belongId;
//    1新评论 2新关注 3新文章 4点赞 5审核结果
    private Integer type;
    private String content;

    public MessageAddEvent(Object source, Integer userId, Integer belongId, Integer type,
                           String content) {
        super(source);
        this.belongId = belongId;
        this.userId = userId;
        this.type = type;
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getBelongId() {
        return belongId;
    }

    public Integer getType() {
        return type;
    }

    public String getText() {
        return content;
    }
}
