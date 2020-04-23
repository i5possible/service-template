package com.template.model.mapper;

import com.template.model.User;
import com.template.resource.UserResource;
import com.template.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/23
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    User mapResourceToModel(UserResource userResource);

    UserResponse mapModelToResponse(User user);
}
