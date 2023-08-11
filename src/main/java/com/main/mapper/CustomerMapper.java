package com.main.mapper;

import com.main.entity.Address;
import com.main.entity.Customer;
import com.main.entity.Store;
import com.main.dto.AddressDTO;
import com.main.dto.CustomerDTO;
import com.main.dto.StoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper interface for converting between Customer entities and CustomerDTOs.
 * Uses MapStruct and Spring's component model for mapping.
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    // Singleton instance of the CustomerMapper interface
    CustomerMapper instance = Mappers.getMapper(CustomerMapper.class);

    /**
     * Converts a Customer entity to a CustomerDTO.
     *
     * @param customer The Customer entity to be converted.
     * @return The corresponding CustomerDTO.
     */
    @Mapping(source = "address", target = "addressDTO")
    @Mapping(source = "store", target = "storeDTO")
    CustomerDTO modelToDto(Customer customer);

    /**
     * Converts an Address entity to an AddressDTO.
     *
     * @param address The Address entity to be converted.
     * @return The corresponding AddressDTO.
     */
    AddressDTO modelToDto(Address address);

    /**
     * Converts a Store entity to a StoreDTO.
     *
     * @param store The Store entity to be converted.
     * @return The corresponding StoreDTO.
     */
    StoreDTO modelToDto(Store store);

    /**
     * Converts a CustomerDTO to a Customer entity.
     *
     * @param customerDTO The CustomerDTO to be converted.
     * @return The corresponding Customer entity.
     */
    @Mapping(source = "addressDTO", target = "address")
    @Mapping(source = "storeDTO", target = "store")
    Customer dtoToModel(CustomerDTO customerDTO);

    /**
     * Converts an AddressDTO to an Address entity.
     *
     * @param addressDTO The AddressDTO to be converted.
     * @return The corresponding Address entity.
     */
    Address dtoToModel(AddressDTO addressDTO);

    /**
     * Converts a StoreDTO to a Store entity.
     *
     * @param storeDTO The StoreDTO to be converted.
     * @return The corresponding Store entity.
     */
    Store dtoToModel(StoreDTO storeDTO);

    /**
     * Converts a list of Customer entities to a list of CustomerDTOs.
     *
     * @param customerList The list of Customer entities to be converted.
     * @return The corresponding list of CustomerDTOs.
     */
    List<CustomerDTO> modelToDtoList(List<Customer> customerList);

    /**
     * Converts a list of CustomerDTOs to a list of Customer entities.
     *
     * @param customerDTOList The list of CustomerDTOs to be converted.
     * @return The corresponding list of Customer entities.
     */
    List<Customer> dtoToModelList(List<CustomerDTO> customerDTOList);
}
