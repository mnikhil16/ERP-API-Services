package com.controller;

import com.customer.beans.*;
import com.customer.controller.AddResponse;
import com.customer.controller.SalesInvoiceController;
import com.customer.service.SalesInvoiceService;
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
@SpringBootTest(classes = {SalesInvoiceControllerMockitoTests.class})
public class SalesInvoiceControllerMockitoTests {

    @Mock
    SalesInvoiceService salesInvoiceService;

    @InjectMocks
    SalesInvoiceController salesInvoiceController;

    List<SalesInvoice> salesInvoices = new ArrayList<>();

    /**
     * Test the getAllSalesInvoices method of SalesInvoiceController.
     * Verify that all the salesInvoice objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllSalesInvoices(){
        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", 1, 1, 1);
        salesInvoices.add(salesInvoice1);

        SalesInvoice salesInvoice2 = new SalesInvoice(2, 400.0, "18-04-2023","567whsusjns7h", 2, 2, 2);
        salesInvoices.add(salesInvoice2);

        when(salesInvoiceService.getSalesInvoices()).thenReturn(salesInvoices);
        assertEquals(2,salesInvoiceController.getAllSalesInvoices().size());
    }

    /**
     * Test the getSalesInvoiceById method of PurchaseSalesController.
     * Verify that the correct salesInvoice object is returned for a given salesInvoice ID.
     */
    @Test
    @Order(2)
    public void test_getSalesInvoiceById(){
        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", 1, 1, 1);
        salesInvoices.add(salesInvoice1);


        SalesInvoice salesInvoice2 = new SalesInvoice(2, 400.0, "18-04-2023","567whsusjns7h", 2, 2, 2);
        salesInvoices.add(salesInvoice2);

        when(salesInvoiceService.getSalesInvoiceById(1)).thenReturn(salesInvoice1);
        ResponseEntity<SalesInvoice> res  = salesInvoiceController.getSalesInvoiceById(1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(1, res.getBody().getSalesInvoiceId());
    }

    /**
     * Test the createSalesInvoice method of PurchaseSalesController.
     * Verify that the salesInvoice object is saved using the SalesInvoiceRepository save method.
     */
    @Test
    @Order(3)
    public void test_createSalesInvoice(){
        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", 1, 1, 1);
        salesInvoices.add(salesInvoice1);

        when(salesInvoiceService.createSalesInvoice(salesInvoice1)).thenReturn(salesInvoice1);
        assertEquals(salesInvoice1,salesInvoiceController.createSalesInvoice(salesInvoice1));
    }

    /**
     * Test the updateSalesInvoice method of SalesInvoiceController.
     * Verify that the salesInvoice object is updated using the SalesInvoiceRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateSalesInvoice(){
        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", 1, 1, 1);
        salesInvoices.add(salesInvoice1);

        when(salesInvoiceService.updateSalesInvoice(salesInvoice1)).thenReturn(salesInvoice1);
        ResponseEntity<SalesInvoice> res = salesInvoiceController.updateSalesInvoice(salesInvoice1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(salesInvoice1,res.getBody());
    }

    /**
     * Test the deleteSalesInvoiceById method of PurchaseSalesController.
     * Verify that the correct salesInvoice object is deleted for a given salesInvoice ID.
     */
    @Test
    @Order(5)
    public void test_deleteSalesInvoiceById(){
        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", 1, 1, 1);
        salesInvoices.add(salesInvoice1);

        AddResponse addResponse = new AddResponse();
        addResponse.setId(1);
        addResponse.setMsg("PurchaseInvoice deleted");
        when(salesInvoiceService.deleteSalesInvoiceById(1)).thenReturn(addResponse);
        assertEquals(addResponse,salesInvoiceController.deleteSalesInvoiceById(1));
    }
}