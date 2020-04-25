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
@AllArgsConstructor
public class AuthenticationFailureResponse {

    private Integer status;

    private String message;

    public AuthenticationFailureResponse() {
        this.status = HttpStatus.UNAUTHORIZED.value();
        this.message = "用户名密码错误！";
    }
}
