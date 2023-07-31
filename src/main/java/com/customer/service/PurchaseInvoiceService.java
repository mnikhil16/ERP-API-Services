package com.customer.service;

import com.customer.beans.PurchaseInvoice;
import com.customer.controller.AddResponse;
import com.customer.repository.PurchaseInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles Customer-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete Customer information in the database.
 * This service communicates with the CustomerRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The CustomerService should be autowired into other components that require Customer-related functionalities.
 */

@Service
public class PurchaseInvoiceService {

    @Autowired
    PurchaseInvoiceRepository purchaseInvoiceRep;

    /**
     * Get all the customer information.
     *
     * @return All the Customer objects.
     */
    public List<PurchaseInvoice> getPurchaseInvoices(){
        return purchaseInvoiceRep.findAll();
    }


    /**
     * Get purchaseInvoice information by the specified purchaseInvoice ID.
     *
     * @param purchaseInvoiceId The ID of the purchaseInvoice to retrieve.
     * @return The PurchaseInvoice object corresponding to the given ID.
     */
    public PurchaseInvoice getPurchaseInvoiceById(int purchaseInvoiceId){
        List<PurchaseInvoice> purchaseInvoices = purchaseInvoiceRep.findAll();
        PurchaseInvoice purchaseInvoice = null;
        for(PurchaseInvoice pi: purchaseInvoices){
            if(pi.getPurchaseInvoiceId() == purchaseInvoiceId){
                purchaseInvoice = pi;
            }
        }
        return purchaseInvoice;
    }

    /**
     * Create a new purchaseInvoice with the provided PurchaseInvoice object.
     *
     * @param purchaseInvoice The PurchaseInvoice object representing the purchaseInvoice to be created.
     * @return The newly created PurchaseInvoice object with a generated ID.
     */
    public PurchaseInvoice createPurchaseInvoice(PurchaseInvoice purchaseInvoice){
        return purchaseInvoiceRep.save(purchaseInvoice);
    }

    /**
     * Update a new purchaseInvoice with the provided PurchaseInvoice object.
     *
     * @param purchaseInvoice The PurchaseInvoice object representing the purchaseInvoice to be updated.
     * @return The updated PurchaseInvoice object.
     */
    public PurchaseInvoice updatePurchaseInvoice(PurchaseInvoice purchaseInvoice){
        return purchaseInvoiceRep.save(purchaseInvoice);
    }


    /**
     * Delete a purchaseInvoice with the provided purchaseInvoiceId.
     *
     * @param purchaseInvoiceId The ID of the purchaseInvoice to delete.
     * @return The deleted purchaseInvoiceId.
     */
    public AddResponse deletePurchaseInvoiceById(int purchaseInvoiceId){
        purchaseInvoiceRep.deleteById(purchaseInvoiceId);
        AddResponse res = new AddResponse();
        res.setMsg("PurchaseInvoice deleted");
        res.setId(purchaseInvoiceId);
        return res;
    }
}