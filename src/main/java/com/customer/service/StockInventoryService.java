package com.customer.service;

import com.customer.beans.StockInventory;
import com.customer.repository.StockInventoryRepository;
import com.customer.controller.AddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * This class represents a service that handles StockInventory-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete StockInventory information in the database.
 * This service communicates with the StockInventoryRepository to perform CRUD operations on Customer_db entities.
 * Usage:
 * The StockInventoryService should be autowired into other components that require StockInventory-related functionalities.
 */

@Service
public class StockInventoryService {

    @Autowired
    StockInventoryRepository inventoryRep;

    /**
     * Get inventory information.
     *
     * @return All the StockInventory objects.
     */
    public List<StockInventory> getInventories(){
        return inventoryRep.findAll();
    }


    /**
     * Get inventory information by the specified inventory ID.
     *
     * @param Id The ID of the inventory to retrieve.
     * @return The StockInventory object corresponding to the given ID.
     */
    public StockInventory getInventoryById(int inventoryId){
        List<StockInventory> stockInventories = inventoryRep.findAll();
        StockInventory stockInventory = null;
        for(StockInventory i: stockInventories){
            if(i.getInventoryId() == inventoryId){
                stockInventory = i;
            }
        }
        return stockInventory;
    }

    /**
     * Create a new stockInventory with the provided stockInventory object.
     *
     * @param stockInventory The StockInventory object representing the stockInventory to be created.
     * @return The newly created stockInventory object with a generated ID.
     */
    public StockInventory createInventory(StockInventory stockInventory){
        return inventoryRep.save(stockInventory);
    }

    /**
     * Update a new stockInventory with the provided stockInventory object.
     *
     * @param stockInventory The StockInventory object representing the stockInventory to be updated.
     * @return The updated StockInventory object.
     */
    public StockInventory updateInventory(StockInventory stockInventory){
        return inventoryRep.save(stockInventory);
    }


    /**
     * Delete an inventory with the provided Id.
     *
     * @param inventoryId The ID of the inventory to delete.
     * @return The deleted Id.
     */
    public AddResponse deleteInventory(int inventoryId){
        inventoryRep.deleteById(inventoryId);
        AddResponse res = new AddResponse();
        res.setMsg("StockInventory deleted");
        res.setId(inventoryId);
        return res;
    }
}
