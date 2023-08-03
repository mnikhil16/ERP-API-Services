package com.customer.controller;

import com.customer.beans.StockItem;
import com.customer.service.StockItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * This class represents the RESTful controller for managing StockItem-related endpoints.
 * It handles HTTP requests for creating, reading, updating, and deleting StockItem information.
 * The StockItemController maps incoming HTTP requests to appropriate methods to process them.
 * It interacts with the StockItemService to perform operations on item data.
 * Endpoints:
 * - GET /stockItems: Retrieves all the stockItems information.
 * - GET /getStockItemById/{itemId}: Retrieve stockItem information by the specified ID.
 * - POST /createStockItem: Creates a new stockItem using the provided customer data.
 * - PUT /updateStockItem: Update stockItems' information.
 * - DELETE /deleteStockItemById/{stockItemId}: Delete the stockItem with the given ID from the system.
 * Usage:
 * The StockItemController should be registered with the Spring application context and
 * automatically handle incoming HTTP requests to the specified endpoints.
 */
@RestController
public class StockItemController {

    @Autowired
    StockItemService stockItemService;

    /**
     * Returns all the stock item objects.
     * URL : "http://localhost8080/StockItems"
     * @return  All stock items as an arrayList of item JSON objects.
     */
    @GetMapping("/StockItems")
    public List<StockItem> getAllStockItems(){
        return stockItemService.getStockItems();
    }

    /**
     * Returns the StockItem object with given itemId.
     * URL : "http://localhost8080/getStockItemById/"
     * @param stockItemId as an input.
     * @return ResponseEntity with item information if found, or 404 if not found.
     * @throws if stock item object not found with given stockItemId.
     */
    @GetMapping("/getStockItemById/{stockItemId}")
    public ResponseEntity<StockItem> getStockItemById(@PathVariable(value = "stockItemId") int stockItemId) {

        try {
            StockItem stockItem = stockItemService.getStockItemById(stockItemId);
            return new ResponseEntity<>(stockItem, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the stockItem object.
     * URL : "http://localhost8080/createStockItem"
     * @param  stockItem object as an input.
     * @return  stockItem JSON object.
     */
    @PostMapping("/createStockItem")
    public StockItem createStockItem(@RequestBody StockItem stockItem){

        return stockItemService.createStockItem(stockItem);
    }

    /**
     * Updates the stockItem object.
     * URL : "http://localhost8080/updateStockItem"
     * @param  stockItem object as an input.
     * @return ResponseEntity with stockItem information if updated, or 404 if not found.
     * @throws  if stockItem object not found.
     */
    @PutMapping("/updateStockItem")
    public ResponseEntity<StockItem> updateStockItem(@RequestBody StockItem stockItem){
        try{
            StockItem updatedStockItem = stockItemService.updateStockItem(stockItem);
            return new ResponseEntity<>(updatedStockItem,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    /**
     * Deletes the stock item object with specific id
     * URL : "http://localhost8080/deleteItemById/"
     * @param stockItemId as an input.
     * @return AddResponse with stockItemId which is deleted.
     */
    @DeleteMapping("/deleteStockItemById/{stockItemId}")
    public AddResponse deleteStockItemById(@PathVariable(value = "stockItemId") int stockItemId){
        return stockItemService.deleteStockItemById(stockItemId);
    }
}