package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.AuthUser;
import java.util.List;

public interface AuthUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthUser record);

    AuthUser selectByPrimaryKey(Integer id);

    List<AuthUser> selectAll();

    int updateByPrimaryKey(AuthUser record);
}