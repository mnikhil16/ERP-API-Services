package com.main.mapper;

import com.main.beans.Address;
import com.main.beans.Company;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyMapper instance = Mappers.getMapper(CompanyMapper.class);

    @Mapping(source = "address", target = "addressDTO")
    CompanyDTO modelToDto(Company company);

    AddressDTO modelToDto(Address address);


    @Mapping(source = "addressDTO", target = "address")
    Company dtoToModel(CompanyDTO companyDTO);

    Address dtoToModel(AddressDTO AddressDTO);

    List<CompanyDTO> modelToDtoList(List<Company> companyList);

    @Mapping(source = "AddressDTO", target = "Address")
    List<Company> dtoToModelList(List<CompanyDTO> companyDTOList);
}
