package com.controller;

import com.customer.beans.*;
import com.customer.controller.AddResponse;
import com.customer.controller.SupplierController;
import com.customer.service.SupplierService;
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
@SpringBootTest(classes = {SupplierControllerMockitoTests.class})
public class SupplierControllerMockitoTests {

    @Mock
    SupplierService supplierService;

    @InjectMocks
    SupplierController supplierController;

    List<Supplier> suppliers = new ArrayList<>();

    /**
     * Test the getAllSuppliers method of SupplierController.
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

        when(supplierService.getSuppliers()).thenReturn(suppliers);
        assertEquals(2,supplierController.getAllSuppliers().size());
    }

    /**
     * Test the getSupplierById method of SupplierController.
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

        when(supplierService.getSupplierById(1)).thenReturn(supplier1);
        ResponseEntity<Supplier> res  = supplierController.getSupplierById(1);
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
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", 1, 1, add1);
        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", 2, 2, add2);
        suppliers.add(supplier1);
        suppliers.add(supplier2);


        when(supplierService.createSupplier(supplier1)).thenReturn(supplier1);
        assertEquals(supplier1,supplierController.createSupplier(supplier1));
    }

    /**
     * Test the updateSupplier method of SupplierController.
     * Verify that the supplier object is updated using the SupplierRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateSupplier(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Supplier supplier1 = new Supplier(1,"James", "Smith", "jsmith@gmail.com","(+1) 555 1234567", 1, 1, add1);
        suppliers.add(supplier1);

        when(supplierService.updateSupplier(supplier1)).thenReturn(supplier1);
        ResponseEntity<Supplier> res = supplierController.updateSupplier(supplier1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(supplier1,res.getBody());
    }

    /**
     * Test the deleteSupplier method of SupplierController.
     * Verify that the correct supplier object is deleted for a given supplier ID.
     */
    @Test
    @Order(5)
    public void test_deleteSupplierById(){
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Supplier supplier2 = new Supplier(2,"John", "Doe", "jdoe@gmail.com","(+1) 555 1234567", 2, 2, add2);
        suppliers.add(supplier2);

        AddResponse addResponse = new AddResponse();
        addResponse.setId(2);
        addResponse.setMsg("Supplier deleted");
        when(supplierService.deleteSupplierById(2)).thenReturn(addResponse);
        assertEquals(addResponse,supplierController.deleteSupplierById(2));
    }
}