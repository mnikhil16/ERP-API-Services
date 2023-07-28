package com.customer.service;

import com.customer.controller.AddResponse;
import com.customer.repository.CustomerRepository;
import com.customer.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * This class represents a service that handles Customer-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete Customer information in the database.
 * This service communicates with the CustomerRepository to perform CRUD operations on Customer_db entities.
 *
 * Usage:
 * The CustomerService should be autowired into other components that require Customer-related functionalities.
 */

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRep;

    /**
     * Get all the customer information.
     *
     * @return All the Customer objects.
     */
    public List<Customer> getCustomers(){
       return customerRep.findAll();
    }


    /**
     * Get customer information by the specified customer ID.
     *
     * @param Id The ID of the customer to retrieve.
     * @return The Customer object corresponding to the given ID.
     */
    public Customer getCustomerById(int Id){
        List<Customer> customers = customerRep.findAll();
        Customer customer = null;
        for(Customer c: customers){
            if(c.getCustomerId() == Id){
                customer = c;
            }
        }
        return customer;
    }

    /**
     * Create a new customer with the provided customer object.
     *
     * @param customer The Customer object representing the customer to be created.
     * @return The newly created customer object with a generated ID.
     */
    public Customer createCustomer(Customer customer){
        return customerRep.save(customer);
    }

    /**
     * Update a new customer with the provided customer object.
     *
     * @param customer The Customer object representing the customer to be updated.
     * @return The updated Customer object.
     */
    public Customer updateCustomer(Customer customer){
        return customerRep.save(customer);
    }


    /**
     * Delete a customer with the provided customerId.
     *
     * @param Id The ID of the customer to delete.
     * @return The deleted customerId.
     */
    public AddResponse deleteCustomer(int Id){
            customerRep.deleteById(Id);
            AddResponse res = new AddResponse();
            res.setMsg("Customer deleted");
            res.setId(Id);
            return res;
    }
}
