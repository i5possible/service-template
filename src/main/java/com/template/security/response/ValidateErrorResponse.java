package com.template.security.response;

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
@NoArgsConstructor
@AllArgsConstructor
public class ValidateErrorResponse {

    private Integer status;

    private String message;

    public ValidateErrorResponse(String message) {
        this.status = HttpStatus.UNAUTHORIZED.value();
        this.message = message;
    }
}
