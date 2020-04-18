package com.template.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author lianghongbuaa@gmail.com
 */
@NoRepositoryBean
public interface RepositoryBase<T, ID extends Serializable> extends JpaRepository<T, ID> {

    <S extends T> S persist(S entity);
}
