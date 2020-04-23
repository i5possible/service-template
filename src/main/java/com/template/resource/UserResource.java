package com.template.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private String userName;
    private String password;
    private String email;
    private boolean rememberMe;
}
