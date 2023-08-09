package com.test.controller;

import com.main.controller.AddResponse;
import com.main.controller.SalesInvoiceController;
import com.main.dto.*;
import com.main.service.SalesInvoiceService;
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
 * This class contains unit tests for the SalesInvoiceController using Mockito framework.
 * It tests the behaviour of the SalesInvoiceController methods in isolation.
 * The SalesInvoiceControllerMockitoTest class uses Mockito to mock dependencies, such as the
 * SalesInvoiceService, to focus solely on testing the controller layer.
 * Test Cases:
 * - Test all salesInvoices retrieval and verify that the SalesInvoiceService getSalesInvoices method is called.
 * - Test salesInvoice retrieval by ID and verify that the getSalesInvoiceById method is called.
 * - Test salesInvoice creation and verify that the SalesInvoiceService createSalesInvoice method is called.
 * - Test salesInvoice update and verify that the SalesInvoiceService updateSalesInvoice method is called.
 * - Test salesInvoice deletion and verify that the SalesInvoiceService deleteSalesInvoiceById method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * SalesInvoiceController implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {SalesInvoiceControllerTests.class})
public class SalesInvoiceControllerTests {

    @Mock
    SalesInvoiceService salesInvoiceService;

    @InjectMocks
    SalesInvoiceController salesInvoiceController;

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
     * Test the getAllSalesInvoices method of SalesInvoiceController.
     * Verify that all the salesInvoice objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllSalesInvoices(){
        salesInvoicesDTO.add(salesInvoiceDTO1);
        salesInvoicesDTO.add(salesInvoiceDTO2);

        when(salesInvoiceService.getSalesInvoices()).thenReturn(salesInvoicesDTO);
        assertEquals(2,salesInvoiceController.getAllSalesInvoices().size());
    }

    /**
     * Test the getSalesInvoiceById method of PurchaseSalesController.
     * Verify that the correct salesInvoice object is returned for a given salesInvoice ID.
     */
    @Test
    @Order(2)
    public void test_getSalesInvoiceById(){

        when(salesInvoiceService.getSalesInvoiceById(1)).thenReturn(salesInvoiceDTO1);
        ResponseEntity<SalesInvoiceDTO> responseEntity  = salesInvoiceController.getSalesInvoiceById(1);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getSalesInvoiceId());
    }

    /**
     * Test the createSalesInvoice method of PurchaseSalesController.
     * Verify that the salesInvoice object is saved using the SalesInvoiceRepository save method.
     */
    @Test
    @Order(3)
    public void test_createSalesInvoice(){

        when(salesInvoiceService.createSalesInvoice(salesInvoiceDTO1)).thenReturn(salesInvoiceDTO1);
        assertEquals(salesInvoiceDTO1,salesInvoiceController.createSalesInvoice(salesInvoiceDTO1));
    }

    /**
     * Test the updateSalesInvoice method of SalesInvoiceController.
     * Verify that the salesInvoice object is updated using the SalesInvoiceRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateSalesInvoice(){

        when(salesInvoiceService.updateSalesInvoice(salesInvoiceDTO1)).thenReturn(salesInvoiceDTO1);
        ResponseEntity<SalesInvoiceDTO> res = salesInvoiceController.updateSalesInvoice(salesInvoiceDTO1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(salesInvoiceDTO1,res.getBody());
    }

    /**
     * Test the deleteSalesInvoiceById method of PurchaseSalesController.
     * Verify that the correct salesInvoice object is deleted for a given salesInvoice ID.
     */
    @Test
    @Order(5)
    public void test_deleteSalesInvoiceById(){
        int id = salesInvoiceDTO2.getSalesInvoiceId();
        AddResponse addResponse = new AddResponse();
        addResponse.setId(id);
        addResponse.setMsg("PurchaseInvoice deleted");
        when(salesInvoiceService.deleteSalesInvoiceById(id)).thenReturn(addResponse);
        assertEquals(addResponse,salesInvoiceController.deleteSalesInvoiceById(id));
    }
}