package com.service;

import com.customer.beans.*;
import com.customer.repository.PurchaseOrderRepository;
import com.customer.service.PurchaseOrderService;
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
 * This class contains unit tests for the PurchaseOrderService using Mockito framework.
 * It tests the business logic and functionality of the PurchaseOrderService methods in isolation.
 * The PurchaseOrderServiceMockitoTest class uses Mockito to mock dependencies.
 * PurchaseOrderRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all purchaseOrders retrieval and verify the expected purchaseOrder objects are returned.
 * - Test purchaseOrder retrieval by ID and verify the expected purchaseOrder object is returned.
 * - Test purchaseOrder creation and verify that the PurchaseOrderRepository save method is called.
 * - Test purchaseOrder update and verify that the PurchaseOrderRepository save method is called.
 * - Test purchaseOrder deletion and verify that the PurchaseOrderRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * PurchaseOrderService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StockInventoryServiceMockitoTest.class})
class PurchaseOrderServiceMockitoTest {

    @Mock
    PurchaseOrderRepository purchaseOrderRepository;

    @InjectMocks
    PurchaseOrderService purchaseOrderService;

    List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    /**
     * Test the getPurchaseOrders method of PurchaseOrderService.
     * Verify that all the purchaseOrder objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllPurchaseOrders() {
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, 1, 1, 1);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(2, 400.0, 2, 2, 2);
        purchaseOrders.add(purchaseOrder1);
        purchaseOrders.add(purchaseOrder2);
        when(purchaseOrderRepository.findAll()).thenReturn(purchaseOrders);
        assertEquals(2, purchaseOrderService.getPurchaseOrders().size());
    }

    /**
     * Test the getPurchaseOrderById method of PurchaseOrderService.
     * Verify that the correct purchaseOrder object is returned for a given purchaseOrder ID.
     */
    @Test
    @Order(2)
    public void test_getPurchaseOrderById() {
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, 1, 1, 1);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(1, 400.0, 2, 2, 2);
        purchaseOrders.add(purchaseOrder1);
        purchaseOrders.add(purchaseOrder2);
        int id = 1;

        when(purchaseOrderRepository.findAll()).thenReturn(purchaseOrders);

        assertEquals(id, purchaseOrderService.getPurchaseOrderById(id).getPurchaseOrderId());
    }

    /**
     * Test the createPurchaseOrder method of PurchaseOrderService.
     * Verify that the purchaseOrder object is saved using the PurchaseOrderRepository save method.
     */
    @Test
    @Order(3)
    public void test_createPurchaseOrder() {

        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, 1, 1, 1);
        purchaseOrders.add(purchaseOrder1);

        when(purchaseOrderRepository.save(purchaseOrder1)).thenReturn(purchaseOrder1);

        assertEquals(purchaseOrder1, purchaseOrderService.createPurchaseOrder(purchaseOrder1));
    }

    /**
     * Test the updatePurchaseOrder method of PurchaseOrderService.
     * Verify that the purchaseOrder object is updated using the PurchaseOrderRepository save method.
     */
    @Test
    @Order(4)
    public void test_updatePurchaseOrder() {
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, 1, 1, 1);
        purchaseOrders.add(purchaseOrder1);

        when(purchaseOrderRepository.save(purchaseOrder1)).thenReturn(purchaseOrder1);

        assertEquals(purchaseOrder1, purchaseOrderService.updatePurchaseOrder(purchaseOrder1));
    }

    /**
     * Test the deletePurchaseOrderById method of PurchaseOrderService.
     * Verify that the correct purchaseOrder object is deleted for a given purchaseOrder ID.
     */
    @Test
    @Order(5)
    public void test_deletePurchaseOrderById() {
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(1, 400.0, 2, 2, 2);
        purchaseOrders.add(purchaseOrder2);

        purchaseOrderService.deletePurchaseOrderById(purchaseOrder2.getPurchaseOrderId());
        verify(purchaseOrderRepository, times(1));
    }
}