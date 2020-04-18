package com.template.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author lianghongbuaa@gmail.com
 */
@Getter
@Setter
@MappedSuperclass
public class EntityBase {

    @CreationTimestamp
    @Column(nullable = false, name = "create_timestamp", columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createTimestamp;

    @UpdateTimestamp
    @Column(nullable = false, name = "update_timestamp", columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updateTimestamp;
}
