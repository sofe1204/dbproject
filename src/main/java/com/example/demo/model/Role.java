package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {


       Client,
       ROLE_CLIENT
, ROLE_EMPLOYEE;

    @Override
    public String getAuthority() {
        return name();
    }


}
