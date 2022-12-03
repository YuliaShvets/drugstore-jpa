package ua.lviv.iot.drugsjpa.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.drugsjpa.controller.DrugstoreController;
import ua.lviv.iot.drugsjpa.domain.Drugstore;
import ua.lviv.iot.drugsjpa.dto.DrugstoreDto;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DrugstoreDtoAssembler implements RepresentationModelAssembler<Drugstore, DrugstoreDto> {
    @Override
    public DrugstoreDto toModel(Drugstore entity) {
        DrugstoreDto drugstoreDto = DrugstoreDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
        Link link = linkTo(methodOn(DrugstoreController.class).getbyId(drugstoreDto.getId())).withSelfRel();
        drugstoreDto.add(link);
        return drugstoreDto;
    }

    @Override
    public CollectionModel<DrugstoreDto> toCollectionModel(Iterable<? extends Drugstore> entities) {
        CollectionModel<DrugstoreDto> drugstoreDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link links = linkTo(methodOn(DrugstoreController.class).getAll()).withSelfRel();
        drugstoreDtos.add(links);
        return drugstoreDtos;
    }
}
