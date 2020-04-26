package com.template.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.template.resource.UserResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/26
 */

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private JwtProperties jwtProperties;
    private JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtProperties jwtProperties, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProperties = jwtProperties;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            UserResource loginUser = new ObjectMapper().readValue(request.getInputStream(), UserResource.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginUser.getUserName(),
                    loginUser.getPassword(),
                    new ArrayList<>())
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        // TODO: 处理 RememberMe
        String token = jwtTokenProvider.createToken(authResult, false);
        response.setHeader(jwtProperties.getHeader(), jwtProperties.getTokenHead() + token);

        // TODO: cookie 和 header 用一个就可以了
        Cookie cookie = new Cookie(jwtProperties.getTokenCookie(), token);
        cookie.setHttpOnly(true);
        cookie.setPath("/api");
        response.addCookie(cookie);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
    }
}
