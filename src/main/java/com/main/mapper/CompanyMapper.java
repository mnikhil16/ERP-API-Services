package com.main.mapper;

import com.main.entity.Address;
import com.main.entity.Company;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper interface for converting between Company entities and CompanyDTOs.
 * Uses MapStruct and Spring's component model for mapping.
 */
@Mapper(componentModel = "spring")
public interface CompanyMapper {

    // Singleton instance of the CompanyMapper interface
    CompanyMapper instance = Mappers.getMapper(CompanyMapper.class);

    /**
     * Converts a Company entity to a CompanyDTO.
     *
     * @param company The Company entity to be converted.
     * @return The corresponding CompanyDTO.
     */
    @Mapping(source = "address", target = "addressDTO")
    CompanyDTO modelToDto(Company company);

    /**
     * Converts an Address entity to an AddressDTO.
     *
     * @param address The Address entity to be converted.
     * @return The corresponding AddressDTO.
     */
    AddressDTO modelToDto(Address address);

    /**
     * Converts a CompanyDTO to a Company entity.
     *
     * @param companyDTO The CompanyDTO to be converted.
     * @return The corresponding Company entity.
     */
    @Mapping(source = "addressDTO", target = "address")
    Company dtoToModel(CompanyDTO companyDTO);

    /**
     * Converts an AddressDTO to an Address entity.
     *
     * @param addressDTO The AddressDTO to be converted.
     * @return The corresponding Address entity.
     */
    Address dtoToModel(AddressDTO addressDTO);

    /**
     * Converts a list of Company entities to a list of CompanyDTOs.
     *
     * @param companyList The list of Company entities to be converted.
     * @return The corresponding list of CompanyDTOs.
     */
    List<CompanyDTO> modelToDtoList(List<Company> companyList);

    /**
     * Converts a list of CompanyDTOs to a list of Company entities.
     *
     * @param companyDTOList The list of CompanyDTOs to be converted.
     * @return The corresponding list of Company entities.
     */
    List<Company> dtoToModelList(List<CompanyDTO> companyDTOList);
}