package com.customer.controller;

import com.customer.beans.Customer;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * This class represents the RESTful controller for managing Customer-related endpoints.
 * It handles HTTP requests for creating, reading, updating, and deleting Customer information.
 * The CustomerController maps incoming HTTP requests to appropriate methods to process them.
 * It interacts with the CustomerService to perform operations on customer data.
 * Endpoints:
 * - GET /customers: Retrieves all the customers' information.
 * - GET /getCustomerById/{customerId}: Retrieve customer information by the specified ID.
 * - POST /createCustomer: Creates a new customer using the provided customer data.
 * - PUT /updateCustomer: Update customer information.
 * - DELETE /deleteCustomerById/{customerId}: Delete the customer with the given ID from the system.
 * Usage:
 * The CustomerController should be registered with the Spring application context and
 * automatically handle incoming HTTP requests to the specified endpoints.
 */
@RestController
public class CustomerController {

        @Autowired
        CustomerService service;

        /**
          * Returns all the customer objects.
          * URL : "http://localhost8080/Customers"
          * @return  All customers as an arrayList of customer JSON objects.
        */
        @GetMapping("/Customers")
        public List<Customer> getAllCustomers(){
            return service.getCustomers();
        }

        /**
        * Returns the customer object with given customerId.
        * URL : "http://localhost8080/getCustomerById/"
        * @param customerId as an input.
        * @return ResponseEntity with customer information if found, or 404 if not found.
        * @throws if customer object not found with given customerId.
        */
        @GetMapping("/getCustomerById/{customerId}")
        public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "customerId") int customerId) {

            try {
                Customer customer = service.getCustomerById(customerId);
                return new ResponseEntity<Customer>(customer, HttpStatus.OK);
            }
            catch(Exception e){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        /**
        * Creates the customer object.
        * URL : "http://localhost8080/createCustomer"
        * @param  customer object as an input.
        * @return  customer JSON object.
        */
        @PostMapping("/createCustomer")
        public Customer createCustomer(@RequestBody Customer customer){

            return service.createCustomer(customer);
        }

        /**
        * Updates the customer object.
        * URL : "http://localhost8080/updateCustomer"
        * @param  customer object as an input.
        * @return ResponseEntity with customer information if updated, or 404 if not found.
        * @throws  if customer object not found.
        */
        @PutMapping("/updateCustomer")
        public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
                try{
                    Customer updatedCustomer = service.updateCustomer(customer);
                    return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
                }
                catch(Exception e){
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
                }

        }

        /**
        * Deletes the customer object with specific id
        * URL : "http://localhost8080/deleteCustomerById/"
        * @param customerId as an input.
        * @return AddResponse with customerId which is deleted.
        */
        @DeleteMapping("/deleteCustomerById/{customerId}")
        public AddResponse deleteCustomer(@PathVariable(value = "customerId") int customerId){
            return service.deleteCustomer(customerId);
        }
}
