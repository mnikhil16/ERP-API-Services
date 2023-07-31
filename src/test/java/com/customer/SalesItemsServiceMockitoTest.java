package com.customer;

import com.customer.beans.*;
import com.customer.repository.SalesItemsRepository;
import com.customer.service.SalesItemsService;
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
 * This class contains unit tests for the SalesItemsService using Mockito framework.
 * It tests the business logic and functionality of the SalesItemsService methods in isolation.
 * The SalesItemsServiceMockitoTest class uses Mockito to mock dependencies.
 * SalesItemsRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all salesItems retrieval and verify the expected salesItems objects are returned.
 * - Test salesItems retrieval by ID and verify the expected purchaseItems object is returned.
 * - Test salesItems creation and verify that the SalesItemsRepository save method is called.
 * - Test salesItems update and verify that the salesItemsRepository save method is called.
 * - Test salesItems deletion and verify that the salesItemsRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * SalesItemsService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StockInventoryServiceMockitoTest.class})
class SalesItemsServiceMockitoTest {

    @Mock
    SalesItemsRepository salesItemsRep;

    @InjectMocks
    SalesItemsService salesItemsSer;

    List<SalesItems> salesItems = new ArrayList<>();

    /**
     * Test the getSalesItems method of SalesItemsService.
     * Verify that all the salesItems objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllSalesItems() {
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Supplier supplier1 = new Supplier(1, "James", "Smith", "jsmith@gmail.com", "(+1) 555 1234567", s1, com1, add1);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1, com1, s1);
        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j",com1, supplier1, s1, customer1);
        SalesItems salesItem1 = new SalesItems(1, 30, 300.0, s1, salesInvoice1);
        salesItems.add(salesItem1);

        Address add2 = new Address(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Supplier supplier2 = new Supplier(2, "John", "Doe", "jdoe@gmail.com", "(+1) 555 1234567", s2, com2, add2);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", add2, com2, s2);
        SalesInvoice salesInvoice2 = new SalesInvoice(2, 400.0, "18-04-2023","567whsusjns7h",com2, supplier2, s2, customer2);
        SalesItems salesItem2 = new SalesItems(1, 30, 300.0, s2, salesInvoice2);
        salesItems.add(salesItem2);

        when(salesItemsRep.findAll()).thenReturn(salesItems);
        assertEquals(2, salesItemsSer.getSalesItems().size());
    }

    /**
     * Test the getSalesItemsById method of SalesItemsService.
     * Verify that the correct salesItems object is returned for a given salesItems ID.
     */
    @Test
    @Order(2)
    public void test_getSalesItemsById() {
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Supplier supplier1 = new Supplier(1, "James", "Smith", "jsmith@gmail.com", "(+1) 555 1234567", s1, com1, add1);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1, com1, s1);
        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j",com1, supplier1, s1, customer1);
        SalesItems salesItem1 = new SalesItems(1, 30, 300.0, s1, salesInvoice1);
        salesItems.add(salesItem1);

        Address add2 = new Address(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Supplier supplier2 = new Supplier(2, "John", "Doe", "jdoe@gmail.com", "(+1) 555 1234567", s2, com2, add2);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", add2, com2, s2);
        SalesInvoice salesInvoice2 = new SalesInvoice(2, 400.0, "18-04-2023","567whsusjns7h",com2, supplier2, s2, customer2);
        SalesItems salesItem2 = new SalesItems(1, 30, 300.0, s2, salesInvoice2);
        salesItems.add(salesItem2);

        int id = 1;

        when(salesItemsRep.findAll()).thenReturn(salesItems);

        assertEquals(id, salesItemsSer.getSalesItemsById(id).getSalesItemsId());
    }

    /**
     * Test the createSalesItems method of SalesItemsService.
     * Verify that the SalesItems object is saved using the SalesItemsRepository save method.
     */
    @Test
    @Order(3)
    public void test_createSalesInvoice() {
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Supplier supplier1 = new Supplier(1, "James", "Smith", "jsmith@gmail.com", "(+1) 555 1234567", s1, com1, add1);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1, com1, s1);
        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j",com1, supplier1, s1, customer1);
        SalesItems salesItem1 = new SalesItems(1, 30, 300.0, s1, salesInvoice1);
        salesItems.add(salesItem1);

        when(salesItemsRep.save(salesItem1)).thenReturn(salesItem1);

        assertEquals(salesItem1, salesItemsSer.createSalesItems(salesItem1));
    }

    /**
     * Test the updateSalesItems method of SalesItemsService.
     * Verify that the salesItems object is updated using the SalesItemsRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateSalesInvoice() {
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Supplier supplier1 = new Supplier(1, "James", "Smith", "jsmith@gmail.com", "(+1) 555 1234567", s1, com1, add1);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1, com1, s1);
        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j",com1, supplier1, s1, customer1);
        SalesItems salesItem1 = new SalesItems(1, 30, 300.0, s1, salesInvoice1);
        salesItems.add(salesItem1);

        when(salesItemsRep.save(salesItem1)).thenReturn(salesItem1);

        assertEquals(salesItem1, salesItemsSer.updateSalesItems(salesItem1));
    }

    /**
     * Test the deleteSalesItemsById method of SalesItemsService.
     * Verify that the correct salesItems object is deleted for a given salesItems ID.
     */
    @Test
    @Order(5)
    public void test_deleteSalesItemsById() {

        Address add2 = new Address(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Supplier supplier2 = new Supplier(2, "John", "Doe", "jdoe@gmail.com", "(+1) 555 1234567", s2, com2, add2);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", add2, com2, s2);
        SalesInvoice salesInvoice2 = new SalesInvoice(2, 400.0, "18-04-2023","567whsusjns7h",com2, supplier2, s2, customer2);
        SalesItems salesItem2 = new SalesItems(1, 30, 300.0, s2, salesInvoice2);
        salesItems.add(salesItem2);

        salesItemsSer.deleteSalesItemsById(salesItem2.getSalesItemsId());
        verify(salesItemsRep, times(1));
    }
}