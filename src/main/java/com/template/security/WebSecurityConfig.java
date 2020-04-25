package com.template.security;

import com.template.security.jwt.JwtAuthenticationTokenFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Value("${security.use-session}")
    private Boolean useSession;

    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandlerImpl;

    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    public WebSecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService, JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        log.info("use-session:" + useSession);
        if (!useSession) {
            httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            httpSecurity
                    .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        }

        httpSecurity.csrf().disable();

        httpSecurity.formLogin(form -> form
                .loginPage("/login.html")
                .loginProcessingUrl("/api/Authentication/login"));

        httpSecurity.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandlerImpl);

        httpSecurity
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/v2/**",
                        "/swagger-resources/**",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated();

        httpSecurity.headers().cacheControl();
    }
}

