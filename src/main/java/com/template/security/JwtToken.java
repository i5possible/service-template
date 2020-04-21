package com.template.security;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

public class JwtToken {
    private String idToken;

    public JwtToken(String idToken) {
        this.idToken = idToken;
    }

    @JsonProperty("id_token")
    String getIdToken() {
        return idToken;
    }

    void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}
