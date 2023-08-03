package com.customer.controller;

import com.customer.beans.StockInventory;
import com.customer.service.StockInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * This class represents the RESTful controller for managing StockInventory-related endpoints.
 * It handles HTTP requests for creating, reading, updating, and deleting StockInventory information.
 * The StockInventoryController maps incoming HTTP requests to appropriate methods to process them.
 * It interacts with the StockInventoryService to perform operations on inventory data.
 * Endpoints:
 * - GET /inventories: Retrieves all the stockInventories information.
 * - GET /getStockInventoryById/{stockInventoryId}: Retrieve stockInventory information by the specified ID.
 * - POST /createStockInventory: Creates a new stockInventory using the provided inventory data.
 * - PUT /updateStockInventory: Update stockInventory information.
 * - DELETE /deleteStockInventoryById/{stockInventoryId}: Delete the stockInventory with the given ID from the system.
 * Usage:
 * The StockInventoryController should be registered with the Spring application context and
 * automatically handle incoming HTTP requests to the specified endpoints.
 */
@RestController
public class StockInventoryController {

    @Autowired
    StockInventoryService stockInventoryService;

    /**
     * Returns all the inventory objects.
     * URL : "http://localhost8080/StockInventories"
     * @return  All stockInventories as an arrayList of stockInventory JSON objects.
     */
    @GetMapping("/StockInventories")
    public List<StockInventory> getAllStockInventories(){
        return stockInventoryService.getStockInventories();
    }

    /**
     * Returns the customer object with given stockInventoryId.
     * URL : "http://localhost8080/getStockInventoryById/"
     * @param stockInventoryId as an input.
     * @return ResponseEntity with stockInventory information if found, or 404 if not found.
     * @throws if stockInventory object not found with given stockInventoryId.
     */
    @GetMapping("/getStockInventoryById/{stockInventoryId}")
    public ResponseEntity<StockInventory> getStockInventoryById(@PathVariable(value = "stockInventoryId") int stockInventoryId) {

        try {
            StockInventory stockInventory = stockInventoryService.getStockInventoryById(stockInventoryId);
            return new ResponseEntity<>(stockInventory, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the stockInventory object.
     * URL : "http://localhost8080/createStockInventory"
     * @param  stockInventory object as an input.
     * @return  stockInventory JSON object.
     */
    @PostMapping("/createStockInventory")
    public StockInventory createStockInventory(@RequestBody StockInventory stockInventory){

        return stockInventoryService.createStockInventory(stockInventory);
    }

    /**
     * Updates the stockInventory object.
     * URL : "http://localhost8080/updateStockInventory"
     * @param  stockInventory object as an input.
     * @return ResponseEntity with stockInventory information if updated, or 404 if not found.
     * @throws  if stockInventory object not found.
     */
    @PutMapping("/updateStockInventory")
    public ResponseEntity<StockInventory> updateStockInventory(@RequestBody StockInventory stockInventory){
        try{
            StockInventory updatedStockInventory = stockInventoryService.updateStockInventory(stockInventory);
            return new ResponseEntity<>(updatedStockInventory,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    /**
     * Deletes the inventory object with specific id
     * URL : "http://localhost8080/deleteStockInventoryById/"
     * @param stockInventoryId as an input.
     * @return AddResponse with inventoryId which is deleted.
     */
    @DeleteMapping("/deleteStockInventoryById/{stockInventoryId}")
    public AddResponse deleteStockInventoryById(@PathVariable(value = "stockInventoryId") int stockInventoryId){
        return stockInventoryService.deleteStockInventoryById(stockInventoryId);
    }
}