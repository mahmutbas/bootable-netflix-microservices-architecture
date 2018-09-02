package com.mahmutbas.microservices.zuul.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient // zuul also eureka client
@EnableZuulProxy
public class ZuulServerApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

    // for try
    //http://localhost:8862/customers/1
    //http://localhost:8862/customers
    //http://localhost:8862/customers will get with differend port number. Thanks to Ribbon (load balancer)
}
