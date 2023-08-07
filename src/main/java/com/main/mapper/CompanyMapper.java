package com.main.mapper;

import com.main.beans.Company;
import com.main.dto.CompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyMapper instance = Mappers.getMapper(CompanyMapper.class);

    CompanyDTO modelToDto(Company company);
    Company dtoToModel(CompanyDTO companyDTO);

    List<CompanyDTO> modelToDtoList(List<Company> companyList);

    List<Company> dtoToModelList(List<CompanyDTO> companyDTOList);

}
