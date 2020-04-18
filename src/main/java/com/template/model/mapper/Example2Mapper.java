package com.template.model.mapper;

import com.template.model.Example2;
import com.template.resource.Example2Resource;
import com.template.response.Example2Response;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author 851788096@qq.com
 * @date 2020/4/18
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface Example2Mapper {

    Example2Mapper EXAMPLE_2_MAPPER = Mappers.getMapper(Example2Mapper.class);

    Example2Response mapToResponse(Example2 example2);

    @Mapping(target = "id", expression = "java(example2Resource.getId()==null?java.util.UUID.randomUUID():java.util.UUID.fromString(example2Resource.getId()))")
    Example2 mapResourceToModel(Example2Resource example2Resource);
}
