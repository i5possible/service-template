package com.template.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

@Data
@Builder
@AllArgsConstructor
public class JwtUser implements UserDetails {
    private final String id;
    private final String username;
    private final String password;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;
    private final LocalDate lastPasswordResetDate;
    private final LocalDate accountExpiredDate;
    private final Boolean locked;
    private final LocalDate credentialsExpiredDate;
    private final Boolean active;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return LocalDate.now().isBefore(accountExpiredDate);
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return LocalDate.now().isBefore(credentialsExpiredDate);
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return active;
    }
}
