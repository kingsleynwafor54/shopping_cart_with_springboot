package com.cart.shopping.service;

import com.cart.shopping.model.Admin;
import com.cart.shopping.model.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface dataService {
    Customer registerCustomer(Customer customer);
    Admin registerAdmin(Admin admin);
    List<Customer> gettingAllCustomers();
    void removeCustomer(Long id);
    void removeAdmin(Long id);
    List<Admin> getAllAdmin();
}

