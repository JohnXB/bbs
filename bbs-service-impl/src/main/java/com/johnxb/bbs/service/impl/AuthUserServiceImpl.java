package com.johnxb.bbs.service.impl;

import com.johnxb.bbs.dao.mapper.AuthUserMapper;
import com.johnxb.bbs.dao.mapper.AuthUserRolesMapper;
import com.johnxb.bbs.entity.AuthUser;
import com.johnxb.bbs.enumeration.DuplicateKeyExceptionEnum;
import com.johnxb.bbs.service.AuthUserService;
import com.johnxb.bbs.utils.exception.BusinessException;
import com.johnxb.bbs.utils.security.JwtTokenUtil;
import com.johnxb.bbs.utils.security.JwtUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
    private final AuthUserRolesMapper authUserRolesMapper;

    @Autowired
    public AuthUserServiceImpl(AuthUserMapper authUserMapper, JwtTokenUtil jwtTokenUtil, AuthUserRolesMapper authUserRolesMapper) {
        this.authUserMapper = authUserMapper;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authUserRolesMapper = authUserRolesMapper;
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

    //当前用户
    @Override
    public AuthUser currentUser() {
        JwtUser jwtUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findByUserName(jwtUser.getUsername());
    }

    //注册
    @Override
    public String register(AuthUser user) throws BusinessException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword().trim()));

        try {
            authUserMapper.register(user);
        } catch (DuplicateKeyException e) {
            String message = e.getCause().getMessage();
            message = message.substring(message.lastIndexOf(" ") + 1).replace("'", "");
            if (message.equals(DuplicateKeyExceptionEnum.PHONE.getValue()))
                throw new BusinessException("注册失败:" + DuplicateKeyExceptionEnum.PHONE.getName() + "已被占用");
            else if (message.equals(DuplicateKeyExceptionEnum.MAIL.getValue()))
                throw new BusinessException("注册失败:" + DuplicateKeyExceptionEnum.MAIL.getName() + "已被占用");
            else if (message.equals(DuplicateKeyExceptionEnum.USERNAME.getValue()))
                throw new BusinessException("注册失败:" + DuplicateKeyExceptionEnum.USERNAME.getName() + "已被占用");
            throw new BusinessException("注册失败");

        }
        try {
            Integer result = authUserRolesMapper.insertUserRole(user.getId(), 1);
            if (result > 0)
                return "注册成功";
        } catch (Exception e) {
            return "注册失败";
        }

        //添加用户角色关系；
        return "注册失败";
    }

    /**
     * @param token
     * @return
     * 验证token是否过期
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
     * 生成token
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
