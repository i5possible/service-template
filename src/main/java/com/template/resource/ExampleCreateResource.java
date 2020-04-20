package com.template.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/18
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExampleCreateResource {
    private String id;
    private String name;
    private BigDecimal height;
    private Integer age;
}

