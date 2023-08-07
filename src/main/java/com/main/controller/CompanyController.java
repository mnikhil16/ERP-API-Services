package com.main.controller;

import com.main.dto.CompanyDTO;
import com.main.service.CompanyService;
import com.main.beans.Company;
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
    CompanyService companyService;

    /**
     * Returns all the company objects.
     * URL : "http://localhost:8080/Companies"
     * @return  All companies as an arrayList of company JSON objects.
     */
    @GetMapping("/Companies")
    public List<CompanyDTO> getAllCompanies(){
        return companyService.getCompanies();
    }

    /**
     * Returns the company object with given customerId.
     * URL : "http://localhost:8080/getCustomerById/"
     * @param companyId as an input.
     * @return ResponseEntity with company information if found, or 404 if not found.
     * @throws  if company object not found with given companyId.
     */
    @GetMapping("/getCompanyById/{companyId}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable(value = "companyId") int companyId) {

        try {
            CompanyDTO companyDTO = companyService.getCompanyById(companyId);
            return new ResponseEntity<>(companyDTO, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the company object.
     * URL : "http://localhost:8080/createCompany"
     * @param  companyDTO object as an input.
     * @return  company JSON object.
     */
    @PostMapping("/createCompany")
    public CompanyDTO createCompany(@RequestBody CompanyDTO companyDTO){

        return companyService.createCompany(companyDTO);
    }

    /**
     * Updates the company object.
     * URL : "http://localhost:8080/updateCompany"
     * @param  companyDTO object as an input.
     * @return ResponseEntity with company information if updated, or 404 if not found.
     * @throws  if company object not found.
     */
    @PutMapping("/updateCompany")
    public ResponseEntity<CompanyDTO> updateCompany(@RequestBody CompanyDTO companyDTO){
        try{
            CompanyDTO updatedCompanyDTO = companyService.updateCompany(companyDTO);
            return new ResponseEntity<>(updatedCompanyDTO,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    /**
     * Deletes the company object with specific id
     * URL : "http://localhost:8080/deleteCompanyById/"
     * @param companyId as an input.
     * @return AddResponse with companyId which is deleted.
     */
    @DeleteMapping("/deleteCompanyById/{companyId}")
    public AddResponse deleteCompanyById(@PathVariable(value = "companyId") int companyId){
        return companyService.deleteCompanyById(companyId);
    }
}