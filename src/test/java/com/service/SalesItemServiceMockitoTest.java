package com.service;

import com.customer.beans.*;
import com.customer.repository.SalesItemRepository;
import com.customer.service.SalesItemService;
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
 * The SalesItemServiceMockitoTest class uses Mockito to mock dependencies.
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
@SpringBootTest(classes = {StockInventoryServiceMockitoTest.class})
class SalesItemServiceMockitoTest {

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

        SalesItem salesItem1 = new SalesItem(1, 30, 300.0, 1);
        salesItems.add(salesItem1);

        SalesItem salesItem2 = new SalesItem(1, 30, 300.0, 2);
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
        SalesItem salesItem1 = new SalesItem(1, 30, 300.0, 1);
        salesItems.add(salesItem1);

        SalesItem salesItem2 = new SalesItem(1, 30, 300.0, 2);
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
        SalesItem salesItem1 = new SalesItem(1, 30, 300.0, 1);
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
        SalesItem salesItem1 = new SalesItem(1, 30, 300.0, 1);
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
        SalesItem salesItem2 = new SalesItem(1, 30, 300.0, 2);
        salesItems.add(salesItem2);

        salesItemService.deleteSalesItemById(salesItem2.getSalesItemId());
        verify(salesItemRepository, times(1));
    }
}