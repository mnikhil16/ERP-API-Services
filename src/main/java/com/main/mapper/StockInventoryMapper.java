package com.main.mapper;

import com.main.beans.StockInventory;
import com.main.dto.StockInventoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockInventoryMapper {
    StockInventoryMapper instance = Mappers.getMapper(StockInventoryMapper.class);

    StockInventoryDTO modelToDto(StockInventory stockInventory);
    StockInventory dtoToModel(StockInventoryDTO stockInventoryDTO);

    List<StockInventoryDTO> modelToDtoList(List<StockInventory> stockInventoryList);

    List<StockInventory> dtoToModelList(List<StockInventoryDTO> stockInventoryDTOList);
}
