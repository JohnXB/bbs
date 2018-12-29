package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.entity.AuthUser;
import com.johnxb.bbs.service.AuthUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Override
    public AuthUser findByUserName(String username) {
//        测试数据
        AuthUser user = new AuthUser();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("ROLE_USER");
        user.setId(1);
        user.setUsername("john");
        user.setPassword("123456");
        user.setMail("4081063");
        user.setRoles(strings);
        return user;
    }
    @Override
    public boolean signUp(AuthUser user) {
//        List<String> usernameList = authUserMapper.checkByUsername(user.getUsername());
//        if (usernameList.size() > 0) {
//            return false;
//        }
//        user.setAvatar("aaa");
////        加密
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        user.setPassword(encoder.encode(user.getPassword().trim()));
//        user.setCurrentToken(generateToken(user));
//        int id = authUserMapper.insert(user);
//        userRolesMapper.insertUserRole(user.getId(), 2);
        return 1>0;

    }

    public AuthUser signIn(AuthUser user) {
        if (user.getPassword().equals("000000")) {
            ArrayList<String> strings = new ArrayList<>();
            strings.add("USER");
            user.setId(1);
            user.setUsername("john");
            user.setMail("4081063");
            user.setRoles(strings);
            user.setCurrentToken(generateToken(user));
            return user;
        }
        return null;
    }

   private String generateToken(AuthUser user) {
        return Jwts.builder()
                .claim("id", user.getId())   //设置payload的键值对
                .claim("username", user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secret") //采用什么算法是可以自己选择的，不一定非要采用HS512
                .compact();
    }
}
