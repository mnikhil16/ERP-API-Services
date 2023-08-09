package com.test.service;

import com.main.beans.Company;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import com.main.mapper.CompanyMapper;
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
import java.util.Optional;

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
@SpringBootTest(classes = {CustomerServiceTests.class})
public class CompanyServiceTests {

    @Mock
    CompanyRepository companyRepository;

    @InjectMocks
    CompanyService companyService;

    List<CompanyDTO> companiesDTO = new ArrayList<>();
    AddressDTO addressDTO1 = new AddressDTO(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
    AddressDTO addressDTO2 = new AddressDTO(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
    CompanyDTO companyDTO1 = new CompanyDTO(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", addressDTO1);
    CompanyDTO companyDTO2 = new CompanyDTO(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", addressDTO2);

    /**
     * Test the getCompanies method of CompanyService.
     * Verify that all the company objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllCompanies() {
        companiesDTO.add(companyDTO1);
        companiesDTO.add(companyDTO2);
        List<Company> companyList = CompanyMapper.instance.dtoToModelList(companiesDTO);
        when(companyRepository.findAll()).thenReturn(companyList);
        assertEquals(2, companyService.getCompanies().size());
    }

    /**
     * Test the getCompanyById method of CompanyService.
     * Verify that the correct company object is returned for a given company ID.
     */
    @Test
    @Order(2)
    public void test_getCompanyById() {
        companiesDTO.add(companyDTO1);
        int id = 1;
        Company company = CompanyMapper.instance.dtoToModel(companyDTO1);

        // Mocking the behavior of the companyRepository
        when(companyRepository.findById(id)).thenReturn(Optional.of(company));

        assertEquals(id, companyService.getCompanyById(id).getCompanyId());
    }


    /**
     * Test the createCompany method of CompanyService.
     * Verify that the company object is saved using the CompanyRepository save method.
     */
    @Test
    @Order(3)
    public void test_createCompany() {

        // mocking the response for save operation.
        Company companyEntity = CompanyMapper.instance.dtoToModel(companyDTO1);
        when(companyRepository.save(companyEntity)).thenReturn(companyEntity);
        System.out.println(companyDTO1);
        System.out.println(companyService.createCompany(companyDTO1));

        assertEquals(companyDTO1, companyService.createCompany(companyDTO1));
    }

    /**
     * Test the updateCompany method of CompanyService.
     * Verify that the company object is updated using the CompanyRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateCompany() {
        Company companyEntity = CompanyMapper.instance.dtoToModel(companyDTO1);
        when(companyRepository.save(companyEntity)).thenReturn(companyEntity);

        assertEquals(companyDTO1, companyService.updateCompany(companyDTO1));
    }

    /**
     * Test the deleteCompany method of CompanyService.
     * Verify that the correct company object is deleted for a given company ID.
     */
    @Test
    @Order(5)
    public void test_deleteCompanyById() {
        Company companyEntity = CompanyMapper.instance.dtoToModel(companyDTO2);
        companyService.deleteCompanyById(companyEntity.getCompanyId());
        verify(companyRepository, times(1));
    }
}