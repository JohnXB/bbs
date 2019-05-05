package com.johnxb.bbs.service;

import com.johnxb.bbs.dto.auth.ChangePassInputDto;
import com.johnxb.bbs.entity.AuthUser;
import com.johnxb.bbs.utils.exception.BusinessException;

import java.util.List;

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
    AuthUser login(AuthUser user);

    /**
     * @param user
     * @return 管理员
     */
    AuthUser adminLogin(AuthUser user);

    /**
     * @return 当前用户
     */
    AuthUser currentUser();

    /**
     * @param user
     * @return 结果
     */
    String register(AuthUser user) throws BusinessException;

    Boolean changePass(ChangePassInputDto changePassInputDto,String username) throws BusinessException;

    List<AuthUser> searchByQuery(String query);
}
