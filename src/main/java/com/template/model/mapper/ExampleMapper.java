package com.template.model.mapper;

import com.template.model.Example;
import com.template.resource.ExampleResource;
import com.template.response.ExampleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/18
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExampleMapper {

    ExampleMapper EXAMPLE_MAPPER = Mappers.getMapper(ExampleMapper.class);

    ExampleResponse mapToResponse(Example example);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    Example mapResourceToModel(ExampleResource exampleResource);
}
