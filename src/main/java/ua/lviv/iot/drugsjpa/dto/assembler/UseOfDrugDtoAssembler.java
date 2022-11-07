package ua.lviv.iot.drugsjpa.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.drugsjpa.controller.CountryController;
import ua.lviv.iot.drugsjpa.controller.UseOfDrugController;
import ua.lviv.iot.drugsjpa.domain.Country;
import ua.lviv.iot.drugsjpa.domain.UseOfDrug;
import ua.lviv.iot.drugsjpa.dto.CountryDto;
import ua.lviv.iot.drugsjpa.dto.UseOfDrugDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UseOfDrugDtoAssembler implements RepresentationModelAssembler<UseOfDrug, UseOfDrugDto> {
    @Override
    public UseOfDrugDto toModel(UseOfDrug entity) {
        UseOfDrugDto useOfDrugDto = UseOfDrugDto.builder()
                .id(entity.getId())
                .useType(entity.getUseType())
                .drugId(entity.getDrugId().getId())
                .build();
        Link link = linkTo(methodOn(UseOfDrugController.class).getbyId(useOfDrugDto.getId())).withSelfRel();
        useOfDrugDto.add(link);
        return useOfDrugDto;
    }

    @Override
    public CollectionModel<UseOfDrugDto> toCollectionModel(Iterable<? extends UseOfDrug> entities) {
        CollectionModel<UseOfDrugDto> useOfDrugDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link links = linkTo(methodOn(UseOfDrugController.class).getAll()).withSelfRel();
        useOfDrugDtos.add(links);
        return useOfDrugDtos;
    }
}
