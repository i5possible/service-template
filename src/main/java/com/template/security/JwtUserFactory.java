package com.template.security;

import com.template.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return JwtUser.builder()
                .id(user.getId().toString())
                .username(user.getUserName())
                .password(user.getPassword())
                .email(user.getEmail())
                .authorities(mapToGrantedAuthorities(Arrays.asList(user.getRoles().split(","))))
                .lastPasswordResetDate(user.getLastPasswordResetDate())
                .accountExpiredDate(user.getAccountExpiredDate())
                .credentialsExpiredDate(user.getCredentialsExpiredDate())
                .locked(user.isLocked())
                .active(user.isActive())
                .build();
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
