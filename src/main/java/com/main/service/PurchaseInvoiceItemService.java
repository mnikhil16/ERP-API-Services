package com.main.service;

import com.main.entity.PurchaseInvoiceItem;
import com.main.controller.AddResponse;
import com.main.dto.PurchaseInvoiceItemDTO;
import com.main.mapper.PurchaseInvoiceItemMapper;
import com.main.repository.PurchaseInvoiceItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles PurchaseInvoiceItem-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete PurchaseInvoiceItem information in the database.
 * This service communicates with the PurchaseInvoiceItemRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The PurchaseInvoiceItemService should be autowired into other components that require PurchaseInvoiceItem-related functionalities.
 */

@Service
public class PurchaseInvoiceItemService {

    @Autowired
    PurchaseInvoiceItemRepository purchaseInvoiceItemRepository;
    Logger logger = LoggerFactory.getLogger(PurchaseInvoiceItemService.class);

    /**
     * Get all the purchaseInvoiceItems information.
     *
     * @return All the PurchaseInvoiceItem objects.
     */
    public List<PurchaseInvoiceItemDTO> getPurchaseInvoiceItems(){
        logger.trace("Get all Purchase Invoice Items service is invoked.");
        List<PurchaseInvoiceItem> purchaseInvoiceItemList = purchaseInvoiceItemRepository.findAll();
        List<PurchaseInvoiceItemDTO> purchaseInvoiceItemDTOList =  PurchaseInvoiceItemMapper.instance.modelToDtoList(purchaseInvoiceItemList);
        return purchaseInvoiceItemDTOList;
    }

    /**
     * Get purchaseInvoiceItem information by the specified purchaseInvoiceItem ID.
     *
     * @param purchaseInvoiceItemId The ID of the purchaseInvoiceItem to retrieve.
     * @return The PurchaseInvoiceItem object corresponding to the given ID.
     */
    public PurchaseInvoiceItemDTO getPurchaseInvoiceItemById(int purchaseInvoiceItemId){
        logger.trace("Get Purchase Invoice Item by Id service is invoked.");
        PurchaseInvoiceItem purchaseInvoiceItemEntity = purchaseInvoiceItemRepository.findById(purchaseInvoiceItemId).get();
        PurchaseInvoiceItemDTO purchaseInvoiceItemDTO = PurchaseInvoiceItemMapper.instance.modelToDto(purchaseInvoiceItemEntity);
        return purchaseInvoiceItemDTO;
    }

    /**
     * Create a new purchaseInvoiceItem with the provided PurchaseInvoiceItem object.
     *
     * @param purchaseInvoiceItemDTO The PurchaseInvoiceItemDTO object representing the purchaseInvoiceItem to be created.
     * @return The newly created PurchaseInvoiceItem object with a generated ID.
     */
    public PurchaseInvoiceItemDTO createPurchaseInvoiceItem(PurchaseInvoiceItemDTO purchaseInvoiceItemDTO){
        logger.trace("Create Purchase Invoice Item service is invoked.");
        PurchaseInvoiceItem purchaseInvoiceItemEntity = PurchaseInvoiceItemMapper.instance.dtoToModel(purchaseInvoiceItemDTO);
        purchaseInvoiceItemRepository.save(purchaseInvoiceItemEntity);
        PurchaseInvoiceItemDTO createdPurchaseInvoiceItemDTO = PurchaseInvoiceItemMapper.instance.modelToDto(purchaseInvoiceItemEntity);
        return createdPurchaseInvoiceItemDTO;
    }

    /**
     * Update purchaseInvoiceItem information with the provided PurchaseInvoiceItem object.
     *
     * @param purchaseInvoiceItemDTO The PurchaseInvoiceItemDTO object representing the purchaseInvoiceItem to be updated.
     * @return The updated PurchaseInvoiceItem object.
     */
    public PurchaseInvoiceItemDTO updatePurchaseInvoiceItem(PurchaseInvoiceItemDTO purchaseInvoiceItemDTO){
        logger.trace("Update Purchase Invoice Item service is invoked.");
        PurchaseInvoiceItem purchaseInvoiceItemEntity = PurchaseInvoiceItemMapper.instance.dtoToModel(purchaseInvoiceItemDTO);
        purchaseInvoiceItemRepository.save(purchaseInvoiceItemEntity);
        PurchaseInvoiceItemDTO updatedPurchaseInvoiceItemDTO = PurchaseInvoiceItemMapper.instance.modelToDto(purchaseInvoiceItemEntity);
        return updatedPurchaseInvoiceItemDTO;
    }

    /**
     * Delete a purchaseInvoiceItem with the provided purchaseInvoiceItemId.
     *
     * @param purchaseInvoiceItemId The ID of the purchaseInvoiceItem to delete.
     * @return An AddResponse indicating the deletion result.
     */
    public AddResponse deletePurchaseInvoiceItemById(int purchaseInvoiceItemId){
        logger.trace("Delete Purchase Invoice Item service is invoked.");
        purchaseInvoiceItemRepository.deleteById(purchaseInvoiceItemId);
        AddResponse response = new AddResponse();
        response.setMsg("PurchaseInvoiceItem deleted");
        response.setId(purchaseInvoiceItemId);
        return response;
    }
}
