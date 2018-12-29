package com.johnxb.bbs.service;

import com.johnxb.bbs.entity.AuthUser;

public interface AuthUserService {

    /**
     * @param username
     * @return AuthUser
     * @author johnxiao
     */
    AuthUser findByUserName(String username);
}
