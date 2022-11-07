package ua.lviv.iot.drugsjpa.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.drugsjpa.controller.CityController;
import ua.lviv.iot.drugsjpa.domain.City;
import ua.lviv.iot.drugsjpa.dto.CityDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CityDtoAssembler implements RepresentationModelAssembler<City, CityDto> {

    @Override
    public CityDto toModel(City entity) {
        CityDto cityDto = CityDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .countryName(entity.getCountryName().getName())
                .build();
        Link link = linkTo(methodOn(CityController.class).getbyId(cityDto.getId())).withSelfRel();
        cityDto.add(link);
        return cityDto;
    }

    @Override
    public CollectionModel<CityDto> toCollectionModel(Iterable<? extends City> entities) {
        CollectionModel<CityDto> cityDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link links = linkTo(methodOn(CityController.class).getAll()).withSelfRel();
        cityDtos.add(links);
        return cityDtos;
    }

}
