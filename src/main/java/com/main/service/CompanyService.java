package com.main.service;

import com.main.entity.Company;
import com.main.controller.AddResponse;
import com.main.dto.CompanyDTO;
import com.main.mapper.CompanyMapper;
import com.main.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that handles Company-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete Company information in the database.
 * This service communicates with the CompanyRepository to perform CRUD operations on erp_db entities.
 * Usage:
 * The CompanyService should be autowired into other components that require Company-related functionalities.
 */

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    Logger logger = LoggerFactory.getLogger(CompanyService.class);

    /**
     * Get all the company information.
     *
     * @return All the Company objects.
     */
    public List<CompanyDTO> getCompanies(){
        logger.trace("Get all Companies service is invoked.");
        List<Company> companyList = companyRepository.findAll();
        List<CompanyDTO> companyDTOList =  CompanyMapper.instance.modelToDtoList(companyList);
        return companyDTOList;
    }

    /**
     * Get company information by the specified company ID.
     *
     * @param companyId The ID of the company to retrieve.
     * @return The Company object corresponding to the given ID.
     */
    public CompanyDTO getCompanyById(int companyId){
        logger.trace("Get Company by Id service is invoked.");
        Company companyEntity = companyRepository.findById(companyId).get();
        CompanyDTO companyDTO = CompanyMapper.instance.modelToDto(companyEntity);
        return companyDTO;
    }

    /**
     * Create a new customer with the provided customer object.
     *
     * @param companyDTO The CompanyDTO object representing the company to be created.
     * @return The newly created company object with a generated ID.
     */
    public CompanyDTO createCompany(CompanyDTO companyDTO){
        logger.trace("Create Company service is invoked.");
        Company companyEntity = CompanyMapper.instance.dtoToModel(companyDTO);
        companyRepository.save(companyEntity);
        CompanyDTO createdCompanyDTO = CompanyMapper.instance.modelToDto(companyEntity);
        return createdCompanyDTO;
    }

    /**
     * Update company information with the provided company object.
     *
     * @param companyDTO The CompanyDTO object representing the company to be updated.
     * @return The updated Company object.
     */
    public CompanyDTO updateCompany(CompanyDTO companyDTO){
        logger.trace("Update Company service is invoked.");
        Company companyEntity = CompanyMapper.instance.dtoToModel(companyDTO);
        companyRepository.save(companyEntity);
        CompanyDTO updatedCompanyDTO = CompanyMapper.instance.modelToDto(companyEntity);
        return updatedCompanyDTO;
    }

    /**
     * Delete a company with the provided companyId.
     *
     * @param companyId The ID of the company to delete.
     * @return An AddResponse indicating the deletion result.
     */
    public AddResponse deleteCompanyById(int companyId){
        logger.trace("Delete Company service is invoked.");
        companyRepository.deleteById(companyId);
        AddResponse response = new AddResponse();
        response.setMsg("Company deleted");
        response.setId(companyId);
        return response;
    }
}