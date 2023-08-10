package com.main.mapper;

import com.main.beans.Address;
import com.main.beans.Customer;
import com.main.beans.Store;
import com.main.dto.AddressDTO;
import com.main.dto.CustomerDTO;
import com.main.dto.StoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper instance = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "address", target = "addressDTO")
    @Mapping(source = "store", target = "storeDTO")
    CustomerDTO modelToDto(Customer customer);

    AddressDTO modelToDto(Address address);
    StoreDTO modelToDto(Store store);

    @Mapping(source = "addressDTO", target = "address")
    @Mapping(source = "storeDTO", target = "store")
    Customer dtoToModel(CustomerDTO customerDTO);

    Address dtoToModel(AddressDTO addressDTO);
    Store dtoToModel(StoreDTO storeDTO);

    List<CustomerDTO> modelToDtoList(List<Customer> customerList);

    List<Customer> dtoToModelList(List<CustomerDTO> customerDTOList);
}
