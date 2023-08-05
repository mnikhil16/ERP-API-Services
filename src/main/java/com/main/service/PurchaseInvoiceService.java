package com.main.service;

import com.main.beans.PurchaseInvoice;
import com.main.controller.AddResponse;
import com.main.repository.PurchaseInvoiceRepository;
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
    PurchaseInvoiceRepository purchaseInvoiceRepository;

    /**
     * Get all the customer information.
     *
     * @return All the Customer objects.
     */
    public List<PurchaseInvoice> getPurchaseInvoices(){
        return purchaseInvoiceRepository.findAll();
    }


    /**
     * Get purchaseInvoice information by the specified purchaseInvoice ID.
     *
     * @param purchaseInvoiceId The ID of the purchaseInvoice to retrieve.
     * @return The PurchaseInvoice object corresponding to the given ID.
     */
    public PurchaseInvoice getPurchaseInvoiceById(int purchaseInvoiceId){
        List<PurchaseInvoice> purchaseInvoices = purchaseInvoiceRepository.findAll();
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
        return purchaseInvoiceRepository.save(purchaseInvoice);
    }

    /**
     * Update a new purchaseInvoice with the provided PurchaseInvoice object.
     *
     * @param purchaseInvoice The PurchaseInvoice object representing the purchaseInvoice to be updated.
     * @return The updated PurchaseInvoice object.
     */
    public PurchaseInvoice updatePurchaseInvoice(PurchaseInvoice purchaseInvoice){
        return purchaseInvoiceRepository.save(purchaseInvoice);
    }


    /**
     * Delete a purchaseInvoice with the provided purchaseInvoiceId.
     *
     * @param purchaseInvoiceId The ID of the purchaseInvoice to delete.
     * @return The deleted purchaseInvoiceId.
     */
    public AddResponse deletePurchaseInvoiceById(int purchaseInvoiceId){
        purchaseInvoiceRepository.deleteById(purchaseInvoiceId);
        AddResponse res = new AddResponse();
        res.setMsg("PurchaseInvoice deleted");
        res.setId(purchaseInvoiceId);
        return res;
    }
}