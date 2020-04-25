package com.template.security.authentication;

import org.springframework.security.core.AuthenticationException;

public class UserNamePasswordErrorException extends AuthenticationException {
    private static final long serialVersionUID = 5022575393500654459L;

    UserNamePasswordErrorException(String message) {
        super(message);
    }
}
