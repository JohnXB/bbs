package com.johnxb.bbs.api.security;

import com.alibaba.fastjson.JSONObject;
import com.johnxb.bbs.api.utils.JSONResult;
import com.johnxb.bbs.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
        httpServletResponse.setContentType("text/html;charset=utf-8");
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        JSONResult jsonResult = new JSONResult();
        JSONObject jsonObject = new JSONObject();
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            final String authToken = authHeader.substring(tokenHead.length()); // The part after "Bearer "
            if (jwtTokenUtil.isTokenExpired(authToken)) {
                //登录信息已过期，请重新登陆
                jsonResult.setMessage("登录信息已过期，请重新登陆");
            }
        } else
            jsonResult.setMessage("身份校验错误");
        httpServletResponse.getWriter().println(jsonObject.toJSONString(jsonResult));
    }
}