package com.main.mapper;

import com.main.entity.SalesInvoice;
import com.main.entity.SalesItem;
import com.main.entity.StockItem;
import com.main.dto.SalesInvoiceDTO;
import com.main.dto.SalesItemDTO;
import com.main.dto.StockItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper interface for converting between SalesItem entities and SalesItemDTOs.
 * Uses MapStruct and Spring's component model for mapping.
 */
@Mapper(componentModel = "spring")
public interface SalesItemMapper {

    // Singleton instance of the SalesItemMapper interface
    SalesItemMapper instance = Mappers.getMapper(SalesItemMapper.class);

    /**
     * Converts a SalesItem entity to a SalesItemDTO.
     *
     * @param salesItem The SalesItem entity to be converted.
     * @return The corresponding SalesItemDTO.
     */
    @Mapping(source = "salesInvoice",target = "salesInvoiceDTO")
    @Mapping(source = "stockItem",target = "stockItemDTO")
    SalesItemDTO modelToDto(SalesItem salesItem);

    /**
     * Converts a SalesInvoice entity to a SalesInvoiceDTO.
     *
     * @param salesInvoice The SalesInvoice entity to be converted.
     * @return The corresponding SalesInvoiceDTO.
     */
    SalesInvoiceDTO modelToDto(SalesInvoice salesInvoice);

    /**
     * Converts a StockItem entity to a StockItemDTO.
     *
     * @param stockItem The StockItem entity to be converted.
     * @return The corresponding StockItemDTO.
     */
    StockItemDTO modelToDto(StockItem stockItem);

    /**
     * Converts a SalesItemDTO to a SalesItem entity.
     *
     * @param salesItemDTO The SalesItemDTO to be converted.
     * @return The corresponding SalesItem entity.
     */
    @Mapping(source = "salesInvoiceDTO",target = "salesInvoice")
    @Mapping(source = "stockItemDTO",target = "stockItem")
    SalesItem dtoToModel(SalesItemDTO salesItemDTO);

    /**
     * Converts a SalesInvoiceDTO to a SalesInvoice entity.
     *
     * @param salesInvoiceDTO The SalesInvoiceDTO to be converted.
     * @return The corresponding SalesInvoice entity.
     */
    SalesInvoiceDTO modelToDto(SalesInvoiceDTO salesInvoiceDTO);

    /**
     * Converts a StockItemDTO to a StockItem entity.
     *
     * @param stockItemDTO The StockItemDTO to be converted.
     * @return The corresponding StockItem entity.
     */
    StockItem modelToDto(StockItemDTO stockItemDTO);

    /**
     * Converts a list of SalesItem entities to a list of SalesItemDTOs.
     *
     * @param salesItemList The list of SalesItem entities to be converted.
     * @return The corresponding list of SalesItemDTOs.
     */
    List<SalesItemDTO> modelToDtoList(List<SalesItem> salesItemList);

    /**
     * Converts a list of SalesItemDTOs to a list of SalesItem entities.
     *
     * @param salesItemDTOList The list of SalesItemDTOs to be converted.
     * @return The corresponding list of SalesItem entities.
     */
    List<SalesItem> dtoToModelList(List<SalesItemDTO> salesItemDTOList);
}