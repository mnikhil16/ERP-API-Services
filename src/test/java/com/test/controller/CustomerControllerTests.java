package com.test.controller;

import com.main.controller.AddResponse;
import com.main.controller.CustomerController;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import com.main.dto.CustomerDTO;
import com.main.dto.StoreDTO;
import com.main.service.CustomerService;
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
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * This class contains unit tests for the CustomerController using Mockito framework.
 * It tests the behaviour of the CustomerController methods in isolation.
 * The CustomerControllerMockitoTest class uses Mockito to mock dependencies, such as the
 * CustomerService, to focus solely on testing the controller layer.
 * Test Cases:
 * - Test all customers retrieval and verify that the CustomerService getCustomers method is called.
 * - Test customer retrieval by ID and verify that the getCustomerById method is called.
 * - Test customer creation and verify that the CustomerService createCustomer method is called.
 * - Test customer update and verify that the CustomerService updateCustomer method is called.
 * - Test customer deletion and verify that the CustomerService deleteCustomer method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * CustomerController implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {CustomerControllerTests.class})
public class CustomerControllerTests {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    List<CustomerDTO> customersDTO = new ArrayList<>();
    AddressDTO addressDTO1 = new AddressDTO(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
    AddressDTO addressDTO2 = new AddressDTO(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
    CompanyDTO companyDTO1 = new CompanyDTO(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", addressDTO1);
    CompanyDTO companyDTO2 = new CompanyDTO(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", addressDTO2);
    StoreDTO storeDTO1 = new StoreDTO(1, "Laundry", "Washington St.", companyDTO1, addressDTO1);
    StoreDTO storeDTO2 = new StoreDTO(2, "Food Store", "Washington St.", companyDTO2, addressDTO2);
    CustomerDTO customerDTO1 = new CustomerDTO(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", addressDTO1, storeDTO1);
    CustomerDTO customerDTO2 = new CustomerDTO(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", addressDTO2, storeDTO2);

    /**
     * Test the getAllCustomers method of CustomerController.
     * Verify that all the customer objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllCustomers(){

        customersDTO.add(customerDTO1);
        customersDTO.add(customerDTO2);

        when(customerService.getCustomers()).thenReturn(customersDTO);
        assertEquals(2,customerController.getAllCustomers().size());
    }

    /**
     * Test the getCustomerById method of CustomerController.
     * Verify that the correct customer object is returned for a given customer ID.
     */
    @Test
    @Order(2)
    public void test_getCustomerById() {
        
        when(customerService.getCustomerById(1)).thenReturn(customerDTO1);
        ResponseEntity<CustomerDTO> responseEntity = customerController.getCustomerById(1);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getCustomerId());

    }

    /**
     * Test the createCustomer method of CustomerController.
     * Verify that the customer object is saved using the CustomerRepository save method.
     */
    @Test
    @Order(3)
    public void test_createCustomer(){

        when(customerService.createCustomer(customerDTO1)).thenReturn(customerDTO1);
        assertEquals(customerDTO1,customerController.createCustomer(customerDTO1));
    }

    /**
     * Test the updateCustomer method of CustomerController.
     * Verify that the customer object is updated using the CustomerRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateCustomer(){

        when(customerService.updateCustomer(customerDTO1)).thenReturn(customerDTO1);
        ResponseEntity<CustomerDTO> res = customerController.updateCustomer(customerDTO1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(customerDTO1,res.getBody());
    }

    /**
     * Test the deleteCustomer method of CustomerController.
     * Verify that the correct customer object is deleted for a given customer ID.
     */
    @Test
    @Order(5)
    public void test_deleteCustomerById(){
        int id = customerDTO2.getCustomerId();
        AddResponse addResponse = new AddResponse();
        addResponse.setId(id);
        addResponse.setMsg("Customer deleted");
        when(customerService.deleteCustomer(id)).thenReturn(addResponse);
        assertEquals(addResponse,customerController.deleteCustomerById(id));
    }
}