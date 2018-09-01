package com.mahmutbas.microservices.client.clientcustomerservice.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
