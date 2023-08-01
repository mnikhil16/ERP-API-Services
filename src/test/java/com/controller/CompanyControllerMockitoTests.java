package com.controller;

import com.customer.beans.Address;
import com.customer.beans.Company;
import com.customer.controller.AddResponse;
import com.customer.controller.CompanyController;
import com.customer.service.CompanyService;
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
import static org.mockito.Mockito.when;

/**
 * This class contains unit tests for the CompanyController using Mockito framework.
 * It tests the behaviour of the CompanyController methods in isolation.
 * The CompanyControllerMockitoTest class uses Mockito to mock dependencies, such as the
 * CompanyService, to focus solely on testing the controller layer.
 * Test Cases:
 * - Test all companies retrieval and verify that the CompanyService getCompanies method is called.
 * - Test company retrieval by ID and verify that the getCompanyById method is called.
 * - Test company creation and verify that the CustomerService createCompany method is called.
 * - Test company update and verify that the CustomerService updateCompany method is called.
 * - Test company deletion and verify that the CustomerService deleteCompanyById method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * CompanyController implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {CustomerControllerMockitoTests.class})
public class CompanyControllerMockitoTests {

    @Mock
    CompanyService companyService;

    @InjectMocks
    CompanyController companyController;

    List<Company> companies = new ArrayList<>();

    /**
     * Test the getAllCompanies method of CompanyController.
     * Verify that all the company objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllCompanies(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        companies.add(com1);
        companies.add(com2);

        when(companyService.getCompanies()).thenReturn(companies);
        assertEquals(2,companyController.getAllCompanies().size());
    }

    /**
     * Test the getCompanyById method of CompanyController.
     * Verify that the correct company object is returned for a given company ID.
     */
    @Test
    @Order(2)
    public void test_getCompanyById(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        companies.add(com1);
        companies.add(com2);

        when(companyService.getCompanyById(1)).thenReturn(com1);
        ResponseEntity<Company> res  = companyController.getCompanyById(1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(1, res.getBody().getCompanyId());
    }

    /**
     * Test the createCompany method of CompanyController.
     * Verify that the company object is saved using the CompanyRepository save method.
     */
    @Test
    @Order(3)
    public void test_createCompany(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        companies.add(com1);


        when(companyService.createCompany(com1)).thenReturn(com1);
        assertEquals(com1,companyController.createCompany(com1));
    }

    /**
     * Test the updateCompany method of CompanyController.
     * Verify that the company object is updated using the CompanyRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateCompany(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        companies.add(com1);

        when(companyService.updateCompany(com1)).thenReturn(com1);
        ResponseEntity<Company> res = companyController.updateCompany(com1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(com1,res.getBody());
    }

    /**
     * Test the deleteCompany method of CompanyController.
     * Verify that the correct company object is deleted for a given company ID.
     */
    @Test
    @Order(5)
    public void test_deleteCompanyById(){
        Address add = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add);
        companies.add(com);

        AddResponse addResponse = new AddResponse();
        addResponse.setId(1);
        addResponse.setMsg("Company deleted");
        when(companyService.deleteCompanyById(1)).thenReturn(addResponse);
        assertEquals(addResponse,companyController.deleteCompanyById(1));
    }
}