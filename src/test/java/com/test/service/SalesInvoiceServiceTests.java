package com.test.service;

import com.main.entity.*;
import com.main.dto.*;
import com.main.mapper.SalesInvoiceMapper;
import com.main.repository.SalesInvoiceRepository;
import com.main.service.SalesInvoiceService;
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
 * This class contains unit tests for the SalesInvoiceService using Mockito framework.
 * It tests the business logic and functionality of the SalesInvoiceService methods in isolation.
 * The SalesInvoiceServiceTests class uses Mockito to mock dependencies.
 * SalesInvoiceRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all salesInvoices retrieval and verify the expected salesInvoice objects are returned.
 * - Test salesInvoice retrieval by ID and verify the expected purchaseInvoice object is returned.
 * - Test salesInvoice creation and verify that the SalesInvoiceRepository save method is called.
 * - Test salesInvoice update and verify that the salesInvoiceRepository save method is called.
 * - Test salesInvoice deletion and verify that the salesInvoiceRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * SalesInvoiceService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StockInventoryServiceTests.class})
class SalesInvoiceServiceTests {

    @Mock
    SalesInvoiceRepository salesInvoiceRepository;

    @InjectMocks
    SalesInvoiceService salesInvoiceService;

    List<SalesInvoiceDTO> salesInvoicesDTO = new ArrayList<>();
    AddressDTO addressDTO1 = new AddressDTO(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
    AddressDTO addressDTO2 = new AddressDTO(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
    CompanyDTO companyDTO1 = new CompanyDTO(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", addressDTO1);
    CompanyDTO companyDTO2 = new CompanyDTO(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", addressDTO2);
    StoreDTO storeDTO1 = new StoreDTO(1, "Laundry", "Washington St.", companyDTO1, addressDTO1);
    StoreDTO storeDTO2 = new StoreDTO(2, "Food Store", "Washington St.", companyDTO2, addressDTO2);
    CustomerDTO customerDTO1 = new CustomerDTO(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", addressDTO1, storeDTO1);
    CustomerDTO customerDTO2 = new CustomerDTO(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", addressDTO2, storeDTO2);
    SalesInvoiceDTO salesInvoiceDTO1 = new SalesInvoiceDTO(1, 300.0, "16-04-2023", "348hwhsn38wu2j", companyDTO1, storeDTO1, customerDTO1);
    SalesInvoiceDTO salesInvoiceDTO2 = new SalesInvoiceDTO(2, 400.0, "18-04-2023","567whsusjns7h", companyDTO2, storeDTO2, customerDTO2);

    /**
     * Test the getSalesInvoices method of SalesInvoiceService.
     * Verify that all the salesInvoice objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllSalesInvoices() {

        salesInvoicesDTO.add(salesInvoiceDTO1);
        salesInvoicesDTO.add(salesInvoiceDTO2);
        List<SalesInvoice> salesInvoiceList = SalesInvoiceMapper.instance.dtoToModelList(salesInvoicesDTO);
        when(salesInvoiceRepository.findAll()).thenReturn(salesInvoiceList);
        assertEquals(2, salesInvoiceService.getSalesInvoices().size());
    }

    /**
     * Test the getSalesInvoiceById method of SalesInvoiceService.
     * Verify that the correct salesInvoice object is returned for a given salesInvoice ID.
     */
    @Test
    @Order(2)
    public void test_getSalesInvoiceById() {

        salesInvoicesDTO.add(salesInvoiceDTO1);
        salesInvoicesDTO.add(salesInvoiceDTO2);
        int id = 1;
        SalesInvoice salesInvoice = SalesInvoiceMapper.instance.dtoToModel(salesInvoiceDTO1);

        // Mocking the behavior of the salesInvoiceRepository
        when(salesInvoiceRepository.findById(id)).thenReturn(Optional.of(salesInvoice));

        assertEquals(id, salesInvoiceService.getSalesInvoiceById(id).getSalesInvoiceId());
    }

    /**
     * Test the createSalesInvoice method of SalesInvoiceService.
     * Verify that the SalesInvoice object is saved using the SalesInvoiceRepository save method.
     */
    @Test
    @Order(3)
    public void test_createSalesInvoice() {

        SalesInvoice salesInvoiceEntity = SalesInvoiceMapper.instance.dtoToModel(salesInvoiceDTO1);

        when(salesInvoiceRepository.save(salesInvoiceEntity)).thenReturn(salesInvoiceEntity);

        assertEquals(salesInvoiceDTO1.getSalesInvoiceId(), salesInvoiceService.createSalesInvoice(salesInvoiceDTO1).getSalesInvoiceId());
    }

    /**
     * Test the updateSalesInvoice method of SalesInvoiceService.
     * Verify that the salesInvoice object is updated using the SalesInvoiceRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateSalesInvoice() {
        SalesInvoice salesInvoiceEntity = SalesInvoiceMapper.instance.dtoToModel(salesInvoiceDTO1);

        when(salesInvoiceRepository.save(salesInvoiceEntity)).thenReturn(salesInvoiceEntity);

        assertEquals(salesInvoiceDTO1.getSalesInvoiceId(), salesInvoiceService.updateSalesInvoice(salesInvoiceDTO1).getSalesInvoiceId());
    }

    /**
     * Test the deleteSalesInvoiceById method of SalesInvoiceService.
     * Verify that the correct salesInvoice object is deleted for a given salesInvoice ID.
     */
    @Test
    @Order(5)
    public void test_deleteSalesInvoiceById() {
        SalesInvoice salesInvoiceEntity = SalesInvoiceMapper.instance.dtoToModel(salesInvoiceDTO2);
        salesInvoiceService.deleteSalesInvoiceById(salesInvoiceEntity.getSalesInvoiceId());
        verify(salesInvoiceRepository, times(1));
    }
}