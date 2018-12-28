package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.RolePermissions;
import java.util.List;

public interface RolePermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermissions record);

    RolePermissions selectByPrimaryKey(Integer id);

    List<RolePermissions> selectAll();

    int updateByPrimaryKey(RolePermissions record);
}