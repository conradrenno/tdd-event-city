package com.devsuperior.bds02.controllers;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CityService service;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll() {
        List<CityDTO> cities = service.findAll();
        return ResponseEntity.ok().body(cities);
    }

    @PostMapping
    public ResponseEntity<CityDTO> insert(@RequestBody CityDTO cityDTO){
        cityDTO = service.insert(cityDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cityDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(cityDTO);
    }


}
