package com.main.service;

import com.main.entity.StockInventory;
import com.main.dto.StockInventoryDTO;
import com.main.mapper.StockInventoryMapper;
import com.main.repository.StockInventoryRepository;
import com.main.controller.AddResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(StockInventoryService.class);

    /**
     * Get inventory information.
     *
     * @return All the StockInventory objects.
     */
    public List<StockInventoryDTO> getStockInventories(){
        logger.trace("Get all Stock Inventories service is invoked.");
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
        logger.trace("Get Stock Inventory by Id service is invoked.");
        StockInventory stockInventoryEntity = stockInventoryRepository.findById(stockInventoryId).get();
        StockInventoryDTO stockInventoryDTO = StockInventoryMapper.instance.modelToDto(stockInventoryEntity);
        return stockInventoryDTO;
    }

    /**
     * Create a new stockInventory with the provided StockInventory object.
     *
     * @param stockInventoryDTO The StockInventoryDTO object representing the stockInventory to be created.
     * @return The newly created StockInventoryDTO object with a generated ID.
     */
    public StockInventoryDTO createStockInventory(StockInventoryDTO stockInventoryDTO){
        logger.trace("Create Stock Inventory service is invoked.");
        StockInventory stockInventoryEntity = StockInventoryMapper.instance.dtoToModel(stockInventoryDTO);
        stockInventoryRepository.save(stockInventoryEntity);
        StockInventoryDTO createdStockInventoryDTO = StockInventoryMapper.instance.modelToDto(stockInventoryEntity);
        return createdStockInventoryDTO;
    }

    /**
     * Update stock inventory information with the provided StockInventory object.
     *
     * @param stockInventoryDTO The StockInventoryDTO object representing the stockInventory to be updated.
     * @return The updated StockInventoryDTO object.
     */
    public StockInventoryDTO updateStockInventory(StockInventoryDTO stockInventoryDTO){
        logger.trace("Update Stock Inventory service is invoked.");
        StockInventory stockInventoryEntity = StockInventoryMapper.instance.dtoToModel(stockInventoryDTO);
        stockInventoryRepository.save(stockInventoryEntity);
        StockInventoryDTO updatedStockInventoryDTO = StockInventoryMapper.instance.modelToDto(stockInventoryEntity);
        return updatedStockInventoryDTO;
    }

    /**
     * Delete a stock inventory with the provided stockInventoryId.
     *
     * @param stockInventoryId The ID of the stock inventory to delete.
     * @return An AddResponse indicating the deletion result.
     */
    public AddResponse deleteStockInventoryById(int stockInventoryId){
        logger.trace("Delete Stock Inventory service is invoked.");
        stockInventoryRepository.deleteById(stockInventoryId);
        AddResponse response = new AddResponse();
        response.setMsg("StockInventory deleted");
        response.setId(stockInventoryId);
        return response;
    }
}