package com.johnxb.bbs.service;

import com.johnxb.bbs.entity.AuthUser;

public interface AuthUserService {

    /**
     * @param username
     * @return AuthUser
     * @author johnxiao
     */
    AuthUser findByUserName(String username);

    /**
     * @param user
     * @return 注册结果
     * @author johnxiao
     */
    boolean signUp(AuthUser user);

    /**
     * @param user(username,pass)
     * @return 用户
     */
    AuthUser signIn(AuthUser user);


}
