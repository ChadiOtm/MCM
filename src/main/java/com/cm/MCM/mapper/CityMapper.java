package com.cm.MCM.mapper;

import com.cm.MCM.dto.CityDTO;
import com.cm.MCM.model.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityDTO cityToCityDTO(City city);
    City cityDTOToCity(CityDTO cityDTO);
}