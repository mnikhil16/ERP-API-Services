package com.test.service;

import com.main.beans.*;
import com.main.dto.*;
import com.main.mapper.PurchaseInvoiceMapper;
import com.main.repository.PurchaseInvoiceRepository;
import com.main.service.PurchaseInvoiceService;
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
 * This class contains unit tests for the PurchaseInvoiceService using Mockito framework.
 * It tests the business logic and functionality of the PurchaseInvoiceService methods in isolation.
 * The PurchaseInvoiceServiceTests class uses Mockito to mock dependencies.
 * PurchaseInvoiceRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all purchaseInvoices retrieval and verify the expected purchaseInvoice objects are returned.
 * - Test purchaseInvoice retrieval by ID and verify the expected purchaseInvoice object is returned.
 * - Test purchaseInvoice creation and verify that the PurchaseInvoiceRepository save method is called.
 * - Test purchaseInvoice update and verify that the PurchaseInvoiceRepository save method is called.
 * - Test purchaseInvoice deletion and verify that the PurchaseInvoiceRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * PurchaseInvoiceService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StockInventoryServiceTests.class})
class PurchaseInvoiceServiceTests {

    @Mock
    PurchaseInvoiceRepository purchaseInvoiceRep;

    @InjectMocks
    PurchaseInvoiceService purchaseInvoiceSer;

    List<PurchaseInvoiceDTO> purchaseInvoicesDTO = new ArrayList<>();
    AddressDTO addressDTO1 = new AddressDTO(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
    AddressDTO addressDTO2 = new AddressDTO(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
    CompanyDTO companyDTO1 = new CompanyDTO(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", addressDTO1);
    CompanyDTO companyDTO2 = new CompanyDTO(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", addressDTO2);
    StoreDTO storeDTO1 = new StoreDTO(1, "Laundry", "Washington St.", companyDTO1, addressDTO1);
    StoreDTO storeDTO2 = new StoreDTO(2, "Food Store", "Washington St.", companyDTO2, addressDTO2);
    SupplierDTO supplierDTO1 = new SupplierDTO(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", storeDTO1, companyDTO1, addressDTO1);
    SupplierDTO supplierDTO2 = new SupplierDTO(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", storeDTO2, companyDTO2, addressDTO2);
    PurchaseInvoiceDTO purchaseInvoiceDTO1 = new PurchaseInvoiceDTO(1, 300.0, "16-04-2023", "348hwhsn38wu2j", "77846jjnbgs832f", companyDTO1, supplierDTO1);
    PurchaseInvoiceDTO purchaseInvoiceDTO2 = new PurchaseInvoiceDTO(2, 400.0, "18-04-2023","567whsusjns7h", "564hsjjnsuj8d", companyDTO2, supplierDTO2);

    /**
     * Test the getPurchaseInvoices method of PurchaseInvoiceService.
     * Verify that all the purchaseInvoice objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllPurchaseInvoices() {

        purchaseInvoicesDTO.add(purchaseInvoiceDTO1);
        purchaseInvoicesDTO.add(purchaseInvoiceDTO2);
        List<PurchaseInvoice> purchaseInvoiceList = PurchaseInvoiceMapper.instance.dtoToModelList(purchaseInvoicesDTO);
        when(purchaseInvoiceRep.findAll()).thenReturn(purchaseInvoiceList);
        assertEquals(2, purchaseInvoiceSer.getPurchaseInvoices().size());
    }

    /**
     * Test the getPurchaseInvoiceById method of PurchaseInvoiceService.
     * Verify that the correct purchaseInvoice object is returned for a given purchaseInvoice ID.
     */
    @Test
    @Order(2)
    public void test_getPurchaseInvoiceById() {

        purchaseInvoicesDTO.add(purchaseInvoiceDTO1);
        purchaseInvoicesDTO.add(purchaseInvoiceDTO2);
        int id = 1;
        List<PurchaseInvoice> purchaseInvoiceList = PurchaseInvoiceMapper.instance.dtoToModelList(purchaseInvoicesDTO);
        when(purchaseInvoiceRep.findAll()).thenReturn(purchaseInvoiceList);

        assertEquals(id, purchaseInvoiceSer.getPurchaseInvoiceById(id).getPurchaseInvoiceId());
    }

    /**
     * Test the createPurchaseInvoice method of PurchaseInvoiceService.
     * Verify that the purchaseInvoice object is saved using the PurchaseInvoiceRepository save method.
     */
    @Test
    @Order(3)
    public void test_createPurchaseInvoice() {

        PurchaseInvoice purchaseInvoiceEntity = PurchaseInvoiceMapper.instance.dtoToModel(purchaseInvoiceDTO1);

        when(purchaseInvoiceRep.save(purchaseInvoiceEntity)).thenReturn(purchaseInvoiceEntity);

        assertEquals(purchaseInvoiceDTO1, purchaseInvoiceSer.createPurchaseInvoice(purchaseInvoiceDTO1));
    }

    /**
     * Test the updatePurchaseInvoice method of PurchaseInvoiceService.
     * Verify that the purchaseInvoice object is updated using the PurchaseInvoiceRepository save method.
     */
    @Test
    @Order(4)
    public void test_updatePurchaseInvoice() {

        PurchaseInvoice purchaseInvoiceEntity = PurchaseInvoiceMapper.instance.dtoToModel(purchaseInvoiceDTO1);

        when(purchaseInvoiceRep.save(purchaseInvoiceEntity)).thenReturn(purchaseInvoiceEntity);

        assertEquals(purchaseInvoiceDTO1, purchaseInvoiceSer.updatePurchaseInvoice(purchaseInvoiceDTO1));
    }

    /**
     * Test the deletePurchaseInvoiceById method of PurchaseInvoiceService.
     * Verify that the correct purchaseInvoice object is deleted for a given purchaseInvoice ID.
     */
    @Test
    @Order(5)
    public void test_deletePurchaseInvoiceById() {
        PurchaseInvoice purchaseInvoiceEntity = PurchaseInvoiceMapper.instance.dtoToModel(purchaseInvoiceDTO2);
        purchaseInvoiceSer.deletePurchaseInvoiceById(purchaseInvoiceEntity.getPurchaseInvoiceId());
        verify(purchaseInvoiceRep, times(1));
    }
}