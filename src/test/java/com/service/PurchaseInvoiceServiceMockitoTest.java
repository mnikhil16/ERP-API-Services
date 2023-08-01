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
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Supplier supplier1 = new Supplier(1, "James", "Smith", "jsmith@gmail.com", "(+1) 555 1234567", s1, com1, add1);
        Supplier supplier2 = new Supplier(2, "John", "Doe", "jdoe@gmail.com", "(+1) 555 1234567", s2, com2, add2);
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", com1, supplier1);
        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", com2, supplier2);
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
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Supplier supplier1 = new Supplier(1, "James", "Smith", "jsmith@gmail.com", "(+1) 555 1234567", s1, com1, add1);
        Supplier supplier2 = new Supplier(2, "John", "Doe", "jdoe@gmail.com", "(+1) 555 1234567", s2, com2, add2);
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", com1, supplier1);
        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", com2, supplier2);
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
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Supplier supplier1 = new Supplier(1, "James", "Smith", "jsmith@gmail.com", "(+1) 555 1234567", s1, com1, add1);
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", com1, supplier1);
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
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Supplier supplier1 = new Supplier(1, "James", "Smith", "jsmith@gmail.com", "(+1) 555 1234567", s1, com1, add1);
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", com1, supplier1);
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
        Address add2 = new Address(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Supplier supplier2 = new Supplier(2, "John", "Doe", "jdoe@gmail.com", "(+1) 555 1234567", s2, com2, add2);
        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", com2, supplier2);
        purchaseInvoices.add(purchaseInvoice2);

        purchaseInvoiceSer.deletePurchaseInvoiceById(purchaseInvoice2.getPurchaseInvoiceId());
        verify(purchaseInvoiceRep, times(1));
    }
}