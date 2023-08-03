package com.controller;

import com.customer.beans.*;
import com.customer.controller.AddResponse;
import com.customer.controller.StockInventoryController;
import com.customer.service.StockInventoryService;
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
 * This class contains unit tests for the StockInventoryController using Mockito framework.
 * It tests the behaviour of the CustomerController methods in isolation.
 * The CustomerControllerMockitoTest class uses Mockito to mock dependencies, such as the
 * CustomerService, to focus solely on testing the controller layer.
 * Test Cases:
 * - Test all customers retrieval and verify that the CustomerService getCustomers method is called.
 * - Test customer retrieval by ID and verify that the getCustomerById method is called.
 * - Test customer creation and verify that the CustomerService createCustomer method is called.
 * - Test customer update and verify that the CustomerService updateCustomer method is called.
 * - Test customer deletion and verify that the CustomerService deleteCustomerById method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * CustomerController implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {CustomerControllerMockitoTests.class})
public class StockInventoryControllerMockitoTests {

    @Mock
    StockInventoryService stockInventoryService;

    @InjectMocks
    StockInventoryController stockInventoryController;

    List<StockInventory> stockInventories = new ArrayList<>();

    /**
     * Test the getAllStockInventories method of StockInventoryController.
     * Verify that all the stockInventory objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllStockInventories(){
        StockInventory stockInventory1 = new StockInventory(1, 20, "01-04-2023", 1, 1, 1);
        StockInventory stockInventory2 = new StockInventory(2, 30, "23-03-2023", 2, 2, 2);
        stockInventories.add(stockInventory1);
        stockInventories.add(stockInventory2);

        when(stockInventoryService.getStockInventories()).thenReturn(stockInventories);
        assertEquals(2,stockInventoryController.getAllStockInventories().size());
    }

    /**
     * Test the getStockInventoryById method of StockInventoryController.
     * Verify that the correct stockInventory object is returned for a given stockInventory ID.
     */
    @Test
    @Order(2)
    public void test_getStockInventoryById(){
        StockInventory stockInventory1 = new StockInventory(1, 20, "01-04-2023", 1, 1, 1);
        StockInventory stockInventory2 = new StockInventory(2, 30, "23-03-2023", 2, 2, 2);
        stockInventories.add(stockInventory1);
        stockInventories.add(stockInventory2);

        when(stockInventoryService.getStockInventoryById(1)).thenReturn(stockInventory1);
        ResponseEntity<StockInventory> res  = stockInventoryController.getStockInventoryById(1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(1, Objects.requireNonNull(res.getBody()).getStockInventoryId());
    }

    /**
     * Test the createStockInventory method of StockInventoryController.
     * Verify that the stockInventory object is saved using the StockInventoryRepository save method.
     */
    @Test
    @Order(3)
    public void test_createStockInventory(){
        StockInventory stockInventory1 = new StockInventory(1, 20, "01-04-2023", 1, 1, 1);
        stockInventories.add(stockInventory1);

        when(stockInventoryService.createStockInventory(stockInventory1)).thenReturn(stockInventory1);
        assertEquals(stockInventory1,stockInventoryController.createStockInventory(stockInventory1));
    }

    /**
     * Test the updateStockInventory method of StockInventoryController.
     * Verify that the stockInventory object is updated using the StockInventoryRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateStockInventory(){
        StockInventory stockInventory1 = new StockInventory(1, 20, "01-04-2023", 1, 1, 1);
        stockInventories.add(stockInventory1);

        when(stockInventoryService.updateStockInventory(stockInventory1)).thenReturn(stockInventory1);
        ResponseEntity<StockInventory> res = stockInventoryController.updateStockInventory(stockInventory1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(stockInventory1,res.getBody());
    }

    /**
     * Test the deleteStockInventoryById method of StockInventoryController.
     * Verify that the correct stockInventory object is deleted for a given stockInventory ID.
     */
    @Test
    @Order(5)
    public void test_deleteStockInventoryById(){
        StockInventory stockInventory1 = new StockInventory(1, 20, "01-04-2023", 1, 1, 1);
        stockInventories.add(stockInventory1);

        AddResponse addResponse = new AddResponse();
        addResponse.setId(1);
        addResponse.setMsg("StockInventory deleted");
        when(stockInventoryService.deleteStockInventoryById(1)).thenReturn(addResponse);
        assertEquals(addResponse,stockInventoryController.deleteStockInventoryById(1));
    }
}