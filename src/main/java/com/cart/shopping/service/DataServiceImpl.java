package com.cart.shopping.service;

import com.cart.shopping.model.Admin;
import com.cart.shopping.model.Customer;
import com.cart.shopping.repository.AdminDao;
import com.cart.shopping.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceImpl implements dataService{
    @Autowired
    private CustomerDao customerRepo;
    @Autowired
    private AdminDao adminRepo;
    @Override
    public Customer registerCustomer(Customer customer) {

        if(customerRepo.getCustomer(customer.getId())==null){
           customer= customerRepo.registerCustomer(customer.getId(),customer);
        }
        else
            System.out.println("Customer Already Exist");
        return customer;
    }


    @Override
    public Admin registerAdmin(Admin admin) {

    if(adminRepo.getAdmin(admin.getId())==null) {

        admin = adminRepo.registerAdmin(admin.getId(), admin);
    }
       else
        System.out.println("Admin Already Exist");
        return admin;

    }

    @Override
    public List<Customer> gettingAllCustomers() {
        List<Customer> customerList=new ArrayList<>();
        for(int counter=1;counter<=customerRepo.gettingAllTheCustomers().size();counter++){
            Long l2= (long) counter;
            customerList.add(customerRepo.getCustomer(l2));
        }
        return customerList;
    }

    @Override
    public void removeCustomer(Long id) {
        if(customerRepo.getCustomer(id)==null){
            System.out.println("Customer does not exist");
        }
        else
            customerRepo.removeCustomer(id);
    }

    @Override
    public void removeAdmin(Long id) {
        if(adminRepo.getAdmin(id)==null){
            System.out.println("Customer does not exist");
        }
        else
            adminRepo.removeAdmin(id);
    }

    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> adminList=new ArrayList<>();
        for(int counter=1;counter<=adminRepo.getAllAdmin().size();counter++){
            Long l2= (long) counter;
            adminList.add(adminRepo.getAdmin(l2));
        }
        return adminList;
    }
}
