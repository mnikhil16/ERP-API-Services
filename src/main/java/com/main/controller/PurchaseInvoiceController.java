package com.main.controller;

import com.main.dto.PurchaseInvoiceDTO;
import com.main.service.PurchaseInvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class represents the RESTful controller for managing PurchaseInvoice-related endpoints.
 * It handles HTTP requests for creating, reading, updating, and deleting PurchaseInvoice information.
 * The PurchaseInvoiceController maps incoming HTTP requests to appropriate methods to process them.
 * It interacts with the PurchaseInvoiceService to perform operations on customer data.
 * Endpoints:
 * - GET /purchaseInvoices: Retrieves all the purchaseInvoices information.
 * - GET /getPurchaseInvoiceById/{purchaseInvoiceId}: Retrieve purchaseInvoice information by the specified ID.
 * - POST /createPurchaseInvoice: Creates a new purchaseInvoice using the provided purchaseInvoice data.
 * - PUT /updatePurchaseInvoice: Update purchaseInvoice information.
 * - DELETE /deletePurchaseInvoiceById/{purchaseInvoiceId}: Delete the purchaseInvoice with the given ID from the system.
 * Usage:
 * The PurchaseInvoiceController should be registered with the Spring application context and
 * automatically handle incoming HTTP requests to the specified endpoints.
 */
@RestController
public class PurchaseInvoiceController {

    @Autowired
    PurchaseInvoiceService purchaseInvoiceService;
    Logger logger = LoggerFactory.getLogger(PurchaseInvoiceController.class);
    /**
     * Returns all the purchaseInvoice objects.
     * URL : "http://localhost8080/PurchaseInvoices"
     * @return  All purchaseInvoices as an arrayList of purchaseInvoice JSON objects.
     */
    @GetMapping("/PurchaseInvoices")
    public List<PurchaseInvoiceDTO> getAllPurchaseInvoices(){
        logger.trace("Get all Purchase Invoices controller is invoked.");
        return purchaseInvoiceService.getPurchaseInvoices();
    }

    /**
     * Returns the purchaseInvoice object with given purchaseInvoiceId.
     * URL : "http://localhost8080/getPurchaseInvoiceById/"
     * @param purchaseInvoiceId as an input.
     * @return ResponseEntity with purchaseInvoice information if found, or 404 if not found.
     * @throws if PurchaseInvoice object not found with given purchaseInvoiceId.
     */
    @GetMapping("/getPurchaseInvoiceById/{purchaseInvoiceId}")
    public ResponseEntity<PurchaseInvoiceDTO> getPurchaseInvoiceById(@PathVariable(value = "purchaseInvoiceId") int purchaseInvoiceId) {
        logger.trace("Get Purchase Invoice by Id controller is invoked.");
        try {
            PurchaseInvoiceDTO purchaseInvoiceDTO = purchaseInvoiceService.getPurchaseInvoiceById(purchaseInvoiceId);
            return new ResponseEntity<>(purchaseInvoiceDTO, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the purchaseInvoice object.
     * URL : "http://localhost8080/createPurchaseInvoice"
     * @param  purchaseInvoiceDTO object as an input.
     * @return  purchaseInvoice JSON object.
     */
    @PostMapping("/createPurchaseInvoice")
    public PurchaseInvoiceDTO createPurchaseInvoice(@RequestBody PurchaseInvoiceDTO purchaseInvoiceDTO){
        logger.trace("Create Purchase Invoice controller is invoked.");
        return purchaseInvoiceService.createPurchaseInvoice(purchaseInvoiceDTO);
    }

    /**
     * Updates the purchaseInvoice object.
     * URL : "http://localhost8080/updatePurchaseInvoice"
     * @param  purchaseInvoiceDTO object as an input.
     * @return ResponseEntity with purchaseInvoice information if updated, or 404 if not found.
     * @throws  if PurchaseInvoice object not found.
     */
    @PutMapping("/updatePurchaseInvoice")
    public ResponseEntity<PurchaseInvoiceDTO> updatePurchaseInvoice(@RequestBody PurchaseInvoiceDTO purchaseInvoiceDTO){
        logger.trace("Update Purchase Invoice controller is invoked.");
        try{
            PurchaseInvoiceDTO updatedPurchaseInvoiceDTO = purchaseInvoiceService.updatePurchaseInvoice(purchaseInvoiceDTO);
            return new ResponseEntity<>(updatedPurchaseInvoiceDTO,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    /**
     * Deletes the purchaseInvoice object with specific id
     * URL : "http://localhost8080/deletePurchaseInvoiceById/"
     * @param purchaseInvoiceId as an input.
     * @return AddResponse with purchaseInvoiceId which is deleted.
     */
    @DeleteMapping("/deletePurchaseInvoiceById/{purchaseInvoiceId}")
    public AddResponse deletePurchaseInvoiceById(@PathVariable(value = "purchaseInvoiceId") int purchaseInvoiceId){
        logger.trace("Delete Purchase Invoice controller is invoked.");
        return purchaseInvoiceService.deletePurchaseInvoiceById(purchaseInvoiceId);
    }
}