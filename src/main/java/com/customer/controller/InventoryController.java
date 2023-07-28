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
 * The InventoryController maps incoming HTTP requests to appropriate methods to process them.
 * It interacts with the StockInventoryService to perform operations on inventory data.
 * Endpoints:
 * - GET /inventories: Retrieves all the inventories' information.
 * - GET /getInventoryById/{inventoryId}: Retrieve inventory information by the specified ID.
 * - POST /createInventory: Creates a new inventory using the provided inventory data.
 * - PUT /updateInventory: Update inventory information.
 * - DELETE /deleteInventoryById/{inventoryId}: Delete the inventory with the given ID from the system.
 * Usage:
 * The InventoryController should be registered with the Spring application context and
 * automatically handle incoming HTTP requests to the specified endpoints.
 */
@RestController
public class InventoryController {

    @Autowired
    StockInventoryService service;

    /**
     * Returns all the inventory objects.
     * URL : "http://localhost8080/StockInventories"
     * @return  All inventories as an arrayList of inventory JSON objects.
     */
    @GetMapping("/StockInventories")
    public List<StockInventory> getAllStockInventories(){
        return service.getInventories();
    }

    /**
     * Returns the customer object with given inventoryId.
     * URL : "http://localhost8080/getInventoryById/"
     * @param inventoryId as an input.
     * @return ResponseEntity with inventory information if found, or 404 if not found.
     * @throws if inventory object not found with given inventoryId.
     */
    @GetMapping("/getInventoryById/{inventoryId}")
    public ResponseEntity<StockInventory> getInventoryById(@PathVariable(value = "inventoryId") int inventoryId) {

        try {
            StockInventory stockInventory = service.getInventoryById(inventoryId);
            return new ResponseEntity<StockInventory>(stockInventory, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the stockInventory object.
     * URL : "http://localhost8080/createInventory"
     * @param  stockInventory object as an input.
     * @return  stockInventory JSON object.
     */
    @PostMapping("/createInventory")
    public StockInventory createInventory(@RequestBody StockInventory stockInventory){

        return service.createInventory(stockInventory);
    }

    /**
     * Updates the stockInventory object.
     * URL : "http://localhost8080/updateInventory"
     * @param  stockInventory object as an input.
     * @return ResponseEntity with stockInventory information if updated, or 404 if not found.
     * @throws  if customer object not found.
     */
    @PutMapping("/updateInventory")
    public ResponseEntity<StockInventory> updateInventory(@RequestBody StockInventory stockInventory){
        try{
            StockInventory updatedStockInventory = service.updateInventory(stockInventory);
            return new ResponseEntity<StockInventory>(updatedStockInventory,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    /**
     * Deletes the inventory object with specific id
     * URL : "http://localhost8080/deleteInventoryById/"
     * @param inventoryId as an input.
     * @return AddResponse with inventoryId which is deleted.
     */
    @DeleteMapping("/deleteInventoryById/{inventoryId}")
    public AddResponse deleteInventory(@PathVariable(value = "inventoryId") int inventoryId){
        return service.deleteInventory(inventoryId);
    }
}