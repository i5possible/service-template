package com.template.repository;

import com.template.model.User;

import java.util.Optional;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

public interface UserRepositoryExtension {

    Optional<User> findByUserName(String userName);
}
