package com.main.controller;

import com.main.dto.StoreDTO;
import com.main.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    StoreService storeService;
    Logger logger = LoggerFactory.getLogger(StoreController.class);
    /**
     * Returns all the store objects.
     * URL : "http://localhost:8080/Stores"
     * @return  All stores as an arrayList of store JSON objects.
     */
    @GetMapping("/stores")
    public List<StoreDTO> getStores(){
        logger.trace("Get all Stores controller is invoked.");
        return storeService.getStores();
    }

    /**
     * Returns the store object with given storeId.
     * URL : "http://localhost:8080/getStoreById/"
     * @param storeId as an input.
     * @return ResponseEntity with store information if found, or 404 if not found.
     * @throws if store object not found with given storeId.
     */
    @GetMapping("/getStoreById/{storeId}")
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable(value = "storeId") int storeId) {
        logger.trace("Get Store by Id controller is invoked.");
        try {
            StoreDTO storeDTO = storeService.getStoreById(storeId);
            return new ResponseEntity<>(storeDTO, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the store object.
     * URL : "http://localhost:8080/createStore"
     * @param  storeDTO object as an input.
     * @return  store JSON object.
     */
    @PostMapping("/createStore")
    public StoreDTO createStore(@RequestBody StoreDTO storeDTO){
        logger.trace("Create Store controller is invoked.");
        return storeService.createStore(storeDTO);
    }

    /**
     * Updates the store object.
     * URL : "http://localhost:8080/updateStore"
     * @param  storeDTO object as an input.
     * @return ResponseEntity with store information if updated, or 404 if not found.
     * @throws  if store object not found.
     */
    @PutMapping("/updateStore")
    public ResponseEntity<StoreDTO> updateStore(@RequestBody StoreDTO storeDTO){
        logger.trace("Update Store controller is invoked.");
        try{
            StoreDTO updatedStoreDTO = storeService.updateStore(storeDTO);
            return new ResponseEntity<>(updatedStoreDTO,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    /**
     * Deletes the store object with specific id
     * URL : "http://localhost:8080/deleteStoreById/"
     * @param storeId as an input.
     * @return AddResponse with storeId which is deleted.
     */
    @DeleteMapping("/deleteStoreById/{storeId}")
    public AddResponse deleteStoreById(@PathVariable(value = "storeId") int storeId){
        logger.trace("Delete Store controller is invoked.");
        return storeService.deleteStoreById(storeId);
    }
}