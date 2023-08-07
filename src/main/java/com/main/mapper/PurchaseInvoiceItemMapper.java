package com.main.mapper;

import com.main.beans.PurchaseInvoiceItem;
import com.main.dto.PurchaseInvoiceItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseInvoiceItemMapper {
    PurchaseInvoiceItemMapper instance = Mappers.getMapper(PurchaseInvoiceItemMapper.class);

    PurchaseInvoiceItemDTO modelToDto(PurchaseInvoiceItem purchaseInvoiceItem);
    PurchaseInvoiceItem dtoToModel(PurchaseInvoiceItemDTO purchaseInvoiceItemDTO);

    List<PurchaseInvoiceItemDTO> modelToDtoList(List<PurchaseInvoiceItem> purchaseInvoiceItemList);

    List<PurchaseInvoiceItem> dtoToModelList(List<PurchaseInvoiceItemDTO> purchaseInvoiceItemDTOList);
}
