package com.template.service;

import com.template.model.User;
import com.template.repository.UserRepository;
import com.template.security.JwtTokenProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserRepository userRepository;
    private final JwtTokenProvider tokenProvider;

    private static final String ROLE_USER = "ROLE_USER";

    public AuthenticationServiceImpl(AuthenticationManagerBuilder authenticationManagerBuilder,
                                     UserRepository userRepository,
                                     JwtTokenProvider tokenProvider) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public Optional<User> register(User user) {
        final String userName = user.getUserName();
        if (userRepository.findByUserName(userName).isPresent()) {
            return Optional.empty();
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User toSaveUser = User.builder()
                .id(UUID.nameUUIDFromBytes(userName.getBytes()))
                .userName(user.getUserName())
                .password(encoder.encode(user.getPassword()))
                .email(user.getEmail())
                .accountExpiredDate(LocalDate.now().plusYears(20))
                .credentialsExpiredDate(LocalDate.now().plusMonths(3))
                .locked(false)
                .active(true)
                .roles(ROLE_USER)
                .lastPasswordResetDate(LocalDate.now())
                .build();
        return Optional.of(userRepository.persist(toSaveUser));
    }

    @Override
    public String login(String userName, String password, boolean rememberMe) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userName, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return tokenProvider.createToken(authentication, rememberMe);
    }

    @Override
    public String refresh(String oldToken) {

        return "";
    }
}
