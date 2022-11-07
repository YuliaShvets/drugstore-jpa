package ua.lviv.iot.drugsjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.drugsjpa.domain.Country;
import ua.lviv.iot.drugsjpa.dto.CountryDto;
import ua.lviv.iot.drugsjpa.dto.assembler.CountryDtoAssembler;
import ua.lviv.iot.drugsjpa.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/country")

public class CountryController {

    private CountryService countryService;

    @Autowired
    private CountryDtoAssembler countryDtoAssembler;

    @GetMapping
    public CollectionModel<CountryDto> getAll() {
        List<Country> countries = countryService.getAll();
        return countryDtoAssembler.toCollectionModel(countries);
    }

    @GetMapping("/{name}")
    public CountryDto getbyId(@PathVariable String name) {
        Country country = countryService.getById(name);
        return countryDtoAssembler.toModel(country);
    }

    @PostMapping
    public CountryDto create(@RequestBody Country entity) {
        Country country = countryService.create(entity);
        return countryDtoAssembler.toModel(country);
    }

    @PutMapping("/{name}")
    public CountryDto update(@PathVariable String name, @RequestBody Country entity) {
        Country country = countryService.update(name, entity);
        return countryDtoAssembler.toModel(country);
    }

    @DeleteMapping("/{name}")
    public void delete(@PathVariable String name) {
        countryService.delete(name);
    }
}
