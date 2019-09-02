package com.imdb.api.model.entity;

import com.imdb.api.security.domain.enumeration.AuthRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private int age;

    @Column
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = AuthRole.class, fetch = FetchType.EAGER)
    private Collection<AuthRole> roles = new ArrayList<>();

}
