package com.main.service;

import com.main.beans.Company;
import com.main.controller.AddResponse;
import com.main.dto.CompanyDTO;
import com.main.mapper.CompanyMapper;
import com.main.repository.CompanyRepository;
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

    /**
     * Get all the company information.
     *
     * @return All the Company objects.
     */
    public List<CompanyDTO> getCompanies(){
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
        Company companyEntity = companyRepository.findById(companyId).get();
        CompanyDTO companyDTO = CompanyMapper.instance.modelToDto(companyEntity);
        return companyDTO;
    }

    /**
     * Create a new customer with the provided customer object.
     *
     * @return The newly created company object with a generated ID.
     */
    public CompanyDTO createCompany(CompanyDTO companyDTO){
        Company companyEntity = CompanyMapper.instance.dtoToModel(companyDTO);
        companyRepository.save(companyEntity);
        CompanyDTO companyDTO1 = CompanyMapper.instance.modelToDto(companyEntity);
        return companyDTO1;
    }

    /**
     * Update a new company with the provided company object.
     *
     * @param companyDTO The Company object representing the company to be updated.
     * @return The updated Company object.
     */
    public CompanyDTO updateCompany(CompanyDTO companyDTO){
        Company companyEntity = CompanyMapper.instance.dtoToModel(companyDTO);
        companyRepository.save(companyEntity);
        CompanyDTO companyDTO1 = CompanyMapper.instance.modelToDto(companyEntity);
        return companyDTO1;
    }


    /**
     * Delete a company with the provided companyId.
     *
     * @param companyId The ID of the company to delete.
     * @return The deleted companyId.
     */
    public AddResponse deleteCompanyById(int companyId){
        companyRepository.deleteById(companyId);
        AddResponse res = new AddResponse();
        res.setMsg("Company deleted");
        res.setId(companyId);
        return res;
    }
}