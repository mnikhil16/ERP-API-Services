package com.main.mapper;

import com.main.beans.Company;
import com.main.beans.PurchaseInvoice;
import com.main.beans.Supplier;
import com.main.dto.CompanyDTO;
import com.main.dto.PurchaseInvoiceDTO;
import com.main.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseInvoiceMapper {
    PurchaseInvoiceMapper instance = Mappers.getMapper(PurchaseInvoiceMapper.class);

    @Mapping(source = "company", target = "companyDTO")
    @Mapping(source = "supplier", target = "supplierDTO")
    PurchaseInvoiceDTO modelToDto(PurchaseInvoice purchaseInvoice);

    CompanyDTO modelToDto(Company company);
    SupplierDTO modelToDto(Supplier supplier);

    @Mapping(source = "companyDTO", target = "company")
    @Mapping(source = "supplierDTO", target = "supplier")
    PurchaseInvoice dtoToModel(PurchaseInvoiceDTO PurchaseInvoiceDTO);

    Company dtoToModel(CompanyDTO companyDTO);
    Supplier dtoToModel(SupplierDTO supplierDTO);

    List<PurchaseInvoiceDTO> modelToDtoList(List<PurchaseInvoice> purchaseInvoiceList);

    List<PurchaseInvoice> dtoToModelList(List<PurchaseInvoiceDTO> PurchaseInvoiceDTOList);
}
