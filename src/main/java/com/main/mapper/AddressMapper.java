package com.main.mapper;

import com.main.beans.Address;
import com.main.beans.Company;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper instance = Mappers.getMapper(AddressMapper.class);

    AddressDTO modelToDto(Address address);
    Address dtoToModel(AddressDTO addressDTO);

}
