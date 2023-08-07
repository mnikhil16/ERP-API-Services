package com.test.controller;

import com.main.beans.*;
import com.main.controller.AddResponse;
import com.main.controller.PurchaseInvoiceController;
import com.main.service.PurchaseInvoiceService;
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
@SpringBootTest(classes = {PurchaseInvoiceControllerTests.class})
public class PurchaseInvoiceControllerTests {

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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);
        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", s2, com2, add2);
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", com1, supplier1);
        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", com2, supplier2);
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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);
        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", s2, com2, add2);
        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", com1, supplier1);
        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", com2, supplier2);
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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);

        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", com1, supplier1);

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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);

        PurchaseInvoice purchaseInvoice1 = new PurchaseInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", com1, supplier1);

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

        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);

        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);

        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);

        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", s2, com2, add2);

        PurchaseInvoice purchaseInvoice2 = new PurchaseInvoice(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", com2, supplier2);

        purchaseInvoices.add(purchaseInvoice2);

        AddResponse addResponse = new AddResponse();
        addResponse.setId(2);
        addResponse.setMsg("PurchaseInvoice deleted");
        when(purchaseInvoiceService.deletePurchaseInvoiceById(2)).thenReturn(addResponse);
        assertEquals(addResponse,purchaseInvoiceController.deletePurchaseInvoiceById(2));
    }
}