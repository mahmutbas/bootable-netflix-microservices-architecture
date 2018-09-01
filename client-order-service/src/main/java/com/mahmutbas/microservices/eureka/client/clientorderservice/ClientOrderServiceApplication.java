package com.mahmutbas.microservices.eureka.client.clientorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientOrderServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ClientOrderServiceApplication.class, args);
    }
}

//@EnableEurekaClient inherits @EnableDiscoveryClient. it makes so eureka client.