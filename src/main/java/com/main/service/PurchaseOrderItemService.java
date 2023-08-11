package com.main.service;


import com.main.entity.PurchaseOrderItem;
import com.main.controller.AddResponse;
import com.main.repository.PurchaseOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles PurchaseOrderItem-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete PurchaseOrderItem information in the database.
 * This service communicates with the PurchaseOrderItemRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The PurchaseOrderItemService should be autowired into other components that require PurchaseOrderItem-related functionalities.
 */

@Service
public class PurchaseOrderItemService {

    @Autowired
    PurchaseOrderItemRepository purchaseOrderItemRepository;

    /**
     * Get all the purchaseOrderItems information.
     *
     * @return All the PurchaseOrderItem objects.
     */
    public List<PurchaseOrderItem> getPurchaseOrderItems(){
        return purchaseOrderItemRepository.findAll();
    }

    /**
     * Get purchaseOrderItems information by the specified purchaseOrderItems ID.
     *
     * @param purchaseOrderItemId The ID of the purchaseOrderItems to retrieve.
     * @return The PurchaseOrderItem object corresponding to the given ID.
     */
    public PurchaseOrderItem getPurchaseOrderItemById(int purchaseOrderItemId){
        List<PurchaseOrderItem> purchaseOrderItems = purchaseOrderItemRepository.findAll();
        PurchaseOrderItem purchaseOrderItem = null;
        for(PurchaseOrderItem poi: purchaseOrderItems){
            if(poi.getPurchaseOrderItemId() == purchaseOrderItemId){
                purchaseOrderItem = poi;
            }
        }
        return purchaseOrderItem;
    }

    /**
     * Create a new purchaseOrderItem with the provided PurchaseOrderItem object.
     *
     * @param purchaseOrderItem The PurchaseOrderItem object representing the purchaseOrderItem to be created.
     * @return The newly created PurchaseOrderItem object with a generated ID.
     */
    public PurchaseOrderItem createPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem){
        return purchaseOrderItemRepository.save(purchaseOrderItem);
    }

    /**
     * Update purchaseOrderItem information with the provided PurchaseOrderItem object.
     *
     * @param purchaseOrderItem The PurchaseOrderItem object representing the purchaseOrderItem to be updated.
     * @return The updated PurchaseOrderItem object.
     */
    public PurchaseOrderItem updatePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem){
        return purchaseOrderItemRepository.save(purchaseOrderItem);
    }

    /**
     * Delete a purchaseOrderItem with the provided purchaseOrderItemId.
     *
     * @param purchaseOrderItemId The ID of the purchaseOrderItem to delete.
     * @return An AddResponse indicating the deletion result.
     */
    public AddResponse deletePurchaseOrderItemById(int purchaseOrderItemId){
        purchaseOrderItemRepository.deleteById(purchaseOrderItemId);
        AddResponse response = new AddResponse();
        response.setMsg("PurchaseOrderItem deleted");
        response.setId(purchaseOrderItemId);
        return response;
    }
}