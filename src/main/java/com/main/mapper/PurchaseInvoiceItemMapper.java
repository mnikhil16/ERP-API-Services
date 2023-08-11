package com.main.mapper;

import com.main.entity.*;
import com.main.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper interface for converting between PurchaseInvoiceItem entities and PurchaseInvoiceItemDTOs.
 * Uses MapStruct and Spring's component model for mapping.
 */
@Mapper(componentModel = "spring")
public interface PurchaseInvoiceItemMapper {

    // Singleton instance of the PurchaseInvoiceItemMapper interface
    PurchaseInvoiceItemMapper instance = Mappers.getMapper(PurchaseInvoiceItemMapper.class);

    /**
     * Converts a PurchaseInvoiceItem entity to a PurchaseInvoiceItemDTO.
     *
     * @param purchaseInvoiceItem The PurchaseInvoiceItem entity to be converted.
     * @return The corresponding PurchaseInvoiceItemDTO.
     */
    @Mapping(source = "store",target = "storeDTO")
    @Mapping(source = "stockItem",target = "stockItemDTO")
    @Mapping(source = "purchaseInvoice",target = "purchaseInvoiceDTO")
    PurchaseInvoiceItemDTO modelToDto(PurchaseInvoiceItem purchaseInvoiceItem);

    /**
     * Converts a Store entity to a StoreDTO.
     *
     * @param store The Store entity to be converted.
     * @return The corresponding StoreDTO.
     */
    StoreDTO modelToDto(Store store);

    /**
     * Converts a StockItem entity to a StockItemDTO.
     *
     * @param stockItem The StockItem entity to be converted.
     * @return The corresponding StockItemDTO.
     */
    StockItemDTO modelToDto(StockItem stockItem);

    /**
     * Converts a PurchaseInvoice entity to a PurchaseInvoiceDTO.
     *
     * @param purchaseInvoice The PurchaseInvoice entity to be converted.
     * @return The corresponding PurchaseInvoiceDTO.
     */
    PurchaseInvoiceDTO modelToDto(PurchaseInvoice purchaseInvoice);

    /**
     * Converts a PurchaseInvoiceItemDTO to a PurchaseInvoiceItem entity.
     *
     * @param purchaseInvoiceItemDTO The PurchaseInvoiceItemDTO to be converted.
     * @return The corresponding PurchaseInvoiceItem entity.
     */
    @Mapping(source = "storeDTO",target = "store")
    @Mapping(source = "stockItemDTO",target = "stockItem")
    @Mapping(source = "purchaseInvoiceDTO",target = "purchaseInvoice")
    PurchaseInvoiceItem dtoToModel(PurchaseInvoiceItemDTO purchaseInvoiceItemDTO);

    /**
     * Converts a StoreDTO to a Store entity.
     *
     * @param storeDTO The StoreDTO to be converted.
     * @return The corresponding Store entity.
     */
    Store modelToDto(StoreDTO storeDTO);

    /**
     * Converts a StockItemDTO to a StockItem entity.
     *
     * @param stockItemDTO The StockItemDTO to be converted.
     * @return The corresponding StockItem entity.
     */
    StockItem modelToDto(StockItemDTO stockItemDTO);

    /**
     * Converts a PurchaseInvoiceDTO to a PurchaseInvoice entity.
     *
     * @param purchaseInvoiceDTO The PurchaseInvoiceDTO to be converted.
     * @return The corresponding PurchaseInvoice entity.
     */
    PurchaseInvoice modelToDto(PurchaseInvoiceDTO purchaseInvoiceDTO);

    /**
     * Converts a list of PurchaseInvoiceItem entities to a list of PurchaseInvoiceItemDTOs.
     *
     * @param purchaseInvoiceItemList The list of PurchaseInvoiceItem entities to be converted.
     * @return The corresponding list of PurchaseInvoiceItemDTOs.
     */
    List<PurchaseInvoiceItemDTO> modelToDtoList(List<PurchaseInvoiceItem> purchaseInvoiceItemList);

    /**
     * Converts a list of PurchaseInvoiceItemDTOs to a list of PurchaseInvoiceItem entities.
     *
     * @param purchaseInvoiceItemDTOList The list of PurchaseInvoiceItemDTOs to be converted.
     * @return The corresponding list of PurchaseInvoiceItem entities.
     */
    List<PurchaseInvoiceItem> dtoToModelList(List<PurchaseInvoiceItemDTO> purchaseInvoiceItemDTOList);
}