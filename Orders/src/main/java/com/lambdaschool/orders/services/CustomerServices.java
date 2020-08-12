package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.views.OrderCounts;

import java.util.List;

public interface CustomerServices {

    Customer save(Customer customer);

    //dim method to find all customers
    public List<Customer> findAllCustomers();

    //dim method to find specific customer with id
    public Customer findCustomerById(Long custid);

    //dim method to find  all customers given a substring
    public List<Customer> findCustomersBySubstring(String substring);

    //dim method to give all customers and the number of orders they've made
    public List<OrderCounts> getOrderCount();
}
