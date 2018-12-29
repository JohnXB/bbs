package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.entity.AuthUser;
import com.johnxb.bbs.service.AuthUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Override
    public AuthUser findByUserName(String username) {
        AuthUser user = new AuthUser();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("USER");
        user.setId(1);
        user.setUsername("john");
        user.setPassword("123456");
        user.setMail("4081063");
        user.setRoles(strings);
        return user;
    }
}
