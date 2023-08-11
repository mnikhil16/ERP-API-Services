package com.main.mapper;

import com.main.entity.Company;
import com.main.entity.StockItem;
import com.main.dto.CompanyDTO;
import com.main.dto.StockItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper interface for converting between StockItem entities and StockItemDTOs.
 * Uses MapStruct and Spring's component model for mapping.
 */
@Mapper(componentModel = "spring")
public interface StockItemMapper {

    // Singleton instance of the StockItemMapper interface
    StockItemMapper instance = Mappers.getMapper(StockItemMapper.class);

    /**
     * Converts a StockItem entity to a StockItemDTO.
     *
     * @param stockItem The StockItem entity to be converted.
     * @return The corresponding StockItemDTO.
     */
    @Mapping(source = "company", target = "companyDTO")
    StockItemDTO modelToDto(StockItem stockItem);

    /**
     * Converts a Company entity to a CompanyDTO.
     *
     * @param company The Company entity to be converted.
     * @return The corresponding CompanyDTO.
     */
    CompanyDTO modelToDto(Company company);

    /**
     * Converts a StockItemDTO to a StockItem entity.
     *
     * @param stockItemDTO The StockItemDTO to be converted.
     * @return The corresponding StockItem entity.
     */
    @Mapping(source = "companyDTO", target = "company")
    StockItem dtoToModel(StockItemDTO stockItemDTO);

    /**
     * Converts a CompanyDTO to a Company entity.
     *
     * @param companyDTO The CompanyDTO to be converted.
     * @return The corresponding Company entity.
     */
    Company dtoToModel(CompanyDTO companyDTO);

    /**
     * Converts a list of StockItem entities to a list of StockItemDTOs.
     *
     * @param stockItemList The list of StockItem entities to be converted.
     * @return The corresponding list of StockItemDTOs.
     */
    List<StockItemDTO> modelToDtoList(List<StockItem> stockItemList);

    /**
     * Converts a list of StockItemDTOs to a list of StockItem entities.
     *
     * @param stockItemDTOList The list of StockItemDTOs to be converted.
     * @return The corresponding list of StockItem entities.
     */
    List<StockItem> dtoToModelList(List<StockItemDTO> stockItemDTOList);
}

