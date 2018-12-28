package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.UserRoles;
import java.util.List;

public interface UserRolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoles record);

    UserRoles selectByPrimaryKey(Integer id);

    List<UserRoles> selectAll();

    int updateByPrimaryKey(UserRoles record);
}