package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repositories.CustomerRepo;
import com.lambdaschool.orders.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    private CustomerRepo customerrepo;

    //creates list, adds all the data in customer repo to the list and returns an output
    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> list = new ArrayList<>();
        customerrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustomerById(Long custid) {

        return customerrepo.findById(custid)
            .orElseThrow(() -> new EntityNotFoundException("Customer " + custid + " not found."));
    }

    @Override
    public List<Customer> findCustomersBySubstring(String substring) {
        List<Customer> list = customerrepo.findByCustnameContainingIgnoringCase(substring);
        return list;
    }

    @Override
    public List<OrderCounts> getOrderCount() {
        List<OrderCounts> list = customerrepo.findOrderCounts();
        return list;
    }

    @Override
    public Customer save(Customer customer){
        return customerrepo.save(customer);
    }

}
