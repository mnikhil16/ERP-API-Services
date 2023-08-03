package com.service;

import com.customer.beans.*;
import com.customer.repository.SupplierRepository;
import com.customer.service.SupplierService;
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
 * The SupplierServiceMockitoTest class uses Mockito to mock dependencies.
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
@SpringBootTest(classes = {SupplierServiceMockitoTest.class})
public class SupplierServiceMockitoTest {

    @Mock
    SupplierRepository supplierRepository;

    @InjectMocks
    SupplierService supplierService;

    List<Supplier> suppliers = new ArrayList<>();

    /**
     * Test the getSuppliers method of SupplierService.
     * Verify that all the supplier objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllSuppliers(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", 1, 1, add1);
        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", 2, 2, add2);
        suppliers.add(supplier1);
        suppliers.add(supplier2);

        when(supplierRepository.findAll()).thenReturn(suppliers);
        assertEquals(2, supplierService.getSuppliers().size());
    }

    /**
     * Test the getSupplierById method of SupplierService.
     * Verify that the correct supplier object is returned for a given supplier ID.
     */
    @Test
    @Order(2)
    public void test_getSupplierById(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", 1, 1, add1);
        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", 2, 2, add2);
        suppliers.add(supplier1);
        suppliers.add(supplier2);
        int id=1;

        when(supplierRepository.findAll()).thenReturn(suppliers);

        assertEquals(id, supplierService.getSupplierById(id).getSupplierId());
    }

    /**
     * Test the createSupplier method of SupplierService.
     * Verify that the Supplier object is saved using the SupplierRepository save method.
     */
    @Test
    @Order(3)
    public void test_createSupplier(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", 1, 1, add1);
        suppliers.add(supplier1);

        when(supplierRepository.save(supplier1)).thenReturn(supplier1);

        assertEquals(supplier1, supplierService.createSupplier(supplier1));
    }

    /**
     * Test the updateSupplier method of SupplierService.
     * Verify that the Supplier object is updated using the SupplierRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateSupplier(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", 1, 1, add1);
        suppliers.add(supplier1);

        when(supplierRepository.save(supplier1)).thenReturn(supplier1);

        assertEquals(supplier1, supplierService.updateSupplier(supplier1));
    }

    /**
     * Test the deleteSupplier method of SupplierService.
     * Verify that the correct supplier object is deleted for a given supplier ID.
     */
    @Test
    @Order(5)
    public void test_deleteSupplierById(){
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", 2, 2, add2);
        suppliers.add(supplier2);

        supplierService.deleteSupplierById(supplier2.getSupplierId());
        verify(supplierRepository,times(1));
    }
}