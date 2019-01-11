package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.AuthRolePermissions;
import java.util.List;

public interface AuthRolePermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthRolePermissions record);

    AuthRolePermissions selectByPrimaryKey(Integer id);

    List<AuthRolePermissions> selectAll();

    int updateByPrimaryKey(AuthRolePermissions record);
}