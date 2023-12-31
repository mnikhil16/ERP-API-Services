package com.main.service;

import com.main.entity.PurchaseOrder;
import com.main.controller.AddResponse;
import com.main.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles PurchaseOrder-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete PurchaseOrder information in the database.
 * This service communicates with the CustomerRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The PurchaseOrderService should be autowired into other components that require PurchaseOrder-related functionalities.
 */
@Service
public class PurchaseOrderService {

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    /**
     * Get all the purchase order information.
     *
     * @return All the PurchaseOrder objects.
     */
    public List<PurchaseOrder> getPurchaseOrders(){
        return purchaseOrderRepository.findAll();
    }

    /**
     * Get purchase order information by the specified purchase order ID.
     *
     * @param purchaseOrderId The ID of the purchase order to retrieve.
     * @return The PurchaseOrder object corresponding to the given ID.
     */
    public PurchaseOrder getPurchaseOrderById(int purchaseOrderId){
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.findAll();
        PurchaseOrder purchaseOrder = null;
        for(PurchaseOrder po: purchaseOrders){
            if(po.getPurchaseOrderId() == purchaseOrderId){
                purchaseOrder = po;
            }
        }
        return purchaseOrder;
    }

    /**
     * Create a new purchase order with the provided purchase order object.
     *
     * @param purchaseOrder The PurchaseOrder object representing the purchaseOrder to be created.
     * @return The newly created PurchaseOrder object with a generated ID.
     */
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder){
        return purchaseOrderRepository.save(purchaseOrder);
    }

    /**
     * Update purchase order information with the provided PurchaseOrder object.
     *
     * @param purchaseOrder The PurchaseOrder object representing the purchaseOrder to be updated.
     * @return The updated PurchaseOrder object.
     */
    public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder){
        return purchaseOrderRepository.save(purchaseOrder);
    }

    /**
     * Delete a purchase order with the provided purchaseOrderId.
     *
     * @param purchaseOrderId The ID of the purchase order to delete.
     * @return An AddResponse indicating the deletion result.
     */
    public AddResponse deletePurchaseOrderById(int purchaseOrderId){
        purchaseOrderRepository.deleteById(purchaseOrderId);
        AddResponse response = new AddResponse();
        response.setMsg("PurchaseOrder deleted");
        response.setId(purchaseOrderId);
        return response;
    }
}