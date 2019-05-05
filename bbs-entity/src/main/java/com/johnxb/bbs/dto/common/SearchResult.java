package com.johnxb.bbs.dto.common;

import com.johnxb.bbs.dto.ResponseDto;
import com.johnxb.bbs.dto.like.UserInfoDto;

import java.util.List;

public class SearchResult extends ResponseDto {
    private List<UserInfoDto> users;
    private List<GetArticleOutputDto> articles;

    public List<UserInfoDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfoDto> users) {
        this.users = users;
    }

    public List<GetArticleOutputDto> getArticles() {
        return articles;
    }

    public void setArticles(List<GetArticleOutputDto> articles) {
        this.articles = articles;
    }
}
