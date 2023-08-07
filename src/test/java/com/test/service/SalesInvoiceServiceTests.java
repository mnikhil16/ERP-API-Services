package com.test.service;

import com.main.beans.*;
import com.main.repository.SalesInvoiceRepository;
import com.main.service.SalesInvoiceService;
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
 * This class contains unit tests for the SalesInvoiceService using Mockito framework.
 * It tests the business logic and functionality of the SalesInvoiceService methods in isolation.
 * The SalesInvoiceServiceTests class uses Mockito to mock dependencies.
 * SalesInvoiceRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all salesInvoices retrieval and verify the expected salesInvoice objects are returned.
 * - Test salesInvoice retrieval by ID and verify the expected purchaseInvoice object is returned.
 * - Test salesInvoice creation and verify that the SalesInvoiceRepository save method is called.
 * - Test salesInvoice update and verify that the salesInvoiceRepository save method is called.
 * - Test salesInvoice deletion and verify that the salesInvoiceRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * SalesInvoiceService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StockInventoryServiceTests.class})
class SalesInvoiceServiceTests {

    @Mock
    SalesInvoiceRepository salesInvoiceRep;

    @InjectMocks
    SalesInvoiceService salesInvoiceSer;

    List<SalesInvoice> salesInvoices = new ArrayList<>();

    /**
     * Test the getSalesInvoices method of SalesInvoiceService.
     * Verify that all the salesInvoice objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllSalesInvoices() {
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

        when(salesInvoiceRep.findAll()).thenReturn(salesInvoices);
        assertEquals(2, salesInvoiceSer.getSalesInvoices().size());
    }

    /**
     * Test the getSalesInvoiceById method of SalesInvoiceService.
     * Verify that the correct salesInvoice object is returned for a given salesInvoice ID.
     */
    @Test
    @Order(2)
    public void test_getSalesInvoiceById() {
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
        int id = 1;

        when(salesInvoiceRep.findAll()).thenReturn(salesInvoices);

        assertEquals(id, salesInvoiceSer.getSalesInvoiceById(id).getSalesInvoiceId());
    }

    /**
     * Test the createSalesInvoice method of SalesInvoiceService.
     * Verify that the SalesInvoice object is saved using the SalesInvoiceRepository save method.
     */
    @Test
    @Order(3)
    public void test_createSalesInvoice() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);

        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", com1, s1, customer1);

        salesInvoices.add(salesInvoice1);

        when(salesInvoiceRep.save(salesInvoice1)).thenReturn(salesInvoice1);

        assertEquals(salesInvoice1, salesInvoiceSer.createSalesInvoice(salesInvoice1));
    }

    /**
     * Test the updateSalesInvoice method of SalesInvoiceService.
     * Verify that the salesInvoice object is updated using the SalesInvoiceRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateSalesInvoice() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);

        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", com1, s1, customer1);
        salesInvoices.add(salesInvoice1);

        when(salesInvoiceRep.save(salesInvoice1)).thenReturn(salesInvoice1);

        assertEquals(salesInvoice1, salesInvoiceSer.updateSalesInvoice(salesInvoice1));
    }

    /**
     * Test the deleteSalesInvoiceById method of SalesInvoiceService.
     * Verify that the correct salesInvoice object is deleted for a given salesInvoice ID.
     */
    @Test
    @Order(5)
    public void test_deleteSalesInvoiceById() {
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);

        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);

        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);

        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", s2, add2);

        SalesInvoice salesInvoice2 = new SalesInvoice(2, 400.0, "18-04-2023","567whsusjns7h", com2, s2, customer2);
        salesInvoices.add(salesInvoice2);

        salesInvoiceSer.deleteSalesInvoiceById(salesInvoice2.getSalesInvoiceId());
        verify(salesInvoiceRep, times(1));
    }
}