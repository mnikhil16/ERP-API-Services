package com.main.mapper;

import com.main.beans.Company;
import com.main.beans.Customer;
import com.main.beans.SalesInvoice;
import com.main.beans.Store;
import com.main.dto.CompanyDTO;
import com.main.dto.CustomerDTO;
import com.main.dto.SalesInvoiceDTO;
import com.main.dto.StoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalesInvoiceMapper {
    SalesInvoiceMapper instance = Mappers.getMapper(SalesInvoiceMapper.class);

    @Mapping(source = "company",target = "companyDTO")
    @Mapping(source = "store",target = "storeDTO")
    @Mapping(source = "customer",target = "customerDTO")
    SalesInvoiceDTO modelToDto(SalesInvoice salesInvoice);

    CompanyDTO modelToDto(Company company);
    StoreDTO modelToDto(Store store);
    CustomerDTO modelToDto(Customer customer);

    @Mapping(source = "companyDTO",target = "company")
    @Mapping(source = "storeDTO",target = "store")
    @Mapping(source = "customerDTO",target = "customer")
    SalesInvoice dtoToModel(SalesInvoiceDTO salesInvoiceDTO);

    Company modelToDto(CompanyDTO companyDTO);
    Store dtoToModel(StoreDTO storeDTO);
    Customer dtoToModel(CustomerDTO customerDTO);

    List<SalesInvoiceDTO> modelToDtoList(List<SalesInvoice> salesInvoiceList);

    List<SalesInvoice> dtoToModelList(List<SalesInvoiceDTO> salesInvoiceDTOList);
}
