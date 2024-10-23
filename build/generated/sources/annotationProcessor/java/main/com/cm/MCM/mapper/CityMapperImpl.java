package com.cm.MCM.mapper;

import com.cm.MCM.dto.CityDTO;
import com.cm.MCM.model.City;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-23T12:28:25+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class CityMapperImpl implements CityMapper {

    @Override
    public CityDTO cityToCityDTO(City city) {
        if ( city == null ) {
            return null;
        }

        CityDTO cityDTO = new CityDTO();

        cityDTO.setCityId( city.getCityId() );
        cityDTO.setName( city.getName() );
        cityDTO.setDescription( city.getDescription() );
        cityDTO.setImageUrl( city.getImageUrl() );

        return cityDTO;
    }

    @Override
    public City cityDTOToCity(CityDTO cityDTO) {
        if ( cityDTO == null ) {
            return null;
        }

        City city = new City();

        city.setCityId( cityDTO.getCityId() );
        city.setName( cityDTO.getName() );
        city.setDescription( cityDTO.getDescription() );
        city.setImageUrl( cityDTO.getImageUrl() );

        return city;
    }
}
