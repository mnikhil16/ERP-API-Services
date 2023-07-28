package com.customer.controller;

import com.customer.beans.Store;
import com.customer.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * This class represents the RESTful controller for managing Store-related endpoints.
 * It handles HTTP requests for creating, reading, updating, and deleting Store information.
 * The StoreController maps incoming HTTP requests to appropriate methods to process them.
 * It interacts with the StoreService to perform operations on store data.
 * Endpoints:
 * - GET /stores: Retrieves all the stores' information.
 * - GET /getStoreById/{storeId}: Retrieve store information by the specified ID.
 * - POST /createStore: Creates a new store using the provided store data.
 * - PUT /updateStore: Update store information.
 * - DELETE /deleteStoreById/{storeId}: Delete the store with the given ID from the system.
 * Usage:
 * The storeController should be registered with the Spring application context and
 * automatically handle incoming HTTP requests to the specified endpoints.
 */
@RestController
public class StoreController {

    @Autowired
    StoreService service;

    /**
     * Returns all the store objects.
     * URL : "http://localhost8080/Stores"
     * @return  All store as an arrayList of store JSON objects.
     */
    @GetMapping("/stores")
    public List<Store> getAllStores(){
        return service.getStores();
    }

    /**
     * Returns the store object with given storeId.
     * URL : "http://localhost8080/getStoreById/"
     * @param storeId as an input.
     * @return ResponseEntity with store information if found, or 404 if not found.
     * @throws if store object not found with given storeId.
     */
    @GetMapping("/getStoreById/{storeId}")
    public ResponseEntity<Store> getStoreById(@PathVariable(value = "storeId") int storeId) {

        try {
            Store store = service.getStoreById(storeId);
            return new ResponseEntity<Store>(store, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the store object.
     * URL : "http://localhost8080/createStore"
     * @param  store object as an input.
     * @return  store JSON object.
     */
    @PostMapping("/createStore")
    public Store createStore(@RequestBody Store store){

        return service.createStore(store);
    }

    /**
     * Updates the store object.
     * URL : "http://localhost8080/updateStore"
     * @param  store object as an input.
     * @return ResponseEntity with store information if updated, or 404 if not found.
     * @throws  if store object not found.
     */
    @PutMapping("/updateStore")
    public ResponseEntity<Store> updateStore(@RequestBody Store store){
        try{
            Store updatedStore = service.updateStore(store);
            return new ResponseEntity<Store>(updatedStore,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    /**
     * Deletes the store object with specific id
     * URL : "http://localhost8080/deleteStoreById/"
     * @param storeId as an input.
     * @return AddResponse with storeId which is deleted.
     */
    @DeleteMapping("/deleteStoreById/{storeId}")
    public AddResponse deleteStore(@PathVariable(value = "storeId") int storeId){
        return service.deleteStore(storeId);
    }
}