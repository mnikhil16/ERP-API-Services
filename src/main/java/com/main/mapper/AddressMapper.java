package com.main.mapper;

import com.main.entity.Address;
import com.main.dto.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper interface for converting between Address entities and AddressDTOs.
 * Uses MapStruct and Spring's component model for mapping.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper {

    // Singleton instance of the AddressMapper interface
    AddressMapper instance = Mappers.getMapper(AddressMapper.class);

    /**
     * Converts an Address entity to an AddressDTO.
     *
     * @param address The Address entity to be converted.
     * @return The corresponding AddressDTO.
     */
    AddressDTO modelToDto(Address address);

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
     * @param addressList The list of Company entities to be converted.
     * @return The corresponding list of CompanyDTOs.
     */
    List<AddressDTO> modelToDtoList(List<Address> addressList);

    /**
     * Converts a list of CompanyDTOs to a list of Company entities.
     *
     * @param addressDTOList The list of CompanyDTOs to be converted.
     * @return The corresponding list of Company entities.
     */
    List<Address> dtoToModelList(List<AddressDTO> addressDTOList);
}
