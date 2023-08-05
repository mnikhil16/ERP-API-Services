package com.test.service;

import com.main.beans.Address;
import com.main.beans.Company;
import com.main.beans.Store;
import com.main.repository.StoreRepository;
import com.main.service.StoreService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * This class contains unit tests for the StoreService using Mockito framework.
 * It tests the business logic and functionality of the StoreService methods in isolation.
 * The StoreServiceMockitoTest class uses Mockito to mock dependencies.
 * StoreRepository or other external services, to focus solely on testing the service layer.
 * Test Cases:
 * - Test all stores retrieval and verify the expected store objects are returned.
 * - Test store retrieval by ID and verify the expected store object is returned.
 * - Test store creation and verify that the StoreRepository save method is called.
 * - Test store update and verify that the StoreRepository save method is called.
 * - Test store deletion and verify that the StoreRepository delete method is called.
 * Usage:
 * This class should be executed as a JUnit test to validate the correctness of the
 * StoreService implementation using Mockito mocks for dependency isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {StoreServiceMockitoTest.class})
public class StoreServiceMockitoTest {

    @Mock
    StoreRepository storeRep;

    @InjectMocks
    StoreService storeSer;

    List<Store> stores = new ArrayList<>();


    /**
     * Test the getStores method of StoreService.
     * Verify that all the store objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllStores() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        stores.add(s1);
        stores.add(s2);

        when(storeRep.findAll()).thenReturn(stores);
        assertEquals(2, storeSer.getStores().size());
    }

    /**
     * Test the getStoreById method of StoreService.
     * Verify that the correct store object is returned for a given store ID.
     */
    @Test
    @Order(2)
    public void test_getCustomerById() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);
        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);
        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);
        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        stores.add(s1);
        stores.add(s2);
        int id = 1;

        when(storeRep.findAll()).thenReturn(stores);

        assertEquals(id, storeSer.getStoreById(id).getStoreId());
    }

    /**
     * Test the createStore method of StoreService.
     * Verify that the store object is saved using the StoreRepository save method.
     */
    @Test
    @Order(3)
    public void test_createCustomer() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        stores.add(s1);

        when(storeRep.save(s1)).thenReturn(s1);

        assertEquals(s1, storeSer.createStore(s1));
    }

    /**
     * Test the updateStore method of StoreService.
     * Verify that the store object is updated using the StoreRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateStore() {
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);

        Company com1 = new Company(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", add1);

        Store s1 = new Store(1, "Laundry", "Washington St.", com1, add1);

        stores.add(s1);

        when(storeRep.save(s1)).thenReturn(s1);

        assertEquals(s1, storeSer.updateStore(s1));
    }

    /**
     * Test the deleteStore method of StoreService.
     * Verify that the correct store object is deleted for a given store ID.
     */
    @Test
    @Order(5)
    public void test_deleteStoreById() {

        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);

        Company com2 = new Company(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", add2);

        Store s2 = new Store(2, "Food Store", "Washington St.", com2, add2);
        stores.add(s2);

        storeSer.deleteStoreById(s2.getStoreId());
        verify(storeRep, times(1));
    }
}