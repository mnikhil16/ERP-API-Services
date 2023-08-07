package com.main.mapper;

import com.main.beans.Supplier;
import com.main.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierMapper instance = Mappers.getMapper(SupplierMapper.class);

    SupplierDTO modelToDto(Supplier supplier);
    Supplier dtoToModel(SupplierDTO supplierDTO);

    List<SupplierDTO> modelToDtoList(List<Supplier> SupplierList);

    List<Supplier> dtoToModelList(List<SupplierDTO> supplierDTOList);
}
