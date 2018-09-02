package com.mahmutbas.microservices.auth.authservice.security;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class JwtConfig
{
    @Value("${security.jwt.uri:/auth/**}")
    private String Uri;

    @Value("${security.jwt.header:Authorization}")
    private String header;

    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;

    @Value("${security.jwt.expiration:#{12*60*60}}")
    private int expiration;

    @Value("${security.jwt.secret:MahmutBas}")
    private String secret;
}
