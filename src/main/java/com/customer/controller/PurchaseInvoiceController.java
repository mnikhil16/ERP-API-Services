package com.customer.controller;

import com.customer.beans.PurchaseInvoice;
import com.customer.service.PurchaseInvoiceService;
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

    /**
     * Returns all the purchaseInvoice objects.
     * URL : "http://localhost8080/PurchaseInvoices"
     * @return  All purchaseInvoices as an arrayList of purchaseInvoice JSON objects.
     */
    @GetMapping("/PurchaseInvoices")
    public List<PurchaseInvoice> getAllPurchaseInvoices(){
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
    public ResponseEntity<PurchaseInvoice> getPurchaseInvoiceById(@PathVariable(value = "purchaseInvoiceId") int purchaseInvoiceId) {

        try {
            PurchaseInvoice purchaseInvoice = purchaseInvoiceService.getPurchaseInvoiceById(purchaseInvoiceId);
            return new ResponseEntity<>(purchaseInvoice, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the purchaseInvoice object.
     * URL : "http://localhost8080/createPurchaseInvoice"
     * @param  purchaseInvoice object as an input.
     * @return  purchaseInvoice JSON object.
     */
    @PostMapping("/createPurchaseInvoice")
    public PurchaseInvoice createPurchaseInvoice(@RequestBody PurchaseInvoice purchaseInvoice){

        return purchaseInvoiceService.createPurchaseInvoice(purchaseInvoice);
    }

    /**
     * Updates the purchaseInvoice object.
     * URL : "http://localhost8080/updatePurchaseInvoice"
     * @param  purchaseInvoice object as an input.
     * @return ResponseEntity with purchaseInvoice information if updated, or 404 if not found.
     * @throws  if PurchaseInvoice object not found.
     */
    @PutMapping("/updatePurchaseInvoice")
    public ResponseEntity<PurchaseInvoice> updatePurchaseInvoice(@RequestBody PurchaseInvoice purchaseInvoice){
        try{
            PurchaseInvoice updatedPurchaseInvoice = purchaseInvoiceService.updatePurchaseInvoice(purchaseInvoice);
            return new ResponseEntity<>(updatedPurchaseInvoice,HttpStatus.OK);
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
        return purchaseInvoiceService.deletePurchaseInvoiceById(purchaseInvoiceId);
    }
}