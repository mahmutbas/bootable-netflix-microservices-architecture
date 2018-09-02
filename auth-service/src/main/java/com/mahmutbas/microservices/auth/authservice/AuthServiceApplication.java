package com.mahmutbas.microservices.auth.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    //to test
    //http://localhost:8862/auth
    //Content-Type in the headers is assigned to application/json
    //body
    //{
    //	"username":"admin",
    //	"password":"passwd"
    //}
    // then post it. response header will include token
    // tooken with Auth with Bearer token
}
