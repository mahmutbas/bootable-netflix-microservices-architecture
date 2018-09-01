package com.mahmutbas.microservices.eureka.client.clientorderservice.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CustomerOrder
{
    private Long id;
    private String productName;
    private LocalDateTime orderDate;
    private BigDecimal productPrice;

    public CustomerOrder(Long id, String productName, LocalDateTime orderDate, BigDecimal productPrice)
    {
        this.id = id;
        this.productName = productName;
        this.orderDate = orderDate;
        this.productPrice = productPrice;
    }
}
