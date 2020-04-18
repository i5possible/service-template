package com.template.response;

import com.template.model.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * @author 851788096@qq.com
 * @date 2020/4/18
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Example2Response extends EntityBase {

    private UUID id;

    private String stringColumn;

    private String textColumn;

    private BigDecimal decimalColumn;

    private Date dateColumn;

    private Integer integerColumn;

    private Float floatColumn;


}
