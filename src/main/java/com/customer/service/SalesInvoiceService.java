package com.customer.service;

import com.customer.beans.SalesInvoice;
import com.customer.controller.AddResponse;
import com.customer.repository.SalesInvoiceRepository;
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
    SalesInvoiceRepository salesInvoiceRep;

    /**
     * Get all the salesInvoice information.
     *
     * @return All the SalesInvoice objects.
     */
    public List<SalesInvoice> getSalesInvoices(){
        return salesInvoiceRep.findAll();
    }


    /**
     * Get salesInvoice information by the specified salesInvoice ID.
     *
     * @param salesInvoiceId The ID of the salesInvoice to retrieve.
     * @return The SalesInvoice object corresponding to the given ID.
     */
    public SalesInvoice getSalesInvoiceById(int salesInvoiceId){
        List<SalesInvoice> salesInvoices = salesInvoiceRep.findAll();
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
        return salesInvoiceRep.save(salesInvoice);
    }

    /**
     * Update a new salesInvoice with the provided SalesInvoice object.
     *
     * @param salesInvoice The SalesInvoice object representing the salesInvoice to be updated.
     * @return The updated SalesInvoice object.
     */
    public SalesInvoice updateSalesInvoice(SalesInvoice salesInvoice){
        return salesInvoiceRep.save(salesInvoice);
    }


    /**
     * Delete a salesInvoice with the provided salesInvoiceId.
     *
     * @param salesInvoiceId The ID of the salesInvoice to delete.
     * @return The deleted salesInvoiceId.
     */
    public AddResponse deleteSalesInvoiceById(int salesInvoiceId){
        salesInvoiceRep.deleteById(salesInvoiceId);
        AddResponse res = new AddResponse();
        res.setMsg("SalesInvoice deleted");
        res.setId(salesInvoiceId);
        return res;
    }
}