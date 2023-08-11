package com.main.mapper;

import com.main.entity.Store;
import com.main.dto.StoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper interface for converting between Store entities and StoreDTOs.
 * Uses MapStruct and Spring's component model for mapping.
 */
@Mapper(componentModel = "spring")
public interface StoreMapper {

    // Singleton instance of the StoreMapper interface
    StoreMapper instance = Mappers.getMapper(StoreMapper.class);

    /**
     * Converts a Store entity to a StoreDTO.
     *
     * @param store The Store entity to be converted.
     * @return The corresponding StoreDTO.
     */
    @Mapping(source = "company", target = "companyDTO")
    @Mapping(source = "address", target = "addressDTO")
    StoreDTO modelToDto(Store store);

    /**
     * Converts a StoreDTO to a Store entity.
     *
     * @param storeDTO The StoreDTO to be converted.
     * @return The corresponding Store entity.
     */
    @Mapping(source = "companyDTO", target = "company")
    @Mapping(source = "addressDTO", target = "address")
    Store dtoToModel(StoreDTO storeDTO);

    /**
     * Converts a list of Store entities to a list of StoreDTOs.
     *
     * @param storeList The list of Store entities to be converted.
     * @return The corresponding list of StoreDTOs.
     */
    List<StoreDTO> modelToDtoList(List<Store> storeList);

    /**
     * Converts a list of StoreDTOs to a list of Store entities.
     *
     * @param storeDTOList The list of StoreDTOs to be converted.
     * @return The corresponding list of Store entities.
     */
    List<Store> dtoToModelList(List<StoreDTO> storeDTOList);
}

