package com.test.service;

import com.main.beans.Address;
import com.main.beans.Company;
import com.main.repository.CompanyRepository;
import com.main.service.CompanyService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * This class contains unit tests for the CompanyService using Mockito framework.
 * It tests the business logic and functionality of the CompanyService methods in isolation.
 * The CompanyServiceMockitoTest class uses Mockito to mock dependencies.
 * CompanyRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all companies retrieval and verify the expected company objects are returned.
 * - Test company retrieval by ID and verify the expected company object is returned.
 * - Test company creation and verify that the CompanyRepository save method is called.
 * - Test company update and verify that the CompanyRepository save method is called.
 * - Test company deletion and verify that the CompanyRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * CompanyService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {CustomerServiceMockitoTest.class})
public class CompanyServiceMockitoTest {

    @Mock
    CompanyRepository companyRepository;

    @InjectMocks
    CompanyService companyService;

    List<Company> companies = new ArrayList<>();

    /**
     * Test the getCompanies method of CompanyService.
     * Verify that all the company objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllCompanies() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        companies.add(com1);
        companies.add(com2);

        when(companyRepository.findAll()).thenReturn(companies);
        assertEquals(2, companyService.getCompanies().size());
    }

    /**
     * Test the getCompanyById method of CompanyService.
     * Verify that the correct company object is returned for a given company ID.
     */
    @Test
    @Order(2)
    public void test_getCompanyById() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        companies.add(com1);
        companies.add(com2);
        int id = 1;

        when(companyRepository.findAll()).thenReturn(companies);

        assertEquals(id, companyService.getCompanyById(id).getCompanyId());
    }

    /**
     * Test the createCompany method of CompanyService.
     * Verify that the company object is saved using the CompanyRepository save method.
     */
    @Test
    @Order(3)
    public void test_createCompany() {
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        companies.add(com1);

        when(companyRepository.save(com1)).thenReturn(com1);

        assertEquals(com1, companyService.createCompany(com1));
    }

    /**
     * Test the updateCompany method of CompanyService.
     * Verify that the company object is updated using the CompanyRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateCompany() {
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        companies.add(com1);

        when(companyRepository.save(com1)).thenReturn(com1);

        assertEquals(com1, companyService.updateCompany(com1));
    }

    /**
     * Test the deleteCompany method of CompanyService.
     * Verify that the correct company object is deleted for a given company ID.
     */
    @Test
    @Order(5)
    public void test_deleteCompanyById() {
        Address add2 = new Address(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        companies.add(com2);

        companyService.deleteCompanyById(com2.getCompanyId());
        verify(companyRepository, times(1));
    }
}