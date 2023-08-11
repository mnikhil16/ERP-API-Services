package com.main.controller;

import com.main.dto.AddressDTO;
import com.main.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controller class responsible for handling HTTP requests related to addresses.
 */
@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    /**
     * Get a list of all addresses.
     *
     * @return List of AddressDTO objects representing all addresses.
     */
    @GetMapping("/Addresses")
    public List<AddressDTO> getAllAddresses() {
        return addressService.getAddresses();
    }

    /**
     * Get an address by its ID.
     *
     * @param addressId The ID of the address to retrieve.
     * @return ResponseEntity containing the AddressDTO if found, or HttpStatus.NOT_FOUND if not found.
     */
    @GetMapping("/getAddressById/{addressId}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable(value = "addressId") int addressId) {
        try {
            AddressDTO addressDTO = addressService.getAddressById(addressId);
            return new ResponseEntity<>(addressDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create a new address.
     *
     * @param addressDTO The AddressDTO object containing address information.
     * @return The created AddressDTO with generated ID.
     */
    @PostMapping("/createAddress")
    public AddressDTO createAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.createAddress(addressDTO);
    }

    /**
     * Update an existing address.
     *
     * @param addressDTO The AddressDTO object containing updated information.
     * @return ResponseEntity containing the updated AddressDTO if successful, or HttpStatus.CONFLICT if an error occurs.
     */
    @PutMapping("/updateAddress")
    public ResponseEntity<AddressDTO> updateAddress(@RequestBody AddressDTO addressDTO) {
        try {
            AddressDTO updatedAddressDTO = addressService.updateAddress(addressDTO);
            return new ResponseEntity<>(updatedAddressDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    /**
     * Delete an address by its ID.
     *
     * @param addressId The ID of the address to delete.
     * @return AddResponse indicating the result of the deletion process.
     */
    @DeleteMapping("/deleteAddressById/{addressId}")
    public AddResponse deleteAddressById(@PathVariable(value = "addressId") int addressId) {
        return addressService.deleteAddressById(addressId);
    }
}
