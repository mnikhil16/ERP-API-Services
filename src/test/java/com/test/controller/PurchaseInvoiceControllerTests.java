package com.test.controller;

import com.main.controller.AddResponse;
import com.main.controller.PurchaseInvoiceController;
import com.main.dto.*;
import com.main.service.PurchaseInvoiceService;
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
 * This class contains unit tests for the PurchaseInvoiceController using Mockito framework.
 * It tests the behaviour of the PurchaseInvoiceController methods in isolation.
 * The PurchaseInvoiceControllerMockitoTest class uses Mockito to mock dependencies, such as the
 * PurchaseInvoiceService, to focus solely on testing the controller layer.
 * Test Cases:
 * - Test all purchaseInvoices retrieval and verify that the PurchaseInvoiceService getPurchaseInvoices method is called.
 * - Test purchaseInvoice retrieval by ID and verify that the getPurchaseInvoiceById method is called.
 * - Test purchaseInvoice creation and verify that the PurchaseInvoiceService createPurchaseInvoice method is called.
 * - Test purchaseInvoice update and verify that the PurchaseInvoiceService updatePurchaseInvoice method is called.
 * - Test purchaseInvoice deletion and verify that the PurchaseInvoiceService deletePurchaseInvoiceById method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * PurchaseInvoiceController implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {PurchaseInvoiceControllerTests.class})
public class PurchaseInvoiceControllerTests {

    @Mock
    PurchaseInvoiceService purchaseInvoiceService;

    @InjectMocks
    PurchaseInvoiceController purchaseInvoiceController;

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
     * Test the getAllPurchaseInvoices method of PurchaseInvoiceController.
     * Verify that all the purchaseInvoice objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllPurchaseInvoices(){

        purchaseInvoicesDTO.add(purchaseInvoiceDTO1);
        purchaseInvoicesDTO.add(purchaseInvoiceDTO2);

        when(purchaseInvoiceService.getPurchaseInvoices()).thenReturn(purchaseInvoicesDTO);
        assertEquals(2,purchaseInvoiceController.getAllPurchaseInvoices().size());
    }

    /**
     * Test the getPurchaseInvoiceById method of PurchaseInvoiceController.
     * Verify that the correct purchaseInvoice object is returned for a given purchaseInvoice ID.
     */
    @Test
    @Order(2)
    public void test_getPurchaseInvoiceById(){

        when(purchaseInvoiceService.getPurchaseInvoiceById(1)).thenReturn(purchaseInvoiceDTO1);
        ResponseEntity<PurchaseInvoiceDTO> responseEntity = purchaseInvoiceController.getPurchaseInvoiceById(1);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getPurchaseInvoiceId());
    }

    /**
     * Test the createPurchaseInvoice method of PurchaseInvoiceController.
     * Verify that the purchaseInvoice object is saved using the PurchaseInvoiceRepository save method.
     */
    @Test
    @Order(3)
    public void test_createPurchaseInvoice(){

        when(purchaseInvoiceService.createPurchaseInvoice(purchaseInvoiceDTO1)).thenReturn(purchaseInvoiceDTO1);
        assertEquals(purchaseInvoiceDTO1,purchaseInvoiceController.createPurchaseInvoice(purchaseInvoiceDTO1));
    }

    /**
     * Test the updatePurchaseInvoice method of PurchaseInvoiceController.
     * Verify that the purchaseInvoice object is updated using the PurchaseInvoiceRepository save method.
     */
    @Test
    @Order(4)
    public void test_updatePurchaseInvoice(){

        when(purchaseInvoiceService.updatePurchaseInvoice(purchaseInvoiceDTO1)).thenReturn(purchaseInvoiceDTO1);
        ResponseEntity<PurchaseInvoiceDTO> res = purchaseInvoiceController.updatePurchaseInvoice(purchaseInvoiceDTO1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(purchaseInvoiceDTO1,res.getBody());
    }

    /**
     * Test the deletePurchaseInvoiceById method of PurchaseInvoiceController.
     * Verify that the correct purchaseInvoice object is deleted for a given purchaseInvoice ID.
     */
    @Test
    @Order(5)
    public void test_deletePurchaseInvoiceById(){
        int id = purchaseInvoiceDTO2.getPurchaseInvoiceId();
        AddResponse addResponse = new AddResponse();
        addResponse.setId(id);
        addResponse.setMsg("PurchaseInvoice deleted");
        when(purchaseInvoiceService.deletePurchaseInvoiceById(id)).thenReturn(addResponse);
        assertEquals(addResponse,purchaseInvoiceController.deletePurchaseInvoiceById(id));
    }
}