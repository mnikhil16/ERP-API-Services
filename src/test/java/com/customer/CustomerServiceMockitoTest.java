package com.customer;

import com.customer.beans.Address;
import com.customer.beans.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * This class contains unit tests for the CustomerService using Mockito framework.
 * It tests the business logic and functionality of the CustomerService methods in isolation.
 *
 * The CustomerServiceMockitoTest class uses Mockito to mock dependencies, such as the
 * CustomerRepository or other external services, to focus solely on testing the service layer.
 *
 * Test Cases:
 * - Test all customers retrieval and verify the expected customer objects are returned.
 * - Test customer retrieval by ID and verify the expected customer object is returned.
 * - Test customer creation and verify that the CustomerRepository save method is called.
 * - Test customer update and verify that the CustomerRepository save method is called.
 * - Test customer deletion and verify that the CustomerRepository delete method is called.
 *
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * CustomerService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {CustomerServiceMockitoTest.class})
public class CustomerServiceMockitoTest {

    @Mock
    CustomerRepository customerRep;

    @InjectMocks
    CustomerService customerSer;


    /**
     * Test the getCustomers method of CustomerService.
     * Verify that all the customer objects are returned.
     */
    @Test
    @Order(1)
    public void test_getCustomers(){
        List<Customer> customer = new ArrayList<>();
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", add2);
        customer.add(customer1);
        customer.add(customer2);

        when(customerRep.findAll()).thenReturn(customer);
        assertEquals(2, customerSer.getCustomers().size());
    }

    /**
     * Test the getCustomerById method of CustomerService.
     * Verify that the correct customer object is returned for a given customer ID.
     */
    @Test
    @Order(2)
    public void test_getCustomerById(){
        List<Customer> customer = new ArrayList<>();
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", add2);
        customer.add(customer1);
        customer.add(customer2);
        int id=1;

        when(customerRep.findAll()).thenReturn(customer);

        assertEquals(id, customerSer.getCustomerById(id).getCustomerId());
    }

    /**
     * Test the createCustomer method of CustomerService.
     * Verify that the customer object is saved using the CustomerRepository save method.
     */
    @Test
    @Order(3)
    public void test_createCustomer(){
        List<Customer> customer = new ArrayList<>();
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1);
        customer.add(customer1);

        when(customerRep.save(customer1)).thenReturn(customer1);

        assertEquals(customer1, customerSer.createCustomer(customer1));
    }

    /**
     * Test the updateCustomer method of CustomerService.
     * Verify that the customer object is updated using the CustomerRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateCustomer(){
        List<Customer> customer = new ArrayList<>();
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1);
        customer.add(customer1);

        when(customerRep.save(customer1)).thenReturn(customer1);

        assertEquals(customer1, customerSer.updateCustomer(customer1));
    }

    /**
     * Test the deleteCustomer method of CustomerService.
     * Verify that the correct customer object is deleted for a given customer ID.
     */
    @Test
    @Order(5)
    public void test_deleteCustomer(){
        List<Customer> customer = new ArrayList<>();
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", add2);

        customer.add(customer2);

        customerSer.deleteCustomer(customer2.getCustomerId());
        verify(customerRep,times(1));
    }

}

