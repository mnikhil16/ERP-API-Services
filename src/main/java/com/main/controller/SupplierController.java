package com.main.controller;

import com.main.dto.SupplierDTO;
import com.main.service.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class represents the RESTful controller for managing Supplier-related endpoints.
 * It handles HTTP requests for creating, reading, updating, and deleting Supplier information.
 * The SupplierController maps incoming HTTP requests to appropriate methods to process them.
 * It interacts with the SupplierService to perform operations on supplier data.
 * Endpoints:
 * - GET /suppliers: Retrieves all the suppliers' information.
 * - GET /getSupplierById/{supplierId}: Retrieve supplier information by the specified ID.
 * - POST /createSupplier: Creates a new supplier using the provided supplier data.
 * - PUT /updateSupplier: Update supplier information.
 * - DELETE /deleteSupplierById/{supplierId}: Delete the supplier with the given ID from the system.
 * Usage:
 * The SupplierController should be registered with the Spring application context and
 * automatically handle incoming HTTP requests to the specified endpoints.
 */
@RestController
public class SupplierController {

    @Autowired
    SupplierService supplierService;
    Logger logger = LoggerFactory.getLogger(StoreController.class);

    /**
     * Returns all the supplier objects.
     * URL : "http://localhost8080/Suppliers"
     * @return  All suppliers as an arrayList of supplier JSON objects.
     */
    @GetMapping("/Suppliers")
    public List<SupplierDTO> getAllSuppliers(){
        logger.trace("Get all Suppliers is invoked.");
        return supplierService.getSuppliers();
    }

    /**
     * Returns the supplier object with given supplierId.
     * URL : "http://localhost8080/getSupplierById/"
     * @param supplierId as an input.
     * @return ResponseEntity with supplier information if found, or 404 if not found.
     * @throws if Supplier object not found with given supplierId.
     */
    @GetMapping("/getSupplierById/{supplierId}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable(value = "supplierId") int supplierId) {
        logger.trace("Get Supplier by Id is invoked.");
        try {
            SupplierDTO supplierDTO = supplierService.getSupplierById(supplierId);
            return new ResponseEntity<>(supplierDTO, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the supplier object.
     * URL : "http://localhost8080/createSupplier"
     * @param  supplierDTO object as an input.
     * @return  supplier JSON object.
     */
    @PostMapping("/createSupplier")
    public SupplierDTO createSupplier(@RequestBody SupplierDTO supplierDTO){
        logger.trace("Create Supplier is invoked.");
        return supplierService.createSupplier(supplierDTO);
    }

    /**
     * Updates the supplier object.
     * URL : "http://localhost8080/updateSupplier"
     * @param  supplierDTO object as an input.
     * @return ResponseEntity with supplier information if updated, or 404 if not found.
     * @throws  if supplier object not found.
     */
    @PutMapping("/updateSupplier")
    public ResponseEntity<SupplierDTO> updateSupplier(@RequestBody SupplierDTO supplierDTO){
        logger.trace("Update Supplier is invoked.");
        try{
            SupplierDTO updatedSupplierDTO = supplierService.updateSupplier(supplierDTO);
            return new ResponseEntity<>(updatedSupplierDTO,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    /**
     * Deletes the supplier object with specific id
     * URL : "http://localhost8080/deleteSupplierById/"
     * @param supplierId as an input.
     * @return AddResponse with supplierId which is deleted.
     */
    @DeleteMapping("/deleteSupplierById/{supplierId}")
    public AddResponse deleteSupplierById(@PathVariable(value = "supplierId") int supplierId){
        logger.trace("Delete Supplier is invoked.");
        return supplierService.deleteSupplierById(supplierId);
    }
}