package com.cart.shopping.service;

import com.cart.shopping.cart.Cart;
import com.cart.shopping.model.Admin;
import com.cart.shopping.model.Customer;
import com.cart.shopping.model.Product;
import com.cart.shopping.repository.AdminDao;
import com.cart.shopping.repository.CustomerDao;
import com.cart.shopping.repository.productDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class CartServiceImpl implements cartService{
    @Autowired
    private CustomerDao customerRepo;
    @Autowired
    private productDao productRepo;
    @Autowired
    private Cart cart;
    @Autowired
    private AdminDao adminDao;

    @Override
    public void addProductToCartByCustomer(Long id, Product product) {
if(customerRepo.getCustomer(id)!=null){

    cart.addToTheCart(product);
}
    }

    @Override
    public void addProductToCartByAdmin(Long id, Product product) {
        if(adminDao.getAdmin(id)!=null){
            cart.addToTheCart(product);
        }
    }

    @Override
    public void removeProductsFromCartByCustomer(Long id, Product product) {
if(customerRepo.getCustomer(id)!=null){
    cart.removeFromCart(product);
}
    }

    @Override
    public void removeProductsFromCartByAdmin(Long id, Product product) {
        if(adminDao.getAdmin(id)!=null){
            cart.removeFromCart(product);
        }
    }

    @Override
    public List<Product> checkAllTheProductsInTheCartByCustomer(Long id) {
        List<Product> productList=new ArrayList<>();
        if (customerRepo.getCustomer(id) != null) {
            productList=cart.displayAllItems();
        }
            return productList;
        }

    @Override
    public List<Product> checkAllTheProductsInTheCartByAdmin(Long id) {
        List<Product> productList=new ArrayList<>();
        if (adminDao.getAdmin(id) != null) {
            productList=cart.displayAllItems();
        }
        return productList;
    }


    @Override
    public BigDecimal calculatePrice() {
        return cart.calculatePriceInCart();
    }


    @Override
    public int totalNumberOfItems() {
        return cart.totalNumberOfProducts();
    }

    @Override
    public BigDecimal calculatingPurchase(Long id) {
        return customerRepo.getCustomer(id).getBalance().subtract(calculatePrice());
    }
}
