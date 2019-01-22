package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.AuthUserRoles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthUserRolesMapper {
    /**
     * @param userId
     * @param roleId
     * @return 结果
     */
    Integer insertUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
}