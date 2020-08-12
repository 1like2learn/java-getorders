package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerServices;
import com.lambdaschool.orders.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerServices customerservices;

    //http://localhost:2019/customers/orders
    //give a list of all customers and their orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllCustomers(){

        List<Customer> myList = customerservices.findAllCustomers();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    //http://localhost:2019/customers/customer/7
    //give a specific customer and their orders
    @GetMapping(value = "/customer/{custid}", produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable Long custid){

        Customer thisCustomer = customerservices.findCustomerById(custid);
        return new ResponseEntity<>(thisCustomer, HttpStatus.OK);
    }

    //http://localhost:2019/customers/namelike/mes
    //give all customers that have a pathVariable provided substring somewhere in their names
    @GetMapping(value = "/namelike/{substring}", produces = "application/json")
    public ResponseEntity<?> findCustomersBySubstring(@PathVariable String substring){

        List<Customer> myList = customerservices.findCustomersBySubstring(substring);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    //http://localhost:2019/customers/orders/count
    //give all customers and the number of orders they've made
    @GetMapping(value = "/orders/count", produces = "application/json")
    public ResponseEntity<?> getOrderCount(){

        List<OrderCounts> myList = customerservices.getOrderCount();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

}
