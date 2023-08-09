package com.test.controller;

import com.main.controller.AddResponse;
import com.main.controller.StockInventoryController;
import com.main.dto.*;
import com.main.service.StockInventoryService;
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
@SpringBootTest(classes = {CustomerControllerTests.class})
public class StockInventoryControllerTests {

    @Mock
    StockInventoryService stockInventoryService;

    @InjectMocks
    StockInventoryController stockInventoryController;

    List<StockInventoryDTO> stockInventoriesDTO = new ArrayList<>();
    AddressDTO addressDTO1 = new AddressDTO(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
    AddressDTO addressDTO2 = new AddressDTO(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
    CompanyDTO companyDTO1 = new CompanyDTO(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", addressDTO1);
    CompanyDTO companyDTO2 = new CompanyDTO(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", addressDTO2);
    StockItemDTO stockItemDTO1 = new StockItemDTO(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", companyDTO1);
    StockItemDTO stockItemDTO2 = new StockItemDTO(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", companyDTO2);
    StoreDTO storeDTO1 = new StoreDTO(1, "Laundry", "Washington St.", companyDTO1, addressDTO1);
    StoreDTO storeDTO2 = new StoreDTO(2, "Food Store", "Washington St.", companyDTO2, addressDTO2);
    SupplierDTO supplierDTO1 = new SupplierDTO(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", storeDTO1, companyDTO1, addressDTO1);
    SupplierDTO supplierDTO2 = new SupplierDTO(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", storeDTO2, companyDTO2, addressDTO2);
    StockInventoryDTO stockInventoryDTO1 = new StockInventoryDTO(1, 20, "01-04-2023", stockItemDTO1, storeDTO1, supplierDTO1);
    StockInventoryDTO stockInventoryDTO2 = new StockInventoryDTO(2, 30, "23-03-2023", stockItemDTO2, storeDTO2, supplierDTO2);

    /**
     * Test the getAllStockInventories method of StockInventoryController.
     * Verify that all the stockInventory objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllStockInventories(){

        stockInventoriesDTO.add(stockInventoryDTO1);
        stockInventoriesDTO.add(stockInventoryDTO2);

        when(stockInventoryService.getStockInventories()).thenReturn(stockInventoriesDTO);
        assertEquals(2,stockInventoryController.getAllStockInventories().size());
    }

    /**
     * Test the getStockInventoryById method of StockInventoryController.
     * Verify that the correct stockInventory object is returned for a given stockInventory ID.
     */
    @Test
    @Order(2)
    public void test_getStockInventoryById(){
        
        when(stockInventoryService.getStockInventoryById(1)).thenReturn(stockInventoryDTO1);
        ResponseEntity<StockInventoryDTO> responseEntity  = stockInventoryController.getStockInventoryById(1);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getStockInventoryId());
    }

    /**
     * Test the createStockInventory method of StockInventoryController.
     * Verify that the stockInventory object is saved using the StockInventoryRepository save method.
     */
    @Test
    @Order(3)
    public void test_createStockInventory(){


        when(stockInventoryService.createStockInventory(stockInventoryDTO1)).thenReturn(stockInventoryDTO1);
        assertEquals(stockInventoryDTO1,stockInventoryController.createStockInventory(stockInventoryDTO1));
    }

    /**
     * Test the updateStockInventory method of StockInventoryController.
     * Verify that the stockInventory object is updated using the StockInventoryRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateStockInventory(){

        when(stockInventoryService.updateStockInventory(stockInventoryDTO1)).thenReturn(stockInventoryDTO1);
        ResponseEntity<StockInventoryDTO> res = stockInventoryController.updateStockInventory(stockInventoryDTO1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(stockInventoryDTO1,res.getBody());
    }

    /**
     * Test the deleteStockInventoryById method of StockInventoryController.
     * Verify that the correct stockInventory object is deleted for a given stockInventory ID.
     */
    @Test
    @Order(5)
    public void test_deleteStockInventoryById(){
        int id = stockInventoryDTO2.getStockInventoryId();

        AddResponse addResponse = new AddResponse();
        addResponse.setId(id);
        addResponse.setMsg("StockInventory deleted");
        when(stockInventoryService.deleteStockInventoryById(id)).thenReturn(addResponse);
        assertEquals(addResponse,stockInventoryController.deleteStockInventoryById(id));
    }
}