package com.customer.service;

import com.customer.beans.PurchaseOrder;
import com.customer.controller.AddResponse;
import com.customer.repository.PurchaseOrderRepository;
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
    PurchaseOrderRepository purchaseOrderRep;

    /**
     * Get all the purchase order information.
     *
     * @return All the PurchaseOrder objects.
     */
    public List<PurchaseOrder> getPurchaseOrders(){
        return purchaseOrderRep.findAll();
    }


    /**
     * Get purchase order information by the specified purchase order ID.
     *
     * @param purchaseOrderId The ID of the purchase order to retrieve.
     * @return The PurchaseOrder object corresponding to the given ID.
     */
    public PurchaseOrder getPurchaseOrderById(int purchaseOrderId){
        List<PurchaseOrder> purchaseOrders = purchaseOrderRep.findAll();
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
     * @return The newly created purchaseOrder object with a generated ID.
     */
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder){
        return purchaseOrderRep.save(purchaseOrder);
    }

    /**
     * Update a new purchaseOrder with the provided PurchaseOrder object.
     *
     * @param purchaseOrder The PurchaseOrder object representing the purchaseOrder to be updated.
     * @return The updated PurchaseOrder object.
     */
    public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder){
        return purchaseOrderRep.save(purchaseOrder);
    }


    /**
     * Delete a purchaseOrder with the provided purchaseOrderId.
     *
     * @param purchaseOrderId The ID of the purchaseOrder to delete.
     * @return The deleted purchaseOrderId.
     */
    public AddResponse deletePurchaseOrderById(int purchaseOrderId){
        purchaseOrderRep.deleteById(purchaseOrderId);
        AddResponse res = new AddResponse();
        res.setMsg("PurchaseOrder deleted");
        res.setId(purchaseOrderId);
        return res;
    }
}
