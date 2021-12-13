package com.cart.shopping.repository;

import com.cart.shopping.model.Admin;
import com.cart.shopping.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class AdminDao {
    Map<Long, Admin> adminDao=new HashMap<>();
    public Admin registerAdmin(Long id,Admin admin){
      return   adminDao.put(id,admin);
    }
    public void removeAdmin(Long id){
        adminDao.remove(id);
    }
    public Admin getAdmin(Long id){
        return adminDao.get(id);
    }
    public Map<Long,Admin> getAllAdmin(){
        return adminDao;
    }
}
