package com.test.controller;

import com.main.controller.AddResponse;
import com.main.controller.StoreController;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import com.main.dto.StoreDTO;
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

    List<StoreDTO> storesDTO = new ArrayList<>();
    AddressDTO addressDTO1 = new AddressDTO(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
    AddressDTO addressDTO2 = new AddressDTO(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
    CompanyDTO companyDTO1 = new CompanyDTO(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", addressDTO1);
    CompanyDTO companyDTO2 = new CompanyDTO(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", addressDTO2);
    StoreDTO storeDTO1 = new StoreDTO(1, "Laundry", "Washington St.", companyDTO1, addressDTO1);
    StoreDTO storeDTO2 = new StoreDTO(2, "Food Store", "Washington St.", companyDTO2, addressDTO2);

    /**
     * Test the getAllStores method of StoreController.
     * Verify that all the store objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllStores(){

        storesDTO.add(storeDTO1);
        storesDTO.add(storeDTO2);

        when(storeService.getStores()).thenReturn(storesDTO);
        assertEquals(2,storeController.getStores().size());
    }

    /**
     * Test the getStoreById method of StoreController.
     * Verify that the correct store object is returned for a given store ID.
     */
    @Test
    @Order(2)
    public void test_getStoreById(){
        
        when(storeService.getStoreById(1)).thenReturn(storeDTO1);
        ResponseEntity<StoreDTO> responseEntity  = storeController.getStoreById(1);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getStoreId());
    }

    /**
     * Test the createStore method of StoreController.
     * Verify that the store object is saved using the StoreRepository save method.
     */
    @Test
    @Order(3)
    public void test_createStore(){

        when(storeService.createStore(storeDTO1)).thenReturn(storeDTO1);
        assertEquals(storeDTO1,storeController.createStore(storeDTO1));
    }

    /**
     * Test the updateStore method of StoreController.
     * Verify that the store object is updated using the StoreRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateStore(){

        when(storeService.updateStore(storeDTO1)).thenReturn(storeDTO1);
        ResponseEntity<StoreDTO> res = storeController.updateStore(storeDTO1);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(storeDTO1,res.getBody());
    }

    /**
     * Test the deleteStore method of StoreController.
     * Verify that the correct store object is deleted for a given store ID.
     */
    @Test
    @Order(5)
    public void test_deleteStoreById(){
        int id = storeDTO2.getStoreId();
        AddResponse addResponse = new AddResponse();
        addResponse.setId(id);
        addResponse.setMsg("Store deleted");
        when(storeService.deleteStoreById(id)).thenReturn(addResponse);
        assertEquals(addResponse,storeController.deleteStoreById(id));
    }
}