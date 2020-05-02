package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService{
    private static Map<Integer,Customer> customers;

    static {
        customers=new HashMap<Integer,Customer>();
        customers.put(1,new Customer(1,"Thao","thao@codegym.vn","Ha Noi"));
        customers.put(2,new Customer(2,"Chung","chung@codegym.vn","Thanh Hoa"));
        customers.put(3,new Customer(3,"Anh","anh@codegym.vn","Hai Phong"));
        customers.put(4,new Customer(4,"Tho","tho@codegym.vn","Nghe An"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<Customer>(customers.values());
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
