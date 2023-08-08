package com.test.service;

import com.main.beans.Store;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import com.main.dto.StoreDTO;
import com.main.mapper.StoreMapper;
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
 * The StoreServiceTests class uses Mockito to mock dependencies.
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
@SpringBootTest(classes = {StoreServiceTests.class})
public class StoreServiceTests {

    @Mock
    StoreRepository storeRepository;

    @InjectMocks
    StoreService storeService;

    List<StoreDTO> storesDTO = new ArrayList<>();
    AddressDTO addressDTO1 = new AddressDTO(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
    AddressDTO addressDTO2 = new AddressDTO(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
    CompanyDTO companyDTO1 = new CompanyDTO(1, "AaBbCc", "Retail", "www.AaBbCc.com", "12unn93i4ifmr8974", addressDTO1);
    CompanyDTO companyDTO2 = new CompanyDTO(2, "BbCcDd", "Retail", "www.BbCcDd.com", "12uuen3ii4544m", addressDTO2);
    StoreDTO storeDTO1 = new StoreDTO(1, "Laundry", "Washington St.", companyDTO1, addressDTO1);
    StoreDTO storeDTO2 = new StoreDTO(2, "Food Store", "Washington St.", companyDTO2, addressDTO2);

    /**
     * Test the getStores method of StoreService.
     * Verify that all the store objects are returned.
     */
    @Test
    @Order(1)
    public void test_getAllStores() {
        storesDTO.add(storeDTO1);
        storesDTO.add(storeDTO2);
        List<Store> storeList = StoreMapper.instance.dtoToModelList(storesDTO);
        when(storeRepository.findAll()).thenReturn(storeList);
        assertEquals(2, storeService.getStores().size());
    }

    /**
     * Test the getStoreById method of StoreService.
     * Verify that the correct store object is returned for a given store ID.
     */
    @Test
    @Order(2)
    public void test_getCustomerById() {
        storesDTO.add(storeDTO1);
        storesDTO.add(storeDTO2);
        int id = 1;
        List<Store> storeList = StoreMapper.instance.dtoToModelList(storesDTO);
        when(storeRepository.findAll()).thenReturn(storeList);
        assertEquals(id, storeService.getStoreById(id).getStoreId());
    }

    /**
     * Test the createStore method of StoreService.
     * Verify that the store object is saved using the StoreRepository save method.
     */
    @Test
    @Order(3)
    public void test_createCustomer() {
        Store storeEntity = StoreMapper.instance.dtoToModel(storeDTO1);
        when(storeRepository.save(storeEntity)).thenReturn(storeEntity);

        assertEquals(storeDTO1, storeService.createStore(storeDTO1));
    }

    /**
     * Test the updateStore method of StoreService.
     * Verify that the store object is updated using the StoreRepository save method.
     */
    @Test
    @Order(4)
    public void test_updateStore() {

        Store storeEntity = StoreMapper.instance.dtoToModel(storeDTO1);

        when(storeRepository.save(storeEntity)).thenReturn(storeEntity);

        assertEquals(storeDTO1, storeService.updateStore(storeDTO1));
    }

    /**
     * Test the deleteStore method of StoreService.
     * Verify that the correct store object is deleted for a given store ID.
     */
    @Test
    @Order(5)
    public void test_deleteStoreById() {

        Store storeEntity = StoreMapper.instance.dtoToModel(storeDTO2);

        storeService.deleteStoreById(storeEntity.getStoreId());
        verify(storeRepository, times(1));
    }
}