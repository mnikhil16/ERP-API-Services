package com.test.controller;

import com.main.controller.AddResponse;
import com.main.controller.CompanyController;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import com.main.service.CompanyService;
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
@SpringBootTest(classes = {CustomerControllerTests.class})
public class CompanyControllerTests {

    @Mock
    CompanyService companyService;

    @InjectMocks
    CompanyController companyController;

    List<CompanyDTO> companyDTOList = new ArrayList<>();
    AddressDTO addressDTO1 = new AddressDTO(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
    AddressDTO addressDTO2 = new AddressDTO(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
    CompanyDTO companyDTO1 = new CompanyDTO(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", addressDTO1);
    CompanyDTO companyDTO2 = new CompanyDTO(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", addressDTO2);
    /**
     * Test the getAllCompanies method of CompanyController.
     * Verify that all the company objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllCompanies(){

        companyDTOList.add(companyDTO1);
        companyDTOList.add(companyDTO2);

        when(companyService.getCompanies()).thenReturn(companyDTOList);
        assertEquals(2,companyController.getAllCompanies().size());
    }

    /**
     * Test the getCompanyById method of CompanyController.
     * Verify that the correct company object is returned for a given company ID.
     */
    @Test
    @Order(2)
    public void test_getCompanyById() {

        when(companyService.getCompanyById(1)).thenReturn(companyDTO1);
        ResponseEntity<CompanyDTO> responseEntity = companyController.getCompanyById(1);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getCompanyId());
    }

    /**
     * Test the createCompany method of CompanyController.
     * Verify that the company object is saved using the CompanyRepository save method.
     */
    @Test
    @Order(3)
    public void test_createCompany(){
        companyDTOList.add(companyDTO1);

        when(companyService.createCompany(companyDTO1)).thenReturn(companyDTO1);
        assertEquals(companyDTO1,companyController.createCompany(companyDTO1));
    }

    /**
     * Test the updateCompany method of CompanyController.
     * Verify that the company object is updated using the CompanyRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateCompany(){

        companyDTOList.add(companyDTO1);

        when(companyService.updateCompany(companyDTO1)).thenReturn(companyDTO1);
        ResponseEntity<CompanyDTO> res = companyController.updateCompany(companyDTO1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(companyDTO1,res.getBody());
    }

    /**
     * Test the deleteCompany method of CompanyController.
     * Verify that the correct company object is deleted for a given company ID.
     */
    @Test
    @Order(5)
    public void test_deleteCompanyById(){

        int id = companyDTO2.getCompanyId();

        AddResponse addResponse = new AddResponse();
        addResponse.setId(id);
        addResponse.setMsg("Company deleted");

        when(companyService.deleteCompanyById(id)).thenReturn(addResponse);
        assertEquals(addResponse,companyController.deleteCompanyById(id));
    }
}