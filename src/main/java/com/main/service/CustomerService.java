package com.main.service;

import com.main.controller.AddResponse;
import com.main.repository.CustomerRepository;
import com.main.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * This class represents a service that handles Customer-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete Customer information in the database.
 * This service communicates with the CustomerRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The CustomerService should be autowired into other components that require Customer-related functionalities.
 */

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Get all the customer information.
     *
     * @return All the Customer objects.
     */
    public List<Customer> getCustomers(){
       return customerRepository.findAll();
    }


    /**
     * Get customer information by the specified customer ID.
     *
     * @param customerId The ID of the customer to retrieve.
     * @return The Customer object corresponding to the given ID.
     */
    public Customer getCustomerById(int customerId){
        List<Customer> customers = customerRepository.findAll();
        Customer customer = null;
        for(Customer c: customers){
            if(c.getCustomerId() == customerId){
                customer = c;
            }
        }
        return customer;
    }

    /**
     * Create a new customer with the provided Customer object.
     *
     * @param customer The Customer object representing the customer to be created.
     * @return The newly created Customer object with a generated ID.
     */
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    /**
     * Update a new customer with the provided Customer object.
     *
     * @param customer The Customer object representing the customer to be updated.
     * @return The updated Customer object.
     */
    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }


    /**
     * Delete a customer with the provided customerId.
     *
     * @param customerId The ID of the customer to delete.
     * @return The deleted customerId.
     */
    public AddResponse deleteCustomer(int customerId){
            customerRepository.deleteById(customerId);
            AddResponse res = new AddResponse();
            res.setMsg("Customer deleted");
            res.setId(customerId);
            return res;
    }
}