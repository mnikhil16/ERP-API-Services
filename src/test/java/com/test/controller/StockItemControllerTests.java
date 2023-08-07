package com.test.controller;

import com.main.beans.Address;
import com.main.beans.Company;
import com.main.beans.StockItem;
import com.main.controller.AddResponse;
import com.main.controller.StockItemController;
import com.main.service.StockItemService;
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
 * This class contains unit tests for the StockItemController using Mockito framework.
 * It tests the behaviour of the StockItemController methods in isolation.
 * The StockItemControllerMockitoTest class uses Mockito to mock dependencies, such as the
 * StockItemService, to focus solely on testing the controller layer.
 * Test Cases:
 * - Test all stockItems retrieval and verify that the StockItemsService getStockItems method is called.
 * - Test stockItem retrieval by ID and verify that the getStockItemById method is called.
 * - Test stockItem creation and verify that the StockItemService createStockItem method is called.
 * - Test stockItem update and verify that the StockItemService updateStockItem method is called.
 * - Test stockItem deletion and verify that the StockItemService deleteStockItemBYId method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * StockItemController implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StockItemControllerTests.class})
public class StockItemControllerTests {

    @Mock
    StockItemService stockItemService;

    @InjectMocks
    StockItemController stockItemController;

    List<StockItem> stockItems = new ArrayList<>();

    /**
     * Test the getAllStockItems method of StockItemController.
     * Verify that all the stockItem objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllStockItems(){
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);
        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", com2);
        stockItems.add(si1);
        stockItems.add(si2);

        when(stockItemService.getStockItems()).thenReturn(stockItems);
        assertEquals(2,stockItemController.getAllStockItems().size());
    }

    /**
     * Test the getStockItemById method of StockItemController.
     * Verify that the correct customer object is returned for a given stockItem ID.
     */
    @Test
    @Order(2)
    public void test_getStockItemById(){
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);
        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", com2);
        stockItems.add(si1);
        stockItems.add(si2);

        when(stockItemService.getStockItemById(1)).thenReturn(si1);
        ResponseEntity<StockItem> res  = stockItemController.getStockItemById(1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(1, Objects.requireNonNull(res.getBody()).getStockItemId());
    }

    /**
     * Test the createStockItem method of StockItemController.
     * Verify that the stockItem object is saved using the StockItemRepository save method.
     */
    @Test
    @Order(3)
    public void test_createStockItem(){
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);
        stockItems.add(si1);

        when(stockItemService.createStockItem(si1)).thenReturn(si1);
        assertEquals(si1,stockItemController.createStockItem(si1));
    }

    /**
     * Test the updateStockItem method of StockItemController.
     * Verify that the stockItem object is updated using the StockItemRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateStockItem(){
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);
        stockItems.add(si1);


        when(stockItemService.updateStockItem(si1)).thenReturn(si1);
        ResponseEntity<StockItem> res = stockItemController.updateStockItem(si1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(si1,res.getBody());
    }

    /**
     * Test the deleteStockItemById method of StockItemController.
     * Verify that the correct stockItem object is deleted for a given stockItem ID.
     */
    @Test
    @Order(5)
    public void test_deleteStockItemById(){
        Address add1 = new Address(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", com1);
        stockItems.add(si1);

        AddResponse addResponse = new AddResponse();
        addResponse.setId(1);
        addResponse.setMsg("StockItem deleted");
        when(stockItemService.deleteStockItemById(1)).thenReturn(addResponse);
        assertEquals(addResponse,stockItemController.deleteStockItemById(1));
    }
}