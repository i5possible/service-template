package com.template.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "user",
        indexes = {@Index(columnList = "username")}
 )
public class User {

    @Id
    private UUID id;

    @Column(columnDefinition = "text")
    private String userName;

    @Column(columnDefinition = "text")
    private String password;

    @Column(columnDefinition = "text")
    private String email;

    @Column
    private LocalDate lastPasswordResetDate;

    @Column(columnDefinition = "text[]")
    private List<String> roles;

    @Column
    private LocalDate accountExpiredDate;

    @Column(columnDefinition = "bool default false")
    private boolean locked;

    @Column
    private LocalDate credentialsExpiredDate;

    @Column(columnDefinition = "bool default false")
    private boolean active;
}
