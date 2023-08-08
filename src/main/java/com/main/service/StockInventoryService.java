package com.main.service;

import com.main.beans.StockInventory;
import com.main.dto.StockInventoryDTO;
import com.main.mapper.StockInventoryMapper;
import com.main.repository.StockInventoryRepository;
import com.main.controller.AddResponse;
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
    StockInventoryRepository stockInventoryRepository;

    /**
     * Get inventory information.
     *
     * @return All the StockInventory objects.
     */
    public List<StockInventoryDTO> getStockInventories(){
        List<StockInventory> stockInventoryList = stockInventoryRepository.findAll();
        List<StockInventoryDTO> stockInventoryDTOList =  StockInventoryMapper.instance.modelToDtoList(stockInventoryList);
        return stockInventoryDTOList;
    }


    /**
     * Get stock inventory information by the specified stock inventory ID.
     *
     * @param stockInventoryId The ID of the stock inventory to retrieve.
     * @return The StockInventory object corresponding to the given ID.
     */
    public StockInventoryDTO getStockInventoryById(int stockInventoryId){
        StockInventory stockInventoryEntity = stockInventoryRepository.findById(stockInventoryId).get();
        StockInventoryDTO stockInventoryDTO = StockInventoryMapper.instance.modelToDto(stockInventoryEntity);
        return stockInventoryDTO;
    }

    /**
     * Create a new stockInventory with the provided stockInventory object.
     *
     * @param stockInventoryDTO The StockInventory object representing the stockInventory to be created.
     * @return The newly created stockInventory object with a generated ID.
     */
    public StockInventoryDTO createStockInventory(StockInventoryDTO stockInventoryDTO){
        StockInventory stockInventoryEntity = StockInventoryMapper.instance.dtoToModel(stockInventoryDTO);
        stockInventoryRepository.save(stockInventoryEntity);
        StockInventoryDTO stockInventoryDTO1 = StockInventoryMapper.instance.modelToDto(stockInventoryEntity);
        return stockInventoryDTO1;
    }

    /**
     * Update a new stockInventory with the provided stockInventory object.
     *
     * @param stockInventoryDTO The StockInventory object representing the stockInventory to be updated.
     * @return The updated StockInventory object.
     */
    public StockInventoryDTO updateStockInventory(StockInventoryDTO stockInventoryDTO){
        StockInventory stockInventoryEntity = StockInventoryMapper.instance.dtoToModel(stockInventoryDTO);
        stockInventoryRepository.save(stockInventoryEntity);
        StockInventoryDTO stockInventoryDTO1 = StockInventoryMapper.instance.modelToDto(stockInventoryEntity);
        return stockInventoryDTO1;
    }


    /**
     * Delete a stockInventory with the provided Id.
     *
     * @param stockInventoryId The ID of the stock inventory to delete.
     * @return The deleted Id.
     */
    public AddResponse deleteStockInventoryById(int stockInventoryId){
        stockInventoryRepository.deleteById(stockInventoryId);
        AddResponse res = new AddResponse();
        res.setMsg("StockInventory deleted");
        res.setId(stockInventoryId);
        return res;
    }
}
