package com.main.mapper;

import com.main.entity.Address;
import com.main.entity.Company;
import com.main.entity.Store;
import com.main.entity.Supplier;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import com.main.dto.StoreDTO;
import com.main.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper interface for converting between Supplier entities and SupplierDTOs.
 * Uses MapStruct and Spring's component model for mapping.
 */
@Mapper(componentModel = "spring")
public interface SupplierMapper {

    // Singleton instance of the SupplierMapper interface
    SupplierMapper instance = Mappers.getMapper(SupplierMapper.class);

    /**
     * Converts a Supplier entity to a SupplierDTO.
     *
     * @param supplier The Supplier entity to be converted.
     * @return The corresponding SupplierDTO.
     */
    @Mapping(source = "store", target = "storeDTO")
    @Mapping(source = "company", target = "companyDTO")
    @Mapping(source = "address", target = "addressDTO")
    SupplierDTO modelToDto(Supplier supplier);

    /**
     * Converts a Store entity to a StoreDTO.
     *
     * @param store The Store entity to be converted.
     * @return The corresponding StoreDTO.
     */
    StoreDTO modelToDto(Store store);

    /**
     * Converts a Company entity to a CompanyDTO.
     *
     * @param company The Company entity to be converted.
     * @return The corresponding CompanyDTO.
     */
    CompanyDTO modelToDto(Company company);

    /**
     * Converts an Address entity to an AddressDTO.
     *
     * @param address The Address entity to be converted.
     * @return The corresponding AddressDTO.
     */
    AddressDTO modelToDto(Address address);

    /**
     * Converts a SupplierDTO to a Supplier entity.
     *
     * @param supplierDTO The SupplierDTO to be converted.
     * @return The corresponding Supplier entity.
     */
    @Mapping(source = "storeDTO", target = "store")
    @Mapping(source = "companyDTO", target = "company")
    @Mapping(source = "addressDTO", target = "address")
    Supplier dtoToModel(SupplierDTO supplierDTO);

    /**
     * Converts a StoreDTO to a Store entity.
     *
     * @param storeDTO The StoreDTO to be converted.
     * @return The corresponding Store entity.
     */
    Store dtoToModel(StoreDTO storeDTO);

    /**
     * Converts a CompanyDTO to a Company entity.
     *
     * @param companyDTO The CompanyDTO to be converted.
     * @return The corresponding Company entity.
     */
    Company dtoToModel(CompanyDTO companyDTO);

    /**
     * Converts an AddressDTO to an Address entity.
     *
     * @param addressDTO The AddressDTO to be converted.
     * @return The corresponding Address entity.
     */
    Address dtoToModel(AddressDTO addressDTO);

    /**
     * Converts a list of Supplier entities to a list of SupplierDTOs.
     *
     * @param supplierList The list of Supplier entities to be converted.
     * @return The corresponding list of SupplierDTOs.
     */
    List<SupplierDTO> modelToDtoList(List<Supplier> supplierList);

    /**
     * Converts a list of SupplierDTOs to a list of Supplier entities.
     *
     * @param supplierDTOList The list of SupplierDTOs to be converted.
     * @return The corresponding list of Supplier entities.
     */
    List<Supplier> dtoToModelList(List<SupplierDTO> supplierDTOList);
}