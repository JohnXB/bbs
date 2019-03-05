package com.johnxb.bbs.api.security;

import com.johnxb.bbs.utils.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
//        JSONResult jsonResult = new JSONResult();
//        JSONObject jsonObject = new JSONObject();

        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            final String authToken = authHeader.substring(tokenHead.length()); // The part after "Bearer "
            if (jwtTokenUtil.isTokenExpired(authToken)) {
                //登录信息已过期，请重新登陆
                throw new AccessDeniedException("登录信息已过期，请重新登陆");
            } else
                throw new AccessDeniedException("令牌有误");
        } else
            throw new AccessDeniedException("令牌有误");
//        httpServletResponse.getWriter().println(jsonObject.toJSONString(jsonResult));
    }
}