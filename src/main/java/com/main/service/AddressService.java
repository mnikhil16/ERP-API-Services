package com.main.service;

import com.main.controller.AddResponse;
import com.main.dto.AddressDTO;
import com.main.entity.Address;
import com.main.mapper.AddressMapper;
import com.main.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing address-related operations.
 */
@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
    Logger logger = LoggerFactory.getLogger(AddressService.class);
    /**
     * Get all address information.
     *
     * @return All the AddressDTO objects.
     */
    public List<AddressDTO> getAddresses(){
        logger.trace("Get all Addresses service is invoked.");
        // Retrieve all addresses from the repository
        List<Address> addressList = addressRepository.findAll();
        // Convert the list of address entities to DTOs using the mapper
        List<AddressDTO> addressDTOList =  AddressMapper.instance.modelToDtoList(addressList);
        return addressDTOList;
    }

    /**
     * Get address information by the specified address ID.
     *
     * @param addressId The ID of the address to retrieve.
     * @return The AddressDTO object corresponding to the given ID.
     */
    public AddressDTO getAddressById(int addressId){
        logger.trace("Get Address by Id service is invoked.");
        // Retrieve the address entity by its ID from the repository
        Address addressEntity = addressRepository.findById(addressId).get();
        // Convert the address entity to a DTO using the mapper
        AddressDTO addressDTO = AddressMapper.instance.modelToDto(addressEntity);
        return addressDTO;
    }

    /**
     * Create a new address with the provided address object.
     *
     * @param addressDTO The AddressDTO object representing the address to be created.
     * @return The newly created address object with a generated ID.
     */
    public AddressDTO createAddress(AddressDTO addressDTO){
        logger.trace("Create Address service is invoked.");
        // Convert the DTO to an entity using the mapper
        Address addressEntity = AddressMapper.instance.dtoToModel(addressDTO);
        // Save the new address entity to the repository
        addressRepository.save(addressEntity);
        // Convert the saved entity back to a DTO
        AddressDTO createdAddressDTO = AddressMapper.instance.modelToDto(addressEntity);
        return createdAddressDTO;
    }

    /**
     * Update address information with the provided address object.
     *
     * @param addressDTO The AddressDTO object representing the address to be updated.
     * @return The updated AddressDTO object.
     */
    public AddressDTO updateAddress(AddressDTO addressDTO){
        logger.trace("Update Address service is invoked.");
        // Convert the DTO to an entity using the mapper
        Address addressEntity = AddressMapper.instance.dtoToModel(addressDTO);
        // Save the updated address entity to the repository
        addressRepository.save(addressEntity);
        // Convert the updated entity back to a DTO
        AddressDTO updatedAddressDTO = AddressMapper.instance.modelToDto(addressEntity);
        return updatedAddressDTO;
    }

    /**
     * Delete an address with the provided addressId.
     *
     * @param addressId The ID of the address to delete.
     * @return An AddResponse indicating the deletion result.
     */
    public AddResponse deleteAddressById(int addressId){
        logger.trace("Delete Address service is invoked.");
        // Delete the address entity by its ID from the repository
        addressRepository.deleteById(addressId);
        // Create a response indicating the successful deletion
        AddResponse response = new AddResponse();
        response.setMsg("Address deleted");
        response.setId(addressId);
        return response;
    }
}