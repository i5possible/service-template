package com.template.security.authorization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author 851788096@qq.com
 * @date 2020/4/18
 */

@Data
@Builder
@AllArgsConstructor
public class AccessDeniedResponse {

    private Integer status;

    private String message;

    public AccessDeniedResponse() {
        this.status = HttpStatus.FORBIDDEN.value();
        this.message = "很抱歉，您没有该访问权限";
    }
}
