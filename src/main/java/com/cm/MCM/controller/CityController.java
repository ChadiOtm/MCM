package com.cm.MCM.controller;

import com.cm.MCM.dto.CityDTO;
import com.cm.MCM.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cities")
public class CityController {

    private CityService cityService;
    @PostMapping
    public ResponseEntity<CityDTO> addNewCity(@RequestBody CityDTO cityDTO) {
        CityDTO savedCity = cityService.addNewCity(cityDTO);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }
}
