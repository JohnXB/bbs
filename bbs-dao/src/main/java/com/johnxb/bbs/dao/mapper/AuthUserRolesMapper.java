package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.AuthUserRoles;
import java.util.List;

public interface AuthUserRolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthUserRoles record);

    AuthUserRoles selectByPrimaryKey(Integer id);

    List<AuthUserRoles> selectAll();

    int updateByPrimaryKey(AuthUserRoles record);
}