package com.template.service;

import com.template.model.User;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
