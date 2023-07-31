package com.customer.service;


import com.customer.beans.PurchaseOrderItems;
import com.customer.controller.AddResponse;
import com.customer.repository.PurchaseOrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles PurchaseOrderItems-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete PurchaseOrderItems information in the database.
 * This service communicates with the PurchaseOrderItemsRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The PurchaseOrderItemsService should be autowired into other components that require PurchaseOrderItems-related functionalities.
 */

@Service
public class PurchaseOrderItemsService {

    @Autowired
    PurchaseOrderItemsRepository purchaseOrderItemsRep;

    /**
     * Get all the purchaseOrderItems information.
     *
     * @return All the PurchaseOrderItems objects.
     */
    public List<PurchaseOrderItems> getPurchaseOrderItems(){
        return purchaseOrderItemsRep.findAll();
    }


    /**
     * Get purchaseOrderItems information by the specified purchaseOrderItems ID.
     *
     * @param purchaseOrderItemsId The ID of the purchaseOrderItems to retrieve.
     * @return The PurchaseOrderItems object corresponding to the given ID.
     */
    public PurchaseOrderItems getPurchaseOrderItemsById(int purchaseOrderItemsId){
        List<PurchaseOrderItems> purchaseOrderItems = purchaseOrderItemsRep.findAll();
        PurchaseOrderItems purchaseOrderItem = null;
        for(PurchaseOrderItems poi: purchaseOrderItems){
            if(poi.getPurchaseOrderItemsId() == purchaseOrderItemsId){
                purchaseOrderItem = poi;
            }
        }
        return purchaseOrderItem;
    }

    /**
     * Create a new purchaseOrderItems with the provided PurchaseOrderItems object.
     *
     * @param purchaseOrderItems The PurchaseOrderItems object representing the purchaseOrderItems to be created.
     * @return The newly created PurchaseOrderItems object with a generated ID.
     */
    public PurchaseOrderItems createPurchaseOrderItems(PurchaseOrderItems purchaseOrderItems){
        return purchaseOrderItemsRep.save(purchaseOrderItems);
    }

    /**
     * Update a new purchaseOrderItems with the provided PurchaseOrderItems object.
     *
     * @param purchaseOrderItems The PurchaseOrderItems object representing the purchaseOrderItems to be updated.
     * @return The updated PurchaseOrderItems object.
     */
    public PurchaseOrderItems updatePurchaseOrderItems(PurchaseOrderItems purchaseOrderItems){
        return purchaseOrderItemsRep.save(purchaseOrderItems);
    }


    /**
     * Delete a purchaseOrderItems with the provided purchaseOrderItemsId.
     *
     * @param purchaseOrderItemsId The ID of the purchaseOrderItems to delete.
     * @return The deleted purchaseOrderItemsId.
     */
    public AddResponse deletePurchaseOrderItemById(int purchaseOrderItemsId){
        purchaseOrderItemsRep.deleteById(purchaseOrderItemsId);
        AddResponse res = new AddResponse();
        res.setMsg("purchaseOrderItems deleted");
        res.setId(purchaseOrderItemsId);
        return res;
    }
}