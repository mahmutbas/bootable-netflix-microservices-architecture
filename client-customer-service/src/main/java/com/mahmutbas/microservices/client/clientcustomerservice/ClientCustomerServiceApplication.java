package com.mahmutbas.microservices.client.clientcustomerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ClientCustomerServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ClientCustomerServiceApplication.class, args);
    }
}
