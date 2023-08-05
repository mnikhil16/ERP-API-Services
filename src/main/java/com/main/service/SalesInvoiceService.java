package com.main.service;

import com.main.beans.SalesInvoice;
import com.main.controller.AddResponse;
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
    public List<SalesInvoice> getSalesInvoices(){
        return salesInvoiceRepository.findAll();
    }


    /**
     * Get salesInvoice information by the specified salesInvoice ID.
     *
     * @param salesInvoiceId The ID of the salesInvoice to retrieve.
     * @return The SalesInvoice object corresponding to the given ID.
     */
    public SalesInvoice getSalesInvoiceById(int salesInvoiceId){
        List<SalesInvoice> salesInvoices = salesInvoiceRepository.findAll();
        SalesInvoice salesInvoice = null;
        for(SalesInvoice si: salesInvoices){
            if(si.getSalesInvoiceId() == salesInvoiceId){
                salesInvoice = si;
            }
        }
        return salesInvoice;
    }

    /**
     * Create a new salesInvoice with the provided SalesInvoice object.
     *
     * @param salesInvoice The SalesInvoice object representing the salesInvoice to be created.
     * @return The newly created SalesInvoice object with a generated ID.
     */
    public SalesInvoice createSalesInvoice(SalesInvoice salesInvoice){
        return salesInvoiceRepository.save(salesInvoice);
    }

    /**
     * Update a new salesInvoice with the provided SalesInvoice object.
     *
     * @param salesInvoice The SalesInvoice object representing the salesInvoice to be updated.
     * @return The updated SalesInvoice object.
     */
    public SalesInvoice updateSalesInvoice(SalesInvoice salesInvoice){
        return salesInvoiceRepository.save(salesInvoice);
    }


    /**
     * Delete a salesInvoice with the provided salesInvoiceId.
     *
     * @param salesInvoiceId The ID of the salesInvoice to delete.
     * @return The deleted salesInvoiceId.
     */
    public AddResponse deleteSalesInvoiceById(int salesInvoiceId){
        salesInvoiceRepository.deleteById(salesInvoiceId);
        AddResponse res = new AddResponse();
        res.setMsg("SalesInvoice deleted");
        res.setId(salesInvoiceId);
        return res;
    }
}