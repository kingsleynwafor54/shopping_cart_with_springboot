package com.cart.shopping.model;

import lombok.Data;

@Data
public class Admin {
    private Long id;
    private String firstName;
    private String lastName;

    public Admin(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
