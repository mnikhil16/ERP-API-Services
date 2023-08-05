package com.main.service;

import com.main.beans.SalesItem;
import com.main.controller.AddResponse;
import com.main.repository.SalesItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles SalesItem-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete SalesItem information in the database.
 * This service communicates with the SalesItemsRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The SalesItemService should be autowired into other components that require SalesItem-related functionalities.
 */

@Service
public class SalesItemService {

    @Autowired
    SalesItemRepository salesItemRepository;

    /**
     * Get all the salesItems information.
     *
     * @return All the SalesItem objects.
     */
    public List<SalesItem> getSalesItems(){
        return salesItemRepository.findAll();
    }


    /**
     * Get salesItem information by the specified salesItem ID.
     *
     * @param salesItemId The ID of the salesItem to retrieve.
     * @return The SalesItem object corresponding to the given ID.
     */
    public SalesItem getSalesItemById(int salesItemId){
        List<SalesItem> salesItems = salesItemRepository.findAll();
        SalesItem salesItem = null;
        for(SalesItem si: salesItems){
            if(si.getSalesItemId() == salesItemId){
                salesItem = si;
            }
        }
        return salesItem;
    }

    /**
     * Create a new salesItem with the provided SalesItem object.
     *
     * @param salesItem The SalesItem object representing the salesItem to be created.
     * @return The newly created SalesItem object with a generated ID.
     */
    public SalesItem createSalesItem(SalesItem salesItem){
        return salesItemRepository.save(salesItem);
    }

    /**
     * Update a new salesItem with the provided SalesItem object.
     *
     * @param salesItem The SalesItem object representing the salesItem to be updated.
     * @return The updated SalesItem object.
     */
    public SalesItem updateSalesItem(SalesItem salesItem){
        return salesItemRepository.save(salesItem);
    }


    /**
     * Delete a salesItem with the provided salesItemId.
     *
     * @param salesItemId The ID of the salesItem to delete.
     * @return The deleted salesItemId.
     */
    public AddResponse deleteSalesItemById(int salesItemId){
        salesItemRepository.deleteById(salesItemId);
        AddResponse res = new AddResponse();
        res.setMsg("SalesItem deleted");
        res.setId(salesItemId);
        return res;
    }
}