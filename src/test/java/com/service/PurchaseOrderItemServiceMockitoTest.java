package com.service;

import com.customer.beans.*;
import com.customer.repository.PurchaseOrderItemRepository;
import com.customer.service.PurchaseOrderItemService;
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
 * This class contains unit tests for the PurchaseOrderItemService using Mockito framework.
 * It tests the business logic and functionality of the PurchaseOrderItemService methods in isolation.
 * The PurchaseOrderItemServiceMockitoTest class uses Mockito to mock dependencies.
 * PurchaseOrderItemRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all purchaseOrderItems retrieval and verify the expected purchaseOrderItems objects are returned.
 * - Test purchaseOrderItems retrieval by ID and verify the expected purchaseOrderItems object is returned.
 * - Test purchaseOrderItems creation and verify that the PurchaseOrderItemRepository save method is called.
 * - Test purchaseOrderItems update and verify that the PurchaseOrderItemRepository save method is called.
 * - Test purchaseOrderItems deletion and verify that the PurchaseOrderItemRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * PurchaseOrderItemService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StockInventoryServiceMockitoTest.class})
class PurchaseOrderItemServiceMockitoTest {

    @Mock
    PurchaseOrderItemRepository purchaseOrderItemsRep;

    @InjectMocks
    PurchaseOrderItemService purchaseOrderItemsSer;

    List<PurchaseOrderItem> purchaseOrderItems = new ArrayList<>();

    /**
     * Test the getPurchaseOrderItems method of PurchaseOrderItemService.
     * Verify that all the purchaseOrderItems objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllPurchaseOrderItems() {
        PurchaseOrderItem purchaseOrderItem1 = new PurchaseOrderItem(1, 40, 1, 1, 1);
        PurchaseOrderItem purchaseOrderItem2 = new PurchaseOrderItem(2, 80, 2, 2, 2);
        purchaseOrderItems.add(purchaseOrderItem1);
        purchaseOrderItems.add(purchaseOrderItem2);
        when(purchaseOrderItemsRep.findAll()).thenReturn(purchaseOrderItems);
        assertEquals(2, purchaseOrderItemsSer.getPurchaseOrderItems().size());
    }

    /**
     * Test the getPurchaseOrderItemsById method of PurchaseOrderItemService.
     * Verify that the correct purchaseOrderItems object is returned for a given purchaseOrderItems ID.
     */
    @Test
    @Order(2)
    public void test_getPurchaseOrderItemsById() {
        PurchaseOrderItem purchaseOrderItem1 = new PurchaseOrderItem(1, 40, 1, 1, 1);
        PurchaseOrderItem purchaseOrderItem2 = new PurchaseOrderItem(2, 80, 2, 2, 2);
        purchaseOrderItems.add(purchaseOrderItem1);
        purchaseOrderItems.add(purchaseOrderItem2);
        int id = 1;

        when(purchaseOrderItemsRep.findAll()).thenReturn(purchaseOrderItems);

        assertEquals(id, purchaseOrderItemsSer.getPurchaseOrderItemById(id).getPurchaseOrderItemId());
    }

    /**
     * Test the createPurchaseOrderItems method of PurchaseOrderItemService.
     * Verify that the purchaseOrderItems object is saved using the PurchaseOrderItemRepository save method.
     */
    @Test
    @Order(3)
    public void test_createPurchaseOrderItemsItems() {
        PurchaseOrderItem purchaseOrderItem1 = new PurchaseOrderItem(1, 40, 1, 1, 1);
        purchaseOrderItems.add(purchaseOrderItem1);

        when(purchaseOrderItemsRep.save(purchaseOrderItem1)).thenReturn(purchaseOrderItem1);

        assertEquals(purchaseOrderItem1, purchaseOrderItemsSer.createPurchaseOrderItem(purchaseOrderItem1));
    }

    /**
     * Test the updatePurchaseItemsOrder method of PurchaseOrderItemService.
     * Verify that the purchaseOrderItems object is updated using the PurchaseOrderItemRepository save method.
     */
    @Test
    @Order(4)
    public void test_updatePurchaseOrderItems() {
        PurchaseOrderItem purchaseOrderItem1 = new PurchaseOrderItem(1, 40, 1, 1, 1);
        purchaseOrderItems.add(purchaseOrderItem1);

        when(purchaseOrderItemsRep.save(purchaseOrderItem1)).thenReturn(purchaseOrderItem1);

        assertEquals(purchaseOrderItem1, purchaseOrderItemsSer.updatePurchaseOrderItem(purchaseOrderItem1));
    }

    /**
     * Test the deletePurchaseOrderItemsById method of PurchaseOrderItemService.
     * Verify that the correct purchaseOrderItems object is deleted for a given purchaseOrderItems ID.
     */
    @Test
    @Order(5)
    public void test_deletePurchaseOrderItemsById() {
        PurchaseOrderItem purchaseOrderItem2 = new PurchaseOrderItem(2, 80, 2, 2, 2);
        purchaseOrderItems.add(purchaseOrderItem2);

        purchaseOrderItemsSer.deletePurchaseOrderItemById(purchaseOrderItem2.getPurchaseOrderItemId());
        verify(purchaseOrderItemsRep, times(1));
    }
}