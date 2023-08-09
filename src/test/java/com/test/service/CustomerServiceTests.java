package com.test.service;

import com.main.beans.Customer;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import com.main.dto.CustomerDTO;
import com.main.dto.StoreDTO;
import com.main.mapper.CustomerMapper;
import com.main.repository.CustomerRepository;
import com.main.service.CustomerService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * This class contains unit tests for the CustomerService using Mockito framework.
 * It tests the business logic and functionality of the CustomerService methods in isolation.
 * The CustomerServiceTests class uses Mockito to mock dependencies.
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
@SpringBootTest(classes = {CustomerServiceTests.class})
public class CustomerServiceTests {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

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
     * Test the getCustomers method of CustomerService.
     * Verify that all the customer objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllCustomers(){

        customersDTO.add(customerDTO1);
        customersDTO.add(customerDTO2);
        List<Customer> customerList = CustomerMapper.instance.dtoToModelList(customersDTO);
        when(customerRepository.findAll()).thenReturn(customerList);
        assertEquals(2, customerService.getCustomers().size());
    }

    /**
     * Test the getCustomerById method of CustomerService.
     * Verify that the correct customer object is returned for a given customer ID.
     */
    @Test
    @Order(2)
    public void test_getCustomerById(){

        customersDTO.add(customerDTO1);
        int id=1;
        Customer customer = CustomerMapper.instance.dtoToModel(customerDTO1);
        // Mocking the behavior of the customerRepository
        when(customerRepository.findById(id)).thenReturn(Optional.of(customer));

        assertEquals(id, customerService.getCustomerById(id).getCustomerId());
    }

    /**
     * Test the createCustomer method of CustomerService.
     * Verify that the customer object is saved using the CustomerRepository save method.
     */
    @Test
    @Order(3)
    public void test_createCustomer(){
        Customer customerEntity = CustomerMapper.instance.dtoToModel(customerDTO1);

        when(customerRepository.save(customerEntity)).thenReturn(customerEntity);

        assertEquals(customerDTO1, customerService.createCustomer(customerDTO1));
    }

    /**
     * Test the updateCustomer method of CustomerService.
     * Verify that the customer object is updated using the CustomerRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateCustomer(){
        Customer customerEntity = CustomerMapper.instance.dtoToModel(customerDTO1);

        when(customerRepository.save(customerEntity)).thenReturn(customerEntity);

        assertEquals(customerDTO1, customerService.updateCustomer(customerDTO1));
    }

    /**
     * Test the deleteCustomer method of CustomerService.
     * Verify that the correct customer object is deleted for a given customer ID.
     */
    @Test
    @Order(5)
    public void test_deleteCustomerById(){
        Customer customerEntity = CustomerMapper.instance.dtoToModel(customerDTO2);

        customerService.deleteCustomer(customerEntity.getCustomerId());
        verify(customerRepository,times(1));
    }
}