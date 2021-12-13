package com.cart.shopping.controller;

import com.cart.shopping.model.Admin;
import com.cart.shopping.model.Customer;
import com.cart.shopping.model.Product;
import com.cart.shopping.service.CartServiceImpl;
import com.cart.shopping.service.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cart")
public class controller {
    @Autowired
    DataServiceImpl dataService;
    @Autowired
    CartServiceImpl cartService;
   @PostMapping("/create_customer")
   public Customer registerCustomer(@RequestBody Customer customer){
 return  dataService.registerCustomer(customer);
    }
    @GetMapping("/get_all_customers")
    public List<Customer> gettingAllList(){
       return dataService.gettingAllCustomers();
    }

    @PostMapping("/create_admin")
    public Admin registerAdmin(@RequestBody Admin admin){
        return  dataService.registerAdmin(admin);
    }
    @GetMapping("/get_all_admins")
    public List<Admin> getAllAdmin(){
        return dataService.getAllAdmin();
    }
    @PostMapping("/{id}/add_product")
    public void addProducts(@PathVariable Long id ,@RequestBody Product product){
         cartService.addProductToCartByCustomer(id,product);
    }
@GetMapping("/cal_price")
    public BigDecimal calculatingPrice(){
       return cartService.calculatePrice();
}
@GetMapping("/{id}/payment")
    public BigDecimal payment(@PathVariable Long id){
       return cartService.calculatingPurchase(id);
}
@GetMapping("/{id}/view_all_product")
    public List<Product> viewAllProducts(@PathVariable Long id){
       return cartService.checkAllTheProductsInTheCartByCustomer(id);
}
@GetMapping("/{id}/view_all_productAdmin")
    public List<Product> viewAllProduct(@PathVariable Long id){
    return cartService.checkAllTheProductsInTheCartByAdmin(id);
    }
}
