package com.customer;

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
    PurchaseOrderRepository purchaseOrderRep;

    @InjectMocks
    PurchaseOrderService purchaseOrderSer;

    List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    /**
     * Test the getPurchaseOrders method of PurchaseOrderService.
     * Verify that all the purchaseOrder objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllPurchaseOrders() {
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Supplier supplier1 = new Supplier(1, "James", "Smith", "jsmith@gmail.com", "(+1) 555 1234567", s1, com1, add1);
        Supplier supplier2 = new Supplier(2, "John", "Doe", "jdoe@gmail.com", "(+1) 555 1234567", s2, com2, add2);
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, s1, com1, supplier1);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(2, 400.0, s2, com2, supplier2);
        purchaseOrders.add(purchaseOrder1);
        purchaseOrders.add(purchaseOrder2);
        when(purchaseOrderRep.findAll()).thenReturn(purchaseOrders);
        assertEquals(2, purchaseOrderSer.getPurchaseOrders().size());
    }

    /**
     * Test the getPurchaseOrderById method of PurchaseOrderService.
     * Verify that the correct purchaseOrder object is returned for a given purchaseOrder ID.
     */
    @Test
    @Order(2)
    public void test_getPurchaseOrderById() {
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Supplier supplier1 = new Supplier(1, "James", "Smith", "jsmith@gmail.com", "(+1) 555 1234567", s1, com1, add1);
        Supplier supplier2 = new Supplier(2, "John", "Doe", "jdoe@gmail.com", "(+1) 555 1234567", s2, com2, add2);
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, s1, com1, supplier1);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(1, 400.0, s2, com2, supplier2);
        purchaseOrders.add(purchaseOrder1);
        purchaseOrders.add(purchaseOrder2);
        int id = 1;

        when(purchaseOrderRep.findAll()).thenReturn(purchaseOrders);

        assertEquals(id, purchaseOrderSer.getPurchaseOrderById(id).getPurchaseOrderId());
    }

    /**
     * Test the createPurchaseOrder method of PurchaseOrderService.
     * Verify that the purchaseOrder object is saved using the PurchaseOrderRepository save method.
     */
    @Test
    @Order(3)
    public void test_createPurchaseOrder() {
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Supplier supplier1 = new Supplier(1, "James", "Smith", "jsmith@gmail.com", "(+1) 555 1234567", s1, com1, add1);
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, s1, com1, supplier1);
        purchaseOrders.add(purchaseOrder1);

        when(purchaseOrderRep.save(purchaseOrder1)).thenReturn(purchaseOrder1);

        assertEquals(purchaseOrder1, purchaseOrderSer.createPurchaseOrder(purchaseOrder1));
    }

    /**
     * Test the updatePurchaseOrder method of PurchaseOrderService.
     * Verify that the purchaseOrder object is updated using the PurchaseOrderRepository save method.
     */
    @Test
    @Order(4)
    public void test_updatePurchaseOrder() {
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Supplier supplier1 = new Supplier(1, "James", "Smith", "jsmith@gmail.com", "(+1) 555 1234567", s1, com1, add1);
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, s1, com1, supplier1);
        purchaseOrders.add(purchaseOrder1);

        when(purchaseOrderRep.save(purchaseOrder1)).thenReturn(purchaseOrder1);

        assertEquals(purchaseOrder1, purchaseOrderSer.updatePurchaseOrder(purchaseOrder1));
    }

    /**
     * Test the deletePurchaseOrderById method of PurchaseOrderService.
     * Verify that the correct purchaseOrder object is deleted for a given purchaseOrder ID.
     */
    @Test
    @Order(5)
    public void test_deletePurchaseOrderById() {
        Address add2 = new Address(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Supplier supplier2 = new Supplier(2, "John", "Doe", "jdoe@gmail.com", "(+1) 555 1234567", s2, com2, add2);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(1, 400.0, s2, com2, supplier2);
        purchaseOrders.add(purchaseOrder2);

        purchaseOrderSer.deletePurchaseOrderById(purchaseOrder2.getPurchaseOrderId());
        verify(purchaseOrderRep, times(1));
    }
}