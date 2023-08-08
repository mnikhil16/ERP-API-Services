package com.main.service;

import com.main.beans.Supplier;
import com.main.controller.AddResponse;
import com.main.dto.SupplierDTO;
import com.main.mapper.SupplierMapper;
import com.main.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles Customer-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete Customer information in the database.
 * This service communicates with the CustomerRepository to perform CRUD operations on Customer_db entities.
 * Usage:
 * The CustomerService should be autowired into other components that require Customer-related functionalities.
 */

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    /**
     * Get all the supplier information.
     *
     * @return All the Supplier objects.
     */
    public List<SupplierDTO> getSuppliers(){
        List<Supplier> supplierList = supplierRepository.findAll();
        List<SupplierDTO> supplierDTOList =  SupplierMapper.instance.modelToDtoList(supplierList);
        return supplierDTOList;
    }


    /**
     * Get supplier information by the specified supplier ID.
     *
     * @param supplierId The ID of the supplier to retrieve.
     * @return The Supplier object corresponding to the given ID.
     */
    public SupplierDTO getSupplierById(int supplierId){
        Supplier supplierEntity = supplierRepository.findById(supplierId).get();
        SupplierDTO supplierDTO = SupplierMapper.instance.modelToDto(supplierEntity);
        return supplierDTO;
    }

    /**
     * Create a new supplier with the provided supplier object.
     *
     * @param supplierDTO The Supplier object representing the supplier to be created.
     * @return The newly created supplier object with a generated ID.
     */
    public SupplierDTO createSupplier(SupplierDTO supplierDTO){
        Supplier supplierEntity = SupplierMapper.instance.dtoToModel(supplierDTO);
        supplierRepository.save(supplierEntity);
        SupplierDTO supplierDTO1 = SupplierMapper.instance.modelToDto(supplierEntity);
        return supplierDTO1;
    }

    /**
     * Update a new supplier with the provided supplier object.
     *
     * @param supplierDTO The Supplier object representing the supplier to be updated.
     * @return The updated Supplier object.
     */
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO){
        Supplier supplierEntity = SupplierMapper.instance.dtoToModel(supplierDTO);
        supplierRepository.save(supplierEntity);
        SupplierDTO supplierDTO1 = SupplierMapper.instance.modelToDto(supplierEntity);
        return supplierDTO1;
    }


    /**
     * Delete a supplier with the provided supplierId.
     *
     * @param supplierId The ID of the supplier to delete.
     * @return The deleted supplierId.
     */
    public AddResponse deleteSupplierById(int supplierId){
        supplierRepository.deleteById(supplierId);
        AddResponse res = new AddResponse();
        res.setMsg("Supplier deleted");
        res.setId(supplierId);
        return res;
    }
}