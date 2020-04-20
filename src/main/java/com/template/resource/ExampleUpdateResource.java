package com.template.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/18
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExampleUpdateResource {
    @NotNull
    private String id;
    private String name;
    private BigDecimal height;
    private Integer age;
}

