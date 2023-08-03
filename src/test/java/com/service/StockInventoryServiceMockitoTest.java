package com.service;

import com.customer.beans.*;
import com.customer.repository.StockInventoryRepository;
import com.customer.service.StockInventoryService;
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
 * The StockInventoryServiceMockitoTest class uses Mockito to mock dependencies.
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
@SpringBootTest(classes = {StockInventoryServiceMockitoTest.class})
class StockInventoryServiceMockitoTest {

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
        StockInventory stockInventory1 = new StockInventory(1, 20, "01-04-2023", 1, 1, 1);
        StockInventory stockInventory2 = new StockInventory(2, 30, "23-03-2023", 2, 2, 2);
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
        StockInventory stockInventory1 = new StockInventory(1, 20, "01-04-2023", 1, 1, 1);
        StockInventory stockInventory2 = new StockInventory(2, 30, "23-03-2023", 2, 2, 2);
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
        StockInventory stockInventory1 = new StockInventory(1, 20, "01-04-2023", 1, 1, 1);
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

        StockInventory stockInventory1 = new StockInventory(1, 20, "01-04-2023", 1, 1, 1);
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
        StockInventory stockInventory2 = new StockInventory(2, 30, "23-03-2023", 2, 2, 2);
        stockInventories.add(stockInventory2);

        stockInventoryService.deleteStockInventoryById(stockInventory2.getStockInventoryId());
        verify(stockInventoryRepository, times(1));
    }
}