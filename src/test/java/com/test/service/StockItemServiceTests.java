package com.test.service;

import com.main.entity.StockItem;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import com.main.dto.StockItemDTO;
import com.main.mapper.StockItemMapper;
import com.main.repository.StockItemRepository;
import com.main.service.StockItemService;
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
@SpringBootTest(classes = {StockItemServiceTests.class})
public class StockItemServiceTests {

    @Mock
    StockItemRepository stockItemRepository;

    @InjectMocks
    StockItemService stockItemService;

    List<StockItemDTO> stockItemsDTO = new ArrayList<>();
    AddressDTO addressDTO1 = new AddressDTO(1, "1-69/3", "Washington St.", "Washington", "USA", 534043);
    AddressDTO addressDTO2 = new AddressDTO(2, "4-82/1", "Mario St.", "Canada", "USA", 657382);
    CompanyDTO companyDTO1 = new CompanyDTO(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", addressDTO1);
    CompanyDTO companyDTO2 = new CompanyDTO(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", addressDTO2);
    StockItemDTO stockItemDTO1 = new StockItemDTO(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", companyDTO1);
    StockItemDTO stockItemDTO2 = new StockItemDTO(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", companyDTO2);

    /**
     * Test the getStockItems method of StockItemService.
     * Verify that all the stockItem objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllStockItems(){

        stockItemsDTO.add(stockItemDTO1);
        stockItemsDTO.add(stockItemDTO2);
        List<StockItem> stockItemList = StockItemMapper.instance.dtoToModelList(stockItemsDTO);
        when(stockItemRepository.findAll()).thenReturn(stockItemList);
        assertEquals(2, stockItemService.getStockItems().size());
    }

    /**
     * Test the getStockItemsById method of StockItemsService.
     * Verify that the correct stockItems object is returned for a given stockItems ID.
     */
    @Test
    @Order(2)
    public void test_getStockItemById(){

        stockItemsDTO.add(stockItemDTO1);
        int id=1;
        StockItem stockItem = StockItemMapper.instance.dtoToModel(stockItemDTO1);

        // Mocking the behavior of the stockItemRepository
        when(stockItemRepository.findById(id)).thenReturn(Optional.of(stockItem));

        assertEquals(id, stockItemService.getStockItemById(id).getStockItemId());
    }

    /**
     * Test the createStockItem method of StockItemService.
     * Verify that the stockItem object is saved using the StockItemRepository save method.
     */
    @Test
    @Order(3)
    public void test_createCustomer(){

        StockItem stockItemEntity = StockItemMapper.instance.dtoToModel(stockItemDTO1);

        when(stockItemRepository.save(stockItemEntity)).thenReturn(stockItemEntity);

        assertEquals(stockItemDTO1.getStockItemId(), stockItemService.createStockItem(stockItemDTO1).getStockItemId());
    }

    /**
     * Test the updateStockItems method of StockItemsService.
     * Verify that the stockItems object is updated using the StockItemsRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateStockItems(){

        StockItem stockItemEntity = StockItemMapper.instance.dtoToModel(stockItemDTO1);

        when(stockItemRepository.save(stockItemEntity)).thenReturn(stockItemEntity);

        assertEquals(stockItemDTO1.getStockItemId(), stockItemService.updateStockItem(stockItemDTO1).getStockItemId());
    }

    /**
     * Test the deleteStockItems method of StockItemsService.
     * Verify that the correct stockItems object is deleted for a given customer ID.
     */
    @Test
    @Order(5)
    public void test_deleteStockItemsById() {

        StockItem stockItemEntity = StockItemMapper.instance.dtoToModel(stockItemDTO2);

        stockItemService.deleteStockItemById(stockItemEntity.getStockItemId());
        verify(stockItemRepository, times(1));
    }
}