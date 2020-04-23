package com.template.config;

import com.template.repository.RepositoryBaseImpl;
import com.template.security.JwtProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author lianghongbuaa@gmail.com
 */
@Configuration
@EnableJpaRepositories(repositoryBaseClass = RepositoryBaseImpl.class, basePackages = "com.template.repository")
@EnableConfigurationProperties(value = {JwtProperties.class})
public class ApplicationConfiguration {

}
