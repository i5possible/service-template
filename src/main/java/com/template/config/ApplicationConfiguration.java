package com.template.config;

import com.google.common.collect.Lists;
import com.template.repository.RepositoryBaseImpl;
import com.template.security.jwt.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;

/**
 * @author lianghongbuaa@gmail.com
 */
@Configuration
@EnableJpaRepositories(repositoryBaseClass = RepositoryBaseImpl.class, basePackages = "com.template.repository")
@EnableConfigurationProperties(value = {JwtProperties.class})
@EnableSwagger2
public class ApplicationConfiguration {

    @Bean
    public Docket documentation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.template.api"))
                .build()
                .protocols(new HashSet<String>(Lists.newArrayList("http")))
                .pathMapping("/")
                .apiInfo(apiInfo());
    }

    @Bean
    public UiConfiguration uiConfig(){
        return UiConfigurationBuilder.builder().build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("service-template API")
                .description("service-template description")
                .version("1.0")
                .build();
    }
}
