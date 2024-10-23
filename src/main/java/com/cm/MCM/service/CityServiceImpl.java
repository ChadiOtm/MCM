package com.cm.MCM.service;


import com.cm.MCM.dto.CityDTO;
import com.cm.MCM.mapper.CityMapper;
import com.cm.MCM.model.City;
import com.cm.MCM.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class CityServiceImpl implements CityService  {

    private CityRepository cityRepository;
    private CityMapper cityMapper;


    @Override
    @Transactional
    public CityDTO addNewCity(CityDTO cityDTO) {
        if (cityDTO == null) {
            throw new IllegalArgumentException("City cannot be null");
        }

        City city = cityMapper.cityDTOToCity(cityDTO);
        City savedCity = cityRepository.save(city);
        return cityMapper.cityToCityDTO(savedCity);
    }

}
