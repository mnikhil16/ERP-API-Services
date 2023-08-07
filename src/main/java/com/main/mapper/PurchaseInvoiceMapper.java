package com.main.mapper;

import com.main.beans.Company;
import com.main.beans.PurchaseInvoice;
import com.main.dto.CompanyDTO;
import com.main.dto.PurchaseInvoiceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseInvoiceMapper {
    PurchaseInvoiceMapper instance = Mappers.getMapper(PurchaseInvoiceMapper.class);

    PurchaseInvoiceDTO modelToDto(PurchaseInvoice purchaseInvoice);
    PurchaseInvoice dtoToModel(PurchaseInvoiceDTO PurchaseInvoiceDTO);

    List<PurchaseInvoiceDTO> modelToDtoList(List<PurchaseInvoice> purchaseInvoiceList);

    List<PurchaseInvoice> dtoToModelList(List<PurchaseInvoiceDTO> PurchaseInvoiceDTOList);
}
