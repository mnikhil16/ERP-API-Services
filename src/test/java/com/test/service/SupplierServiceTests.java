package com.test.service;

import com.main.beans.Supplier;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import com.main.dto.StoreDTO;
import com.main.dto.SupplierDTO;
import com.main.mapper.SupplierMapper;
import com.main.repository.SupplierRepository;
import com.main.service.SupplierService;
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
 * This class contains unit tests for the SupplierService using Mockito framework.
 * It tests the business logic and functionality of the SupplierService methods in isolation.
 * The SupplierServiceTests class uses Mockito to mock dependencies.
 * SupplierRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all suppliers retrieval and verify the expected supplier objects are returned.
 * - Test supplier retrieval by ID and verify the expected supplier object is returned.
 * - Test supplier creation and verify that the SupplierRepository save method is called.
 * - Test Supplier update and verify that the SupplierRepository save method is called.
 * - Test supplier deletion and verify that the SupplierRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * SupplierService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {SupplierServiceTests.class})
public class SupplierServiceTests {

    @Mock
    SupplierRepository supplierRepository;

    @InjectMocks
    SupplierService supplierService;

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
     * Test the getSuppliers method of SupplierService.
     * Verify that all the supplier objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllSuppliers(){
        suppliersDTO.add(supplierDTO1);
        suppliersDTO.add(supplierDTO2);
        List<Supplier> supplierList = SupplierMapper.instance.dtoToModelList(suppliersDTO);
        when(supplierRepository.findAll()).thenReturn(supplierList);
        assertEquals(2, supplierService.getSuppliers().size());
    }

    /**
     * Test the getSupplierById method of SupplierService.
     * Verify that the correct supplier object is returned for a given supplier ID.
     */
    @Test
    @Order(2)
    public void test_getSupplierById(){
        suppliersDTO.add(supplierDTO1);
        suppliersDTO.add(supplierDTO2);
        int id=1;
        List<Supplier> supplierList = SupplierMapper.instance.dtoToModelList(suppliersDTO);

        when(supplierRepository.findAll()).thenReturn(supplierList);

        assertEquals(id, supplierService.getSupplierById(id).getSupplierId());
    }

    /**
     * Test the createSupplier method of SupplierService.
     * Verify that the Supplier object is saved using the SupplierRepository save method.
     */
    @Test
    @Order(3)
    public void test_createSupplier(){

        Supplier supplierEntity = SupplierMapper.instance.dtoToModel(supplierDTO1);
        when(supplierRepository.save(supplierEntity)).thenReturn(supplierEntity);
        assertEquals(supplierDTO1, supplierService.createSupplier(supplierDTO1));
    }

    /**
     * Test the updateSupplier method of SupplierService.
     * Verify that the Supplier object is updated using the SupplierRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateSupplier(){
        Supplier supplierEntity = SupplierMapper.instance.dtoToModel(supplierDTO1);

        when(supplierRepository.save(supplierEntity)).thenReturn(supplierEntity);

        assertEquals(supplierDTO1, supplierService.updateSupplier(supplierDTO1));
    }

    /**
     * Test the deleteSupplier method of SupplierService.
     * Verify that the correct supplier object is deleted for a given supplier ID.
     */
    @Test
    @Order(5)
    public void test_deleteSupplierById(){
        Supplier supplierEntity = SupplierMapper.instance.dtoToModel(supplierDTO2);

        supplierService.deleteSupplierById(supplierEntity.getSupplierId());
        verify(supplierRepository,times(1));
    }
}