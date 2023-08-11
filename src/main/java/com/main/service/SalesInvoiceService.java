package com.main.service;

import com.main.entity.SalesInvoice;
import com.main.controller.AddResponse;
import com.main.dto.SalesInvoiceDTO;
import com.main.mapper.SalesInvoiceMapper;
import com.main.repository.SalesInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles SalesInvoice-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete SalesInvoice information in the database.
 * This service communicates with the SalesInvoiceRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The SalesInvoiceService should be autowired into other components that require SalesInvoice-related functionalities.
 */

@Service
public class SalesInvoiceService {

    @Autowired
    SalesInvoiceRepository salesInvoiceRepository;

    /**
     * Get all the salesInvoice information.
     *
     * @return All the SalesInvoice objects.
     */
    public List<SalesInvoiceDTO> getSalesInvoices(){
        List<SalesInvoice> salesInvoiceList = salesInvoiceRepository.findAll();
        List<SalesInvoiceDTO> salesInvoiceDTOList =  SalesInvoiceMapper.instance.modelToDtoList(salesInvoiceList);
        return salesInvoiceDTOList;
    }

    /**
     * Get salesInvoice information by the specified salesInvoice ID.
     *
     * @param salesInvoiceId The ID of the salesInvoice to retrieve.
     * @return The SalesInvoice object corresponding to the given ID.
     */
    public SalesInvoiceDTO getSalesInvoiceById(int salesInvoiceId){
        SalesInvoice salesInvoiceEntity = salesInvoiceRepository.findById(salesInvoiceId).get();
        SalesInvoiceDTO salesInvoiceDTO = SalesInvoiceMapper.instance.modelToDto(salesInvoiceEntity);
        return salesInvoiceDTO;
    }

    /**
     * Create a new salesInvoice with the provided SalesInvoice object.
     *
     * @param salesInvoiceDTO The SalesInvoiceDTO object representing the salesInvoice to be created.
     * @return The newly created SalesInvoice object with a generated ID.
     */
    public SalesInvoiceDTO createSalesInvoice(SalesInvoiceDTO salesInvoiceDTO){
        SalesInvoice salesInvoiceEntity = SalesInvoiceMapper.instance.dtoToModel(salesInvoiceDTO);
        salesInvoiceRepository.save(salesInvoiceEntity);
        SalesInvoiceDTO createdSalesInvoiceDTO = SalesInvoiceMapper.instance.modelToDto(salesInvoiceEntity);
        return createdSalesInvoiceDTO;
    }

    /**
     * Update salesInvoice information with the provided SalesInvoice object.
     *
     * @param salesInvoiceDTO The SalesInvoiceDTO object representing the salesInvoice to be updated.
     * @return The updated SalesInvoice object.
     */
    public SalesInvoiceDTO updateSalesInvoice(SalesInvoiceDTO salesInvoiceDTO){
        SalesInvoice salesInvoiceEntity = SalesInvoiceMapper.instance.dtoToModel(salesInvoiceDTO);
        salesInvoiceRepository.save(salesInvoiceEntity);
        SalesInvoiceDTO updatedSalesInvoiceDTO = SalesInvoiceMapper.instance.modelToDto(salesInvoiceEntity);
        return updatedSalesInvoiceDTO;
    }

    /**
     * Delete a salesInvoice with the provided salesInvoiceId.
     *
     * @param salesInvoiceId The ID of the salesInvoice to delete.
     * @return An AddResponse indicating the deletion result.
     */
    public AddResponse deleteSalesInvoiceById(int salesInvoiceId){
        salesInvoiceRepository.deleteById(salesInvoiceId);
        AddResponse response = new AddResponse();
        response.setMsg("SalesInvoice deleted");
        response.setId(salesInvoiceId);
        return response;
    }
}