package com.main.mapper;

import com.main.beans.StockItem;
import com.main.dto.StockItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockItemMapper {
    StockItemMapper instance = Mappers.getMapper(StockItemMapper.class);

    StockItemDTO modelToDto(StockItem stockItem);
    StockItem dtoToModel(StockItemDTO stockItemDTO);

    List<StockItemDTO> modelToDtoList(List<StockItem> StockItemList);

    List<StockItem> dtoToModelList(List<StockItemDTO> StockItemDTOList);
}
