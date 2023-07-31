package com.customer.service;

import com.customer.beans.Company;
import com.customer.beans.Customer;
import com.customer.controller.AddResponse;
import com.customer.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles Company-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete Company information in the database.
 * This service communicates with the CompanyRepository to perform CRUD operations on erp_db entities.
 *
 * Usage:
 * The CompanyService should be autowired into other components that require Company-related functionalities.
 */

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRep;

    /**
     * Get all the company information.
     *
     * @return All the Company objects.
     */
    public List<Company> getCompanies(){
        return companyRep.findAll();
    }


    /**
     * Get company information by the specified company ID.
     *
     * @param Id The ID of the company to retrieve.
     * @return The Company object corresponding to the given ID.
     */
    public Company getCompanyById(int Id){
        List<Company> companies = companyRep.findAll();
        Company company = null;
        for(Company c: companies){
            if(c.getCompanyId() == Id){
                company = c;
            }
        }
        return company;
    }

    /**
     * Create a new customer with the provided customer object.
     *
     * @param company The Company object representing the company to be created.
     * @return The newly created company object with a generated ID.
     */
    public Company createCompany(Company company){
        return companyRep.save(company);
    }

    /**
     * Update a new company with the provided company object.
     *
     * @param company The Company object representing the company to be updated.
     * @return The updated Company object.
     */
    public Company updateCompany(Company company){
        return companyRep.save(company);
    }


    /**
     * Delete a company with the provided companyId.
     *
     * @param companyId The ID of the company to delete.
     * @return The deleted companyId.
     */
    public AddResponse deleteCompanyById(int companyId){
        companyRep.deleteById(companyId);
        AddResponse res = new AddResponse();
        res.setMsg("Company deleted");
        res.setId(companyId);
        return res;
    }
}