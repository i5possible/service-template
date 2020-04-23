package com.template.repository;

import com.template.model.User;

import java.util.UUID;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

public interface UserRepository extends RepositoryBase<User, UUID>, UserRepositoryExtension{
}
