package com.template.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * @author 851788096@qq.com
 * @date 2020/4/18
 */

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "example2" )
public class Example2 extends EntityBase {

    @Id
    private UUID id;

    @Column(columnDefinition = "varchar")
    private String stringColumn;

    @Column(columnDefinition = "text")
    private String textColumn;

    @Column(columnDefinition = "decimal(20,2)")
    private BigDecimal decimalColumn;

    @Column(columnDefinition = "date")
    private Date dateColumn;

    @Column(columnDefinition = "int")
    private Integer integerColumn;

    @Column(columnDefinition = "float4")
    private Float floatColumn;


}
