package com.cart.shopping.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String Id;
    private String productName;
    private BigDecimal cost;

    public Product(String id, String productName, BigDecimal cost) {
        Id = id;
        this.productName = productName;

        this.cost = cost;
    }

    public Product() {

    }

    @Override
    public String toString() {
        return "Product{" +
                "Id='" + Id + '\'' +
                ", productName='" + productName + '\'' +
                ", cost=" + cost +
                '}';
    }
}
