package com.test.service;

import com.main.beans.*;
import com.main.repository.PurchaseOrderItemRepository;
import com.main.service.PurchaseOrderItemService;
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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);
        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", com2);
        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);
        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", s2, com2, add2);
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, s1, com1, supplier1);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(2, 400.0, s2, com2, supplier2);
        PurchaseOrderItem purchaseOrderItem1 = new PurchaseOrderItem(1, 40, s1, si1, purchaseOrder1);
        PurchaseOrderItem purchaseOrderItem2 = new PurchaseOrderItem(2, 80, s2, si2, purchaseOrder2);
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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);
        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", com2);
        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);
        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", s2, com2, add2);
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, s1, com1, supplier1);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(2, 400.0, s2, com2, supplier2);
        PurchaseOrderItem purchaseOrderItem1 = new PurchaseOrderItem(1, 40, s1, si1, purchaseOrder1);
        PurchaseOrderItem purchaseOrderItem2 = new PurchaseOrderItem(2, 80, s2, si2, purchaseOrder2);
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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);

        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);

        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, s1, com1, supplier1);

        PurchaseOrderItem purchaseOrderItem1 = new PurchaseOrderItem(1, 40, s1, si1, purchaseOrder1);

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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);

        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);

        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, 300.0, s1, com1, supplier1);

        PurchaseOrderItem purchaseOrderItem1 = new PurchaseOrderItem(1, 40, s1, si1, purchaseOrder1);

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
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);

        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);

        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);

        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", com2);

        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", s2, com2, add2);

        PurchaseOrder purchaseOrder2 = new PurchaseOrder(2, 400.0, s2, com2, supplier2);

        PurchaseOrderItem purchaseOrderItem2 = new PurchaseOrderItem(2, 80, s2, si2, purchaseOrder2);
        purchaseOrderItems.add(purchaseOrderItem2);

        purchaseOrderItemsSer.deletePurchaseOrderItemById(purchaseOrderItem2.getPurchaseOrderItemId());
        verify(purchaseOrderItemsRep, times(1));
    }
}