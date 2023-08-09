package com.main.mapper;

import com.main.beans.Address;
import com.main.beans.Company;
import com.main.beans.Store;
import com.main.beans.Supplier;
import com.main.dto.AddressDTO;
import com.main.dto.CompanyDTO;
import com.main.dto.StoreDTO;
import com.main.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierMapper instance = Mappers.getMapper(SupplierMapper.class);

    @Mapping(source = "store", target = "storeDTO")
    @Mapping(source = "company", target = "companyDTO")
    @Mapping(source = "address", target = "addressDTO")
    SupplierDTO modelToDto(Supplier supplier);

    StoreDTO modelToDto(Store store);
    CompanyDTO modelToDto(Company company);
    AddressDTO modelToDto(Address address);

    @Mapping(source = "storeDTO", target = "store")
    @Mapping(source = "companyDTO", target = "company")
    @Mapping(source = "addressDTO", target = "address")
    Supplier dtoToModel(SupplierDTO supplierDTO);

    Store dtoToModel(StoreDTO storeDTO);
    CompanyDTO dtoToModel(CompanyDTO companyDTO);
    AddressDTO dtoToModel(AddressDTO addressDTO);

    List<SupplierDTO> modelToDtoList(List<Supplier> SupplierList);

    List<Supplier> dtoToModelList(List<SupplierDTO> supplierDTOList);
}
