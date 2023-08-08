package com.test.controller;

import com.main.beans.Address;
import com.main.beans.Company;
import com.main.beans.Customer;
import com.main.beans.Store;
import com.main.controller.CustomerController;
import com.main.service.CustomerService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ComponentScan(basePackages = {"com.restservices.demo"})
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes = {CustomerControllerTests.class})
public class CustomerControllerMockMvcTests {
    @Autowired
    MockMvc mockMvc;

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    List<Customer> customers = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    @Order(1)
    public void test_getAllCustomers() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", s2, add2);
        customers.add(customer1);
        customers.add(customer2);

//        when(customerService.getCustomers()).thenReturn(customers);
    }
}
