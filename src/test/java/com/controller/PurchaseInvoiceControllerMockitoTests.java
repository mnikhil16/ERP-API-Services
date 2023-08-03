package com.controller;

import com.customer.beans.*;
import com.customer.controller.AddResponse;
import com.customer.controller.PurchaseInvoiceController;
import com.customer.service.PurchaseInvoiceService;
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
 * This class contains unit tests for the PurchaseInvoiceController using Mockito framework.
 * It tests the behaviour of the PurchaseInvoiceController methods in isolation.
 * The PurchaseInvoiceControllerMockitoTest class uses Mockito to mock dependencies, such as the
 * PurchaseInvoiceService, to focus solely on testing the controller layer.
 * Test Cases:
 * - Test all purchaseInvoices retrieval and verify that the PurchaseInvoiceService getPurchaseInvoices method is called.
 * - Test purchaseInvoice retrieval by ID and verify that the getPurchaseInvoiceById method is called.
 * - Test purchaseInvoice creation and verify that the PurchaseInvoiceService createPurchaseInvoice method is called.
 * - Test purchaseInvoice update and verify that the PurchaseInvoiceService updatePurchaseInvoice method is called.
 * - Test purchaseInvoice deletion and verify that the PurchaseInvoiceService deletePurchaseInvoiceById method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * PurchaseInvoiceController implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {PurchaseInvoiceControllerMockitoTests.class})
public class PurchaseInvoiceControllerMockitoTests {

    @Mock
    PurchaseInvoiceService purchaseInvoiceService;

    @InjectMocks
    PurchaseInvoiceController purchaseInvoiceController;

    List<PurchaseInvoice> purchaseInvoices = new ArrayList<>();

    /**
     * Test the getAllPurchaseInvoices method of PurchaseInvoiceController.
     * Verify that all the purchaseInvoice objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllPurchaseInvoices(){
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", 1, 1);
        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", 2, 2);
        purchaseInvoices.add(purchaseInvoice1);
        purchaseInvoices.add(purchaseInvoice2);

        when(purchaseInvoiceService.getPurchaseInvoices()).thenReturn(purchaseInvoices);
        assertEquals(2,purchaseInvoiceController.getAllPurchaseInvoices().size());
    }

    /**
     * Test the getPurchaseInvoiceById method of PurchaseInvoiceController.
     * Verify that the correct purchaseInvoice object is returned for a given purchaseInvoice ID.
     */
    @Test
    @Order(2)
    public void test_getPurchaseInvoiceById(){
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", 1, 1);
        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", 2, 2);
        purchaseInvoices.add(purchaseInvoice1);
        purchaseInvoices.add(purchaseInvoice2);

        when(purchaseInvoiceService.getPurchaseInvoiceById(1)).thenReturn(purchaseInvoice1);
        ResponseEntity<PurchaseInvoice> res = purchaseInvoiceController.getPurchaseInvoiceById(1);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertEquals(1, Objects.requireNonNull(res.getBody()).getPurchaseInvoiceId());
    }

    /**
     * Test the createPurchaseInvoice method of PurchaseInvoiceController.
     * Verify that the purchaseInvoice object is saved using the PurchaseInvoiceRepository save method.
     */
    @Test
    @Order(3)
    public void test_createPurchaseInvoice(){
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", 1, 1);
        purchaseInvoices.add(purchaseInvoice1);

        when(purchaseInvoiceService.createPurchaseInvoice(purchaseInvoice1)).thenReturn(purchaseInvoice1);
        assertEquals(purchaseInvoice1,purchaseInvoiceController.createPurchaseInvoice(purchaseInvoice1));
    }

    /**
     * Test the updatePurchaseInvoice method of PurchaseInvoiceController.
     * Verify that the purchaseInvoice object is updated using the PurchaseInvoiceRepository save method.
     */
    @Test
    @Order(4)
    public void test_updatePurchaseInvoice(){
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", 1, 1);
        purchaseInvoices.add(purchaseInvoice1);

        when(purchaseInvoiceService.updatePurchaseInvoice(purchaseInvoice1)).thenReturn(purchaseInvoice1);
        ResponseEntity<PurchaseInvoice> res = purchaseInvoiceController.updatePurchaseInvoice(purchaseInvoice1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(purchaseInvoice1,res.getBody());
    }

    /**
     * Test the deletePurchaseInvoiceById method of PurchaseInvoiceController.
     * Verify that the correct purchaseInvoice object is deleted for a given purchaseInvoice ID.
     */
    @Test
    @Order(5)
    public void test_deletePurchaseInvoiceById(){
        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", 2, 2);
        purchaseInvoices.add(purchaseInvoice2);

        AddResponse addResponse = new AddResponse();
        addResponse.setId(2);
        addResponse.setMsg("PurchaseInvoice deleted");
        when(purchaseInvoiceService.deletePurchaseInvoiceById(2)).thenReturn(addResponse);
        assertEquals(addResponse,purchaseInvoiceController.deletePurchaseInvoiceById(2));
    }
}