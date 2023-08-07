package com.main.mapper;

import com.main.beans.SalesInvoice;
import com.main.dto.SalesInvoiceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalesInvoiceMapper {
    SalesInvoiceMapper instance = Mappers.getMapper(SalesInvoiceMapper.class);

    SalesInvoiceDTO modelToDto(SalesInvoice salesInvoice);
    SalesInvoice dtoToModel(SalesInvoiceDTO salesInvoiceDTO);

    List<SalesInvoiceDTO> modelToDtoList(List<SalesInvoice> salesInvoiceList);

    List<SalesInvoice> dtoToModelList(List<SalesInvoiceDTO> salesInvoiceDTOList);
}
