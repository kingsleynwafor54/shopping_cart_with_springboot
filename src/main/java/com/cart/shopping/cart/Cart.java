package com.cart.shopping.cart;

import com.cart.shopping.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class Cart {
    //The cart is an aggregation of product
    private List<Product> productCart=new ArrayList<>();
    public void addToTheCart(Product product){
        productCart.add(product);
    }
    public void removeFromCart(String productName) {
        for (Product pro : productCart) {
            if (pro.getProductName().equalsIgnoreCase(productName)) ;
            productCart.remove(pro);
        }

    }
    public int totalNumberOfProducts(){
        return productCart.size();
    }
    public void removeFromCart(Product product){
        productCart.remove(product);
    }
    public BigDecimal calculatePriceInCart(){
        BigDecimal total=BigDecimal.ZERO;
        for(Product product:productCart){
       total= total.add(product.getCost());
        }
   return total;
    }
    public List<Product> displayAllItems(){
       return productCart;
    }
}
