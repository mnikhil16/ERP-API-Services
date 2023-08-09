package com.test.controller;

import com.main.controller.AddResponse;
import com.main.controller.StockItemController;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import com.main.dto.StockItemDTO;
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

    List<StockItemDTO> stockItemsDTO = new ArrayList<>();
    AddressDTO addressDTO1 = new AddressDTO(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
    AddressDTO addressDTO2 = new AddressDTO(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
    CompanyDTO companyDTO1 = new CompanyDTO(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", addressDTO1);
    CompanyDTO companyDTO2 = new CompanyDTO(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", addressDTO2);
    StockItemDTO stockItemDTO1 = new StockItemDTO(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", companyDTO1);
    StockItemDTO stockItemDTO2 = new StockItemDTO(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", companyDTO2);

    /**
     * Test the getAllStockItems method of StockItemController.
     * Verify that all the stockItem objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllStockItems(){

        stockItemsDTO.add(stockItemDTO1);
        stockItemsDTO.add(stockItemDTO2);

        when(stockItemService.getStockItems()).thenReturn(stockItemsDTO);
        assertEquals(2,stockItemController.getAllStockItems().size());
    }

    /**
     * Test the getStockItemById method of StockItemController.
     * Verify that the correct customer object is returned for a given stockItem ID.
     */
    @Test
    @Order(2)
    public void test_getStockItemById(){
        
        when(stockItemService.getStockItemById(1)).thenReturn(stockItemDTO1);
        ResponseEntity<StockItemDTO> responseEntity  = stockItemController.getStockItemById(1);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getStockItemId());
    }

    /**
     * Test the createStockItem method of StockItemController.
     * Verify that the stockItem object is saved using the StockItemRepository save method.
     */
    @Test
    @Order(3)
    public void test_createStockItem(){

        when(stockItemService.createStockItem(stockItemDTO1)).thenReturn(stockItemDTO1);
        assertEquals(stockItemDTO1,stockItemController.createStockItem(stockItemDTO1));
    }

    /**
     * Test the updateStockItem method of StockItemController.
     * Verify that the stockItem object is updated using the StockItemRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateStockItem(){

        when(stockItemService.updateStockItem(stockItemDTO1)).thenReturn(stockItemDTO1);
        ResponseEntity<StockItemDTO> res = stockItemController.updateStockItem(stockItemDTO1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(stockItemDTO1,res.getBody());
    }

    /**
     * Test the deleteStockItemById method of StockItemController.
     * Verify that the correct stockItem object is deleted for a given stockItem ID.
     */
    @Test
    @Order(5)
    public void test_deleteStockItemById(){
        int id = stockItemDTO2.getStockItemId();
        AddResponse addResponse = new AddResponse();
        addResponse.setId(id);
        addResponse.setMsg("StockItem deleted");
        when(stockItemService.deleteStockItemById(id)).thenReturn(addResponse);
        assertEquals(addResponse,stockItemController.deleteStockItemById(id));
    }
}