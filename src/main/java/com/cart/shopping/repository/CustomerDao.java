package com.cart.shopping.repository;

import com.cart.shopping.model.Customer;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.Map;
@Repository
public class CustomerDao {

    Map<Long, Customer> customerDao=new HashMap<>();
    public Customer registerCustomer(Long id,Customer customer){
       return customerDao.put(id,customer);
    }
    public void removeCustomer(Long id){
        customerDao.remove(id);
    }
    public Customer getCustomer(Long id){
        return customerDao.get(id);
    }

public int totalNumberOfCustomers(){
        return customerDao.size();
}
public Map<Long,Customer> gettingAllTheCustomers(){
        return customerDao;
}

}
