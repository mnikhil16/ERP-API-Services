package com.test.service;

import com.main.beans.*;
import com.main.repository.SalesItemRepository;
import com.main.service.SalesItemService;
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
 * This class contains unit tests for the SalesItemService using Mockito framework.
 * It tests the business logic and functionality of the SalesItemService methods in isolation.
 * The SalesItemServiceTests class uses Mockito to mock dependencies.
 * SalesItemsRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all salesItems retrieval and verify the expected salesItems objects are returned.
 * - Test salesItems retrieval by ID and verify the expected purchaseItems object is returned.
 * - Test salesItems creation and verify that the SalesItemsRepository save method is called.
 * - Test salesItems update and verify that the salesItemsRepository save method is called.
 * - Test salesItems deletion and verify that the salesItemsRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * SalesItemService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StockInventoryServiceTests.class})
class SalesItemServiceTests {

    @Mock
    SalesItemRepository salesItemRepository;

    @InjectMocks
    SalesItemService salesItemService;

    List<SalesItem> salesItems = new ArrayList<>();

    /**
     * Test the getSalesItems method of SalesItemService.
     * Verify that all the salesItems objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllSalesItems() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);
        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", com2);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", s2, add2);
        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", com1, s1, customer1);
        SalesInvoice salesInvoice2 = new SalesInvoice(2, 400.0, "18-04-2023","567whsusjns7h", com2, s2, customer2);

        SalesItem salesItem1 = new SalesItem(1, 30, 300.0, salesInvoice1,si1);
        salesItems.add(salesItem1);

        SalesItem salesItem2 = new SalesItem(1, 30, 300.0, salesInvoice2, si2);
        salesItems.add(salesItem2);

        when(salesItemRepository.findAll()).thenReturn(salesItems);
        assertEquals(2, salesItemService.getSalesItems().size());
    }

    /**
     * Test the getSalesItemsById method of SalesItemService.
     * Verify that the correct salesItems object is returned for a given salesItems ID.
     */
    @Test
    @Order(2)
    public void test_getSalesItemsById() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);
        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", com2);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", s2, add2);
        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", com1, s1, customer1);
        SalesInvoice salesInvoice2 = new SalesInvoice(2, 400.0, "18-04-2023","567whsusjns7h", com2, s2, customer2);

        SalesItem salesItem1 = new SalesItem(1, 30, 300.0, salesInvoice1, si1);
        salesItems.add(salesItem1);

        SalesItem salesItem2 = new SalesItem(1, 30, 300.0, salesInvoice2, si2);
        salesItems.add(salesItem2);

        int id = 1;

        when(salesItemRepository.findAll()).thenReturn(salesItems);

        assertEquals(id, salesItemService.getSalesItemById(id).getSalesItemId());
    }

    /**
     * Test the createSalesItems method of SalesItemService.
     * Verify that the SalesItem object is saved using the SalesItemsRepository save method.
     */
    @Test
    @Order(3)
    public void test_createSalesInvoice() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);

        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", com1, s1, customer1);

        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);


        SalesItem salesItem1 = new SalesItem(1, 30, 300.0, salesInvoice1, si1);
        salesItems.add(salesItem1);

        when(salesItemRepository.save(salesItem1)).thenReturn(salesItem1);

        assertEquals(salesItem1, salesItemService.createSalesItem(salesItem1));
    }

    /**
     * Test the updateSalesItems method of SalesItemService.
     * Verify that the salesItems object is updated using the SalesItemsRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateSalesInvoice() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", s1, add1);

        SalesInvoice salesInvoice1 = new SalesInvoice(1, 300.0, "16-04-2023", "348hwhsn38wu2j", com1, s1, customer1);

        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);

        SalesItem salesItem1 = new SalesItem(1, 30, 300.0, salesInvoice1, si1);
        salesItems.add(salesItem1);

        when(salesItemRepository.save(salesItem1)).thenReturn(salesItem1);

        assertEquals(salesItem1, salesItemService.updateSalesItem(salesItem1));
    }

    /**
     * Test the deleteSalesItemsById method of SalesItemService.
     * Verify that the correct salesItems object is deleted for a given salesItems ID.
     */
    @Test
    @Order(5)
    public void test_deleteSalesItemsById() {
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);

        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);

        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);

        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", s2, add2);

        SalesInvoice salesInvoice2 = new SalesInvoice(2, 400.0, "18-04-2023","567whsusjns7h", com2, s2, customer2);

        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", com2);

        SalesItem salesItem2 = new SalesItem(1, 30, 300.0, salesInvoice2, si2);
        salesItems.add(salesItem2);

        salesItemService.deleteSalesItemById(salesItem2.getSalesItemId());
        verify(salesItemRepository, times(1));
    }
}