package com.service;

import com.customer.beans.*;
import com.customer.repository.PurchaseInvoiceItemRepository;
import com.customer.service.PurchaseInvoiceItemService;
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
 * This class contains unit tests for the PurchaseInvoiceItemsService using Mockito framework.
 * It tests the business logic and functionality of the PurchaseOrderInvoiceItemsService methods in isolation.
 * The PurchaseInvoiceItemServiceMockitoTest class uses Mockito to mock dependencies.
 * PurchaseOrderInvoiceItemsRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all purchaseInvoiceItems retrieval and verify the expected purchaseInvoiceItems objects are returned.
 * - Test purchaseInvoiceItems retrieval by ID and verify the expected purchaseInvoiceItems object is returned.
 * - Test purchaseInvoiceItems creation and verify that the PurchaseInvoiceItemsRepository save method is called.
 * - Test purchaseInvoiceItems update and verify that the PurchaseInvoiceItemsRepository save method is called.
 * - Test purchaseInvoiceItems deletion and verify that the PurchaseInvoiceItemsRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * PurchaseInvoiceItemsService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StockInventoryServiceMockitoTest.class})
class PurchaseInvoiceItemServiceMockitoTest {

    @Mock
    PurchaseInvoiceItemRepository purchaseInvoiceItemsRep;

    @InjectMocks
    PurchaseInvoiceItemService purchaseInvoiceItemsSer;

    List<PurchaseInvoiceItem> purchaseInvoiceItems = new ArrayList<>();

    /**
     * Test the getPurchaseInvoiceItems method of PurchaseInvoiceItemsService.
     * Verify that all the purchaseInvoiceItems objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllPurchaseInvoiceItems() {
        PurchaseInvoiceItem purchaseInvoiceItem1 = new PurchaseInvoiceItem(1, 30,300.0, 1, 1, 1);
        PurchaseInvoiceItem purchaseInvoiceItem2 = new PurchaseInvoiceItem(2, 40,400.0, 2, 2, 2);
        purchaseInvoiceItems.add(purchaseInvoiceItem1);
        purchaseInvoiceItems.add(purchaseInvoiceItem2);

        when(purchaseInvoiceItemsRep.findAll()).thenReturn(purchaseInvoiceItems);
        assertEquals(2, purchaseInvoiceItemsSer.getPurchaseInvoiceItems().size());
    }

    /**
     * Test the getPurchaseInvoiceItemsById method of PurchaseInvoiceItemsService.
     * Verify that the correct purchaseInvoiceItems object is returned for a given purchaseInvoiceItems ID.
     */
    @Test
    @Order(2)
    public void test_getPurchaseInvoiceItemsById() {
        PurchaseInvoiceItem purchaseInvoiceItem1 = new PurchaseInvoiceItem(1, 30,300.0, 1, 1, 1);
        purchaseInvoiceItems.add(purchaseInvoiceItem1);

        PurchaseInvoiceItem purchaseInvoiceItem2 = new PurchaseInvoiceItem(2, 40,400.0, 2, 2, 2);
        purchaseInvoiceItems.add(purchaseInvoiceItem2);
        int id = 1;

        when(purchaseInvoiceItemsRep.findAll()).thenReturn(purchaseInvoiceItems);

        assertEquals(id, purchaseInvoiceItemsSer.getPurchaseInvoiceItemById(id).getPurchaseInvoiceItemId());
    }

    /**
     * Test the createPurchaseInvoiceItems method of PurchaseInvoiceItemsService.
     * Verify that the purchaseInvoiceItems object is saved using the PurchaseInvoiceItemsRepository save method.
     */
    @Test
    @Order(3)
    public void test_createPurchaseInvoiceItems() {
        PurchaseInvoiceItem purchaseInvoiceItem1 = new PurchaseInvoiceItem(1, 30,300.0, 1, 1, 1);
        purchaseInvoiceItems.add(purchaseInvoiceItem1);

        when(purchaseInvoiceItemsRep.save(purchaseInvoiceItem1)).thenReturn(purchaseInvoiceItem1);

        assertEquals(purchaseInvoiceItem1, purchaseInvoiceItemsSer.createPurchaseInvoiceItem(purchaseInvoiceItem1));
    }

    /**
     * Test the updatePurchaseInvoiceItems method of PurchaseInvoiceItemsService.
     * Verify that the purchaseInvoiceItems object is updated using the PurchaseInvoiceItemsRepository save method.
     */
    @Test
    @Order(4)
    public void test_updatePurchaseInvoiceItems() {
        PurchaseInvoiceItem purchaseInvoiceItem1 = new PurchaseInvoiceItem(1, 30,300.0, 1, 1, 1);
        purchaseInvoiceItems.add(purchaseInvoiceItem1);

        when(purchaseInvoiceItemsRep.save(purchaseInvoiceItem1)).thenReturn(purchaseInvoiceItem1);

        assertEquals(purchaseInvoiceItem1, purchaseInvoiceItemsSer.updatePurchaseInvoiceItem(purchaseInvoiceItem1));
    }

    /**
     * Test the deletePurchaseInvoiceItemsById method of PurchaseInvoiceItemsService.
     * Verify that the correct purchaseInvoiceItems object is deleted for a given purchaseInvoiceItems ID.
     */
    @Test
    @Order(5)
    public void test_deletePurchaseInvoiceItemsById() {
        PurchaseInvoiceItem purchaseInvoiceItem2 = new PurchaseInvoiceItem(2, 40,400.0, 2, 2, 2);
        purchaseInvoiceItems.add(purchaseInvoiceItem2);

        purchaseInvoiceItemsSer.deletePurchaseInvoiceItemById(purchaseInvoiceItem2.getPurchaseInvoiceItemId());
        verify(purchaseInvoiceItemsRep, times(1));
    }
}