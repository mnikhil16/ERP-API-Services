package com.customer.service;

import com.customer.beans.Customer;
import com.customer.beans.Supplier;
import com.customer.controller.AddResponse;
import com.customer.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles Customer-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete Customer information in the database.
 * This service communicates with the CustomerRepository to perform CRUD operations on Customer_db entities.
 * Usage:
 * The CustomerService should be autowired into other components that require Customer-related functionalities.
 */

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRep;

    /**
     * Get all the supplier information.
     *
     * @return All the Supplier objects.
     */
    public List<Supplier> getSuppliers(){
        return supplierRep.findAll();
    }


    /**
     * Get supplier information by the specified supplier ID.
     *
     * @param supplierId The ID of the supplier to retrieve.
     * @return The Supplier object corresponding to the given ID.
     */
    public Supplier getSupplierById(int supplierId){
        List<Supplier> suppliers = supplierRep.findAll();
        Supplier supplier = null;
        for(Supplier s: suppliers){
            if(s.getSupplierId() == supplierId){
                supplier = s;
            }
        }
        return supplier;
    }

    /**
     * Create a new supplier with the provided supplier object.
     *
     * @param supplier The Supplier object representing the supplier to be created.
     * @return The newly created supplier object with a generated ID.
     */
    public Supplier createSupplier(Supplier supplier){
        return supplierRep.save(supplier);
    }

    /**
     * Update a new supplier with the provided supplier object.
     *
     * @param supplier The Supplier object representing the supplier to be updated.
     * @return The updated Supplier object.
     */
    public Supplier updateSupplier(Supplier supplier){
        return supplierRep.save(supplier);
    }


    /**
     * Delete a supplier with the provided supplierId.
     *
     * @param supplierId The ID of the supplier to delete.
     * @return The deleted supplierId.
     */
    public AddResponse deleteSupplierById(int supplierId){
        supplierRep.deleteById(supplierId);
        AddResponse res = new AddResponse();
        res.setMsg("Supplier deleted");
        res.setId(supplierId);
        return res;
    }
}