package com.main.controller;

import com.main.service.PurchaseOrderService;
import com.main.entity.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class represents the RESTful controller for managing PurchaseOrder-related endpoints.
 * It handles HTTP requests for creating, reading, updating, and deleting PurchaseOrder information.
 * The PurchaseOrderController maps incoming HTTP requests to appropriate methods to process them.
 * It interacts with the PurchaseOrderService to perform operations on purchaseOrder data.
 * Endpoints:
 * - GET /purchaseOrders: Retrieves all the purchaseOrders information.
 * - GET /getPurchaseOrderById/{purchaseOrderId}: Retrieve purchaseOrder information by the specified ID.
 * - POST /createPurchaseOrder: Creates a new purchaseOrder using the provided purchaseOrder data.
 * - PUT /updatePurchaseOrder: Update purchaseOrder information.
 * - DELETE /deletePurchaseOrderById/{purchaseOrderId}: Delete the purchaseOrder with the given ID from the system.
 * Usage:
 * The PurchaseOrderController should be registered with the Spring application context and
 * automatically handle incoming HTTP requests to the specified endpoints.
 */
@RestController
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    /**
     * Returns all the purchaseOrder objects.
     * URL : "http://localhost8080/PurchaseOrders"
     * @return  All purchaseOrders as an arrayList of purchaseOrder JSON objects.
     */
    @GetMapping("/PurchaseOrders")
    public List<PurchaseOrder> getAllPurchaseOrders(){
        return purchaseOrderService.getPurchaseOrders();
    }

    /**
     * Returns the purchaseOrder object with given purchaseOrderId.
     * URL : "http://localhost8080/getPurchaseOrderById/"
     * @param purchaseOrderId as an input.
     * @return ResponseEntity with purchaseOrder information if found, or 404 if not found.
     * @throws if PurchaseOrder object not found with given purchaseOrderId.
     */
    @GetMapping("/getPurchaseOrderById/{purchaseOrderId}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable(value = "purchaseOrderId") int purchaseOrderId) {

        try {
            PurchaseOrder purchaseOrder = purchaseOrderService.getPurchaseOrderById(purchaseOrderId);
            return new ResponseEntity<>(purchaseOrder, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the purchaseOrder object.
     * URL : "http://localhost8080/createPurchaseOrder"
     * @param  purchaseOrder object as an input.
     * @return  purchaseOrder JSON object.
     */
    @PostMapping("/createPurchaseOrder")
    public PurchaseOrder createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder){

        return purchaseOrderService.createPurchaseOrder(purchaseOrder);
    }

    /**
     * Updates the purchaseOrder object.
     * URL : "http://localhost8080/updatePurchaseOrder"
     * @param  purchaseOrder object as an input.
     * @return ResponseEntity with purchaseOrder information if updated, or 404 if not found.
     * @throws if PurchaseOrder object not found.
     */
    @PutMapping("/updatePurchaseOrder")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder){
        try{
            PurchaseOrder updatedPurchaseOrder = purchaseOrderService.updatePurchaseOrder(purchaseOrder);
            return new ResponseEntity<>(updatedPurchaseOrder,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    /**
     * Deletes the purchaseOrder object with specific id
     * URL : "http://localhost8080/deletePurchaseOrderById/"
     * @param purchaseOrderId as an input.
     * @return AddResponse with purchaseOrderId which is deleted.
     */
    @DeleteMapping("/deletePurchaseOrderById/{purchaseOrderId}")
    public AddResponse deletePurchaseOrderById(@PathVariable(value = "purchaseOrderId") int purchaseOrderId){
        return purchaseOrderService.deletePurchaseOrderById(purchaseOrderId);
    }
}