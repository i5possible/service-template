package com.template.security.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 851788096@qq.com
 * @date 2020/4/18
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessDeniedResponse {

    private Integer status;

    private String message;

}
