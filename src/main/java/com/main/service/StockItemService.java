package com.main.service;

import com.main.entity.StockItem;
import com.main.controller.AddResponse;
import com.main.dto.StockItemDTO;
import com.main.mapper.StockItemMapper;
import com.main.repository.StockItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(StockItemService.class);

    /**
     * Get stock item information.
     *
     * @return All the StockItem objects.
     */
    public List<StockItemDTO> getStockItems(){
        logger.trace("Get all Stock Items service is invoked.");
        List<StockItem> stockItemList = stockItemRepository.findAll();
        List<StockItemDTO> stockItemDTOList = StockItemMapper.instance.modelToDtoList(stockItemList);
        return stockItemDTOList;
    }

    /**
     * Get stock item information by the specified stock item ID.
     *
     * @param stockItemId The ID of the item to retrieve.
     * @return The StockItem object corresponding to the given ID.
     */
    public StockItemDTO getStockItemById(int stockItemId){
        logger.trace("Get Stock Item by Id service is invoked.");
        StockItem stockItemEntity = stockItemRepository.findById(stockItemId).get();
        StockItemDTO stockItemDTO = StockItemMapper.instance.modelToDto(stockItemEntity);
        return stockItemDTO;
    }

    /**
     * Create a new stockItem with the provided StockItem object.
     *
     * @param stockItemDTO The StockItemDTO object representing the stockItem to be created.
     * @return The newly created StockItemDTO object with a generated ID.
     */
    public StockItemDTO createStockItem(StockItemDTO stockItemDTO){
        logger.trace("Create Stock Item service is invoked.");
        StockItem stockItemEntity = StockItemMapper.instance.dtoToModel(stockItemDTO);
        stockItemRepository.save(stockItemEntity);
        StockItemDTO createdStockItemDTO = StockItemMapper.instance.modelToDto(stockItemEntity);
        return createdStockItemDTO;
    }

    /**
     * Update stock item information with the provided StockItem object.
     *
     * @param stockItemDTO The StockItemDTO object representing the stockItem to be updated.
     * @return The updated StockItemDTO object.
     */
    public StockItemDTO updateStockItem(StockItemDTO stockItemDTO){
        logger.trace("Update Stock Item service is invoked.");
        StockItem stockItemEntity = StockItemMapper.instance.dtoToModel(stockItemDTO);
        stockItemRepository.save(stockItemEntity);
        StockItemDTO updatedStockItemDTO = StockItemMapper.instance.modelToDto(stockItemEntity);
        return updatedStockItemDTO;
    }

    /**
     * Delete a stock item with the provided stockItemId.
     *
     * @param stockItemId The ID of the item to delete.
     * @return An AddResponse indicating the deletion result.
     */
    public AddResponse deleteStockItemById(int stockItemId){
        logger.trace("Delete Stock Item service is invoked.");
        stockItemRepository.deleteById(stockItemId);
        AddResponse response = new AddResponse();
        response.setMsg("StockItem deleted");
        response.setId(stockItemId);
        return response;
    }
}