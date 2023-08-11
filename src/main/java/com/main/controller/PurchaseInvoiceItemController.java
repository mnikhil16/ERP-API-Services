package com.main.controller;

import com.main.dto.PurchaseInvoiceItemDTO;
import com.main.service.PurchaseInvoiceItemService;
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

    /**
     * Retrieve a list of all purchase invoice items.
     *
     * @return List of PurchaseInvoiceItemDTO objects representing all purchase invoice items.
     */
    @GetMapping("/PurchaseInvoiceItems")
    public List<PurchaseInvoiceItemDTO> getAllPurchaseInvoiceItems() {
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
        return purchaseInvoiceItemService.deletePurchaseInvoiceItemById(itemId);
    }
}