package com.mahmutbas.microservices.eureka.client.clientorderservice.controller;

import com.mahmutbas.microservices.eureka.client.clientorderservice.model.CustomerOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class OrderController
{
    //http://localhost:8181/orders
    @RequestMapping("/orders")
    public List<CustomerOrder> getAllOrders()
    {
        List<CustomerOrder> orderList = Arrays.asList(
                new CustomerOrder(1L, "Volvo", LocalDateTime.now(), new BigDecimal(350)),
                new CustomerOrder(2L, "BMW", LocalDateTime.now(), new BigDecimal(450)),
                new CustomerOrder(3L, "Mercedes", LocalDateTime.now(), new BigDecimal(500)));
        return orderList;
    }
}
