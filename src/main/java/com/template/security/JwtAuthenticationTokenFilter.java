package com.template.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final JwtTokenProvider tokenProvider;

    @Value("${jwt.header}")
    public static String header;

    @Value("${jwt.tokenHead}")
    public static String tokenHead;

    public JwtAuthenticationTokenFilter(@Qualifier("jwtUserDetailsServiceImpl") UserDetailsService userDetailsService,
                                        JwtTokenProvider tokenProvider) {
        this.userDetailsService = userDetailsService;
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {
        Optional<String> authToken = resolveToken(request);

        authToken.ifPresent(token -> {
            if (tokenProvider.validateToken(token)) {
                Authentication authentication = tokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                log.debug("set Authentication to security context for '{}'.", authentication.getName());
            } else {
                log.debug("no valid JWT token found.");
            }
        });

//        authToken.ifPresent(token -> {
//            Optional<String> username = JwtTokenUtil.getUserNameFromToken(token);
//            logger.info("checking authentication " + username);
//
//            if (username.isPresent()  && SecurityContextHolder.getContext().getAuthentication() == null) {
//                setSecurityContext(request, token, username.get());
//            }
//        });

        chain.doFilter(request, response);
    }

    private void setSecurityContext(HttpServletRequest request, String token, String userName) {
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
//
//        if (JwtTokenUtil.validateToken(token, userDetails)) {
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                    userDetails, null, userDetails.getAuthorities());
//            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//            logger.info("authenticated user " + userName + ", setting security context");
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
    }

    private Optional<String> resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(header);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(tokenHead)) {
            return Optional.of(bearerToken.substring(7));
        }
        return Optional.empty();
    }
}

