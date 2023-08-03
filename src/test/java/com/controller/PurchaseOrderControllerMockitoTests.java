package com.controller;

import com.customer.beans.*;
import com.customer.controller.AddResponse;
import com.customer.controller.PurchaseOrderController;
import com.customer.service.PurchaseOrderService;
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
 * This class contains unit tests for the PurchaseOrderController using Mockito framework.
 * It tests the behaviour of the PurchaseOrderController methods in isolation.
 * The PurchaseOrderControllerMockitoTest class uses Mockito to mock dependencies, such as the
 * PurchaseOrderService, to focus solely on testing the controller layer.
 * Test Cases:
 * - Test all purchaseOrders retrieval and verify that the PurchaseOrderService getPurchaseOrders method is called.
 * - Test purchaseOrder retrieval by ID and verify that the getPurchaseOrderById method is called.
 * - Test purchaseOrder creation and verify that the PurchaseOrderService createPurchaseOrder method is called.
 * - Test purchaseOrder update and verify that the PurchaseOrderService updatePurchaseOrder method is called.
 * - Test purchaseOrder deletion and verify that the PurchaseOrderService deletePurchaseOrderById method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * PurchaseOrderController implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {PurchaseOrderControllerMockitoTests.class})
public class PurchaseOrderControllerMockitoTests {

    @Mock
    PurchaseOrderService purchaseOrderService;

    @InjectMocks
    PurchaseOrderController purchaseOrderController;

    List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    /**
     * Test the getAllPurchaseOrders method of PurchaseOrderController.
     * Verify that all the purchaseOrder objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllPurchaseOrders(){
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, 1, 1, 1);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(2, 400.0, 2, 2, 2);
        purchaseOrders.add(purchaseOrder1);
        purchaseOrders.add(purchaseOrder2);

        when(purchaseOrderService.getPurchaseOrders()).thenReturn(purchaseOrders);
        assertEquals(2,purchaseOrderController.getAllPurchaseOrders().size());
    }

    /**
     * Test the getPurchaseOrderById method of PurchaseOrderController.
     * Verify that the correct purchaseOrder object is returned for a given purchaseOrder ID.
     */
    @Test
    @Order(2)
    public void test_getPurchaseOrderById(){
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, 1, 1, 1);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(2, 400.0, 2, 2, 2);
        purchaseOrders.add(purchaseOrder1);
        purchaseOrders.add(purchaseOrder2);

        when(purchaseOrderService.getPurchaseOrderById(1)).thenReturn(purchaseOrder1);
        ResponseEntity<PurchaseOrder> res  = purchaseOrderController.getPurchaseOrderById(1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(1, Objects.requireNonNull(res.getBody()).getPurchaseOrderId());
    }

    /**
     * Test the createPurchaseOrder method of PurchaseOrderController.
     * Verify that the purchaseOrder object is saved using the PurchaseOrderRepository save method.
     */
    @Test
    @Order(3)
    public void test_createPurchaseOrder(){
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, 1, 1, 1);
        purchaseOrders.add(purchaseOrder1);

        when(purchaseOrderService.createPurchaseOrder(purchaseOrder1)).thenReturn(purchaseOrder1);
        assertEquals(purchaseOrder1,purchaseOrderController.createPurchaseOrder(purchaseOrder1));
    }

    /**
     * Test the updatePurchaseOrder method of PurchaseOrderController.
     * Verify that the purchaseOrder object is updated using the PurchaseOrderRepository save method.
     */
    @Test
    @Order(4)
    public void test_updatePurchaseOrder(){
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, 1, 1, 1);
        purchaseOrders.add(purchaseOrder1);

        when(purchaseOrderService.updatePurchaseOrder(purchaseOrder1)).thenReturn(purchaseOrder1);
        ResponseEntity<PurchaseOrder> res = purchaseOrderController.updatePurchaseOrder(purchaseOrder1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(purchaseOrder1,res.getBody());
    }

    /**
     * Test the deletePurchaseOrderById method of PurchaseOrderController.
     * Verify that the correct purchaseOrder object is deleted for a given purchaseOrder ID.
     */
    @Test
    @Order(5)
    public void test_deletePurchaseOrderById(){
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(2, 400.0, 2, 2, 2);
        purchaseOrders.add(purchaseOrder2);

        AddResponse addResponse = new AddResponse();
        addResponse.setId(2);
        addResponse.setMsg("PurchaseOrder deleted");
        when(purchaseOrderService.deletePurchaseOrderById(2)).thenReturn(addResponse);
        assertEquals(addResponse,purchaseOrderController.deletePurchaseOrderById(2));
    }
}