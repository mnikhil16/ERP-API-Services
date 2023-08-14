package com.main.controller;

import com.main.dto.PurchaseInvoiceItemDTO;
import com.main.service.PurchaseInvoiceItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class responsible for managing purchase invoice items through HTTP endpoints.
 */
@RestController
public class PurchaseInvoiceItemController {

    @Autowired
    PurchaseInvoiceItemService purchaseInvoiceItemService;
    Logger logger = LoggerFactory.getLogger(PurchaseInvoiceItemController.class);
    /**
     * Retrieve a list of all purchase invoice items.
     *
     * @return List of PurchaseInvoiceItemDTO objects representing all purchase invoice items.
     */
    @GetMapping("/PurchaseInvoiceItems")
    public List<PurchaseInvoiceItemDTO> getAllPurchaseInvoiceItems() {
        logger.trace("Get all Purchase Invoice Items controller is invoked.");
        return purchaseInvoiceItemService.getPurchaseInvoiceItems();
    }

    /**
     * Retrieve a purchase invoice item by its unique identifier.
     *
     * @param itemId The ID of the purchase invoice item to retrieve.
     * @return ResponseEntity containing the PurchaseInvoiceItemDTO if found, or HttpStatus.NOT_FOUND if not found.
     */
    @GetMapping("/getPurchaseInvoiceItemById/{itemId}")
    public ResponseEntity<PurchaseInvoiceItemDTO> getPurchaseInvoiceItemById(@PathVariable(value = "itemId") int itemId) {
        logger.trace("Get Purchase Invoice Item by Id controller is invoked.");
        try {
            PurchaseInvoiceItemDTO purchaseInvoiceItemDTO = purchaseInvoiceItemService.getPurchaseInvoiceItemById(itemId);
            return new ResponseEntity<>(purchaseInvoiceItemDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create a new purchase invoice item.
     *
     * @param purchaseInvoiceItemDTO The PurchaseInvoiceItemDTO object containing purchase invoice item information.
     * @return The created PurchaseInvoiceItemDTO with generated ID.
     */
    @PostMapping("/createPurchaseInvoiceItem")
    public PurchaseInvoiceItemDTO createPurchaseInvoiceItem(@RequestBody PurchaseInvoiceItemDTO purchaseInvoiceItemDTO) {
        logger.trace("Create Purchase Invoice Item controller is invoked.");
        return purchaseInvoiceItemService.createPurchaseInvoiceItem(purchaseInvoiceItemDTO);
    }

    /**
     * Update an existing purchase invoice item.
     *
     * @param purchaseInvoiceItemDTO The PurchaseInvoiceItemDTO object containing updated information.
     * @return ResponseEntity containing the updated PurchaseInvoiceItemDTO if successful, or HttpStatus.CONFLICT if an error occurs.
     */
    @PutMapping("/updatePurchaseInvoiceItem")
    public ResponseEntity<PurchaseInvoiceItemDTO> updatePurchaseInvoiceItem(@RequestBody PurchaseInvoiceItemDTO purchaseInvoiceItemDTO) {
        logger.trace("Update Purchase Invoice Item controller is invoked.");
        try {
            PurchaseInvoiceItemDTO updatedPurchaseInvoiceItemDTO = purchaseInvoiceItemService.updatePurchaseInvoiceItem(purchaseInvoiceItemDTO);
            return new ResponseEntity<>(updatedPurchaseInvoiceItemDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    /**
     * Delete a purchase invoice item by its unique identifier.
     *
     * @param itemId The ID of the purchase invoice item to delete.
     * @return AddResponse indicating the result of the deletion process.
     */
    @DeleteMapping("/deletePurchaseInvoiceItemById/{itemId}")
    public AddResponse deletePurchaseInvoiceItemById(@PathVariable(value = "itemId") int itemId) {
        logger.trace("Delete Purchase Invoice Item controller is invoked.");
        return purchaseInvoiceItemService.deletePurchaseInvoiceItemById(itemId);
    }
}