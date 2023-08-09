package com.main.mapper;

import com.main.beans.Store;
import com.main.dto.StoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    StoreMapper instance = Mappers.getMapper(StoreMapper.class);

    @Mapping(source = "company", target = "companyDTO")
    @Mapping(source = "address", target = "addressDTO")
    StoreDTO modelToDto(Store store);

    @Mapping(source = "companyDTO", target = "company")
    @Mapping(source = "addressDTO", target = "address")
    Store dtoToModel(StoreDTO storeDTO);

    List<StoreDTO> modelToDtoList(List<Store> storeList);

    List<Store> dtoToModelList(List<StoreDTO> storeDTOList);
}
