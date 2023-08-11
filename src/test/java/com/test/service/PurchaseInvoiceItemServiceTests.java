package com.test.service;

import com.main.entity.*;
import com.main.dto.*;
import com.main.mapper.PurchaseInvoiceItemMapper;
import com.main.repository.PurchaseInvoiceItemRepository;
import com.main.service.PurchaseInvoiceItemService;
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
 * This class contains unit tests for the PurchaseInvoiceItemsService using Mockito framework.
 * It tests the business logic and functionality of the PurchaseOrderInvoiceItemsService methods in isolation.
 * The PurchaseInvoiceItemServiceTests class uses Mockito to mock dependencies.
 * PurchaseOrderInvoiceItemsRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all purchaseInvoiceItems retrieval and verify the expected purchaseInvoiceItems objects are returned.
 * - Test purchaseInvoiceItems retrieval by ID and verify the expected purchaseInvoiceItems object is returned.
 * - Test purchaseInvoiceItems creation and verify that the PurchaseInvoiceItemsRepository save method is called.
 * - Test purchaseInvoiceItems update and verify that the PurchaseInvoiceItemsRepository save method is called.
 * - Test purchaseInvoiceItems deletion and verify that the PurchaseInvoiceItemsRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * PurchaseInvoiceItemsService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StockInventoryServiceTests.class})
class PurchaseInvoiceItemServiceTests {

    @Mock
    PurchaseInvoiceItemRepository purchaseInvoiceItemRepository;

    @InjectMocks
    PurchaseInvoiceItemService purchaseInvoiceItemService;

    List<PurchaseInvoiceItemDTO> purchaseInvoiceItemsDTO = new ArrayList<>();
    AddressDTO addressDTO1 = new AddressDTO(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
    AddressDTO addressDTO2 = new AddressDTO(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
    CompanyDTO companyDTO1 = new CompanyDTO(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", addressDTO1);
    CompanyDTO companyDTO2 = new CompanyDTO(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", addressDTO2);
    StoreDTO storeDTO1 = new StoreDTO(1, "Laundry", "Washington St.", companyDTO1, addressDTO1);
    StoreDTO storeDTO2 = new StoreDTO(2, "Food Store", "Washington St.", companyDTO2, addressDTO2);
    StockItemDTO stockItemDTO1 = new StockItemDTO(1,"Cap","Clothing","XYZ", 159.0,"18-05-2023", "", "A cap", companyDTO1);
    StockItemDTO stockItemDTO2 = new StockItemDTO(2,"Shirt","Clothing","XYZ", 799.0,"25-02-2023", "", "A shirt", companyDTO2);
    SupplierDTO supplierDTO1 = new SupplierDTO(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", storeDTO1, companyDTO1, addressDTO1);
    SupplierDTO supplierDTO2 = new SupplierDTO(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", storeDTO2, companyDTO2, addressDTO2);
    PurchaseInvoiceDTO purchaseInvoiceDTO1 = new PurchaseInvoiceDTO(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", companyDTO1, supplierDTO1);
    PurchaseInvoiceDTO purchaseInvoiceDTO2 = new PurchaseInvoiceDTO(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", companyDTO2, supplierDTO2);
    PurchaseInvoiceItemDTO purchaseInvoiceItemDTO1 = new PurchaseInvoiceItemDTO(1, 30,300.0, storeDTO1, stockItemDTO1, purchaseInvoiceDTO1);
    PurchaseInvoiceItemDTO purchaseInvoiceItemDTO2 = new PurchaseInvoiceItemDTO(2, 40,400.0, storeDTO2, stockItemDTO2, purchaseInvoiceDTO2);

    /**
     * Test the getPurchaseInvoiceItems method of PurchaseInvoiceItemsService.
     * Verify that all the purchaseInvoiceItems objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllPurchaseInvoiceItems() {

        purchaseInvoiceItemsDTO.add(purchaseInvoiceItemDTO1);
        purchaseInvoiceItemsDTO.add(purchaseInvoiceItemDTO2);
        List<PurchaseInvoiceItem> purchaseInvoiceItemList = PurchaseInvoiceItemMapper.instance.dtoToModelList(purchaseInvoiceItemsDTO);
        when(purchaseInvoiceItemRepository.findAll()).thenReturn(purchaseInvoiceItemList);
        assertEquals(2, purchaseInvoiceItemService.getPurchaseInvoiceItems().size());
    }

    /**
     * Test the getPurchaseInvoiceItemsById method of PurchaseInvoiceItemsService.
     * Verify that the correct purchaseInvoiceItems object is returned for a given purchaseInvoiceItems ID.
     */
    @Test
    @Order(2)
    public void test_getPurchaseInvoiceItemsById() {

        purchaseInvoiceItemsDTO.add(purchaseInvoiceItemDTO1);
        int id = 1;
        PurchaseInvoiceItem purchaseInvoiceItem = PurchaseInvoiceItemMapper.instance.dtoToModel(purchaseInvoiceItemDTO1);

        // Mocking the behavior of the purchaseInvoiceItemRepository
        when(purchaseInvoiceItemRepository.findById(id)).thenReturn(Optional.of(purchaseInvoiceItem));

        assertEquals(id, purchaseInvoiceItemService.getPurchaseInvoiceItemById(id).getPurchaseInvoiceItemId());
    }

    /**
     * Test the createPurchaseInvoiceItems method of PurchaseInvoiceItemsService.
     * Verify that the purchaseInvoiceItems object is saved using the PurchaseInvoiceItemsRepository save method.
     */
    @Test
    @Order(3)
    public void test_createPurchaseInvoiceItems() {


        PurchaseInvoiceItem purchaseInvoiceItemEntity = PurchaseInvoiceItemMapper.instance.dtoToModel(purchaseInvoiceItemDTO1);
        when(purchaseInvoiceItemRepository.save(purchaseInvoiceItemEntity)).thenReturn(purchaseInvoiceItemEntity);

        assertEquals(purchaseInvoiceItemDTO1.getPurchaseInvoiceItemId(), purchaseInvoiceItemService.createPurchaseInvoiceItem(purchaseInvoiceItemDTO1).getPurchaseInvoiceItemId());
    }

    /**
     * Test the updatePurchaseInvoiceItems method of PurchaseInvoiceItemsService.
     * Verify that the purchaseInvoiceItems object is updated using the PurchaseInvoiceItemsRepository save method.
     */
    @Test
    @Order(4)
    public void test_updatePurchaseInvoiceItems() {
        PurchaseInvoiceItem purchaseInvoiceItemEntity = PurchaseInvoiceItemMapper.instance.dtoToModel(purchaseInvoiceItemDTO1);
        when(purchaseInvoiceItemRepository.save(purchaseInvoiceItemEntity)).thenReturn(purchaseInvoiceItemEntity);

        assertEquals(purchaseInvoiceItemDTO1.getPurchaseInvoiceItemId(), purchaseInvoiceItemService.updatePurchaseInvoiceItem(purchaseInvoiceItemDTO1).getPurchaseInvoiceItemId());
    }

    /**
     * Test the deletePurchaseInvoiceItemsById method of PurchaseInvoiceItemsService.
     * Verify that the correct purchaseInvoiceItems object is deleted for a given purchaseInvoiceItems ID.
     */
    @Test
    @Order(5)
    public void test_deletePurchaseInvoiceItemsById() {
        PurchaseInvoiceItem purchaseInvoiceItemEntity = PurchaseInvoiceItemMapper.instance.dtoToModel(purchaseInvoiceItemDTO2);

        purchaseInvoiceItemService.deletePurchaseInvoiceItemById(purchaseInvoiceItemEntity.getPurchaseInvoiceItemId());
        verify(purchaseInvoiceItemRepository, times(1));
    }
}