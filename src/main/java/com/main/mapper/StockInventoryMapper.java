package com.main.mapper;

import com.main.beans.StockInventory;
import com.main.beans.StockItem;
import com.main.beans.Store;
import com.main.beans.Supplier;
import com.main.dto.StockInventoryDTO;
import com.main.dto.StockItemDTO;
import com.main.dto.StoreDTO;
import com.main.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockInventoryMapper {
    StockInventoryMapper instance = Mappers.getMapper(StockInventoryMapper.class);

    @Mapping(source = "stockItem", target = "stockItemDTO")
    @Mapping(source = "store", target = "storeDTO")
    @Mapping(source = "supplier", target = "supplierDTO")
    StockInventoryDTO modelToDto(StockInventory stockInventory);

    StockItemDTO modelToDto(StockItem stockItem);
    StoreDTO modelToDto(Store store);
    SupplierDTO modelToDto(Supplier supplier);

    @Mapping(source = "stockItemDTO", target = "stockItem")
    @Mapping(source = "storeDTO", target = "store")
    @Mapping(source = "supplierDTO", target = "supplier")
    StockInventory dtoToModel(StockInventoryDTO stockInventoryDTO);

    StockItem dtoToModel(StockItemDTO stockItemDTO);
    Store dtoToModel(StoreDTO storeDto);
    Supplier dtoToModel(SupplierDTO supplierDTO);

    List<StockInventoryDTO> modelToDtoList(List<StockInventory> stockInventoryList);

    List<StockInventory> dtoToModelList(List<StockInventoryDTO> stockInventoryDTOList);
}
