package com.mahmutbas.microservices.client.clientcustomerservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Customer
{
    private Long id;
    private String fullName;
    private List<CustomerOrder> orders;

    public static Customer defaultCustomer(Long id)
    {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFullName("Mahmut Bas");
        return customer;
    }
}
