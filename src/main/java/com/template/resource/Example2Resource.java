package com.template.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 851788096@qq.com
 * @date 2020/4/18
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Example2Resource{

    private String id;

    private String stringColumn;

    private String textColumn;

    private BigDecimal decimalColumn;

    private Date dateColumn;

    private Integer integerColumn;

    private Float floatColumn;


}
