package ua.lviv.iot.drugsjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.drugsjpa.domain.City;
import ua.lviv.iot.drugsjpa.dto.CityDto;
import ua.lviv.iot.drugsjpa.dto.assembler.CityDtoAssembler;
import ua.lviv.iot.drugsjpa.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CityDtoAssembler cityDtoAssembler;

    @GetMapping
    public CollectionModel<CityDto> getAll() {
        List<City> cities = cityService.getAll();
        return cityDtoAssembler.toCollectionModel(cities);
    }

    @GetMapping("/{id}")
    public CityDto getbyId(@PathVariable Integer id) {
        City city = cityService.getById(id);
        return cityDtoAssembler.toModel(city);
    }

    @PostMapping
    public CityDto create(@RequestBody City entity) {
        City city = cityService.create(entity);
        return cityDtoAssembler.toModel(city);
    }

    @PutMapping("/{id}")
    public CityDto update(@PathVariable Integer id, @RequestBody City entity) {
        City city = cityService.update(id, entity);
        return cityDtoAssembler.toModel(city);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cityService.delete(id);
    }
}
