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
 * - GET /items: Retrieves all the items' information.
 * - GET /getItemById/{itemId}: Retrieve item information by the specified ID.
 * - POST /createItem: Creates a new item using the provided customer data.
 * - PUT /updateItem: Update customer information.
 * - DELETE /deleteItemById/{itemId}: Delete the item with the given ID from the system.
 * Usage:
 * The StockItemController should be registered with the Spring application context and
 * automatically handle incoming HTTP requests to the specified endpoints.
 */
@RestController
public class StockItemController {

    @Autowired
    StockItemService service;

    /**
     * Returns all the customer objects.
     * URL : "http://localhost8080/Items"
     * @return  All items as an arrayList of item JSON objects.
     */
    @GetMapping("/Items")
    public List<StockItem> getAllItems(){
        return service.getItems();
    }

    /**
     * Returns the StockItem object with given itemId.
     * URL : "http://localhost8080/getItemById/"
     * @param itemId as an input.
     * @return ResponseEntity with item information if found, or 404 if not found.
     * @throws if item object not found with given Id.
     */
    @GetMapping("/getItemById/{itemId}")
    public ResponseEntity<StockItem> getItemById(@PathVariable(value = "itemId") int itemId) {

        try {
            StockItem stockItem = service.getItemById(itemId);
            return new ResponseEntity<StockItem>(stockItem, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the stockItem object.
     * URL : "http://localhost8080/createItem"
     * @param  stockItem object as an input.
     * @return  stockItem JSON object.
     */
    @PostMapping("/createItem")
    public StockItem createItem(@RequestBody StockItem stockItem){

        return service.createItem(stockItem);
    }

    /**
     * Updates the stockItem object.
     * URL : "http://localhost8080/updateItem"
     * @param  stockItem object as an input.
     * @return ResponseEntity with stockItem information if updated, or 404 if not found.
     * @throws  if stockItem object not found.
     */
    @PutMapping("/updateItem")
    public ResponseEntity<StockItem> updateItem(@RequestBody StockItem stockItem){
        try{
            StockItem updatedStockItem = service.updateItem(stockItem);
            return new ResponseEntity<StockItem>(updatedStockItem,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    /**
     * Deletes the item object with specific id
     * URL : "http://localhost8080/deleteItemById/"
     * @param itemId as an input.
     * @return AddResponse with itemId which is deleted.
     */
    @DeleteMapping("/deleteItemById/{itemId}")
    public AddResponse deleteItem(@PathVariable(value = "itemId") int itemId){
        return service.deleteItem(itemId);
    }
}