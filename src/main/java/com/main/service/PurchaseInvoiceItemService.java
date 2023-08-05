package com.main.service;


import com.main.beans.PurchaseInvoiceItem;
import com.main.controller.AddResponse;
import com.main.repository.PurchaseInvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles PurchaseInvoiceItem-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete PurchaseInvoiceItem information in the database.
 * This service communicates with the PurchaseInvoiceItemRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The PurchaseInvoiceItemService should be autowired into other components that require PurchaseInvoiceItem-related functionalities.
 */

@Service
public class PurchaseInvoiceItemService {

    @Autowired
    PurchaseInvoiceItemRepository purchaseInvoiceItemRepository;

    /**
     * Get all the purchaseInvoiceItems information.
     *
     * @return All the PurchaseInvoiceItem objects.
     */
    public List<PurchaseInvoiceItem> getPurchaseInvoiceItems(){
        return purchaseInvoiceItemRepository.findAll();
    }


    /**
     * Get purchaseInvoiceItem information by the specified purchaseInvoiceItem ID.
     *
     * @param purchaseInvoiceItemId The ID of the purchaseInvoiceItem to retrieve.
     * @return The PurchaseInvoiceItem object corresponding to the given ID.
     */
    public PurchaseInvoiceItem getPurchaseInvoiceItemById(int purchaseInvoiceItemId){
        List<PurchaseInvoiceItem> purchaseInvoiceItems = purchaseInvoiceItemRepository.findAll();
        PurchaseInvoiceItem purchaseInvoiceItem = null;
        for(PurchaseInvoiceItem pii: purchaseInvoiceItems){
            if(pii.getPurchaseInvoiceItemId() == purchaseInvoiceItemId){
                purchaseInvoiceItem = pii;
            }
        }
        return purchaseInvoiceItem;
    }

    /**
     * Create a new purchaseInvoiceItem with the provided PurchaseInvoiceItem object.
     *
     * @param purchaseInvoiceItem The PurchaseInvoiceItem object representing the purchaseInvoiceItem to be created.
     * @return The newly created PurchaseInvoiceItem object with a generated ID.
     */
    public PurchaseInvoiceItem createPurchaseInvoiceItem(PurchaseInvoiceItem purchaseInvoiceItem){
        return purchaseInvoiceItemRepository.save(purchaseInvoiceItem);
    }

    /**
     * Update a new purchaseInvoiceItem with the provided PurchaseInvoiceItem object.
     *
     * @param purchaseInvoiceItem The PurchaseInvoiceItem object representing the purchaseInvoiceItem to be updated.
     * @return The updated PurchaseInvoiceItem object.
     */
    public PurchaseInvoiceItem updatePurchaseInvoiceItem(PurchaseInvoiceItem purchaseInvoiceItem){
        return purchaseInvoiceItemRepository.save(purchaseInvoiceItem);
    }


    /**
     * Delete a purchaseInvoiceItem with the provided purchaseInvoiceItemId.
     *
     * @param purchaseInvoiceItemId The ID of the purchaseInvoiceItem to delete.
     * @return The deleted purchaseInvoiceItemId.
     */
    public AddResponse deletePurchaseInvoiceItemById(int purchaseInvoiceItemId){
        purchaseInvoiceItemRepository.deleteById(purchaseInvoiceItemId);
        AddResponse res = new AddResponse();
        res.setMsg("PurchaseInvoiceItem deleted");
        res.setId(purchaseInvoiceItemId);
        return res;
    }
}