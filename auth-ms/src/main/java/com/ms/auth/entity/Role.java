package com.ms.auth.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = { "roleName" })
public class Role implements Serializable {

    private Long id;
    private String roleName;
}
