package com.test.service;

import com.main.beans.*;
import com.main.repository.StockInventoryRepository;
import com.main.service.StockInventoryService;
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
 * This class contains unit tests for the StockInventoryService using Mockito framework.
 * It tests the business logic and functionality of the StockInventoryService methods in isolation.
 * The StockInventoryServiceTests class uses Mockito to mock dependencies.
 * StockInventoryRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all stockInventories retrieval and verify the expected stockInventory objects are returned.
 * - Test stockInventory retrieval by ID and verify the expected stockInventory object is returned.
 * - Test stockInventory creation and verify that the StockInventoryRepository save method is called.
 * - Test stockInventory update and verify that the StockInventoryRepository save method is called.
 * - Test stockInventory deletion and verify that the StockInventoryRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * StockInventoryService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StockInventoryServiceTests.class})
class StockInventoryServiceTests {

    @Mock
    StockInventoryRepository stockInventoryRepository;

    @InjectMocks
    StockInventoryService stockInventoryService;

    List<StockInventory> stockInventories = new ArrayList<>();

    /**
     * Test the getStockInventories method of StockInventoryService.
     * Verify that all the stockInventory objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllStockInventories() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);
        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", com2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);
        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", s2, com2, add2);
        StockInventory stockInventory1 = new StockInventory(1, 20, "01-04-2023", si1, s1, supplier1);
        StockInventory stockInventory2 = new StockInventory(2, 30, "23-03-2023", si2, s2, supplier2);
        stockInventories.add(stockInventory1);
        stockInventories.add(stockInventory2);

        when(stockInventoryRepository.findAll()).thenReturn(stockInventories);
        assertEquals(2, stockInventoryService.getStockInventories().size());
    }

    /**
     * Test the getStockInventoryById method of StockInventoryService.
     * Verify that the correct stockInventory object is returned for a given stockInventory ID.
     */
    @Test
    @Order(2)
    public void test_getStockInventoryById() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);
        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", com2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);
        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", s2, com2, add2);
        StockInventory stockInventory1 = new StockInventory(1, 20, "01-04-2023", si1, s1, supplier1);
        StockInventory stockInventory2 = new StockInventory(2, 30, "23-03-2023", si2, s2, supplier2);
        stockInventories.add(stockInventory1);
        stockInventories.add(stockInventory2);
        int id = 1;

        when(stockInventoryRepository.findAll()).thenReturn(stockInventories);

        assertEquals(id, stockInventoryService.getStockInventoryById(id).getStockInventoryId());
    }

    /**
     * Test the createStockInventory method of StockInventoryService.
     * Verify that the stockInventory object is saved using the StockInventoryRepository save method.
     */
    @Test
    @Order(3)
    public void test_createStockInventory() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);

        StockInventory stockInventory1 = new StockInventory(1, 20, "01-04-2023", si1, s1, supplier1);

        stockInventories.add(stockInventory1);

        when(stockInventoryRepository.save(stockInventory1)).thenReturn(stockInventory1);

        assertEquals(stockInventory1, stockInventoryService.createStockInventory(stockInventory1));
    }

    /**
     * Test the updateStockInventory method of StockInventoryService.
     * Verify that the stockInventory object is updated using the StockInventoryRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateStockInventory() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", s1, com1, add1);

        StockInventory stockInventory1 = new StockInventory(1, 20, "01-04-2023", si1, s1, supplier1);

        stockInventories.add(stockInventory1);

        when(stockInventoryRepository.save(stockInventory1)).thenReturn(stockInventory1);

        assertEquals(stockInventory1, stockInventoryService.updateStockInventory(stockInventory1));
    }

    /**
     * Test the deleteStockInventoryById method of StockInventoryService.
     * Verify that the correct stockInventory object is deleted for a given stockInventory ID.
     */
    @Test
    @Order(5)
    public void test_deleteStockInventoryById() {

        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);

        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);

        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", com2);

        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);

        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", s2, com2, add2);

        StockInventory stockInventory2 = new StockInventory(2, 30, "23-03-2023", si2, s2, supplier2);

        stockInventories.add(stockInventory2);

        stockInventoryService.deleteStockInventoryById(stockInventory2.getStockInventoryId());
        verify(stockInventoryRepository, times(1));
    }
}