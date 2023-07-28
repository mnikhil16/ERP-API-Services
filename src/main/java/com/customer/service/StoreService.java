package com.customer.service;

import com.customer.controller.AddResponse;
import com.customer.repository.StoreRepository;
import com.customer.beans.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * This class represents a service that handles Store-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete Store information in the database.
 * This service communicates with the StoreRepository to perform CRUD operations on Customer_db entities.
 *
 * Usage:
 * The StoreService should be autowired into other components that require Store-related functionalities.
 */

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRep;

    /**
     * Get all the store information.
     *
     * @return All the Store objects.
     */
    public List<Store> getStores(){
        return storeRep.findAll();
    }


    /**
     * Get store information by the specified store ID.
     *
     * @param Id The ID of the store to retrieve.
     * @return The Store object corresponding to the given ID.
     */
    public Store getStoreById(int Id){
        List<Store> stores = storeRep.findAll();
        Store store = null;
        for(Store s: stores){
            if(s.getStoreId() == Id){
                store = s;
            }
        }
        return store;
    }

    /**
     * Create a new store with the provided store object.
     *
     * @param store The store object representing the store to be created.
     * @return The newly created store object with a generated ID.
     */
    public Store createStore(Store store){
        return storeRep.save(store);
    }

    /**
     * Update a new store with the provided store object.
     *
     * @param store The Store object representing the store to be updated.
     * @return The updated Store object.
     */
    public Store updateStore(Store store){
        return storeRep.save(store);
    }


    /**
     * Delete a store with the provided Id.
     *
     * @param Id The ID of the store to delete.
     * @return The deleted Id.
     */
    public AddResponse deleteStore(int Id){
        storeRep.deleteById(Id);
        AddResponse res = new AddResponse();
        res.setMsg("Store deleted");
        res.setId(Id);
        return res;
    }
}