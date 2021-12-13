package com.cart.shopping.service;

import com.cart.shopping.cart.Cart;
import com.cart.shopping.model.Admin;
import com.cart.shopping.model.Customer;
import com.cart.shopping.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface cartService {
    void addProductToCartByCustomer(Long id, Product product);
    void addProductToCartByAdmin(Long id, Product product);
    void removeProductsFromCartByCustomer(Long id, Product product);
    void removeProductsFromCartByAdmin(Long id, Product product);
    List<Product> checkAllTheProductsInTheCartByCustomer(Long id);
    List<Product> checkAllTheProductsInTheCartByAdmin(Long id);
    BigDecimal calculatePrice();
    int totalNumberOfItems();
    BigDecimal calculatingPurchase(Long id);
}
