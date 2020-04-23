package com.template.service;

import com.template.model.User;

import java.util.Optional;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

public interface AuthenticationService {
    /**
     * @param userToAdd
     * @return
     */
    Optional<User> register(User userToAdd);

    /**
     * @param userName
     * @param password
     * @param rememberMe
     * @return
     */
    String login(String userName, String password, boolean rememberMe);

    /**
     * @param oldToken
     * @return
     */
    String refresh(String oldToken);
}
