package com.main.mapper;

import com.main.beans.SalesItem;
import com.main.dto.SalesItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalesItemMapper {
    SalesItemMapper instance = Mappers.getMapper(SalesItemMapper.class);

    SalesItemDTO modelToDto(SalesItem salesItem);
    SalesItem dtoToModel(SalesItemDTO salesItemDTO);

    List<SalesItemDTO> modelToDtoList(List<SalesItem> salesItemList);

    List<SalesItem> dtoToModelList(List<SalesItemDTO> salesItemDTOList);
}
