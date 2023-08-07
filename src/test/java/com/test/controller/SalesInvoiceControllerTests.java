package com.test.controller;

import com.main.beans.*;
import com.main.controller.AddResponse;
import com.main.controller.SalesInvoiceController;
import com.main.service.SalesInvoiceService;
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
 * This class contains unit tests for the SalesInvoiceController using Mockito framework.
 * It tests the behaviour of the SalesInvoiceController methods in isolation.
 * The SalesInvoiceControllerMockitoTest class uses Mockito to mock dependencies, such as the
 * SalesInvoiceService, to focus solely on testing the controller layer.
 * Test Cases:
 * - Test all salesInvoices retrieval and verify that the SalesInvoiceService getSalesInvoices method is called.
 * - Test salesInvoice retrieval by ID and verify that the getSalesInvoiceById method is called.
 * - Test salesInvoice creation and verify that the SalesInvoiceService createSalesInvoice method is called.
 * - Test salesInvoice update and verify that the SalesInvoiceService updateSalesInvoice method is called.
 * - Test salesInvoice deletion and verify that the SalesInvoiceService deleteSalesInvoiceById method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * SalesInvoiceController implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {SalesInvoiceControllerTests.class})
public class SalesInvoiceControllerTests {

    @Mock
    SalesInvoiceService salesInvoiceService;

    @InjectMocks
    SalesInvoiceController salesInvoiceController;

    List<SalesInvoice> salesInvoices = new ArrayList<>();

    /**
     * Test the getAllSalesInvoices method of SalesInvoiceController.
     * Verify that all the salesInvoice objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllSalesInvoices(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", s2, add2);

        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", com1, s1, customer1);
        salesInvoices.add(salesInvoice1);

        SalesInvoice salesInvoice2 = new SalesInvoice(2, 400.0, "18-04-2023","567whsusjns7h", com2, s2, customer2);
        salesInvoices.add(salesInvoice2);

        when(salesInvoiceService.getSalesInvoices()).thenReturn(salesInvoices);
        assertEquals(2,salesInvoiceController.getAllSalesInvoices().size());
    }

    /**
     * Test the getSalesInvoiceById method of PurchaseSalesController.
     * Verify that the correct salesInvoice object is returned for a given salesInvoice ID.
     */
    @Test
    @Order(2)
    public void test_getSalesInvoiceById(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", s2, add2);

        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", com1, s1, customer1);
        salesInvoices.add(salesInvoice1);


        SalesInvoice salesInvoice2 = new SalesInvoice(2, 400.0, "18-04-2023","567whsusjns7h", com2, s2, customer2);
        salesInvoices.add(salesInvoice2);

        when(salesInvoiceService.getSalesInvoiceById(1)).thenReturn(salesInvoice1);
        ResponseEntity<SalesInvoice> res  = salesInvoiceController.getSalesInvoiceById(1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(1, Objects.requireNonNull(res.getBody()).getSalesInvoiceId());
    }

    /**
     * Test the createSalesInvoice method of PurchaseSalesController.
     * Verify that the salesInvoice object is saved using the SalesInvoiceRepository save method.
     */
    @Test
    @Order(3)
    public void test_createSalesInvoice(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);

        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", com1, s1, customer1);
        salesInvoices.add(salesInvoice1);

        when(salesInvoiceService.createSalesInvoice(salesInvoice1)).thenReturn(salesInvoice1);
        assertEquals(salesInvoice1,salesInvoiceController.createSalesInvoice(salesInvoice1));
    }

    /**
     * Test the updateSalesInvoice method of SalesInvoiceController.
     * Verify that the salesInvoice object is updated using the SalesInvoiceRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateSalesInvoice(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);

        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", com1, s1, customer1);
        salesInvoices.add(salesInvoice1);

        when(salesInvoiceService.updateSalesInvoice(salesInvoice1)).thenReturn(salesInvoice1);
        ResponseEntity<SalesInvoice> res = salesInvoiceController.updateSalesInvoice(salesInvoice1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(salesInvoice1,res.getBody());
    }

    /**
     * Test the deleteSalesInvoiceById method of PurchaseSalesController.
     * Verify that the correct salesInvoice object is deleted for a given salesInvoice ID.
     */
    @Test
    @Order(5)
    public void test_deleteSalesInvoiceById(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);

        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", com1, s1, customer1);
        salesInvoices.add(salesInvoice1);

        AddResponse addResponse = new AddResponse();
        addResponse.setId(1);
        addResponse.setMsg("PurchaseInvoice deleted");
        when(salesInvoiceService.deleteSalesInvoiceById(1)).thenReturn(addResponse);
        assertEquals(addResponse,salesInvoiceController.deleteSalesInvoiceById(1));
    }
}