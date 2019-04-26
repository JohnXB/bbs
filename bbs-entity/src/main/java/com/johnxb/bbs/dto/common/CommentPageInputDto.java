package com.johnxb.bbs.dto.common;

import com.johnxb.bbs.dto.RequestDto;

public class CommentPageInputDto extends RequestDto {
    //    created_at 或者 like_num排序
    private String sort;
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
