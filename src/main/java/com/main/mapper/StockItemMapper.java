package com.main.mapper;

import com.main.beans.Company;
import com.main.beans.StockItem;
import com.main.dto.CompanyDTO;
import com.main.dto.StockItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockItemMapper {
    StockItemMapper instance = Mappers.getMapper(StockItemMapper.class);

    @Mapping(source = "company", target = "companyDTO")
    StockItemDTO modelToDto(StockItem stockItem);

    CompanyDTO modelToDto(Company company);

    @Mapping(source = "companyDTO", target = "company")
    StockItem dtoToModel(StockItemDTO stockItemDTO);

    Company dtoToModel(CompanyDTO companyDTO);

    List<StockItemDTO> modelToDtoList(List<StockItem> StockItemList);

    List<StockItem> dtoToModelList(List<StockItemDTO> StockItemDTOList);
}
