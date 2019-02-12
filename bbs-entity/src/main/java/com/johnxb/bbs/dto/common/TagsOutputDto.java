package com.johnxb.bbs.dto.common;

import com.johnxb.bbs.dto.ResponseDto;

public class TagsOutputDto extends ResponseDto {

    private Integer id;

    private String tagName;

    private byte[] icon;

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

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }
}
