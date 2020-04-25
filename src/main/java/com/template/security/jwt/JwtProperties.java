package com.template.security.jwt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/23
 */

@Data
@ConfigurationProperties("jwt")
public class JwtProperties {

    private String authoritiesKey;

    private String base64Secret;

    private Long tokenValidityInSeconds;

    private Long tokenValidityInSecondsForRememberMe;

    private String tokenHead;

    private String header;

}
