package com.main.mapper;

import com.main.beans.Store;
import com.main.dto.StoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    StoreMapper instance = Mappers.getMapper(StoreMapper.class);

    StoreDTO modelToDto(Store store);
    Store dtoToModel(StoreDTO storeDTO);

    List<StoreDTO> modelToDtoList(List<Store> storeList);

    List<Store> dtoToModelList(List<StoreDTO> storeDTOList);
}
