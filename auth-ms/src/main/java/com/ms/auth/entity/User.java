package com.ms.auth.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(of = { "id" })
public class User implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String password;

    @Getter
    private Set<Role> roles = new HashSet<>();

}
