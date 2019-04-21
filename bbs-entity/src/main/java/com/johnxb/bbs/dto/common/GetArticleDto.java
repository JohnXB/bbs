package com.johnxb.bbs.dto.common;

import javax.validation.constraints.NotNull;

public class GetArticleDto {
    //显示文章方法，1按时间排序，2按推荐排序，3点赞排序，4表示草稿
    private Integer type;
    private Integer page;
    private Integer pageSize;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
