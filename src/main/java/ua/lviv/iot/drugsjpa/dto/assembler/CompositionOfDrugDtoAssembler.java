package ua.lviv.iot.drugsjpa.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.drugsjpa.controller.CompositionOfDrugController;
import ua.lviv.iot.drugsjpa.domain.CompositionOfDrug;
import ua.lviv.iot.drugsjpa.dto.CompositionOfDrugDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CompositionOfDrugDtoAssembler implements RepresentationModelAssembler<CompositionOfDrug, CompositionOfDrugDto> {
    @Override
    public CompositionOfDrugDto toModel(CompositionOfDrug entity) {
        CompositionOfDrugDto compositionOfDrugDto = CompositionOfDrugDto.builder()
                .id(entity.getId())
                .activeIngredients(entity.getActiveIngredients())
                .drugId(entity.getDrugId().getId())
                .build();
        Link link = linkTo(methodOn(CompositionOfDrugController.class).getbyId(compositionOfDrugDto.getId())).withSelfRel();
        compositionOfDrugDto.add(link);
        return compositionOfDrugDto;
    }

    @Override
    public CollectionModel<CompositionOfDrugDto> toCollectionModel(Iterable<? extends CompositionOfDrug> entities) {
        CollectionModel<CompositionOfDrugDto> compositionOfDrugDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link links = linkTo(methodOn(CompositionOfDrugController.class).getAll()).withSelfRel();
        compositionOfDrugDtos.add(links);
        return compositionOfDrugDtos;
    }

}
