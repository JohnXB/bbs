package com.johnxb.bbs.service;

import com.johnxb.bbs.entity.AuthUser;
import com.johnxb.bbs.utils.exception.BusinessException;

public interface AuthUserService {

    /**
     * @param username
     * @return AuthUser
     * @author johnxiao
     */
    AuthUser findByUserName(String username);

    /**
     * @param user(username,pass)
     * @return 用户
     */
    AuthUser signIn(AuthUser user);

    /**
     * @return 当前用户
     */
    AuthUser currentUser();

    /**
     * @param user
     * @return 结果
     */
    String register(AuthUser user) throws BusinessException;

}
