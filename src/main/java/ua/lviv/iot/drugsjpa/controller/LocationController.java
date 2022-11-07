package ua.lviv.iot.drugsjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.drugsjpa.domain.Location;
import ua.lviv.iot.drugsjpa.dto.LocationDto;
import ua.lviv.iot.drugsjpa.dto.assembler.LocationDtoAssembler;
import ua.lviv.iot.drugsjpa.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/location")

public class LocationController {
    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationDtoAssembler locationDtoAssembler;

    @GetMapping
    public CollectionModel<LocationDto> getAll() {
        List<Location> locations = locationService.getAll();
        return locationDtoAssembler.toCollectionModel(locations);
    }

    @GetMapping("/{id}")
    public LocationDto getbyId(@PathVariable Integer id) {
        Location location = locationService.getById(id);
        return locationDtoAssembler.toModel(location);
    }

    @PostMapping
    public LocationDto create(@RequestBody Location entity) {
        Location location = locationService.create(entity);
        return locationDtoAssembler.toModel(location);
    }

    @PutMapping("/{id}")
    public LocationDto update(@PathVariable Integer id, @RequestBody Location entity) {
        Location location = locationService.update(id, entity);
        return locationDtoAssembler.toModel(location);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        locationService.delete(id);
    }
}
