package com.cart.shopping.repository;



import com.cart.shopping.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class productDao {
    Map<Long, Product> productDao=new HashMap<>();
    // The products are stored in the product dao like that of a shelf in the super market
    public void customerCanAddProduct(Long id,Product product){
        productDao.put(id,product);
    }
    public void customerCanRemoveProduct(Long id,Product product){
        productDao.remove(id,product);
    }
    public Product customerCanGetProduct(Long id,Product product){
        return productDao.get(id);
    }
}
