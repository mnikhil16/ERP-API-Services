package com.test.controller;

import com.main.controller.AddResponse;
import com.main.controller.SupplierController;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import com.main.dto.StoreDTO;
import com.main.dto.SupplierDTO;
import com.main.service.SupplierService;
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
 * This class contains unit tests for the SupplierController using Mockito framework.
 * It tests the behaviour of the SupplierController methods in isolation.
 * The SupplierControllerMockitoTest class uses Mockito to mock dependencies, such as the
 * SupplierService, to focus solely on testing the controller layer.
 * Test Cases:
 * - Test all suppliers retrieval and verify that the SupplierService getSuppliers method is called.
 * - Test supplier retrieval by ID and verify that the getSupplierById method is called.
 * - Test supplier creation and verify that the SupplierService createSupplier method is called.
 * - Test supplier update and verify that the SupplierService updateSupplier method is called.
 * - Test supplier deletion and verify that the SupplierService deleteSupplier method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * SupplierController implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {SupplierControllerTests.class})
public class SupplierControllerTests {

    @Mock
    SupplierService supplierService;

    @InjectMocks
    SupplierController supplierController;

    List<SupplierDTO> suppliersDTO = new ArrayList<>();
    AddressDTO addressDTO1 = new AddressDTO(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
    AddressDTO addressDTO2 = new AddressDTO(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
    CompanyDTO companyDTO1 = new CompanyDTO(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", addressDTO1);
    CompanyDTO companyDTO2 = new CompanyDTO(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", addressDTO2);
    StoreDTO storeDTO1 = new StoreDTO(1, "Laundry", "Washington St.", companyDTO1, addressDTO1);
    StoreDTO storeDTO2 = new StoreDTO(2, "Food Store", "Washington St.", companyDTO2, addressDTO2);
    SupplierDTO supplierDTO1 = new SupplierDTO(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", storeDTO1, companyDTO1, addressDTO1);
    SupplierDTO supplierDTO2 = new SupplierDTO(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", storeDTO2, companyDTO2, addressDTO2);

    /**
     * Test the getAllSuppliers method of SupplierController.
     * Verify that all the supplier objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllSuppliers(){

        suppliersDTO.add(supplierDTO1);
        suppliersDTO.add(supplierDTO2);

        when(supplierService.getSuppliers()).thenReturn(suppliersDTO);
        assertEquals(2,supplierController.getAllSuppliers().size());
    }

    /**
     * Test the getSupplierById method of SupplierController.
     * Verify that the correct supplier object is returned for a given supplier ID.
     */
    @Test
    @Order(2)
    public void test_getSupplierById(){

        suppliersDTO.add(supplierDTO1);
        suppliersDTO.add(supplierDTO2);

        when(supplierService.getSupplierById(1)).thenReturn(supplierDTO1);
        ResponseEntity<SupplierDTO> res  = supplierController.getSupplierById(1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(1, Objects.requireNonNull(res.getBody()).getSupplierId());
    }

    /**
     * Test the createSupplier method of SupplierController.
     * Verify that the supplier object is saved using the SupplierRepository save method.
     */
    @Test
    @Order(3)
    public void test_createSupplier(){

        when(supplierService.createSupplier(supplierDTO1)).thenReturn(supplierDTO1);
        assertEquals(supplierDTO1,supplierController.createSupplier(supplierDTO1));
    }

    /**
     * Test the updateSupplier method of SupplierController.
     * Verify that the supplier object is updated using the SupplierRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateSupplier(){

        when(supplierService.updateSupplier(supplierDTO1)).thenReturn(supplierDTO1);
        ResponseEntity<SupplierDTO> res = supplierController.updateSupplier(supplierDTO1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(supplierDTO1,res.getBody());
    }

    /**
     * Test the deleteSupplier method of SupplierController.
     * Verify that the correct supplier object is deleted for a given supplier ID.
     */
    @Test
    @Order(5)
    public void test_deleteSupplierById(){
        int id = supplierDTO2.getSupplierId();
        AddResponse addResponse = new AddResponse();
        addResponse.setId(id);
        addResponse.setMsg("Supplier deleted");
        when(supplierService.deleteSupplierById(id)).thenReturn(addResponse);
        assertEquals(addResponse,supplierController.deleteSupplierById(id));
    }
}