package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.AuthUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthUserMapper {
    /**
     * @param username
     * @return user
     */
    AuthUser selectByUsername(@Param("username") String username);

    /**
     * @param user
     * @return user
     * 用户登录
     */
    AuthUser selectByLogin(AuthUser user);

    /**
     * @param user
     * @return 管理员登陆
     */
    AuthUser selectByAdminLogin(AuthUser user);

    /**
     * @param user
     * @return true or false
     */
    Integer refreshToken(AuthUser user);

    /**
     * @param user
     * @return true or false
     */
    Integer register(AuthUser user);

    String getPass(@Param("username") String username);

    Integer changePass(@Param("newPass") String newPss, @Param("username") String username);
//    /**
//     * @param username
//     * @return true or false
//     */
//    Integer checkUsername(@Param("username") String username);
}