package ua.lviv.iot.drugsjpa.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.drugsjpa.controller.CityController;
import ua.lviv.iot.drugsjpa.controller.CountryController;
import ua.lviv.iot.drugsjpa.domain.City;
import ua.lviv.iot.drugsjpa.domain.Country;
import ua.lviv.iot.drugsjpa.dto.CityDto;
import ua.lviv.iot.drugsjpa.dto.CountryDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CountryDtoAssembler implements RepresentationModelAssembler<Country,CountryDto> {
    @Override
    public CountryDto toModel(Country entity) {
        CountryDto countryDto = CountryDto.builder()
                .name(entity.getName())
                .build();
        Link link = linkTo(methodOn(CountryController.class).getbyId(countryDto.getName())).withSelfRel();
        countryDto.add(link);
        return countryDto;
    }

    @Override
    public CollectionModel<CountryDto> toCollectionModel(Iterable<? extends Country> entities) {
        CollectionModel<CountryDto> countryDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link links = linkTo(methodOn(CountryController.class).getAll()).withSelfRel();
        countryDtos.add(links);
        return countryDtos;
    }
}
