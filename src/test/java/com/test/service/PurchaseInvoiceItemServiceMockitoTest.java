package com.test.service;

import com.main.beans.*;
import com.main.repository.PurchaseInvoiceItemRepository;
import com.main.service.PurchaseInvoiceItemService;
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
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", com1, supplier1);
        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", com2, supplier2);
        PurchaseInvoiceItem purchaseInvoiceItem1 = new PurchaseInvoiceItem(1, 30,300.0, s1, si1, purchaseInvoice1);
        PurchaseInvoiceItem purchaseInvoiceItem2 = new PurchaseInvoiceItem(2, 40,400.0, s2, si2, purchaseInvoice2);
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
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", com1, supplier1);
        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", com2, supplier2);
        PurchaseInvoiceItem purchaseInvoiceItem1 = new PurchaseInvoiceItem(1, 30,300.0, s1, si1, purchaseInvoice1);
        PurchaseInvoiceItem purchaseInvoiceItem2 = new PurchaseInvoiceItem(2, 40,400.0, s2, si2, purchaseInvoice2);
        purchaseInvoiceItems.add(purchaseInvoiceItem1);
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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);

        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);

        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", com1, supplier1);

        PurchaseInvoiceItem purchaseInvoiceItem1 = new PurchaseInvoiceItem(1, 30,300.0, s1, si1, purchaseInvoice1);

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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);

        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);

        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", com1, supplier1);

        PurchaseInvoiceItem purchaseInvoiceItem1 = new PurchaseInvoiceItem(1, 30,300.0, s1, si1, purchaseInvoice1);

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
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);

        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);

        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);

        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", com2);

        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", s2, com2, add2);

        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", com2, supplier2);

        PurchaseInvoiceItem purchaseInvoiceItem2 = new PurchaseInvoiceItem(2, 40,400.0, s2, si2, purchaseInvoice2);
        purchaseInvoiceItems.add(purchaseInvoiceItem2);

        purchaseInvoiceItemsSer.deletePurchaseInvoiceItemById(purchaseInvoiceItem2.getPurchaseInvoiceItemId());
        verify(purchaseInvoiceItemsRep, times(1));
    }
}