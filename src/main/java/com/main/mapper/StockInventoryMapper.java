package com.main.mapper;

import com.main.entity.StockInventory;
import com.main.entity.StockItem;
import com.main.entity.Store;
import com.main.entity.Supplier;
import com.main.dto.StockInventoryDTO;
import com.main.dto.StockItemDTO;
import com.main.dto.StoreDTO;
import com.main.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper interface for converting between StockInventory entities and StockInventoryDTOs.
 * Uses MapStruct and Spring's component model for mapping.
 */
@Mapper(componentModel = "spring")
public interface StockInventoryMapper {

    // Singleton instance of the StockInventoryMapper interface
    StockInventoryMapper instance = Mappers.getMapper(StockInventoryMapper.class);

    /**
     * Converts a StockInventory entity to a StockInventoryDTO.
     *
     * @param stockInventory The StockInventory entity to be converted.
     * @return The corresponding StockInventoryDTO.
     */
    @Mapping(source = "stockItem", target = "stockItemDTO")
    @Mapping(source = "store", target = "storeDTO")
    @Mapping(source = "supplier", target = "supplierDTO")
    StockInventoryDTO modelToDto(StockInventory stockInventory);

    /**
     * Converts a StockItem entity to a StockItemDTO.
     *
     * @param stockItem The StockItem entity to be converted.
     * @return The corresponding StockItemDTO.
     */
    StockItemDTO modelToDto(StockItem stockItem);

    /**
     * Converts a Store entity to a StoreDTO.
     *
     * @param store The Store entity to be converted.
     * @return The corresponding StoreDTO.
     */
    StoreDTO modelToDto(Store store);

    /**
     * Converts a Supplier entity to a SupplierDTO.
     *
     * @param supplier The Supplier entity to be converted.
     * @return The corresponding SupplierDTO.
     */
    SupplierDTO modelToDto(Supplier supplier);

    /**
     * Converts a StockInventoryDTO to a StockInventory entity.
     *
     * @param stockInventoryDTO The StockInventoryDTO to be converted.
     * @return The corresponding StockInventory entity.
     */
    @Mapping(source = "stockItemDTO", target = "stockItem")
    @Mapping(source = "storeDTO", target = "store")
    @Mapping(source = "supplierDTO", target = "supplier")
    StockInventory dtoToModel(StockInventoryDTO stockInventoryDTO);

    /**
     * Converts a StockItemDTO to a StockItem entity.
     *
     * @param stockItemDTO The StockItemDTO to be converted.
     * @return The corresponding StockItem entity.
     */
    StockItem dtoToModel(StockItemDTO stockItemDTO);

    /**
     * Converts a StoreDTO to a Store entity.
     *
     * @param storeDto The StoreDTO to be converted.
     * @return The corresponding Store entity.
     */
    Store dtoToModel(StoreDTO storeDto);

    /**
     * Converts a SupplierDTO to a Supplier entity.
     *
     * @param supplierDTO The SupplierDTO to be converted.
     * @return The corresponding Supplier entity.
     */
    Supplier dtoToModel(SupplierDTO supplierDTO);

    /**
     * Converts a list of StockInventory entities to a list of StockInventoryDTOs.
     *
     * @param stockInventoryList The list of StockInventory entities to be converted.
     * @return The corresponding list of StockInventoryDTOs.
     */
    List<StockInventoryDTO> modelToDtoList(List<StockInventory> stockInventoryList);

    /**
     * Converts a list of StockInventoryDTOs to a list of StockInventory entities.
     *
     * @param stockInventoryDTOList The list of StockInventoryDTOs to be converted.
     * @return The corresponding list of StockInventory entities.
     */
    List<StockInventory> dtoToModelList(List<StockInventoryDTO> stockInventoryDTOList);
}
