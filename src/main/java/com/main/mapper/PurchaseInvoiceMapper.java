package com.main.mapper;

import com.main.entity.Company;
import com.main.entity.PurchaseInvoice;
import com.main.entity.Supplier;
import com.main.dto.CompanyDTO;
import com.main.dto.PurchaseInvoiceDTO;
import com.main.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper interface for converting between PurchaseInvoice entities and PurchaseInvoiceDTOs.
 * Uses MapStruct and Spring's component model for mapping.
 */
@Mapper(componentModel = "spring")
public interface PurchaseInvoiceMapper {

    // Singleton instance of the PurchaseInvoiceMapper interface
    PurchaseInvoiceMapper instance = Mappers.getMapper(PurchaseInvoiceMapper.class);

    /**
     * Converts a PurchaseInvoice entity to a PurchaseInvoiceDTO.
     *
     * @param purchaseInvoice The PurchaseInvoice entity to be converted.
     * @return The corresponding PurchaseInvoiceDTO.
     */
    @Mapping(source = "company", target = "companyDTO")
    @Mapping(source = "supplier", target = "supplierDTO")
    PurchaseInvoiceDTO modelToDto(PurchaseInvoice purchaseInvoice);

    /**
     * Converts a Company entity to a CompanyDTO.
     *
     * @param company The Company entity to be converted.
     * @return The corresponding CompanyDTO.
     */
    CompanyDTO modelToDto(Company company);

    /**
     * Converts a Supplier entity to a SupplierDTO.
     *
     * @param supplier The Supplier entity to be converted.
     * @return The corresponding SupplierDTO.
     */
    SupplierDTO modelToDto(Supplier supplier);

    /**
     * Converts a PurchaseInvoiceDTO to a PurchaseInvoice entity.
     *
     * @param purchaseInvoiceDTO The PurchaseInvoiceDTO to be converted.
     * @return The corresponding PurchaseInvoice entity.
     */
    @Mapping(source = "companyDTO", target = "company")
    @Mapping(source = "supplierDTO", target = "supplier")
    PurchaseInvoice dtoToModel(PurchaseInvoiceDTO purchaseInvoiceDTO);

    /**
     * Converts a CompanyDTO to a Company entity.
     *
     * @param companyDTO The CompanyDTO to be converted.
     * @return The corresponding Company entity.
     */
    Company dtoToModel(CompanyDTO companyDTO);

    /**
     * Converts a SupplierDTO to a Supplier entity.
     *
     * @param supplierDTO The SupplierDTO to be converted.
     * @return The corresponding Supplier entity.
     */
    Supplier dtoToModel(SupplierDTO supplierDTO);

    /**
     * Converts a list of PurchaseInvoice entities to a list of PurchaseInvoiceDTOs.
     *
     * @param purchaseInvoiceList The list of PurchaseInvoice entities to be converted.
     * @return The corresponding list of PurchaseInvoiceDTOs.
     */
    List<PurchaseInvoiceDTO> modelToDtoList(List<PurchaseInvoice> purchaseInvoiceList);

    /**
     * Converts a list of PurchaseInvoiceDTOs to a list of PurchaseInvoice entities.
     *
     * @param PurchaseInvoiceDTOList The list of PurchaseInvoiceDTOs to be converted.
     * @return The corresponding list of PurchaseInvoice entities.
     */
    List<PurchaseInvoice> dtoToModelList(List<PurchaseInvoiceDTO> PurchaseInvoiceDTOList);
}
