package com.template;

import com.template.repository.RepositoryBaseImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author lianghongbuaa@gmail.com
 */
@Configuration
@EnableJpaRepositories(repositoryBaseClass = RepositoryBaseImpl.class)
public class ApplicationConfiguration {

}
