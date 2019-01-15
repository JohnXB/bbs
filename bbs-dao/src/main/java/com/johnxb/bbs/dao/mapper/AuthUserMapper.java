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
     */
    AuthUser selectBySignIn(AuthUser user);

    /**
     * @param user
     * @return true or false
     */
    Integer refreshToken(AuthUser user);

}