package com.main.mapper;

import com.main.beans.*;
import com.main.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseInvoiceItemMapper {
    PurchaseInvoiceItemMapper instance = Mappers.getMapper(PurchaseInvoiceItemMapper.class);


    @Mapping(source = "store",target = "storeDTO")
    @Mapping(source = "stockItem",target = "stockItemDTO")
    @Mapping(source = "purchaseInvoice",target = "purchaseInvoiceDTO")
    PurchaseInvoiceItemDTO modelToDto(PurchaseInvoiceItem purchaseInvoiceItem);

    StoreDTO modelToDto(Store store);
    StockItemDTO modelToDto(StockItem stockItem);
    PurchaseInvoiceDTO modelToDto(PurchaseInvoice purchaseInvoice);

    @Mapping(source = "storeDTO",target = "store")
    @Mapping(source = "stockItemDTO",target = "stockItem")
    @Mapping(source = "purchaseInvoiceDTO",target = "purchaseInvoice")
    PurchaseInvoiceItem dtoToModel(PurchaseInvoiceItemDTO purchaseInvoiceItemDTO);

    Store modelToDto(StoreDTO storeDTO);
    StockItem modelToDto(StockItemDTO stockItemDTO);
    PurchaseInvoice modelToDto(PurchaseInvoiceDTO purchaseInvoiceDTO);

    List<PurchaseInvoiceItemDTO> modelToDtoList(List<PurchaseInvoiceItem> purchaseInvoiceItemList);

    List<PurchaseInvoiceItem> dtoToModelList(List<PurchaseInvoiceItemDTO> purchaseInvoiceItemDTOList);
}
