package com.johnxb.bbs.dto.Common;

import com.johnxb.bbs.dto.ResponseDto;

public class TagOutputDto extends ResponseDto {
    private Integer id;

    private String tagName;

    private String introduce;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
