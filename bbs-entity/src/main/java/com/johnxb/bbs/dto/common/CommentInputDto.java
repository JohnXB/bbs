package com.johnxb.bbs.dto.common;

import com.johnxb.bbs.dto.RequestDto;

public class CommentInputDto extends RequestDto {
    private Integer page;

    private Integer pageSize;

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
