package com.service;

import com.customer.beans.StockItem;
import com.customer.repository.StockItemRepository;
import com.customer.service.StockItemService;
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
 * This class contains unit tests for the StockItemService using Mockito framework.
 * It tests the business logic and functionality of the StockItemService methods in isolation.
 * The StockItemsServiceMockitoTest class uses Mockito to mock dependencies.
 * CustomerRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all stockItems retrieval and verify the expected stockItem objects are returned.
 * - Test stockItem retrieval by ID and verify the expected stockItem object is returned.
 * - Test stockItem creation and verify that the StockItemRepository save method is called.
 * - Test stockItem update and verify that the StockItemRepository save method is called.
 * - Test stockItem deletion and verify that the StockItemRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * StockItemService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StockItemServiceMockitoTest.class})
public class StockItemServiceMockitoTest {

    @Mock
    StockItemRepository stockItemRepository;

    @InjectMocks
    StockItemService stockItemService;

    List<StockItem> stockItems = new ArrayList<>();

    /**
     * Test the getStockItems method of StockItemService.
     * Verify that all the stockItem objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllStockItems(){
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", 1);
        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", 2);
        stockItems.add(si1);
        stockItems.add(si2);

        when(stockItemRepository.findAll()).thenReturn(stockItems);
        assertEquals(2, stockItemService.getStockItems().size());
    }

    /**
     * Test the getStockItemsById method of StockItemsService.
     * Verify that the correct stockItems object is returned for a given stockItems ID.
     */
    @Test
    @Order(2)
    public void test_getStockItemsById(){
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", 1);
        StockItem si2 = new StockItem(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", 2);
        stockItems.add(si1);
        stockItems.add(si2);
        int id=1;

        when(stockItemRepository.findAll()).thenReturn(stockItems);

        assertEquals(id, stockItemService.getStockItemById(id).getStockItemId());
    }

    /**
     * Test the createStockItem method of StockItemService.
     * Verify that the stockItem object is saved using the StockItemRepository save method.
     */
    @Test
    @Order(3)
    public void test_createCustomer(){
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", 1);
        stockItems.add(si1);

        when(stockItemRepository.save(si1)).thenReturn(si1);

        assertEquals(si1, stockItemService.createStockItem(si1));
    }

    /**
     * Test the updateStockItems method of StockItemsService.
     * Verify that the stockItems object is updated using the StockItemsRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateStockItems(){
        StockItem si1 = new StockItem(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", 1);
        stockItems.add(si1);

        when(stockItemRepository.save(si1)).thenReturn(si1);

        assertEquals(si1, stockItemService.updateStockItem(si1));
    }

    /**
     * Test the deleteStockItems method of StockItemsService.
     * Verify that the correct stockItems object is deleted for a given customer ID.
     */
    @Test
    @Order(5)
    public void test_deleteStockItemsById() {
        StockItem si2 = new StockItem(2, "Shirt", "Clothing", "XYZ", 799.0, "25-02-2023", "", "A shirt", 2);
        stockItems.add(si2);

        stockItemService.deleteStockItemById(si2.getStockItemId());
        verify(stockItemRepository, times(1));
    }
}