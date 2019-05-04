package com.johnxb.bbs.event;

import org.springframework.context.ApplicationEvent;

public class AddCountEvent  extends ApplicationEvent {
    private Integer belongId;
    //    1评论加 2评论减 3点赞 4取消点赞
    private Integer type;
    private Integer belongType;//点赞
    public AddCountEvent(Object source, Integer belongId, Integer type) {
        super(source);
        this.belongId = belongId;
        this.type = type;
    }

    //点赞构造方法
    public AddCountEvent(Object source, Integer belongId, Integer belongType, Integer type) {
        super(source);
        this.belongId = belongId;
        this.type = type;
        this.belongType = belongType;
    }
    public Integer getBelongId() {
        return belongId;
    }

    public Integer getType() {
        return type;
    }

    public Integer getBelongType() {
        return belongType;
    }
}