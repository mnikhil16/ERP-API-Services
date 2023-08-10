package com.main.mapper;

import com.main.beans.SalesInvoice;
import com.main.beans.SalesItem;
import com.main.beans.StockItem;
import com.main.dto.SalesInvoiceDTO;
import com.main.dto.SalesItemDTO;
import com.main.dto.StockItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalesItemMapper {
    SalesItemMapper instance = Mappers.getMapper(SalesItemMapper.class);

    @Mapping(source = "salesInvoice",target = "salesInvoiceDTO")
    @Mapping(source = "stockItem",target = "stockItemDTO")
    SalesItemDTO modelToDto(SalesItem salesItem);

    SalesInvoiceDTO modelToDto(SalesInvoice salesInvoice);
    StockItemDTO modelToDto(StockItem stockItem);

    @Mapping(source = "salesInvoiceDTO",target = "salesInvoice")
    @Mapping(source = "stockItemDTO",target = "stockItem")
    SalesItem dtoToModel(SalesItemDTO salesItemDTO);

    SalesInvoiceDTO modelToDto(SalesInvoiceDTO salesInvoiceDTO);
    StockItem modelToDto(StockItemDTO stockItemDTO);

    List<SalesItemDTO> modelToDtoList(List<SalesItem> salesItemList);

    List<SalesItem> dtoToModelList(List<SalesItemDTO> salesItemDTOList);
}
