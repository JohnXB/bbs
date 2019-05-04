package com.johnxb.bbs.listener;

import com.johnxb.bbs.event.AddCountEvent;
import com.johnxb.bbs.service.ArticleService;
import com.johnxb.bbs.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

public class AddCountListener implements ApplicationListener<AddCountEvent> {
    private final ArticleService articleService;
    private final LikeService likeService;

    @Autowired
    public AddCountListener(ArticleService articleService, LikeService likeService) {
        this.articleService = articleService;
        this.likeService = likeService;
    }

    @Override
    public void onApplicationEvent(AddCountEvent addCountEvent) {
        //    1评论加 2评论减 3文章点赞 4文章取消点赞 5评论点赞 6评论取消点赞...
        int type = addCountEvent.getType();
        switch (type) {
            case 1:
                articleService.commentNumAdd(addCountEvent.getBelongId());
                break;
            case 2:
                articleService.commentNumReduce(addCountEvent.getBelongId());
                break;
            case 3:
                likeService.addLikeCount(addCountEvent.getBelongId(), addCountEvent.getBelongType());
                break;
            case 4:
                likeService.reduceLikeCount(addCountEvent.getBelongId(), addCountEvent.getBelongType());
                break;
            default:
                break;
        }
    }
}
