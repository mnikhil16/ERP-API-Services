package com.test.service;

import com.main.entity.*;
import com.main.dto.*;
import com.main.mapper.SalesItemMapper;
import com.main.repository.SalesItemRepository;
import com.main.service.SalesItemService;
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
 * This class contains unit tests for the SalesItemService using Mockito framework.
 * It tests the business logic and functionality of the SalesItemService methods in isolation.
 * The SalesItemServiceTests class uses Mockito to mock dependencies.
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
@SpringBootTest(classes = {StockInventoryServiceTests.class})
class SalesItemServiceTests {

    @Mock
    SalesItemRepository salesItemRepository;

    @InjectMocks
    SalesItemService salesItemService;

    List<SalesItemDTO> salesItemsDTO = new ArrayList<>();
    AddressDTO addressDTO1 = new AddressDTO(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
    AddressDTO addressDTO2 = new AddressDTO(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
    CompanyDTO companyDTO1 = new CompanyDTO(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", addressDTO1);
    CompanyDTO companyDTO2 = new CompanyDTO(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", addressDTO2);
    StoreDTO storeDTO1 = new StoreDTO(1, "Laundry", "Washington St.", companyDTO1, addressDTO1);
    StoreDTO storeDTO2 = new StoreDTO(2, "Food Store", "Washington St.", companyDTO2, addressDTO2);
    StockItemDTO stockItemDTO1 = new StockItemDTO(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", companyDTO1);
    StockItemDTO stockItemDTO2 = new StockItemDTO(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", companyDTO2);
    CustomerDTO customerDTO1 = new CustomerDTO(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567",addressDTO1, storeDTO1);
    CustomerDTO customerDTO2 = new CustomerDTO(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", addressDTO2, storeDTO2);
    SalesInvoiceDTO salesInvoiceDTO1 = new SalesInvoiceDTO(1, 300.0, "16-04-2023", "348hwhsn38wu2j", companyDTO1, storeDTO1, customerDTO1);
    SalesInvoiceDTO salesInvoiceDTO2 = new SalesInvoiceDTO(2, 400.0, "18-04-2023","567whsusjns7h", companyDTO2, storeDTO2, customerDTO2);
    SalesItemDTO salesItemDTO1 = new SalesItemDTO(1, 30, 300.0, salesInvoiceDTO1, stockItemDTO1);
    SalesItemDTO salesItemDTO2 = new SalesItemDTO(1, 30, 300.0, salesInvoiceDTO2, stockItemDTO2);

    /**
     * Test the getSalesItems method of SalesItemService.
     * Verify that all the salesItems objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllSalesItems() {

        salesItemsDTO.add(salesItemDTO1);
        salesItemsDTO.add(salesItemDTO2);
        List<SalesItem> salesItemList = SalesItemMapper.instance.dtoToModelList(salesItemsDTO);
        when(salesItemRepository.findAll()).thenReturn(salesItemList);
        assertEquals(2, salesItemService.getSalesItems().size());
    }

    /**
     * Test the getSalesItemsById method of SalesItemService.
     * Verify that the correct salesItems object is returned for a given salesItems ID.
     */
    @Test
    @Order(2)
    public void test_getSalesItemsById() {

        salesItemsDTO.add(salesItemDTO1);
        salesItemsDTO.add(salesItemDTO2);
        int id = 1;

        SalesItem salesItem = SalesItemMapper.instance.dtoToModel(salesItemDTO1);

        // Mocking the behavior of the salesItemRepository
        when(salesItemRepository.findById(id)).thenReturn(Optional.of(salesItem));

        assertEquals(id, salesItemService.getSalesItemById(id).getSalesItemId());
    }

    /**
     * Test the createSalesItems method of SalesItemService.
     * Verify that the SalesItem object is saved using the SalesItemsRepository save method.
     */
    @Test
    @Order(3)
    public void test_createSalesInvoice() {
        SalesItem salesItemEntity = SalesItemMapper.instance.dtoToModel(salesItemDTO1);

        when(salesItemRepository.save(salesItemEntity)).thenReturn(salesItemEntity);

        assertEquals(salesItemDTO1.getSalesItemId(), salesItemService.createSalesItem(salesItemDTO1).getSalesItemId());
    }

    /**
     * Test the updateSalesItems method of SalesItemService.
     * Verify that the salesItems object is updated using the SalesItemsRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateSalesInvoice() {
        SalesItem salesItemEntity = SalesItemMapper.instance.dtoToModel(salesItemDTO1);

        when(salesItemRepository.save(salesItemEntity)).thenReturn(salesItemEntity);

        assertEquals(salesItemDTO1.getSalesItemId(), salesItemService.updateSalesItem(salesItemDTO1).getSalesItemId());
    }

    /**
     * Test the deleteSalesItemsById method of SalesItemService.
     * Verify that the correct salesItems object is deleted for a given salesItems ID.
     */
    @Test
    @Order(5)
    public void test_deleteSalesItemsById() {
        SalesItem salesItemEntity = SalesItemMapper.instance.dtoToModel(salesItemDTO2);

        salesItemService.deleteSalesItemById(salesItemEntity.getSalesItemId());
        verify(salesItemRepository, times(1));
    }
}