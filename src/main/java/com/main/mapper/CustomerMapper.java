package com.main.mapper;

import com.main.beans.Customer;
import com.main.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper instance = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO modelToDto(Customer customer);
    Customer dtoToModel(CustomerDTO customerDTO);

    List<CustomerDTO> modelToDtoList(List<Customer> customerList);

    List<Customer> dtoToModelList(List<CustomerDTO> customerDTOList);
}
