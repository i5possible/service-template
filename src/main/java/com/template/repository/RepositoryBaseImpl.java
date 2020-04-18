package com.template.repository;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lianghongbuaa@gmail.com
 */
@Transactional(readOnly = true)
public class RepositoryBaseImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements RepositoryBase<T, ID> {

    private final EntityManager entityManager;

    RepositoryBaseImpl(JpaEntityInformation<T, ID> entityInformation,
            EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public <S extends T> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }
}
