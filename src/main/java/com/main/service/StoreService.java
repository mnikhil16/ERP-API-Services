package com.main.service;

import com.main.controller.AddResponse;
import com.main.dto.StoreDTO;
import com.main.mapper.StoreMapper;
import com.main.repository.StoreRepository;
import com.main.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * This class represents a service that handles Store-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete Store information in the database.
 * This service communicates with the StoreRepository to perform CRUD operations on Customer_db entities.
 * Usage:
 * The StoreService should be autowired into other components that require Store-related functionalities.
 */

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    /**
     * Get all the store information.
     *
     * @return All the Store objects.
     */
    public List<StoreDTO> getStores(){
        List<Store> storeList = storeRepository.findAll();
        List<StoreDTO> storeDTOList =  StoreMapper.instance.modelToDtoList(storeList);
        return storeDTOList;
    }

    /**
     * Get store information by the specified store ID.
     *
     * @param storeId The ID of the store to retrieve.
     * @return The StoreDTO object corresponding to the given ID.
     */
    public StoreDTO getStoreById(int storeId){
        Store storeEntity = storeRepository.findById(storeId).get();
        StoreDTO storeDTO = StoreMapper.instance.modelToDto(storeEntity);
        return storeDTO;
    }

    /**
     * Create a new store with the provided StoreDTO object.
     *
     * @param storeDTO The StoreDTO object representing the store to be created.
     * @return The newly created StoreDTO object with a generated ID.
     */
    public StoreDTO createStore(StoreDTO storeDTO){
        Store storeEntity = StoreMapper.instance.dtoToModel(storeDTO);
        storeRepository.save(storeEntity);
        StoreDTO createdStoreDTO = StoreMapper.instance.modelToDto(storeEntity);
        return createdStoreDTO;
    }

    /**
     * Update store information with the provided StoreDTO object.
     *
     * @param storeDTO The StoreDTO object representing the store to be updated.
     * @return The updated StoreDTO object.
     */
    public StoreDTO updateStore(StoreDTO storeDTO){
        Store storeEntity = StoreMapper.instance.dtoToModel(storeDTO);
        storeRepository.save(storeEntity);
        StoreDTO updatedStoreDTO = StoreMapper.instance.modelToDto(storeEntity);
        return updatedStoreDTO;
    }

    /**
     * Delete a store with the provided storeId.
     *
     * @param storeId The ID of the store to delete.
     * @return An AddResponse indicating the deletion result.
     */
    public AddResponse deleteStoreById(int storeId){
        storeRepository.deleteById(storeId);
        AddResponse response = new AddResponse();
        response.setMsg("Store deleted");
        response.setId(storeId);
        return response;
    }
}