package com.cart.shopping.customerTest;

import com.cart.shopping.model.Admin;
import com.cart.shopping.model.Customer;
import com.cart.shopping.model.Product;
import com.cart.shopping.repository.CustomerDao;
import com.cart.shopping.service.CartServiceImpl;
import com.cart.shopping.service.DataServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
@Slf4j
public class customerTest {

        @Autowired
        private DataServiceImpl dataService;
        @Autowired
        private CartServiceImpl cart;

        @Autowired
        private CustomerDao customerDao;

    @Test
    void testThatCustomerIsNotNull() {
        Customer customer = new Customer(1L, "Kingsley", "Chukwudi", new BigDecimal("2000"));
        assertNotNull(customer);
    }

    @Test
    void createCustomer() {
       Customer customer=new Customer(1L, "Kingsley", "Chukwudi", new BigDecimal("2000"));
       dataService.registerCustomer(customer);
        assertEquals(1, customerDao.totalNumberOfCustomers());
        customerDao=null;
        cart=null;
    }

    @Test
    void customerCanAddProductToCart() {
        Product product = new Product("1", "Sandine", new BigDecimal(1000));
        Customer customer=new Customer( 1L, "Kingsley", "Chukwudi", new BigDecimal("2000"));
        dataService.registerCustomer(customer);
        cart.addProductToCartByCustomer(1L, product);
        System.out.println(dataService.gettingAllCustomers());
        assertEquals(1, cart.totalNumberOfItems());
        customerDao=null;
        cart=null;
    }

    @Test
    void customerCanRemoveProduct() {
        Product product = new Product("1", "Sandine", new BigDecimal(1000));
        Product product2 = new Product("2", "SandineBread", new BigDecimal(1100));
        Customer customer=new Customer(1L, "Kingsley", "Chukwudi", new BigDecimal("2000"));
        dataService.registerCustomer(customer);
        cart.addProductToCartByCustomer(1L, product);
        cart.addProductToCartByCustomer(1L, product2);
        cart.addProductToCartByCustomer(1L, product);
        assertEquals(3, cart.totalNumberOfItems());
        cart.removeProductsFromCartByCustomer(1L, product);
        assertEquals(2, cart.totalNumberOfItems());
        cart=null;

    }

    @Test
    void calculatingAllTheProductsInTheCart() {
        Product product = new Product("1", "Sandine", new BigDecimal(1000));
        Product product2 = new Product("2", "SandineBread", new BigDecimal(1100));
        Customer customer=new Customer(1L, "Kingsley", "Chukwudi", new BigDecimal("2000"));
        dataService.registerCustomer(customer);
        cart.addProductToCartByCustomer(1L, product);
        cart.addProductToCartByCustomer(1L, product2);
        cart.addProductToCartByCustomer(1L, product);
        assertEquals(3,cart.totalNumberOfItems());

        assertEquals(new BigDecimal( 3100), cart.calculatePrice());
        customerDao=null;
    }
    @Test
    void addProductToCartByAdmin(){
        Product product = new Product("1", "Sandine", new BigDecimal(1000));
        Product product2 = new Product("2", "SandineBread", new BigDecimal(1100));
        Admin admin=new Admin(1L, "Kingsley","Nwafor");
        dataService.registerAdmin(admin);
        cart.addProductToCartByAdmin(1L, product);
        cart.addProductToCartByAdmin(1L, product2);
        cart.addProductToCartByAdmin(1L, product);
        assertEquals(3,cart.totalNumberOfItems());
        cart=null;
    }
    @Test
    void removeProductsFromCartByAdmin(){
        Product product = new Product("1", "Sandine", new BigDecimal(1000));
        Product product2 = new Product("2", "SandineBread", new BigDecimal(1100));
        Admin admin=new Admin(1L, "Kingsley","Nwafor");
        dataService.registerAdmin(admin);
        cart.addProductToCartByAdmin(1L, product);
        cart.addProductToCartByAdmin(1L, product2);
        cart.addProductToCartByAdmin(1L, product);
        System.out.println(cart);
        assertEquals(3,cart.totalNumberOfItems());
        cart.removeProductsFromCartByAdmin(1L,product);
        System.out.println(cart);
        assertEquals(2,cart.totalNumberOfItems());

    }
    @Test
    void checkAllTheProductsInTheCartByCustomer(){
        Product product = new Product("1", "Sandine", new BigDecimal(1000));
        Product product2 = new Product("2", "SandineBread", new BigDecimal(1100));
        Product product3 = new Product("3", "SandineBread", new BigDecimal(1100));
        Admin admin=new Admin(1L, "Kingsley","Nwafor");
        dataService.registerAdmin(admin);
        cart.addProductToCartByAdmin(1L, product);
        cart.addProductToCartByAdmin(1L, product2);
        cart.addProductToCartByAdmin(1L, product3);
        System.out.println(  cart.checkAllTheProductsInTheCartByCustomer(1L));
        cart=null;
    }
    @Test
    void checkAllRegisteredAdmin(){
        Admin admin=new Admin(1L, "Kingsley","Nwafor");
        dataService.registerAdmin(admin);
        System.out.println(dataService.getAllAdmin());
    }
}