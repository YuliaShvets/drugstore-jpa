package ua.lviv.iot.drugsjpa.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.drugsjpa.controller.LocationController;
import ua.lviv.iot.drugsjpa.domain.Location;
import ua.lviv.iot.drugsjpa.dto.LocationDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class LocationDtoAssembler implements RepresentationModelAssembler<Location, LocationDto> {
    @Override
    public LocationDto toModel(Location entity) {
        LocationDto locationDto = LocationDto.builder()
                .id(entity.getId())
                .street(entity.getStreet())
                .departmentId(entity.getDepartmentId().getId())
                .cityId(entity.getCityId().getId())
                .build();
        Link link = linkTo(methodOn(LocationController.class).getbyId(locationDto.getId())).withSelfRel();
        locationDto.add(link);
        return locationDto;
    }

    @Override
    public CollectionModel<LocationDto> toCollectionModel(Iterable<? extends Location> entities) {
        CollectionModel<LocationDto> locationDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link links = linkTo(methodOn(LocationController.class).getAll()).withSelfRel();
        locationDtos.add(links);
        return locationDtos;
    }
}
