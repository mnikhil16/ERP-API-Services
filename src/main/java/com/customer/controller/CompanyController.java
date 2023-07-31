package com.customer.controller;

import com.customer.beans.Company;
import com.customer.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class represents the RESTful controller for managing Company-related endpoints.
 * It handles HTTP requests for creating, reading, updating, and deleting Company information.
 * The CompanyController maps incoming HTTP requests to appropriate methods to process them.
 * It interacts with the CompanyService to perform operations on company data.
 * Endpoints:
 * - GET /companies: Retrieves all the companies' information.
 * - GET /getCompanyById/{companyId}: Retrieve company information by the specified ID.
 * - POST /createCompany: Creates a new company using the provided company data.
 * - PUT /updateCompany: Update company information.
 * - DELETE /deleteCompanyById/{companyId}: Delete the company with the given ID from the system.
 * Usage:
 * The CompanyController should be registered with the Spring application context and
 * automatically handle incoming HTTP requests to the specified endpoints.
 */
@RestController
public class CompanyController {

    @Autowired
    CompanyService service;

    /**
     * Returns all the company objects.
     * URL : "http://localhost8080/Companies"
     * @return  All companies as an arrayList of company JSON objects.
     */
    @GetMapping("/Companies")
    public List<Company> getAllCompanies(){
        return service.getCompanies();
    }

    /**
     * Returns the company object with given customerId.
     * URL : "http://localhost8080/getCustomerById/"
     * @param companyId as an input.
     * @return ResponseEntity with company information if found, or 404 if not found.
     * @throws  if company object not found with given companyId.
     */
    @GetMapping("/getCompanyById/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable(value = "companyId") int companyId) {

        try {
            Company company = service.getCompanyById(companyId);
            return new ResponseEntity<Company>(company, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the company object.
     * URL : "http://localhost8080/createCompany"
     * @param  company object as an input.
     * @return  company JSON object.
     */
    @PostMapping("/createCompany")
    public Company createCompany(@RequestBody Company company){

        return service.createCompany(company);
    }

    /**
     * Updates the company object.
     * URL : "http://localhost8080/updateCompany"
     * @param  company object as an input.
     * @return ResponseEntity with company information if updated, or 404 if not found.
     * @throws  if company object not found.
     */
    @PutMapping("/updateCompany")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company){
        try{
            Company updatedCompany = service.updateCompany(company);
            return new ResponseEntity<Company>(updatedCompany,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    /**
     * Deletes the company object with specific id
     * URL : "http://localhost8080/deleteCompanyById/"
     * @param companyId as an input.
     * @return AddResponse with companyId which is deleted.
     */
    @DeleteMapping("/deleteCompanyById/{companyId}")
    public AddResponse deleteCompanyById(@PathVariable(value = "companyId") int companyId){
        return service.deleteCompanyById(companyId);
    }
}