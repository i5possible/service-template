package com.template.service;

import com.template.model.User;
import com.template.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    public AuthServiceImpl(
            AuthenticationManagerBuilder authenticationManagerBuilder,
            @Qualifier("jwtUserDetailsServiceImpl") UserDetailsService userDetailsService,
            UserRepository userRepository) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        final String userName = user.getUserName();
        if (userRepository.findByUserName(userName) != null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = user.getPassword();
        user.setPassword(encoder.encode(rawPassword));
        user.setLastPasswordResetDate(LocalDate.now());
        user.setRoles(List.of("ROLE_USER"));
        return userRepository.persist(user);
    }

    @Override
    public String login(String username, String password) {
//        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
//        final Authentication authentication = authenticationManager.authenticate(upToken);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        return JwtTokenUtil.generateToken(userDetails);
        return null;
    }

    @Override
    public String refresh(String oldToken) {
//        final String token = oldToken.substring(tokenHead.length());
//        Optional<String> username = JwtTokenUtil.getUserNameFromToken(token);
//        username.ifPresent(userName -> {
//                    JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(userName);
//                    if (JwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
//                        return JwtTokenUtil.refreshToken(token);
//                    }
//                }
//        );

        return null;
    }
}
