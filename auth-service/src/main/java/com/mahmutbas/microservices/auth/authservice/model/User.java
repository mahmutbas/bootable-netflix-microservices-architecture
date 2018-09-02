package com.mahmutbas.microservices.auth.authservice.model;

import lombok.Data;

@Data
public class User
{
    private Long id;
    private String username, password;
    private String role;

    public User(Long id, String username, String password, String role)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
