package com.customer;

import com.customer.beans.Address;
import com.customer.beans.Customer;
import com.customer.controller.AddResponse;
import com.customer.controller.CustomerController;
import com.customer.service.CustomerService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * This class contains unit tests for the CustomerController using Mockito framework.
 * It tests the behaviour of the CustomerController methods in isolation.
 *
 * The CustomerControllerMockitoTest class uses Mockito to mock dependencies, such as the
 * CustomerService, to focus solely on testing the controller layer.
 *
 * Test Cases:
 * - Test all customers retrieval and verify that the CustomerService getCustomers method is called.
 * - Test customer retrieval by ID and verify that the getCustomerById method is called.
 * - Test customer creation and verify that the CustomerService createCustomer method is called.
 * - Test customer update and verify that the CustomerService updateCustomer method is called.
 * - Test customer deletion and verify that the CustomerService deleteCustomer method is called.
 *
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * CustomerController implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {CustomerControllerMockitoTests.class})
public class CustomerControllerMockitoTests {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    List<Customer> customers = new ArrayList<>();
    Customer customer;

    /**
     * Test the getAllCustomers method of CustomerController.
     * Verify that all the customer objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllCustomers(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", add2);
        customers.add(customer1);
        customers.add(customer2);

        when(customerService.getCustomers()).thenReturn(customers);
        assertEquals(2,customerController.getAllCustomers().size());
    }

    /**
     * Test the getCustomerById method of CustomerController.
     * Verify that the correct customer object is returned for a given customer ID.
     */
    @Test
    @Order(2)
    public void test_getCustomerById(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", add2);
        customers.add(customer1);
        customers.add(customer2);

        when(customerService.getCustomerById(1)).thenReturn(customer1);
        ResponseEntity<Customer> res  = customerController.getCustomerById(1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(1, res.getBody().getCustomerId());
    }

    /**
     * Test the createCustomer method of CustomerController.
     * Verify that the customer object is saved using the CustomerRepository save method.
     */
    @Test
    @Order(3)
    public void test_createCustomer(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1);

        when(customerService.createCustomer(customer)).thenReturn(customer);
        assertEquals(customer,customerController.createCustomer(customer));
    }

    /**
     * Test the updateCustomer method of CustomerController.
     * Verify that the customer object is updated using the CustomerRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateCustomer(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Customer customer = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1);

        when(customerService.updateCustomer(customer)).thenReturn(customer);
        ResponseEntity<Customer> res = customerController.updateCustomer(customer);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(customer,res.getBody());
    }

    /**
     * Test the deleteCustomer method of CustomerController.
     * Verify that the correct customer object is deleted for a given customer ID.
     */
    @Test
    @Order(5)
    public void test_deleteCustomer(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Customer customer = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1);
        customers.add(customer);

        AddResponse addResponse = new AddResponse();
        addResponse.setId(1);
        addResponse.setMsg("Customer deleted");
        when(customerService.deleteCustomer(1)).thenReturn(addResponse);
        assertEquals(addResponse,customerController.deleteCustomer(1));
    }
}
