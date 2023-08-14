package com.main.controller;

import com.main.dto.StockItemDTO;
import com.main.service.StockItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(StockItemController.class);

    /**
     * Returns all the stock item objects.
     * URL: "http://localhost:8080/getAllStockItems"
     * @return  All stock items as an arrayList of item JSON objects.
     */
    @GetMapping("/stockItems")
    public List<StockItemDTO> getAllStockItems(){
        logger.trace("Get all Stock Items controller is invoked.");
        return stockItemService.getStockItems();
    }

    /**
     * Returns the StockItem object with given itemId.
     * URL : "http://localhost:8080/getStockItemById/"
     * @param stockItemId as an input.
     * @return ResponseEntity with item information if found, or 404 if not found.
     * @throws if stock item object not found with given stockItemId.
     */
    @GetMapping("/getStockItemById/{stockItemId}")
    public ResponseEntity<StockItemDTO> getStockItemById(@PathVariable(value = "stockItemId") int stockItemId) {
        logger.trace("Get Stock Item by Id controller is invoked.");
        try {
            StockItemDTO stockItemDTO = stockItemService.getStockItemById(stockItemId);
            return new ResponseEntity<>(stockItemDTO, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the stockItem object.
     * URL : "http://localhost:8080/createStockItem"
     * @param  stockItemDTO object as an input.
     * @return  stockItem JSON object.
     */
    @PostMapping("/createStockItem")
    public StockItemDTO createStockItem(@RequestBody StockItemDTO stockItemDTO){
        logger.trace("Create Stock Item controller is invoked.");
        return stockItemService.createStockItem(stockItemDTO);
    }

    /**
     * Updates the stockItem object.
     * URL : "http://localhost:8080/updateStockItem"
     * @param  stockItemDTO object as an input.
     * @return ResponseEntity with stockItem information if updated, or 404 if not found.
     * @throws  if stockItem object not found.
     */
    @PutMapping("/updateStockItem")
    public ResponseEntity<StockItemDTO> updateStockItem(@RequestBody StockItemDTO stockItemDTO){
        logger.trace("Update Stock Item controller is invoked.");
        try{
            StockItemDTO updatedStockItemDTO = stockItemService.updateStockItem(stockItemDTO);
            return new ResponseEntity<>(updatedStockItemDTO,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    /**
     * Deletes the stock item object with specific id
     * URL : "http://localhost:8080/deleteItemById/"
     * @param stockItemId as an input.
     * @return AddResponse with stockItemId which is deleted.
     */
    @DeleteMapping("/deleteStockItemById/{stockItemId}")
    public AddResponse deleteStockItemById(@PathVariable(value = "stockItemId") int stockItemId){
        logger.trace("Delete Stock Item controller is invoked.");
        return stockItemService.deleteStockItemById(stockItemId);
    }
}