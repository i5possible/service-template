package com.template.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/18
 */

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "example" )
public class Example extends EntityBase {

    @Id
    private UUID id;

    @Column(columnDefinition = "text")
    private String name;

    @Column(columnDefinition = "numeric")
    private BigDecimal height;

    private Integer age;
}
