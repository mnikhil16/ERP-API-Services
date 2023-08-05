package com.test.service;

import com.main.beans.Address;
import com.main.beans.Company;
import com.main.beans.Customer;
import com.main.beans.Store;
import com.main.repository.CustomerRepository;
import com.main.service.CustomerService;
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
 * The CustomerServiceMockitoTest class uses Mockito to mock dependencies.
 * CustomerRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all customers retrieval and verify the expected customer objects are returned.
 * - Test customer retrieval by ID and verify the expected customer object is returned.
 * - Test customer creation and verify that the CustomerRepository save method is called.
 * - Test customer update and verify that the CustomerRepository save method is called.
 * - Test customer deletion and verify that the CustomerRepository delete method is called.
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

    List<Customer> customer = new ArrayList<>();

    /**
     * Test the getCustomers method of CustomerService.
     * Verify that all the customer objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllCustomers(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", s2, add2);
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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", s2, add2);
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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);

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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);

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
    public void test_deleteCustomerById(){
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);

        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);

        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);

        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", s2, add2);
        customer.add(customer2);

        customerSer.deleteCustomer(customer2.getCustomerId());
        verify(customerRep,times(1));
    }
}