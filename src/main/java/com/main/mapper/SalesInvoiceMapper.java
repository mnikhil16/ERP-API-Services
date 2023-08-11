package com.main.mapper;

import com.main.entity.Company;
import com.main.entity.Customer;
import com.main.entity.SalesInvoice;
import com.main.entity.Store;
import com.main.dto.CompanyDTO;
import com.main.dto.CustomerDTO;
import com.main.dto.SalesInvoiceDTO;
import com.main.dto.StoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper interface for converting between SalesInvoice entities and SalesInvoiceDTOs.
 * Uses MapStruct and Spring's component model for mapping.
 */
@Mapper(componentModel = "spring")
public interface SalesInvoiceMapper {

    // Singleton instance of the SalesInvoiceMapper interface
    SalesInvoiceMapper instance = Mappers.getMapper(SalesInvoiceMapper.class);

    /**
     * Converts a SalesInvoice entity to a SalesInvoiceDTO.
     *
     * @param salesInvoice The SalesInvoice entity to be converted.
     * @return The corresponding SalesInvoiceDTO.
     */
    @Mapping(source = "company",target = "companyDTO")
    @Mapping(source = "store",target = "storeDTO")
    @Mapping(source = "customer",target = "customerDTO")
    SalesInvoiceDTO modelToDto(SalesInvoice salesInvoice);

    /**
     * Converts a Company entity to a CompanyDTO.
     *
     * @param company The Company entity to be converted.
     * @return The corresponding CompanyDTO.
     */
    CompanyDTO modelToDto(Company company);

    /**
     * Converts a Store entity to a StoreDTO.
     *
     * @param store The Store entity to be converted.
     * @return The corresponding StoreDTO.
     */
    StoreDTO modelToDto(Store store);

    /**
     * Converts a Customer entity to a CustomerDTO.
     *
     * @param customer The Customer entity to be converted.
     * @return The corresponding CustomerDTO.
     */
    CustomerDTO modelToDto(Customer customer);

    /**
     * Converts a SalesInvoiceDTO to a SalesInvoice entity.
     *
     * @param salesInvoiceDTO The SalesInvoiceDTO to be converted.
     * @return The corresponding SalesInvoice entity.
     */
    @Mapping(source = "companyDTO",target = "company")
    @Mapping(source = "storeDTO",target = "store")
    @Mapping(source = "customerDTO",target = "customer")
    SalesInvoice dtoToModel(SalesInvoiceDTO salesInvoiceDTO);

    /**
     * Converts a CompanyDTO to a Company entity.
     *
     * @param companyDTO The CompanyDTO to be converted.
     * @return The corresponding Company entity.
     */
    Company modelToDto(CompanyDTO companyDTO);

    /**
     * Converts a StoreDTO to a Store entity.
     *
     * @param storeDTO The StoreDTO to be converted.
     * @return The corresponding Store entity.
     */
    Store dtoToModel(StoreDTO storeDTO);

    /**
     * Converts a CustomerDTO to a Customer entity.
     *
     * @param customerDTO The CustomerDTO to be converted.
     * @return The corresponding Customer entity.
     */
    Customer dtoToModel(CustomerDTO customerDTO);

    /**
     * Converts a list of SalesInvoice entities to a list of SalesInvoiceDTOs.
     *
     * @param salesInvoiceList The list of SalesInvoice entities to be converted.
     * @return The corresponding list of SalesInvoiceDTOs.
     */
    List<SalesInvoiceDTO> modelToDtoList(List<SalesInvoice> salesInvoiceList);

    /**
     * Converts a list of SalesInvoiceDTOs to a list of SalesInvoice entities.
     *
     * @param salesInvoiceDTOList The list of SalesInvoiceDTOs to be converted.
     * @return The corresponding list of SalesInvoice entities.
     */
    List<SalesInvoice> dtoToModelList(List<SalesInvoiceDTO> salesInvoiceDTOList);
}