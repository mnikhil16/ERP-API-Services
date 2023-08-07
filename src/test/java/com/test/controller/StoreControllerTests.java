package com.test.controller;

import com.main.beans.Address;
import com.main.beans.Company;
import com.main.beans.Store;
import com.main.controller.AddResponse;
import com.main.controller.StoreController;
import com.main.service.StoreService;
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
 * This class contains unit tests for the StoreController using Mockito framework.
 * It tests the behaviour of the StoreController methods in isolation.
 * The StoreControllerMockitoTest class uses Mockito to mock dependencies, such as the
 * StoreService, to focus solely on testing the controller layer.
 * Test Cases:
 * - Test all stores retrieval and verify that the StoreService getStores method is called.
 * - Test store retrieval by ID and verify that the getStoreById method is called.
 * - Test store creation and verify that the StoreService createStore method is called.
 * - Test store update and verify that the StoreService updateStore method is called.
 * - Test store deletion and verify that the StoreService deleteStoreById method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * StoreController implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StoreControllerTests.class})
public class StoreControllerTests {

    @Mock
    StoreService storeService;

    @InjectMocks
    StoreController storeController;

    List<Store> stores = new ArrayList<>();

    /**
     * Test the getAllStores method of StoreController.
     * Verify that all the store objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllStores(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        stores.add(s1);
        stores.add(s2);

        when(storeService.getStores()).thenReturn(stores);
        assertEquals(2,storeController.getStores().size());
    }

    /**
     * Test the getStoreById method of StoreController.
     * Verify that the correct store object is returned for a given store ID.
     */
    @Test
    @Order(2)
    public void test_getStoreById(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        stores.add(s1);
        stores.add(s2);

        when(storeService.getStoreById(1)).thenReturn(s1);
        ResponseEntity<Store> res  = storeController.getStoreById(1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(1, Objects.requireNonNull(res.getBody()).getStoreId());
    }

    /**
     * Test the createStore method of StoreController.
     * Verify that the store object is saved using the StoreRepository save method.
     */
    @Test
    @Order(3)
    public void test_createStore(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        stores.add(s1);


        when(storeService.createStore(s1)).thenReturn(s1);
        assertEquals(s1,storeController.createStore(s1));
    }

    /**
     * Test the updateStore method of StoreController.
     * Verify that the store object is updated using the StoreRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateStore(){
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        stores.add(s1);

        when(storeService.updateStore(s1)).thenReturn(s1);
        ResponseEntity<Store> res = storeController.updateStore(s1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(s1,res.getBody());
    }

    /**
     * Test the deleteStore method of StoreController.
     * Verify that the correct store object is deleted for a given store ID.
     */
    @Test
    @Order(5)
    public void test_deleteStoreById(){
        Address add = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Company com = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add);
        Store s = new Store(1, "Food Store", "Washington St.", com, add);
        stores.add(s);

        AddResponse addResponse = new AddResponse();
        addResponse.setId(1);
        addResponse.setMsg("Store deleted");
        when(storeService.deleteStoreById(1)).thenReturn(addResponse);
        assertEquals(addResponse,storeController.deleteStoreById(1));
    }
}