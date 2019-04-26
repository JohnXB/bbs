package com.johnxb.bbs.event;

import org.springframework.context.ApplicationEvent;

public class AddCountEvent  extends ApplicationEvent {
    private Integer belongId;
    //    1评论加 2评论减 3点赞文章 4取消点赞
    private Integer type;

    public AddCountEvent(Object source, Integer belongId, Integer type) {
        super(source);
        this.belongId = belongId;
        this.type = type;
    }

    public Integer getBelongId() {
        return belongId;
    }

    public Integer getType() {
        return type;
    }

}