package com.cart.shopping.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Customer {

    private Long id;
   private String firstName;
   private String lastName;
   private BigDecimal Balance;


    public Customer(Long id, String firstName, String lastName, BigDecimal balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Balance = balance;
    }
}
