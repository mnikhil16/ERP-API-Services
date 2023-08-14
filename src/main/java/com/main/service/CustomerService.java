package com.main.service;

import com.main.controller.AddResponse;
import com.main.dto.CustomerDTO;
import com.main.mapper.CustomerMapper;
import com.main.repository.CustomerRepository;
import com.main.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(CustomerService.class);
    /**
     * Get all the customer information.
     *
     * @return All the Customer objects.
     */
    public List<CustomerDTO> getCustomers(){
        logger.trace("Get all Customers service is invoked.");
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
        logger.trace("Get Customer by Id service is invoked.");
        Customer customerEntity = customerRepository.findById(customerId).get();
        CustomerDTO customerDTO = CustomerMapper.instance.modelToDto(customerEntity);
        return customerDTO;
    }

    /**
     * Create a new customer with the provided Customer object.
     *
     * @param customerDTO The CustomerDTO object representing the customer to be created.
     * @return The newly created Customer object with a generated ID.
     */
    public CustomerDTO createCustomer(CustomerDTO customerDTO){
        logger.trace("Create Customer service is invoked.");
        Customer customerEntity = CustomerMapper.instance.dtoToModel(customerDTO);
        customerRepository.save(customerEntity);
        CustomerDTO createdCustomerDTO = CustomerMapper.instance.modelToDto(customerEntity);
        return createdCustomerDTO;
    }

    /**
     * Update customer information with the provided Customer object.
     *
     * @param customerDTO The CustomerDTO object representing the customer to be updated.
     * @return The updated Customer object.
     */
    public CustomerDTO updateCustomer(CustomerDTO customerDTO){
        logger.trace("Update Customer service is invoked.");
        Customer customerEntity = CustomerMapper.instance.dtoToModel(customerDTO);
        customerRepository.save(customerEntity);
        CustomerDTO updatedCustomerDTO = CustomerMapper.instance.modelToDto(customerEntity);
        return updatedCustomerDTO;
    }

    /**
     * Delete a customer with the provided customerId.
     *
     * @param customerId The ID of the customer to delete.
     * @return An AddResponse indicating the deletion result.
     */
    public AddResponse deleteCustomer(int customerId){
        logger.trace("Delete Customer service is invoked.");
        customerRepository.deleteById(customerId);
        AddResponse response = new AddResponse();
        response.setMsg("Customer deleted");
        response.setId(customerId);
        return response;
    }
}