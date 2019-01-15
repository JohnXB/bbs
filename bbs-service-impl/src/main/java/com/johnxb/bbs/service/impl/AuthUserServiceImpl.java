package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.security.JwtTokenUtil;
import com.johnxb.bbs.security.JwtUser;
import com.johnxb.bbs.dao.mapper.AuthUserMapper;
import com.johnxb.bbs.entity.AuthUser;
import com.johnxb.bbs.service.AuthUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class AuthUserServiceImpl implements AuthUserService {

    private final AuthUserMapper authUserMapper;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthUserServiceImpl(AuthUserMapper authUserMapper, JwtTokenUtil jwtTokenUtil) {
        this.authUserMapper = authUserMapper;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    /**
     * @param username
     * @return user
     */
    @Override
    public AuthUser findByUserName(String username) {
        AuthUser authUser = authUserMapper.selectByUsername(username);
        return authUser;
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
        //Todo
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword().trim()));
        JwtUser jwtUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return 1 > 0;

    }

    @Override
    public AuthUser signIn(AuthUser user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pass = user.getPassword();
        user = authUserMapper.selectBySignIn(user);
        //密码验证,token生成与刷新
        if (user != null && encoder.matches(pass, user.getPassword())) {
            String token = user.getCurrentToken();
            if (token == null || validate(token)) {
                user.setCurrentToken(generateToken(user));
            }
            authUserMapper.refreshToken(user);
            return user;
        }
        return null;
    }

    @Override
    public AuthUser currentUser() {
        JwtUser jwtUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findByUserName(jwtUser.getUsername());
    }


    /**
     * @param token
     * @return
     * @
     */
    private Boolean validate(String token) {
        Date date;
        try {
            date = Jwts.parser()
                    .setSigningKey("secret")
                    .parseClaimsJws(token)
                    .getBody().getExpiration();
            return date.before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * @param user
     * @return token
     */
    private String generateToken(AuthUser user) {
        return Jwts.builder()
                .claim("id", user.getId())   //设置payload的键值对
                .claim("username", user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secret") //采用什么算法是可以自己选择的，不一定非要采用HS512
                .compact();
    }
}
