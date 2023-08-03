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
 * This service communicates with the StockItemRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The StockItemService should be autowired into other components that require StockItem-related functionalities.
 */

@Service
public class StockItemService {

    @Autowired
    StockItemRepository stockItemRepository;

    /**
     * Get stock item information by the specified stock item ID.
     *
     * @return All the Customer objects.
     */
    public List<StockItem> getStockItems(){
        return stockItemRepository.findAll();
    }


    /**
     * Get stock item information by the specified stock item ID.
     *
     * @param stockItemId The ID of the item to retrieve.
     * @return The StockItem object corresponding to the given ID.
     */
    public StockItem getStockItemById(int stockItemId){
        List<StockItem> stockItems = stockItemRepository.findAll();
        StockItem stockItem = null;
        for(StockItem i: stockItems){
            if(i.getStockItemId() == stockItemId){
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
    public StockItem createStockItem(StockItem stockItem){
        return stockItemRepository.save(stockItem);
    }

    /**
     * Update a new stockItem with the provided stockItem object.
     *
     * @param stockItem The StockItem object representing the stockItem to be updated.
     * @return The updated StockItem object.
     */
    public StockItem updateStockItem(StockItem stockItem){
        return stockItemRepository.save(stockItem);
    }


    /**
     * Delete an item with the provided Id.
     *
     * @param stockItemId The ID of the item to delete.
     * @return The deleted Id.
     */
    public AddResponse deleteStockItemById(int stockItemId){
        stockItemRepository.deleteById(stockItemId);
        AddResponse res = new AddResponse();
        res.setMsg("StockItem deleted");
        res.setId(stockItemId);
        return res;
    }
}