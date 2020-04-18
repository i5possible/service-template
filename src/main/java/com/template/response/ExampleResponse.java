package com.template.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/18
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExampleResponse {

    @Id
    private UUID id;

    @Column(columnDefinition = "text")
    private String name;

    @Column(columnDefinition = "numeric")
    private BigDecimal height;

    private Integer age;
}
