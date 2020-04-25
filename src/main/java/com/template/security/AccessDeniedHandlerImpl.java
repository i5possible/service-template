package com.template.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.template.security.response.AccessDeniedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json;charset=utf-8");
        AccessDeniedResponse accessDeniedResponse = new AccessDeniedResponse(HttpStatus.FORBIDDEN.value(),"很抱歉，您没有该访问权限");
        response.getWriter().write(mapper.writeValueAsString(accessDeniedResponse));
    }
}
