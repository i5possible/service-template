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
    @Column(columnDefinition = "varchar(32)")
    private UUID unidId;

    @Column(columnDefinition = "varchar")
    private String sString;

    @Column(columnDefinition = "text")
    private String tText;

    @Column(columnDefinition = "decimal(20,2)")
    private BigDecimal height;

    @Column(columnDefinition = "date")
    private Date dDate;

    @Column(columnDefinition = "time")
    private Date dDatetime;

    @Column(columnDefinition = "int")
    private int iInt;

    @Column(columnDefinition = "float4")
    private float fFloat;


}
