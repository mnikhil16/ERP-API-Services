package com.main.controller;

import com.main.dto.SalesItemDTO;
import com.main.service.SalesItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class responsible for managing sales items through HTTP endpoints.
 */
@RestController
public class SalesItemController {

    @Autowired
    SalesItemService salesItemService;
    Logger logger = LoggerFactory.getLogger(SalesItemController.class);
    /**
     * Retrieve a list of all sales items.
     *
     * @return List of SalesItemDTO objects representing all sales items.
     */
    @GetMapping("/SalesItems")
    public List<SalesItemDTO> getAllSalesItems() {
        logger.trace("Get all Sales Items controller is invoked.");
        return salesItemService.getSalesItems();
    }

    /**
     * Retrieve a sales item by its unique identifier.
     *
     * @param itemId The ID of the sales item to retrieve.
     * @return ResponseEntity containing the SalesItemDTO if found, or HttpStatus.NOT_FOUND if not found.
     */
    @GetMapping("/getSalesItemById/{itemId}")
    public ResponseEntity<SalesItemDTO> getSalesItemById(@PathVariable(value = "itemId") int itemId) {
        logger.trace("Get Sales Item by Id controller is invoked.");
        try {
            SalesItemDTO salesItemDTO = salesItemService.getSalesItemById(itemId);
            return new ResponseEntity<>(salesItemDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create a new sales item.
     *
     * @param salesItemDTO The SalesItemDTO object containing sales item information.
     * @return The created SalesItemDTO with generated ID.
     */
    @PostMapping("/createSalesItem")
    public SalesItemDTO createSalesItem(@RequestBody SalesItemDTO salesItemDTO) {
        logger.trace("Delete Sales Item controller is invoked.");
        return salesItemService.createSalesItem(salesItemDTO);
    }

    /**
     * Update an existing sales item.
     *
     * @param salesItemDTO The SalesItemDTO object containing updated information.
     * @return ResponseEntity containing the updated SalesItemDTO if successful, or HttpStatus.CONFLICT if an error occurs.
     */
    @PutMapping("/updateSalesItem")
    public ResponseEntity<SalesItemDTO> updateSalesItem(@RequestBody SalesItemDTO salesItemDTO) {
        logger.trace("Update Sales Item controller is invoked.");
        try {
            SalesItemDTO updatedSalesItemDTO = salesItemService.updateSalesItem(salesItemDTO);
            return new ResponseEntity<>(updatedSalesItemDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    /**
     * Delete a sales item by its unique identifier.
     *
     * @param itemId The ID of the sales item to delete.
     * @return AddResponse indicating the result of the deletion process.
     */
    @DeleteMapping("/deleteSalesItemById/{itemId}")
    public AddResponse deleteSalesItemById(@PathVariable(value = "itemId") int itemId) {
        logger.trace("Delete Sales Item controller is invoked.");
        return salesItemService.deleteSalesItemById(itemId);
    }
}