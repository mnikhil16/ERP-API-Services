package com.customer.service;

import com.customer.beans.SalesItems;
import com.customer.controller.AddResponse;
import com.customer.repository.SalesItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles SalesItems-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete SalesItems information in the database.
 * This service communicates with the SalesItemsRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The SalesItemsService should be autowired into other components that require SalesItems-related functionalities.
 */

@Service
public class SalesItemsService {

    @Autowired
    SalesItemsRepository salesItemsRep;

    /**
     * Get all the salesItems information.
     *
     * @return All the SalesItems objects.
     */
    public List<SalesItems> getSalesItems(){
        return salesItemsRep.findAll();
    }


    /**
     * Get salesItems information by the specified salesItems ID.
     *
     * @param salesItemsId The ID of the salesItems to retrieve.
     * @return The SalesItems object corresponding to the given ID.
     */
    public SalesItems getSalesItemsById(int salesItemsId){
        List<SalesItems> salesItems = salesItemsRep.findAll();
        SalesItems salesItem = null;
        for(SalesItems si: salesItems){
            if(si.getSalesItemsId() == salesItemsId){
                salesItem = si;
            }
        }
        return salesItem;
    }

    /**
     * Create a new salesItems with the provided SalesItems object.
     *
     * @param salesItems The SalesItems object representing the salesItems to be created.
     * @return The newly created SalesItems object with a generated ID.
     */
    public SalesItems createSalesItems(SalesItems salesItems){
        return salesItemsRep.save(salesItems);
    }

    /**
     * Update a new salesItems with the provided SalesItems object.
     *
     * @param salesItems The SalesItems object representing the salesItems to be updated.
     * @return The updated SalesItems object.
     */
    public SalesItems updateSalesItems(SalesItems salesItems){
        return salesItemsRep.save(salesItems);
    }


    /**
     * Delete a salesItems with the provided salesItemsId.
     *
     * @param salesItemsId The ID of the salesItems to delete.
     * @return The deleted salesItemsId.
     */
    public AddResponse deleteSalesItemsById(int salesItemsId){
        salesItemsRep.deleteById(salesItemsId);
        AddResponse res = new AddResponse();
        res.setMsg("SalesItems deleted");
        res.setId(salesItemsId);
        return res;
    }
}