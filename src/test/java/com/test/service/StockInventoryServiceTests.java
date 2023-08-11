package com.test.service;

import com.main.entity.*;
import com.main.dto.*;
import com.main.mapper.StockInventoryMapper;
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
import java.util.Optional;

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
     * Test the getStockInventories method of StockInventoryService.
     * Verify that all the stockInventory objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllStockInventories() {

        stockInventoriesDTO.add(stockInventoryDTO1);
        stockInventoriesDTO.add(stockInventoryDTO2);
        List<StockInventory> stockInventoryList = StockInventoryMapper.instance.dtoToModelList(stockInventoriesDTO);
        when(stockInventoryRepository.findAll()).thenReturn(stockInventoryList);
        assertEquals(2, stockInventoryService.getStockInventories().size());
    }

    /**
     * Test the getStockInventoryById method of StockInventoryService.
     * Verify that the correct stockInventory object is returned for a given stockInventory ID.
     */
    @Test
    @Order(2)
    public void test_getStockInventoryById() {

        stockInventoriesDTO.add(stockInventoryDTO1);
        stockInventoriesDTO.add(stockInventoryDTO2);
        int id = 1;
        StockInventory stockInventory = StockInventoryMapper.instance.dtoToModel(stockInventoryDTO1);

        // Mocking the behavior of the stockInventoryRepository
        when(stockInventoryRepository.findById(id)).thenReturn(Optional.of(stockInventory));

        assertEquals(id, stockInventoryService.getStockInventoryById(id).getStockInventoryId());
    }

    /**
     * Test the createStockInventory method of StockInventoryService.
     * Verify that the stockInventory object is saved using the StockInventoryRepository save method.
     */
    @Test
    @Order(3)
    public void test_createStockInventory() {

        StockInventory stockInventoryEntity = StockInventoryMapper.instance.dtoToModel(stockInventoryDTO1);

        when(stockInventoryRepository.save(stockInventoryEntity)).thenReturn(stockInventoryEntity);

        assertEquals(stockInventoryDTO1.getStockInventoryId(), stockInventoryService.createStockInventory(stockInventoryDTO1).getStockInventoryId());
    }

    /**
     * Test the updateStockInventory method of StockInventoryService.
     * Verify that the stockInventory object is updated using the StockInventoryRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateStockInventory() {
        StockInventory stockInventoryEntity = StockInventoryMapper.instance.dtoToModel(stockInventoryDTO1);


        when(stockInventoryRepository.save(stockInventoryEntity)).thenReturn(stockInventoryEntity);

        assertEquals(stockInventoryDTO1.getStockInventoryId(), stockInventoryService.updateStockInventory(stockInventoryDTO1).getStockInventoryId());
    }

    /**
     * Test the deleteStockInventoryById method of StockInventoryService.
     * Verify that the correct stockInventory object is deleted for a given stockInventory ID.
     */
    @Test
    @Order(5)
    public void test_deleteStockInventoryById() {

        StockInventory stockInventoryEntity = StockInventoryMapper.instance.dtoToModel(stockInventoryDTO2);

        stockInventoryService.deleteStockInventoryById(stockInventoryEntity.getStockInventoryId());
        verify(stockInventoryRepository, times(1));
    }
}