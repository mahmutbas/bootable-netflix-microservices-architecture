package com.mahmutbas.microservices.client.clientcustomerservice.controller;

import com.mahmutbas.microservices.client.clientcustomerservice.model.Customer;
import com.mahmutbas.microservices.client.clientcustomerservice.model.CustomerOrder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environments;

//    @Resource
//    private EurekaClient eurekaClient;

    @RequestMapping("/")
    public String rootPath()
    {
        return "Customer Service running on port: " + environments.getProperty("local.server.port");
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/{id}")
    public Customer getCustomer(@PathVariable final Long id)
    {
        LOGGER.info("Creating customer object ... ");

        Customer customer = Customer.defaultCustomer(id);

        //Lets call another rest service
        List<CustomerOrder> orders = restTemplate.getForObject("http://order-service/orders/", List.class);
        customer.setOrders(orders);
        return customer;

        // Also we can get new instance from eureka server and we can get information about instance
        //        InstanceInfo myInstance = eurekaClient.getNextServerFromEureka("order-service",false);
        //        System.out.println("----------"+myInstance.getHomePageUrl());
    }

    //will run only for admin role
    @RequestMapping("/admin")
    public String rootAdmin() {
        return "This is the admin area of Gallery service running at port: " + environments.getProperty("local.server.port");
    }

    // a fallback method to be called if failure happened
    public Customer fallback(Long customerId, Throwable hystrixCommand) {
        return Customer.defaultCustomer(customerId);
    }
}
