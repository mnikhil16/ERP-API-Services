package com.customer.service;


import com.customer.beans.PurchaseInvoiceItems;
import com.customer.controller.AddResponse;
import com.customer.repository.PurchaseInvoiceItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles PurchaseInvoiceItems-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete PurchaseInvoiceItems information in the database.
 * This service communicates with the PurchaseInvoiceItemsRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The PurchaseInvoiceItemsService should be autowired into other components that require PurchaseInvoiceItems-related functionalities.
 */

@Service
public class PurchaseInvoiceItemsService {

    @Autowired
    PurchaseInvoiceItemsRepository purchaseInvoiceItemsRep;

    /**
     * Get all the purchaseInvoiceItems information.
     *
     * @return All the PurchaseInvoiceItems objects.
     */
    public List<PurchaseInvoiceItems> getPurchaseInvoiceItems(){
        return purchaseInvoiceItemsRep.findAll();
    }


    /**
     * Get purchaseInvoiceItems information by the specified purchaseInvoiceItems ID.
     *
     * @param purchaseInvoiceItemsId The ID of the purchaseInvoiceItems to retrieve.
     * @return The PurchaseInvoiceItems object corresponding to the given ID.
     */
    public PurchaseInvoiceItems getPurchaseInvoiceItemsById(int purchaseInvoiceItemsId){
        List<PurchaseInvoiceItems> purchaseInvoiceItems = purchaseInvoiceItemsRep.findAll();
        PurchaseInvoiceItems purchaseInvoiceItem = null;
        for(PurchaseInvoiceItems pii: purchaseInvoiceItems){
            if(pii.getPurchaseInvoiceItemsId() == purchaseInvoiceItemsId){
                purchaseInvoiceItem = pii;
            }
        }
        return purchaseInvoiceItem;
    }

    /**
     * Create a new purchaseInvoiceItems with the provided PurchaseInvoiceItems object.
     *
     * @param purchaseInvoiceItems The PurchaseInvoiceItems object representing the purchaseInvoiceItems to be created.
     * @return The newly created PurchaseInvoiceItems object with a generated ID.
     */
    public PurchaseInvoiceItems createPurchaseInvoiceItems(PurchaseInvoiceItems purchaseInvoiceItems){
        return purchaseInvoiceItemsRep.save(purchaseInvoiceItems);
    }

    /**
     * Update a new purchaseInvoiceItems with the provided PurchaseInvoiceItems object.
     *
     * @param purchaseInvoiceItems The PurchaseInvoiceItems object representing the purchaseInvoiceItems to be updated.
     * @return The updated PurchaseInvoiceItems object.
     */
    public PurchaseInvoiceItems updatePurchaseInvoiceItems(PurchaseInvoiceItems purchaseInvoiceItems){
        return purchaseInvoiceItemsRep.save(purchaseInvoiceItems);
    }


    /**
     * Delete a purchaseInvoiceItems with the provided purchaseInvoiceItemsId.
     *
     * @param purchaseInvoiceItemsId The ID of the purchaseInvoiceItems to delete.
     * @return The deleted purchaseInvoiceItemsId.
     */
    public AddResponse deletePurchaseInvoiceItemsById(int purchaseInvoiceItemsId){
        purchaseInvoiceItemsRep.deleteById(purchaseInvoiceItemsId);
        AddResponse res = new AddResponse();
        res.setMsg("PurchaseInvoiceItems deleted");
        res.setId(purchaseInvoiceItemsId);
        return res;
    }
}