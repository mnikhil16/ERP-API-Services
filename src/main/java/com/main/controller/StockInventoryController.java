package com.main.controller;

import com.main.dto.StockInventoryDTO;
import com.main.service.StockInventoryService;
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
    public List<StockInventoryDTO> getAllStockInventories(){
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
    public ResponseEntity<StockInventoryDTO> getStockInventoryById(@PathVariable(value = "stockInventoryId") int stockInventoryId) {

        try {
            StockInventoryDTO stockInventoryDTO = stockInventoryService.getStockInventoryById(stockInventoryId);
            return new ResponseEntity<>(stockInventoryDTO, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the stockInventory object.
     * URL : "http://localhost8080/createStockInventory"
     * @param  stockInventoryDTO object as an input.
     * @return  stockInventory JSON object.
     */
    @PostMapping("/createStockInventory")
    public StockInventoryDTO createStockInventory(@RequestBody StockInventoryDTO stockInventoryDTO){

        return stockInventoryService.createStockInventory(stockInventoryDTO);
    }

    /**
     * Updates the stockInventory object.
     * URL : "http://localhost8080/updateStockInventory"
     * @param  stockInventoryDTO object as an input.
     * @return ResponseEntity with stockInventory information if updated, or 404 if not found.
     * @throws  if stockInventory object not found.
     */
    @PutMapping("/updateStockInventory")
    public ResponseEntity<StockInventoryDTO> updateStockInventory(@RequestBody StockInventoryDTO stockInventoryDTO){
        try{
            StockInventoryDTO updatedStockInventoryDTO = stockInventoryService.updateStockInventory(stockInventoryDTO);
            return new ResponseEntity<>(updatedStockInventoryDTO,HttpStatus.OK);
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