package com.template.api;

import com.template.model.User;
import com.template.resource.UserResource;
import com.template.response.UserResponse;
import com.template.security.JwtProperties;
import com.template.security.JwtToken;
import com.template.security.JwtTokenProvider;
import com.template.service.AuthenticationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

import static com.template.model.mapper.UserMapper.USER_MAPPER;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final JwtTokenProvider tokenProvider;
    private final JwtProperties jwtProperties;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtTokenProvider tokenProvider,
                                    JwtProperties jwtProperties, AuthenticationManagerBuilder authenticationManagerBuilder, AuthenticationService authenticationService) {
        this.tokenProvider = tokenProvider;
        this.jwtProperties = jwtProperties;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtToken> authorize(@Valid @RequestBody UserResource userResource) {
        String jwt = authenticationService.login(userResource.getUserName(), userResource.getPassword(), userResource.isRememberMe());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(jwtProperties.getHeader(), jwtProperties.getTokenHead() + jwt);

        // TODO: write cookie
        return new ResponseEntity<>(new JwtToken(jwt), httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/register")
    public UserResponse register(@Valid @RequestBody UserResource userResource) {
        Optional<User> registeredUser = authenticationService.register(USER_MAPPER.mapResourceToModel(userResource));
        if(registeredUser.isPresent()) {
            return USER_MAPPER.mapModelToResponse(registeredUser.get());
        } else {
            throw new RuntimeException("User has been registered already.");
        }
    }

}
