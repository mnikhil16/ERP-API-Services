package com.customer.service;

import com.customer.beans.StockItem;
import com.customer.controller.AddResponse;
import com.customer.repository.StockItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * This class represents a service that handles StockItem-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete StockItem information in the database.
 * This service communicates with the StockItemRepository to perform CRUD operations on Customer_db entities.
 *
 * Usage:
 * The StockItemService should be autowired into other components that require StockItem-related functionalities.
 */

@Service
public class StockItemService {

    @Autowired
    StockItemRepository itemRep;

    /**
     * Get item information by the specified item ID.
     *
     * @return All the Customer objects.
     */
    public List<StockItem> getItems(){
        return itemRep.findAll();
    }


    /**
     * Get item information by the specified item ID.
     *
     * @param Id The ID of the item to retrieve.
     * @return The StockItem object corresponding to the given ID.
     */
    public StockItem getItemById(int Id){
        List<StockItem> stockItems = itemRep.findAll();
        StockItem stockItem = null;
        for(StockItem i: stockItems){
            if(i.getItemId() == Id){
                stockItem = i;
            }
        }
        return stockItem;
    }

    /**
     * Create a new stockItem with the provided stockItem object.
     *
     * @param stockItem The StockItem object representing the stockItem to be created.
     * @return The newly created stockItem object with a generated ID.
     */
    public StockItem createItem(StockItem stockItem){
        return itemRep.save(stockItem);
    }

    /**
     * Update a new stockItem with the provided stockItem object.
     *
     * @param stockItem The StockItem object representing the stockItem to be updated.
     * @return The updated StockItem object.
     */
    public StockItem updateItem(StockItem stockItem){
        return itemRep.save(stockItem);
    }


    /**
     * Delete an item with the provided Id.
     *
     * @param Id The ID of the item to delete.
     * @return The deleted Id.
     */
    public AddResponse deleteItem(int Id){
        itemRep.deleteById(Id);
        AddResponse res = new AddResponse();
        res.setMsg("StockItem deleted");
        res.setId(Id);
        return res;
    }
}