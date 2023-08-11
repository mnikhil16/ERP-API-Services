package com.main.service;

import com.main.entity.PurchaseInvoice;
import com.main.controller.AddResponse;
import com.main.dto.PurchaseInvoiceDTO;
import com.main.mapper.PurchaseInvoiceMapper;
import com.main.repository.PurchaseInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles Customer-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete Customer information in the database.
 * This service communicates with the CustomerRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The CustomerService should be autowired into other components that require Customer-related functionalities.
 */

@Service
public class PurchaseInvoiceService {

    @Autowired
    PurchaseInvoiceRepository purchaseInvoiceRepository;

    /**
     * Get all the purchaseInvoice information.
     *
     * @return All the PurchaseInvoice objects.
     */
    public List<PurchaseInvoiceDTO> getPurchaseInvoices(){
        List<PurchaseInvoice> purchaseInvoiceList = purchaseInvoiceRepository.findAll();
        List<PurchaseInvoiceDTO> purchaseInvoiceDTOList =  PurchaseInvoiceMapper.instance.modelToDtoList(purchaseInvoiceList);
        return purchaseInvoiceDTOList;
    }

    /**
     * Get purchaseInvoice information by the specified purchaseInvoice ID.
     *
     * @param purchaseInvoiceId The ID of the purchaseInvoice to retrieve.
     * @return The PurchaseInvoice object corresponding to the given ID.
     */
    public PurchaseInvoiceDTO getPurchaseInvoiceById(int purchaseInvoiceId){
        PurchaseInvoice purchaseInvoiceEntity = purchaseInvoiceRepository.findById(purchaseInvoiceId).get();
        PurchaseInvoiceDTO purchaseInvoiceDTO = PurchaseInvoiceMapper.instance.modelToDto(purchaseInvoiceEntity);
        return purchaseInvoiceDTO;
    }

    /**
     * Create a new purchaseInvoice with the provided PurchaseInvoice object.
     *
     * @param purchaseInvoiceDTO The PurchaseInvoiceDTO object representing the purchaseInvoice to be created.
     * @return The newly created PurchaseInvoice object with a generated ID.
     */
    public PurchaseInvoiceDTO createPurchaseInvoice(PurchaseInvoiceDTO purchaseInvoiceDTO){
        PurchaseInvoice purchaseInvoiceEntity = PurchaseInvoiceMapper.instance.dtoToModel(purchaseInvoiceDTO);
        purchaseInvoiceRepository.save(purchaseInvoiceEntity);
        PurchaseInvoiceDTO createdPurchaseInvoiceDTO = PurchaseInvoiceMapper.instance.modelToDto(purchaseInvoiceEntity);
        return createdPurchaseInvoiceDTO;
    }

    /**
     * Update purchaseInvoice information with the provided PurchaseInvoice object.
     *
     * @param purchaseInvoiceDTO The PurchaseInvoiceDTO object representing the purchaseInvoice to be updated.
     * @return The updated PurchaseInvoice object.
     */
    public PurchaseInvoiceDTO updatePurchaseInvoice(PurchaseInvoiceDTO purchaseInvoiceDTO){
        PurchaseInvoice purchaseInvoiceEntity = PurchaseInvoiceMapper.instance.dtoToModel(purchaseInvoiceDTO);
        purchaseInvoiceRepository.save(purchaseInvoiceEntity);
        PurchaseInvoiceDTO updatedPurchaseInvoiceDTO = PurchaseInvoiceMapper.instance.modelToDto(purchaseInvoiceEntity);
        return updatedPurchaseInvoiceDTO;
    }

    /**
     * Delete a purchaseInvoice with the provided purchaseInvoiceId.
     *
     * @param purchaseInvoiceId The ID of the purchaseInvoice to delete.
     * @return An AddResponse indicating the deletion result.
     */
    public AddResponse deletePurchaseInvoiceById(int purchaseInvoiceId){
        purchaseInvoiceRepository.deleteById(purchaseInvoiceId);
        AddResponse response = new AddResponse();
        response.setMsg("PurchaseInvoice deleted");
        response.setId(purchaseInvoiceId);
        return response;
    }
}