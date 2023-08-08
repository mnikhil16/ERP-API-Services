package com.main.service;

import com.main.controller.AddResponse;
import com.main.dto.CustomerDTO;
import com.main.mapper.CustomerMapper;
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
    public List<CustomerDTO> getCustomers(){
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList =  CustomerMapper.instance.modelToDtoList(customerList);
        return customerDTOList;
    }


    /**
     * Get customer information by the specified customer ID.
     *
     * @param customerId The ID of the customer to retrieve.
     * @return The Customer object corresponding to the given ID.
     */
    public CustomerDTO getCustomerById(int customerId){
        Customer customerEntity = customerRepository.findById(customerId).get();
        CustomerDTO customerDTO = CustomerMapper.instance.modelToDto(customerEntity);
        return customerDTO;
    }

    /**
     * Create a new customer with the provided Customer object.
     *
     * @param customerDTO The Customer object representing the customer to be created.
     * @return The newly created Customer object with a generated ID.
     */
    public CustomerDTO createCustomer(CustomerDTO customerDTO){
        Customer customerEntity = CustomerMapper.instance.dtoToModel(customerDTO);
        customerRepository.save(customerEntity);
        CustomerDTO customerDTO1 = CustomerMapper.instance.modelToDto(customerEntity);
        return customerDTO1;
    }

    /**
     * Update a new customer with the provided Customer object.
     *
     * @param customerDTO The Customer object representing the customer to be updated.
     * @return The updated Customer object.
     */
    public CustomerDTO updateCustomer(CustomerDTO customerDTO){
        Customer customerEntity = CustomerMapper.instance.dtoToModel(customerDTO);
        customerRepository.save(customerEntity);
        CustomerDTO customerDTO1 = CustomerMapper.instance.modelToDto(customerEntity);
        return customerDTO1;
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