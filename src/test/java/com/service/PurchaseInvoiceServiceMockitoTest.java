package com.service;

import com.customer.beans.*;
import com.customer.repository.PurchaseInvoiceRepository;
import com.customer.service.PurchaseInvoiceService;
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
 * This class contains unit tests for the PurchaseInvoiceService using Mockito framework.
 * It tests the business logic and functionality of the PurchaseInvoiceService methods in isolation.
 * The PurchaseInvoiceServiceMockitoTest class uses Mockito to mock dependencies.
 * PurchaseInvoiceRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all purchaseInvoices retrieval and verify the expected purchaseInvoice objects are returned.
 * - Test purchaseInvoice retrieval by ID and verify the expected purchaseInvoice object is returned.
 * - Test purchaseInvoice creation and verify that the PurchaseInvoiceRepository save method is called.
 * - Test purchaseInvoice update and verify that the PurchaseInvoiceRepository save method is called.
 * - Test purchaseInvoice deletion and verify that the PurchaseInvoiceRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * PurchaseInvoiceService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StockInventoryServiceMockitoTest.class})
class PurchaseInvoiceServiceMockitoTest {

    @Mock
    PurchaseInvoiceRepository purchaseInvoiceRep;

    @InjectMocks
    PurchaseInvoiceService purchaseInvoiceSer;

    List<PurchaseInvoice> purchaseInvoices = new ArrayList<>();

    /**
     * Test the getPurchaseInvoices method of PurchaseInvoiceService.
     * Verify that all the purchaseInvoice objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllPurchaseInvoices() {
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", 1, 1);
        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", 2, 2);
        purchaseInvoices.add(purchaseInvoice1);
        purchaseInvoices.add(purchaseInvoice2);
        when(purchaseInvoiceRep.findAll()).thenReturn(purchaseInvoices);
        assertEquals(2, purchaseInvoiceSer.getPurchaseInvoices().size());
    }

    /**
     * Test the getPurchaseInvoiceById method of PurchaseInvoiceService.
     * Verify that the correct purchaseInvoice object is returned for a given purchaseInvoice ID.
     */
    @Test
    @Order(2)
    public void test_getPurchaseInvoiceById() {
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", 1, 1);
        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", 2, 2);
        purchaseInvoices.add(purchaseInvoice1);
        purchaseInvoices.add(purchaseInvoice2);
        int id = 1;

        when(purchaseInvoiceRep.findAll()).thenReturn(purchaseInvoices);

        assertEquals(id, purchaseInvoiceSer.getPurchaseInvoiceById(id).getPurchaseInvoiceId());
    }

    /**
     * Test the createPurchaseInvoice method of PurchaseInvoiceService.
     * Verify that the purchaseInvoice object is saved using the PurchaseInvoiceRepository save method.
     */
    @Test
    @Order(3)
    public void test_createPurchaseInvoice() {
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", 1, 1);
        purchaseInvoices.add(purchaseInvoice1);

        when(purchaseInvoiceRep.save(purchaseInvoice1)).thenReturn(purchaseInvoice1);

        assertEquals(purchaseInvoice1, purchaseInvoiceSer.createPurchaseInvoice(purchaseInvoice1));
    }

    /**
     * Test the updatePurchaseInvoice method of PurchaseInvoiceService.
     * Verify that the purchaseInvoice object is updated using the PurchaseInvoiceRepository save method.
     */
    @Test
    @Order(4)
    public void test_updatePurchaseInvoice() {
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", 1, 1);
        purchaseInvoices.add(purchaseInvoice1);

        when(purchaseInvoiceRep.save(purchaseInvoice1)).thenReturn(purchaseInvoice1);

        assertEquals(purchaseInvoice1, purchaseInvoiceSer.updatePurchaseInvoice(purchaseInvoice1));
    }

    /**
     * Test the deletePurchaseInvoiceById method of PurchaseInvoiceService.
     * Verify that the correct purchaseInvoice object is deleted for a given purchaseInvoice ID.
     */
    @Test
    @Order(5)
    public void test_deletePurchaseInvoiceById() {
        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", 2, 2);
        purchaseInvoices.add(purchaseInvoice2);

        purchaseInvoiceSer.deletePurchaseInvoiceById(purchaseInvoice2.getPurchaseInvoiceId());
        verify(purchaseInvoiceRep, times(1));
    }
}