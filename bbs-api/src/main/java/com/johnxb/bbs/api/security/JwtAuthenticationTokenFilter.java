package com.johnxb.bbs.api.security;

import com.alibaba.fastjson.JSON;
import com.johnxb.bbs.api.utils.BusinessException;
import com.johnxb.bbs.security.JwtTokenUtil;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final String FILTER_APPLIED = "__spring_security_demoFilter_filterApplied";
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        //解决两次进入filter问题
        if (request.getAttribute(FILTER_APPLIED) != null) {
            chain.doFilter(request, response);
            return;
        }
        String authHeader = request.getHeader(this.tokenHeader);
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            final String authToken = authHeader.substring(tokenHead.length()); // The part after "Bearer "
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            logger.info("filter过滤到用户： " + username);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 找到user
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                // 验证token
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                            request));
                    logger.info("authenticated user " + username + ", setting security context");
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        request.setAttribute(FILTER_APPLIED, true);
        chain.doFilter(request, response);
    }

}
